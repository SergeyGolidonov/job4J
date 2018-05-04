package ru.job4j.Tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
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

        @Test
        public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
                tracker.add(previous);
        // Создаем новую заявку.
                Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
                next.setId(previous.getId());
        // Обновляем заявку в трекере.
                tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
                assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
        }
}