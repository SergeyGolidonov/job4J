package ru.job4j.Tracker;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));

                }

        @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
                Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
                Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий
                Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
                new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
                assertThat(tracker.findById(item.getId()).getName(), is("test name"));
        }

        @Test
    public void whenDeleteItemThenThereIsNoSuchItem() {
        // создаём Tracker
                Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
                Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий
                Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        // создаём StartUI и вызываем метод init()
                new StartUI(input, tracker).init();
        // проверяем элемент
                assertThat(tracker.findById(item.getId()), nullValue());
        }
}