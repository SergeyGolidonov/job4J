package ru.job4j.tracker;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int key = -1;
        do {
            try {
                key = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException ex) {
                System.out.println("Введите пункт меню из диапазона!");
            } catch (NumberFormatException ex) {
                System.out.println("Введите правильный пункт меню!");
            }
        } while (invalid);
        return key;
    }
}