package ru.job4j.calculator;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddOneMinusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.minus(5D, 3D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddOneDivOneThenTwo() {
        Calculator calc = new Calculator();
        calc.div(6D, 2D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddOneMultipleOneThenTwo() {
        Calculator calc = new Calculator();
        calc.multiple(3D, 3D);
        double result = calc.getResult();
        double expected = 9D;
        assertThat(result, is(expected));
    }
}