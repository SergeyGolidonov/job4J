package ru.job4j.array;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayStringTest {

    @Test
    public void testContains() {
        ArrayString contains = new ArrayString();
        boolean result = contains.contains("Привет", "иве");
        assertThat(result, is(true));
    }
}