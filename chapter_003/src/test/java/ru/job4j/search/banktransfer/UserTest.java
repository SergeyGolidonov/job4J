package ru.job4j.search.banktransfer;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class UserTest {

    @Test
    public void whenUsersEqualsByFields() {
        User user1 = new User("John", "passport");
        User user2 = new User("John", "passport");
        assertThat(user1.equals(user2), is(true));
    }

    @Test
    public void whenUsersNotEqualsByFields() {
        User user1 = new User("Michael", "passport");
        User user2 = new User("Michael", "unicode");
        assertThat(user1.equals(user2), is(false));
    }

    @Test
    public void whenNewType() {
        User user1 = new User("Isabella", "passport");
        assertThat(user1.equals(new Object()), is(false));
    }

    @Test
    public void whenItsNull() {
        User user1 = new User("Isabella", "passport");
        assertThat(user1.equals(null), is(false));
    }
}