package ru.job4j.search.usersmode;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class SortUserTest {
    @Test
    public void whenListSortedByTreeSet() {
        SortUser users = new SortUser();
        ArrayList<User> spisok = new ArrayList<>();
        spisok.add(new User("Афродита", 23));
        spisok.add(new User("Lastikoff", 31));
        spisok.add(new User("Akhmad", 36));
        spisok.add(new User("Tima", 13));
        Set<User> result = users.sort(spisok);
        TreeSet<User> expected = new TreeSet<>();
        expected.add(new User("Tima", 13));
        expected.add(new User("Афродита", 23));
        expected.add(new User("Lastikoff", 31));
        expected.add(new User("Akhmad", 36));
        assertThat(result, is(expected));
    }

    @Test
    public void sortedNameByLength() {
        SortUser users1 = new SortUser();
        User first = new User("Ибрагим", 25);
        User second = new User("Адам", 44);
        User third = new User("Кирилл", 12);
        List<User> result = Arrays.asList(first, second, third);
        List<User> expected = Arrays.asList(second, third, first);
        new SortUser().sortNameByLength(result);
        assertEquals(result, expected);
    }

    @Test
    public void sortedByAllFields() {
        User one = new User("Светлана", 47);
        User two = new User("Аленка", 30);
        User three = new User("Александр", 50);
        User four = new User("Сергей", 33);
        List<User> result = Arrays.asList(one, four, two, three);
        List<User> expected = Arrays.asList(three, two, one, four);
        new SortUser().sortedByAllFields(result);
        assertEquals(result, expected);
    }
}