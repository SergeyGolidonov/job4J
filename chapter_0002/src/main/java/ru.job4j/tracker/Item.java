package ru.job4j.tracker;
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
    private String desc;
    private long created;
    private String[] comments;

    public Item() {
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public long getCreated() {
        return this.created;
    }

    public String[] getComments() {
        return this.comments;
    }

    public void setId(String id) {
        this.id = id;
    }
}