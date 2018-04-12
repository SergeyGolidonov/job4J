package ru.job4j.array;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {

    @Test
    public void testSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[] {3, 5, 1, 7, 4, 2, 8};
        int[] result = bubbleSort.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5, 7, 8};
        assertThat(result, is(expect));
    }

    @Test
    public void testSort2() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] input = new int[] {13, 15, 1, 27, 4, 2, 48};
        int[] result = bubbleSort.sort(input);
        int[] expect = new int[] {1, 2, 4, 13, 15, 27, 48};
        assertThat(result, is(expect));
    }
}