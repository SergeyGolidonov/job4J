package ru.job4j.search.usersMode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class SortUserTest {
    SortUser sU = new SortUser();

    User u1, u2, u3, u4;
    List<User> users;

    @Before
    public void initUsers() {
        u1 = new User("Сережка", 26);  // Name length = 7
        u2 =  new User("Егорушка", 22);  // Name length = 9
        u3 =  new User("Олег", 25);  // Name length = 4
        u4 =  new User("Пашок", 16);  // Name length = 5
        users = new ArrayList<>(Arrays.asList(u1, u2, u3, u4));
    }


    @Test
    public void whenSortUsersBySortMethodThenTrue() {
        Set<User> sortedUser = sU.sort(users);
        User[] result = new User[4];
        int i = 0;
        for (User user : sortedUser) {
            result[i++] = user;
        }
        User[] expect = new User[] {u4, u2, u3, u1};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortUsersByMethodSortNameLengthThenTrue() {
        List<User> sortedUser = sU.sortNameLength(users);
        User[] result = new User[4];
        int i = 0;
        for (User user : sortedUser) {
            result[i++] = user;
        }
        User[] expect = new User[] {u3, u4, u1, u2};
        assertThat(result, is(expect));
    }

    @Test
    public void whenSortUsersByMethodSortByAllFieldsThenTrue() {
        User ru1 = new User("Сергей", 25);
        User ru2 = new User("Иван", 30);
        User ru3 = new User("Сергей", 20);
        User ru4 = new User("Иван", 25);
        users = new ArrayList<>(Arrays.asList(ru1, ru2, ru3, ru4));

        List<User> sortedUser = sU.sortByAllFields(users);
        User[] result = new User[4];
        int i = 0;
        for (User user : sortedUser) {
            result[i++] = user;
        }
        User[] expect = new User[] {ru4, ru2, ru3, ru1};
        assertThat(result, is(expect));
    }
}