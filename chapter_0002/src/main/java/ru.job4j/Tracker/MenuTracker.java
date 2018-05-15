package ru.job4j.Tracker;
/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemByName();
        this.actions[6] = new Exit();
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

private class AddItem implements UserAction {

    @Override
    public int key() {
        return 0;
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

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Add the new item");
    }
}

private static class ShowItems implements UserAction {

    @Override
    public int key() {
        return 1;
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

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Show all items");
    }
}

private class DeleteItem implements UserAction {

    @Override
    public int key() {
        return 3;
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

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Delete item");
    }
}

private class FindItemById implements UserAction {

    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("---------- Find item by ID. ----------");
        String id = input.ask("Enter task ID: ");
        Item item = tracker.findById(id);
        showItem(item);
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Find item by Id");
    }
}

private class FindItemByName implements UserAction {

    @Override
    public int key() {
        return 5;
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

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Find item by name");
    }
}

private class Exit implements UserAction {

    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Exit Program");
    }
}
}

class EditItem implements UserAction {

    @Override
    public int key() {
        return 2;
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

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit item");
    }
}