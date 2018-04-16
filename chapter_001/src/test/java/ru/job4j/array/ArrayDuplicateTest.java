package ru.job4j.array;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void testRemove() {
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] except = {"Привет", "Мир", "Супер"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.removeDuplicates(input);
        assertThat(result, arrayContainingInAnyOrder(except));
    }
}