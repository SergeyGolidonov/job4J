package ru.job4j.tracker;

import java.util.List;

/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/

public class StartUI {
    private int[] ranges = new int[]{0, 1, 2, 3, 4, 5, 6};
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    private static void accept(List<UserAction> a) {
        a.forEach(userAction -> System.out.println(userAction.info()));
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {

            menu.show(StartUI::accept);

            menu.select(input.ask("Выберете пунет меню :", ranges));
        } while (!"д".equals(this.input.ask("Выйти? д/н: ")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}