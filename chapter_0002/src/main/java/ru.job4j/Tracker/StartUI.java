package ru.job4j.tracker;
/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/
public class StartUI {
    private Input input;
    private Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        boolean exit = false;
        while (!exit) {
            int[] range = menu.getAvailableActions();
            exit = menu.select(input.ask(menu.get(), range));
        }
    }

    public static void main(String[] args) {
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}