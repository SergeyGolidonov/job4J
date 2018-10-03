package ru.job4j.tracker;

import java.util.List;

/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/

public class StartUI {
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private static void accept(List<UserAction> a) {
        for (UserAction action : a) {
            System.out.println(action.info());
        }
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int[] range = new int[menu.getRange()];
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }
        do {
            menu.show(StartUI::accept);
            menu.select(input.ask("Please select action: ", range));
        } while (!"y".equals(this.input.ask("Exit? (y): ")));
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}