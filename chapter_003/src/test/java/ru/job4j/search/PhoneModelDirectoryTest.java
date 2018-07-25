package ru.job4j.search;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneModelDirectoryTest {
    @Test
    public void whenFindByPhone() {
        PhoneModelDirectory phones = new PhoneModelDirectory();
        phones.add(new Person("Sergey", "Golidonov", "109125", "Moscow"));
        List<Person> persons = phones.find("109");
        assertThat(persons.iterator().next().getPhone(), is("109125"));
    }

    @Test
    public void whenFindByAddress() {
        PhoneModelDirectory phones = new PhoneModelDirectory();
        phones.add(new Person("Sergey", "Golidonov", "109125", "Moscow"));
        List<Person> persons = phones.find("sc");
        assertThat(persons.iterator().next().getAddress(), is("Moscow"));
    }

    @Test
    public void whenFindByName() {
        PhoneModelDirectory phones = new PhoneModelDirectory();
        phones.add(new Person("Sergey", "Golidonov", "109125", "Moscow"));
        List<Person> persons = phones.find("er");
        assertThat(persons.iterator().next().getName(), is("Sergey"));
    }

    @Test
    public void whenFindBySureName() {
        PhoneModelDirectory phones = new PhoneModelDirectory();
        phones.add(new Person("Sergey", "Golidonov", "109125", "Moscow"));
        List<Person> persons = phones.find("li");
        assertThat(persons.iterator().next().getSurname(), is("Golidonov"));
    }
}