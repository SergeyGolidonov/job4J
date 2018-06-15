package ru.job4j.brackets;

import java.util.ArrayList;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Info {
    /**
     * Валидная ли переданная строка.
     */
    private boolean valid;

    /**
     * Список из всех пар скобок с позициями открывающей и закрывающей.
     */
    private ArrayList<Item> items;

    /**
     * Конструктор.
     * @param valid - строка правильная.
     * @param items - список скобок с позициями.
     */
    public Info(boolean valid, ArrayList<Item> items) {
        this.valid = valid;
        this.items = items;
    }

    public boolean isValid() {
        return valid;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}