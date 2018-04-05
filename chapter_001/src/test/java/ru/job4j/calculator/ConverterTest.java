package ru.job4j.calculator;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {

    @Test
    public void testRubleToEuro() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70, 1);
        assertThat(result, is(70));
    }

    @Test
    public void testRubleToDollar() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60, 1);
        assertThat(result, is(60));
    }
}