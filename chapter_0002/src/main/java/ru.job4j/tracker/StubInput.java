package ru.job4j.tracker;

/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/

public class StubInput implements Input {

    private final String[] value;

    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    @Override
    public int ask(String question, int[] range) {
        //throw new UnsupportedOperationException("Не поддерживаемая операция.");
        int key = Integer.parseInt(this.ask(question));
        boolean exist = false;
        for (int value: range) {
            if (key == value) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Неправильный пункт меню.");
        }
    }
}