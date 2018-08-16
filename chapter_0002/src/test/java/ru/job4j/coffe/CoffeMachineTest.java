package ru.job4j.coffe;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CoffeMachineTest {

    @Test
    public void when50In35Price() {
        CoffeMachine coffeMachine = new CoffeMachine();
        int in = 50;
        int price = 35;
        int[] result = coffeMachine.changes(in, price);
        int[] expect = {10, 5};
        assertThat(result, is(expect));
    }

    @Test
    public void when100In37Price() {
        CoffeMachine coffeMachine = new CoffeMachine();
        int money = 100;
        int price = 37;
        int[] result = coffeMachine.changes(money, price);
        int[] expect = {10, 10, 10, 10, 10, 10, 2, 1};
        assertThat(result, is(expect));
    }
}