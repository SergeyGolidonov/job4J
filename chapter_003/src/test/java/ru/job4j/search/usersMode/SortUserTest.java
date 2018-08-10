package ru.job4j.search.usersMode;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
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
        spisok.add(new User("Афродита", "23"));
        spisok.add(new User("Lastikoff", "31"));
        spisok.add(new User("Akhmad", "36"));
        spisok.add(new User("Tima", "13"));
        Set<User> result = users.sort(spisok);
        TreeSet<User> expected = new TreeSet<>();
        expected.add(new User("Tima", "13"));
        expected.add(new User("Афродита", "23"));
        expected.add(new User("Lastikoff", "31"));
        expected.add(new User("Akhmad", "36"));
        assertThat(result, is(expected));
    }
}