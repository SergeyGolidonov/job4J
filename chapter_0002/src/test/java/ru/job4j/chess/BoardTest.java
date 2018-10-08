package ru.job4j.chess;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void moveWhenWay() {
        Board board = new Board();
        Cell source = new Cell(3, 2);
        Cell dest = new Cell(6, 5);
        board.add(new Bishop(source));
        assertThat(board.move(source, dest), is(true));
    }
}