package ru.job4j.search;

import java.util.LinkedList;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */


public class PriorityOfQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позицию определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */

    public void put(Task task) {

        int size = this.tasks.size();

        for (int index = 0; index != size; index++) {
            if (task.getPriority() <= tasks.get(index).getPriority()) {
                tasks.add(index, task);
            }
        }
        this.tasks.add(task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}