package ru.job4j.search.comparator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class ListToCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        ListToCompare compare = new ListToCompare();
        int rst = compare.compare("Ivanov", "Ivanov");
        assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        ListToCompare compare = new ListToCompare();
        int rst = compare.compare("Ivanov", "Ivanova");
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        ListToCompare compare = new ListToCompare();
        int rst = compare.compare("Petrov", "Ivanova");
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        ListToCompare compare = new ListToCompare();
        int rst = compare.compare("Petrov", "Patrov");
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        ListToCompare compare = new ListToCompare();
        int rst = compare.compare("Patrova", "Petrov");
        assertThat(rst, lessThan(0));
    }
}