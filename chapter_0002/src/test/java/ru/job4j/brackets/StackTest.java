package ru.job4j.brackets;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class StackTest {

    @Test
    public void stackTestWhenStackIsWrong() {

        Check check = new Check("a[b}e{d](e}");
        check.makeCheck("");
    }

    @Test
    public void stackTestWhenStackIsCorrect() {

        Check check1 = new Check("a[b{c(d)e}f]g");
        check1.makeCheck("");
    }

    @Test
    public void whenStackResultIsExpect() {
        Check check2 = new Check("a1{c(f)34}v");
        boolean result = check2.makeCheck("{()}");
        assertThat(result, is(true));
    }
}