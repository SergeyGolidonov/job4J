package ru.job4j.Tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/

public class TrackerTest {

        @Test
        public void whenAddNewItemThenTrackerHasSameItem() {
                Tracker tracker = new Tracker();
                Item item = new Item("test1", "testDescription", 123L);
                tracker.add(item);
                assertThat(tracker.findAll()[0], is(item));
        }
/**
 * Тест редактирование заявок.
 */
        @Test
        public void whenReplaceNameThenReturnNewName() {
                Tracker tracker = new Tracker();
                Item previous = new Item("test1", "testDescription", 123L);
                tracker.add(previous);
                Item next = new Item("test2", "testDescription2", 123L);
                next.setId(previous.getId());
                tracker.replace(previous.getId(), next);
                assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
            }
/**
 * Тест удаление заявок.
 */
        @Test
        public void whenDeleteItemThenTrackerDeleteItem() {
                Tracker tracker = new Tracker();
                Item item1 = new Item("test1", "testDescription", 123L);
                Item item2 = new Item("test2", "testDescription", 123L);
                tracker.add(item1);
                tracker.add(item2);
                Item[] testArray = new Item[1];
                testArray[0] = item1;
                tracker.delete(item2.getId());
                assertThat(tracker.findAll(), is(testArray));
        }
/**
 * Тест получение списка всех заявок.
 */
        @Test
        public void whenFindAllItemsThanTrackerFindsAllItems() {
                Tracker trackers = new Tracker();
                Item item1 = new Item("test1", "testDescription", 123L);
                Item item2 = new Item("test2", "testDescription", 123L);
                trackers.add(item1);
                trackers.add(item2);
                Item[] testArray = new Item[2];
                testArray[0] = item1;
                testArray[1] = item2;
                assertThat(trackers.findAll(), is(testArray));
        }
/**
 * Тест получение списка по имени.
 */
        @Test
        public void whenFindByNameThenTrackerFindsItem() {
                Tracker tracker = new Tracker();
                Item item = new Item("test1", "testDescription", 123L);
                tracker.add(item);
                Item result = tracker.findByName(item.getName())[0];
        }
/**
 * Тест получение заявки по id.
 */
        @Test
        public void whenFindByIdThenTrackerFidsItem() {
                Tracker tracker = new Tracker();
                Item item = new Item("test1", "testDescription", 123L);
                tracker.add(item);
                Item result = tracker.findById(item.getId());
                assertThat(result, is(item));
        }
}