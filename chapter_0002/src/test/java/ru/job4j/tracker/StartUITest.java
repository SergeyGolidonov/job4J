package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class StartUITest {

    private final PrintStream stdout = System.out;

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("proba", "desc1", 123L));
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenUserDeletedItemThenTrackerHasNoItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("proba", "desc1", 123L));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        List<Item> expected = new ArrayList<>();
        List<Item> result = tracker.findAll();
        assertThat(expected, is(result));
    }

    @Test
    public void whenUserAddTwoIemsAndDeletedFirstItemThenTrackerHasOneItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1", 123L));
        Item item2 = tracker.add(new Item("test2", "desc2", 123L));
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        List<Item> result = tracker.findAll();
        assertThat(result.get(0).getName(), is("test2"));
    }

    @Test
    public void whenFoundById() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1", 123L));
        Item item2 = tracker.add(new Item("test2", "desc2", 123L));
        Input input = new StubInput(new String[]{"4", item1.getId(), "6"});
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append("Меню:").append(System.lineSeparator())
                .append("0. Add new Item").append(System.lineSeparator())
                .append("1. Show all items").append(System.lineSeparator())
                .append("2. Edit item").append(System.lineSeparator())
                .append("3. Delete item").append(System.lineSeparator())
                .append("4. Find item by Id").append(System.lineSeparator())
                .append("5. Find items by name").append(System.lineSeparator())
                .append("6. Exit Program").append(System.lineSeparator())
                .append("------------ Найдена заявка: --------------").append(System.lineSeparator())
                .append("test1, desc1, id = ").append(item1.getId()).append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("Меню:").append(System.lineSeparator())
                .append("0. Add new Item").append(System.lineSeparator())
                .append("1. Show all items").append(System.lineSeparator())
                .append("2. Edit item").append(System.lineSeparator())
                .append("3. Delete item").append(System.lineSeparator())
                .append("4. Find item by Id").append(System.lineSeparator())
                .append("5. Find items by name").append(System.lineSeparator())
                .append("6. Exit Program").append(System.lineSeparator())
                .toString();
        assertThat(result, is(expected));
    }

    @Test
    public void whenFoundByName() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test", "desc1", 123L));
        Item item2 = tracker.add(new Item("test", "desc2", 123L));
        Item item3 = tracker.add(new Item("test3", "desc3", 123L));
        Input input = new StubInput(new String[]{"5", "test", "6"});
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append("Меню:").append(System.lineSeparator())
                .append("0. Add new Item").append(System.lineSeparator())
                .append("1. Show all items").append(System.lineSeparator())
                .append("2. Edit item").append(System.lineSeparator())
                .append("3. Delete item").append(System.lineSeparator())
                .append("4. Find item by Id").append(System.lineSeparator())
                .append("5. Find items by name").append(System.lineSeparator())
                .append("6. Exit Program").append(System.lineSeparator())
                .append("------------ Найдены заявки: --------------").append(System.lineSeparator())
                .append("test, desc1, id = ").append(item1.getId()).append(System.lineSeparator())
                .append("test, desc2, id = ").append(item2.getId()).append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("Меню:").append(System.lineSeparator())
                .append("0. Add new Item").append(System.lineSeparator())
                .append("1. Show all items").append(System.lineSeparator())
                .append("2. Edit item").append(System.lineSeparator())
                .append("3. Delete item").append(System.lineSeparator())
                .append("4. Find item by Id").append(System.lineSeparator())
                .append("5. Find items by name").append(System.lineSeparator())
                .append("6. Exit Program").append(System.lineSeparator())
                .toString();
        assertThat(result, is(expected));
    }

    @Test
    public void whenFoundAll() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test1", "desc1", 123L));
        Item item2 = tracker.add(new Item("test2", "desc2", 123L));
        Item item3 = tracker.add(new Item("test3", "desc3", 123L));
        Input input = new StubInput(new String[]{"1", "6"});
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        String result = new String(out.toByteArray());
        String expected = new StringBuilder()
                .append("Меню:").append(System.lineSeparator())
                .append("0. Add new Item").append(System.lineSeparator())
                .append("1. Show all items").append(System.lineSeparator())
                .append("2. Edit item").append(System.lineSeparator())
                .append("3. Delete item").append(System.lineSeparator())
                .append("4. Find item by Id").append(System.lineSeparator())
                .append("5. Find items by name").append(System.lineSeparator())
                .append("6. Exit Program").append(System.lineSeparator())
                .append("------------ Все заявки: --------------").append(System.lineSeparator())
                .append("1. test1, desc1, id = ").append(item1.getId()).append(System.lineSeparator())
                .append("2. test2, desc2, id = ").append(item2.getId()).append(System.lineSeparator())
                .append("3. test3, desc3, id = ").append(item3.getId()).append(System.lineSeparator())
                .append(System.lineSeparator())
                .append("Меню:").append(System.lineSeparator())
                .append("0. Add new Item").append(System.lineSeparator())
                .append("1. Show all items").append(System.lineSeparator())
                .append("2. Edit item").append(System.lineSeparator())
                .append("3. Delete item").append(System.lineSeparator())
                .append("4. Find item by Id").append(System.lineSeparator())
                .append("5. Find items by name").append(System.lineSeparator())
                .append("6. Exit Program").append(System.lineSeparator())
                .toString();
        assertThat(result, is(expected));
    }
}