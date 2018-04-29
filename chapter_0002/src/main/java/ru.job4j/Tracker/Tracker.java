package ru.job4j.Tracker;

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
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return null;
    }

    public void replace(String id, Item item) { // Метод редактирования заявок

    }

    public void delete (String id) { // Метод удаления заявок

    }

    public Item[] findAll() { // Метод получения всех заявок
        return generateId();
    }

    public Item[] findByName(String key) { // Метод получения списка по имени
        return key;
    }

    public Item findById(String id) { // Метод получения заявки по id
        return id;
    }
}