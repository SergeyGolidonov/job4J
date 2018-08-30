package ru.job4j.search.banktransfer;

import java.util.Objects;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class User {

    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }


    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof User) {
            User user = (User) o;
            result = this == user || (this.name.equals(user.getName()) && this.passport.equals(user.getPassport()));
        }
        return result;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.passport.hashCode();
    }
}