package ru.job4j.Tracker;

import java.util.*;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(RN.nextInt() + System.currentTimeMillis());
    }

    public void replace(String id, Item item) { // Метод редактирования заявок
        Item olditem = findById(id);
        if (olditem != null) {
            olditem = item;
        }
    }

    public void delete (String id) { // Метод удаления заявок
        for (int i = 0; i < this.position; i++) {
            if (items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
                this.position--;
            }
        }
    }

    public Item[] findAll() { // Метод получения всех заявок
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    public Item[] findByName(String key) { // Метод получения списка по имени
        Item[] result = null;
        ArrayList list = new ArrayList();
        for (int i = 0; i != this.position; i++) {
            if (this.items[i].equals(key)) {
                list.add(this.items[i]);
                }
            }
        result = list.size() == 0 ? null : (Item[]) list.toArray();
        return result;
    }

    public Item findById(String id) { // Метод получения заявки по id
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
                }
            }
        return result;
    }
}