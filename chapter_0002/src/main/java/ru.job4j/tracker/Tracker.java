package ru.job4j.tracker;

import java.util.*;
import java.util.function.Predicate;

/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * Поле для созданлия рандомных чисел.
     */
    private int position = 0;
    private static final Random RND = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        this.items.add(item);
        item.setId(generateId());
        return item;
    }

    /**
     * Метод заменяет ячейку в массиве.
     * @param item новая заявка.
     */
    public void replace(Item item) {
        for (Item i : items) {
            if (findById(item.getId()).equals(i) && item.getId() != null) {
                items.add(items.indexOf(i), item);
                break;
            }
        }
    }

    /**
     * Метод удаляет ячейку в массиве.
     * @param id id звявки.
     */
    public void delete(String id) {
        for (Item item : items) {
            if (findById(id).equals(item)) {
                items.remove(item);
                break;
            }
        }
    }

    /**
     * Метод находит элемент по id.
     * @param id id звявки.
     * @return найденный резултат, либо null если результат не найден.
     */
    public Item findById(String id) {
        Predicate<String> predicate = p -> p.equals(id);
        Item result = null;
        for (Item item : items) {
            if (predicate.test(item.getId())) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод находит элемент по названию.
     * @param key Имя.
     * @return массив.
     */
    public List<Item> findByName(String key) {
        Predicate<String> predicate = p -> p.equals(key);
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (predicate.test(item.getName())) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Метод findAll возвращает копию массива this.items без null элементов.
     * @return result.
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RND.nextInt(100));
    }
}