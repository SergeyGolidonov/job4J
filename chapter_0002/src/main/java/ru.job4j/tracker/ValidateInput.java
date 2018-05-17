package ru.job4j.tracker;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid data");
            }
        } while (invalid);
        return value;
    }
}