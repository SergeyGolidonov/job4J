package ru.job4j.array;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TurnTest {

    @Test
    public void testTurn() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4, 5};
        int[] result = turner.turn(input);
        int[] expect = new int[] {5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }

    @Test
    public void testTurn2() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 2, 3, 4, 5, 6};
        int[] result = turner.turn(input);
        int[] expect = new int[] {6, 5, 4, 3, 2, 1};
        assertThat(result, is(expect));
    }

    @Test
    public void testTurn3() {
        Turn turner = new Turn();
        int[] input = new int[] {1, 7, 2, 9, 5, 16, 23};
        int[] result = turner.turn(input);
        int[] expect = new int[] {23, 16, 5, 9, 2, 7, 1};
        assertThat(result, is(expect));
    }
}