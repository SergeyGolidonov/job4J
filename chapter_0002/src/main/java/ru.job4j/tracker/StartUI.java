package ru.job4j.tracker;

/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/

public class StartUI {

    private static final int EXIT = 6;

    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        int[] range = menu.getRange();
        while (true) {
            menu.show();
            int key = this.input.ask("Введите пункт меню: ", range);
            if (key == EXIT) {
                break;
            }
            menu.select(key);
        }
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}