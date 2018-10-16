package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Tracker {

    private List<Item> items = new ArrayList<>();

    private static final Random RN = new Random();

    public Item add(Item item) {
        item.setId(this.generateId());
        //this.items[this.position++] = item;
        this.items.add(item);
        return item;
    }

    public void replace(String id, Item item) {
        if (id != null) {
            for (int i = 0; i < items.size(); i++) {
                if (id.equals(this.items.get(i).getId())) {
                    item.setId(id);
                    this.items.set(i, item);
                    break;
                }
            }
        }
    }

    public void delete(String id) {
        if (id != null) {
            for (int i = 0; i < items.size(); i++) {
                if (id.equals(this.items.get(i).getId())) {
                    this.items.remove(i);
                    break;
                }
            }
        }
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        if (key != null) {
            for (int i = 0; i < items.size(); i++) {
                if (key.equals(this.items.get(i).getName())) {
                    result.add(this.items.get(i));
                }
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        if (id != null) {
            for (int i = 0; i < items.size(); i++) {
                if (id.equals(this.items.get(i).getId())) {
                    result = this.items.get(i);
                    break;
                }
            }
        }
        return result;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public String getItemInfo(Item item) {
        return new StringBuilder().append(item.getName()).append(", ").append(item.getDesc()).append(", id = ").append(item.getId()).toString();
    }
}