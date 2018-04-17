package ru.job4j.array;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayStringTest {

    @Test
    public void testContains() {
        ArrayString arrayString = new ArrayString();
        boolean result = arrayString.contains("Привет", "иве");
        assertThat(result, is(false));
    }
}