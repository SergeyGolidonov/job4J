package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Item result = tracker.add(item);
        assertThat(tracker.findAll().get(0), is(result));
    }

    @Test
    public void whenFindAllThenGetItemsArray() {

    }

    @Test
    public void whenIdIsNotInItemsThenNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item result = tracker.findById("");
        Item expected = null;
        assertThat(expected, is(result));
    }

    @Test
    public void whenIdIsNullThenNull() {
        Tracker tracker = new Tracker();
        Item result = tracker.findById(null);
        Item expected = null;
        assertThat(expected, is(result));
    }

    @Test
    public void whenIdIsFoundThenItemFound() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 123L);
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription3", 123L);
        Item expected = tracker.add(item3);

        Item result = tracker.findById(expected.getId());
        assertThat(expected, is(result));
    }

    @Test
    public void whenDeletedFirstItem() {
        Tracker tracker = new Tracker();
        ArrayList<Item> expected = tracker.findAll();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        tracker.delete(item1.getId());
        ArrayList<Item> result = tracker.findAll();
        assertThat(expected, is(result));
    }

    @Test
    public void whenDeletedSecondItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        Item item2 = new Item("test2", "testDescription2", 124L);
        Item item3 = new Item("test3", "testDescription3", 124L);
        tracker.add(item1);
        tracker.add(item3);
        ArrayList<Item> expected = tracker.findAll();
        tracker.delete(item3.getId());
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2.getId());
        ArrayList<Item> result = tracker.findAll();
        assertThat(expected, is(result));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFoundByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        ArrayList<Item> expected = tracker.findAll();
        Item item2 = new Item("test2", "testDescription2", 124L);
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription3", 124L);
        tracker.add(item3);
        ArrayList<Item> result = tracker.findByName("test1");
        assertThat(expected, is(result));
    }

    @Test
    public void whenNotFoundByName() {
        ArrayList<Item> expected = new ArrayList<>();
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 124L);
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription3", 124L);
        tracker.add(item3);
        ArrayList<Item> result = tracker.findByName("абракадабра");
        assertThat(expected, is(result));
    }

    @Test
    public void whenKeyIsNullThenNotFoundByName() {
        ArrayList<Item> expected = new ArrayList<>();
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 124L);
        tracker.add(item2);
        Item item3 = new Item("test3", "testDescription3", 124L);
        tracker.add(item3);
        ArrayList<Item> result = tracker.findByName(null);
        assertThat(expected, is(result));
    }
}