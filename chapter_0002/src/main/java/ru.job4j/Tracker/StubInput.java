package ru.job4j.tracker;
/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/
public class StubInput implements Input {
    private final String[] answers;

    private int position;

    public StubInput(final String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return this.answers[this.position++];
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exit = false;
        for (int element : range) {
            if (element == key) {
                exit = true;
                break;
            }
        }
        if (exit) {
            return key;
        } else {
            throw new MenuOutException("Enter invalid count");
        }
    }
}