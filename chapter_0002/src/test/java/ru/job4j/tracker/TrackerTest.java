package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/

public class TrackerTest {
        /**
         * Тест.
         * Замены ячейки в массиве.
         */
        @Test
        public void whenReplaceNameThenReturnNewName() {
                Tracker tracker = new Tracker();
                Item previous = new Item("test1", "testDescription", 123L);
                tracker.add(previous);
                Item next = new Item("test2", "testDescription2", 1234L);
                next.setId(previous.getId());
                tracker.replace(next);
                assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
        }

        /**
         * Тест.
         * Поиск всех элементов.
         */
        @Test
        public void whenFindAllThenReturnAll() {
                Tracker tracker = new Tracker();
                Item item = new Item("test1", "testDescription", 123L);
                tracker.add(item);
                assertThat(tracker.findAll().get(0), is(item));
        }

        /**
         * Тест.
         * Поиск по названию.
         */
        @Test
        public void whenFindByNameThenReturnName() {
                Tracker tracker = new Tracker();
                Item item = new Item("test1", "testDescription", 123L);
                tracker.add(item);
                assertThat(tracker.findByName("test1").get(0), is(item));
        }

        /**
         * Тест.
         * Поиск по id.
         */
        @Test
        public void whenFindByIdThenReturnId() {
                Tracker tracker = new Tracker();
                Item item = new Item("test1", "testDescription", 123L);
                tracker.add(item);
                assertThat(tracker.findById(item.getId()), is(item));
        }

        /**
         * Тест.
         * Удаление элемента.
         */
        @Test
        public void whenDeleteThenReturnDelete() {
                Tracker tracker = new Tracker();
                Item item = new Item("test1", "testDescription", 123L);
                Item item1 = new Item("test1", "testDescription", 123L);
                Item item2 = new Item("test1", "testDescription", 123L);
                tracker.add(item);
                tracker.add(item1);
                tracker.add(item2);
                tracker.delete(item.getId());
                assertThat(tracker.findAll().get(1), is(item2));
        }
}