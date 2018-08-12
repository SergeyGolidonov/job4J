package ru.job4j.search.usersMode;

import java.util.*;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class SortUser {
    public Set<User> sort(List<User> users) {
        Set<User> result = new TreeSet<>(users);
        return result;
    }

    public List<User> sortNameLength(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return Integer.compare(u1.getName().length(), u2.getName().length());
            }
        });
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                int result = u1.getName().compareTo(u2.getName());
                if (result == 0) {
                    result = Integer.compare(u1.getAge(), u2.getAge());
                }
                return result;
            }
        });
        return users;
    }
}