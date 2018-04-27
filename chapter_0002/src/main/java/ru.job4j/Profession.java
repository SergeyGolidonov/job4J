package ru.job4j;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */


public class Profession {
    private String name;
    private int age;
    private String profession;

    private String getName() {
        return this.name;
    }

    private int getAge() {
        return this.age;
    }

    private String getProfession() {
        return this.profession;
    }
}