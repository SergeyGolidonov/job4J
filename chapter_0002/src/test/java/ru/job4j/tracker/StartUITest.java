package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class StartUITest {

    @Test
    public void whenCreatetingAnItemAnItemIsCreated() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "name", "desc", "д"});
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.getAll().get(0).getName(), is("name"));
    }
    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "new_name", "new_desc", "д"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("new_name"));
    }
    @Test
    public void whenDeleteThenTrackerHasDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "д"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().size(), is(0));
    }
}