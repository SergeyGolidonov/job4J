package ru.job4j.tracker;
/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[this.position++];
    }

    @Override
    public int ask(String question, int[] range) {
        //throw new UnsupportedOperationException("Unsupported operation");
        return Integer.valueOf(this.ask(question));
    }
}
