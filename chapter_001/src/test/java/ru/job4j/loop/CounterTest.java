package ru.job4j.loop;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class CounterTest {

    @Test
    public void testAdd() {
        Counter counter = new Counter();
        int finish = counter.add(0, 10);
        assertThat(finish, is(30));
    }
}