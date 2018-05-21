package ru.job4j.tracker;

/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
    private int[] availableActions;
    private int position = 0;

    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[position++] = new AddItem(0, "Add the new item");
        this.actions[position++] = new ShowItems(1, "Show all items");
        this.actions[position++] = new EditItem(2, "Edit item");
        this.actions[position++] = new DeleteItem(3, "Delete item");
        this.actions[position++] = new FindItemById(4, "Find item by Id");
        this.actions[position++] = new FindItemByName(5, "Find item by name");
        this.actions[position++] = new Exit(6, "Exit Program");

        this.availableActions = new int[this.actions.length];
        for (int i = 0; i < this.actions.length; i++) {
            this.availableActions[i] = i;
        }
    }

    public void addAction(UserAction action) {
        this.actions[position++] = action;
    }

    int[] getAvailableActions() {
        return this.availableActions;
    }

/**
 * Executed selected action
 * @param key number of selected action
 * @return true if 'Exit' was chosen
 */

public boolean select(int key) {
    boolean result = false;
        if (!(key == 6)) {
            this.actions[key].execute(this.input, this.tracker);
        } else {
            result = true;
        }
        return result;
    }

    public String get() {
    StringBuilder resultBuilder = new StringBuilder();
    for (UserAction action : this.actions) {
        if (action != null) {
            resultBuilder.append(action.info()).append("\n");
        }
    }
    String result = resultBuilder.toString();
    result += "Select: ";
    return result;
}

    static void showItem(Item item) {
    if (item != null) {
        System.out.println(String.format(
                "\tItem name: %s" + System.lineSeparator()
                        + "\tItem description: %s" + System.lineSeparator()
                        + "\tItem ID: %s" + System.lineSeparator()
                        + "\tItem creation time: %s" + System.lineSeparator(),
                item.getName(), item.getDescription(), item.getId(), item.getCreate()));
    } else {
        System.out.println("---------- No such item ----------");
    }
}

    private class AddItem extends BaseAction {

    AddItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Creating new task.----------");
        String name = input.ask("Enter name of the task: ");
        String description = input.ask("Enter description of the task: ");
        Item item = new Item(name, description);
        tracker.add(item);
        System.out.println(String.format("---------- Added new task with ID: %s ----------", item.getId()));
    }
}

    private static class ShowItems extends BaseAction {

    ShowItems(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- All items in the tracker: ");
        int i = 0;
        for (Item item : tracker.findAll()) {
            System.out.println("Item #" + i++);
            if (item != null) {
                showItem(item);
            }
        }
    }
}

    private class DeleteItem extends BaseAction {

    DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Delete item. ----------");
        String id = input.ask("Enter task ID: ");
        if (tracker.findById(id) != null) {
            tracker.delete(id);
            System.out.println(String.format("---------- Item with id %s deleted ----------", id));
        } else {
            System.out.println("---------- No such items. ----------");
        }
    }
}

    private class FindItemById extends BaseAction {

    FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Find item by ID. ----------");
        String id = input.ask("Enter task ID: ");
        Item item = tracker.findById(id);
        showItem(item);
    }
}

    private class FindItemByName extends BaseAction {

    FindItemByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Find item by name. ----------");
        String name = input.ask("Enter task name: ");
        Item[] items = tracker.findByName(name);
        if (items != null) {
            System.out.println("---------- Items with name " + name);
            for (Item item : items) {
                showItem(item);
            }
        } else {
            System.out.println("---------- No such items. ----------");
        }
    }
}

    private class Exit extends BaseAction {

    Exit(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }
}
}

class EditItem extends BaseAction {

    EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Edit item. ----------");
        String id = input.ask("Enter task ID: ");
        Item item = tracker.findById(id);
        String newName = input.ask("Enter new task name: ");
        item.setName(newName);
        String newDesc = input.ask("Enter new task description: ");
        item.setDescription(newDesc);
        System.out.println(String.format("---------- New task name: %s New task description: %s ----------",
                item.getName(), item.getDescription()));
    }
}