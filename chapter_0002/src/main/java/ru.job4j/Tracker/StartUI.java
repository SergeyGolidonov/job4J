package ru.job4j.Tracker;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */


public class StartUI {
    private Input input;
    private String menu = "0. Add new Item\n"
            + "1. Show all items\n"
            + "2. Edit item\n"
            + "3. Delete item\n"
            + "4. Find item by Id\n"
            + "5. Find items by name\n"
            + "6. Exit Program\n"
            + "Select: ";
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";
    private Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        ConsoleInput input = new ConsoleInput();

        Boolean exit = false;
        while (!exit) {
            String answer = input.ask(menu);
            if (ADD.equals(answer)) {
                addNewItem();
            } else if (SHOW_ALL.equals(answer)) {
                showAllItems();
            } else if (EDIT.equals(answer)) {
                editItem();
            } else if (DELETE.equals(answer)) {
                deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                findItembyId();
            } else if (FIND_BY_NAME.equals(answer)) {
                findItemsByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void addNewItem() {
        System.out.println("---------- Creating new task.----------");
        String name = this.input.ask("Enter name of the task: ");
        String description = this.input.ask("Enter description of the task: ");
        Item item = new Item(name, description);
        this.tracker.add(item);
        System.out.println("---------- Added new task with ID: " + item.getId() + " ----------");
    }

    private void findItemsByName() {
        System.out.println("---------- Find item by name. ----------");
        String name = this.input.ask("Enter task name: ");
        Item[] items = this.tracker.findByName(name);
        if (items != null) {
            System.out.println("---------- Items with name " + name);
            for (Item item : items) {
                showItem(item);
            }
        } else {
            System.out.println("---------- No such items. ----------");
        }
    }

    private void findItembyId() {
        System.out.println("---------- Find item by ID. ----------");
        String id = this.input.ask("Enter task ID: ");
        Item item = this.tracker.findById(id);
        showItem(item);
    }

    private void deleteItem() {
        System.out.println("---------- Delete item. ----------");
        String id = this.input.ask("Enter task ID: ");
        if (this.tracker.findById(id) != null) {
            this.tracker.delete(id);
            System.out.println("---------- Item with id " + id + " deleted ----------");
        } else {
            System.out.println("---------- No such items. ----------");
        }
    }

    private void editItem() {
        System.out.println("---------- Edit item. ----------");
        String id = this.input.ask("Enter task ID: ");
        Item item = this.tracker.findById(id);
        String newName = this.input.ask("Enter new task name: ");
        item.setName(newName);
        String newDesc = this.input.ask("Enter new task description: ");
        item.setDescription(newDesc);
        System.out.println("---------- New task name: " + item.getName() + " New task description: " + item.getDescription() + " ----------");
    }

    private void showAllItems() {
        System.out.println("---------- All items in the tracker: ");
        int i = 0;
        for (Item item : tracker.findAll()) {
            System.out.println("Item #" + i++);
            showItem(item);
        }
    }

    private void showItem(Item item) {
        if (item != null) {
            System.out.println("\tItem name: " + item.getName());
            System.out.println("\tItem description: " + item.getDescription());
            System.out.println("\tItem ID: " + item.getId());
            System.out.println("\tItem creation time: " + item.getCreate());
            System.out.println();
        } else {
            System.out.println("---------- No such item ----------");
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();

    }
}