package ru.job4j.array;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArraysPlusTest {
    @Test
    public void whenNewArrayAddArrayOneAndTwoThanNewThirdSortArray() {
        int[] one = {1, 2, 3, 5};
        int[] two = {1, 4, 5, 6};
        ArraysPlus array = new ArraysPlus();
        int[] result = array.arraysPlus(one, two);
        int[] expected = {1, 1, 2, 3, 4, 5, 5, 6};
        assertThat(result, is(expected));
    }
}