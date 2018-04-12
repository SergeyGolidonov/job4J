package ru.job4j.array;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound5() {
        int bound = 5;
        Square square1 = new Square();
        int[] rst = square1.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25};
        assertThat(rst, is(expect));
    }
}