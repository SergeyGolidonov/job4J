package ru.job4j.calculator;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class FitTest {

    @Test
    public void testManWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(173);
        assertThat(weight, closeTo(83.95, 7.95));
    }

    @Test
    public void testWomanWeight() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(165);
        assertThat(weight, closeTo(63.25, 5.65));
    }
}