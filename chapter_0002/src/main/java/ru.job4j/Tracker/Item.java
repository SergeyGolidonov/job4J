package ru.job4j.Tracker;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Item {
    /**
     * Поля состояния объектов Item
     */
    private String id;
    private String name;
    private String description;
    private long create;

    public Item (String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return create;
    }
}