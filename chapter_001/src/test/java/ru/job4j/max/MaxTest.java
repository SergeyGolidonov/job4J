package ru.job4j.max;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void testMax() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void testThreeMaxi() {
        Max maxi = new Max();
        int result = maxi.maximum(1, 2, 3);
        assertThat(result, is(3));
    }
}