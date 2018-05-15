package ru.job4j.Tracker;
/**
* @author Sergey Golidonov (3apa3a86@inbox.ru)
* @version $Id$
* @since 0.1
*/
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class StartUITest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    // трекер

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenShowAllItemsThenAllItemsAreDisplayed() {
        long time = 123L;
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", time);
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is("---------- All items in the tracker: " + System.lineSeparator()
                        + "Item #0" + System.lineSeparator()
                        + "\tItem name: test name" + System.lineSeparator()
                        + "\tItem description: desc" + System.lineSeparator()
                        + "\tItem ID: " + id + System.lineSeparator()
                        + "\tItem creation time: " + time + System.lineSeparator() + System.lineSeparator()));
    }

    @Test
    public void whenFindItemByIdThenFoundItemIsDisplayed() {
        long time = 123L;
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", time);
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"4", id, "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is("---------- Find item by ID. ----------" + System.lineSeparator()
                        + "\tItem name: test name" + System.lineSeparator()
                        + "\tItem description: desc" + System.lineSeparator()
                        + "\tItem ID: " + id + System.lineSeparator()
                        + "\tItem creation time: " + time + System.lineSeparator() + System.lineSeparator()));
    }

    @Test

    public void whenFindByNameThenFoundItemsAreDisplayed() {
        long time = 123L;
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", time);
        tracker.add(item);
        String id = item.getId();
        Input input = new StubInput(new String[]{"5", "test name", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is("---------- Find item by name. ----------" + System.lineSeparator()
                        + "---------- Items with name test name" + System.lineSeparator()
                        + "\tItem name: test name" + System.lineSeparator()
                        + "\tItem description: desc" + System.lineSeparator()
                        + "\tItem ID: " + id + System.lineSeparator()
                        + "\tItem creation time: " + time + System.lineSeparator() + System.lineSeparator()));
    }

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
        // проверяем, что элемента с .
        assertThat(tracker.findById(item.getId()), nullValue());
    }
}