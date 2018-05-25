package ru.job4j.chess;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void whenAddBishopToBoardThenItIsThere() {
        Board board = new Board();
        Cell position = new Cell(1,1);
        Figure bishop = new Bishop(position);
        board.addFigure(bishop);
        Figure result = board.getFigure(position);
        assertThat(result, is(bishop));
    }

    @Test
    public void whenBishopMovesFrom1x1to4x4ThenItIsThere() {
        Board board = new Board();
        Cell start = new Cell(1, 1);
        Cell finish = new Cell(4, 4);
        Figure bishop = new Bishop(start);
        board.addFigure(bishop);
        try {
            board.move(start, finish);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        }
        assertThat(board.getFigure(finish), notNullValue());
        assertThat(board.getFigure(start), nullValue());
    }

    @Test(expected = OccupiedWayException.class)
    public void whenBishopMovesThroughOccupiedCellThenOccupiedWayExceptionOccured()
            throws OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        Board board = new Board();
        Cell start = new Cell(1,1);
        Figure bishop1 = new Bishop(start);
        Figure bishop2 = new Bishop(new Cell(2, 2));
        board.addFigure(bishop1);
        board.addFigure(bishop2);
        board.move(start, new Cell(4,4));
    }
}