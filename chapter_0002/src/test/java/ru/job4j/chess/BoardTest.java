package ru.job4j.chess;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Rule;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.rules.ExpectedException;

public class BoardTest {

    @Test
    public void whenBishopRightMoveWithoutFigures() {
        Cell source = new Cell(8, 1);
        Cell dest = new Cell(3, 6);
        Bishop bishop = new Bishop(source);
        Board board = new Board();
        board.add(bishop);
        boolean result = board.move(source, dest);
        assertThat(result, is(true));
    }

    @Rule
    public ExpectedException impossibl = ExpectedException.none();

    @Test
    public void whenBishopWrongMoveWithoutFigures() throws ImpossibleMoveException {
        impossibl.expect(ImpossibleMoveException.class);
        impossibl.expectMessage("Слон не может так ходить.");

        Cell source = new Cell(8, 1);
        Cell dest = new Cell(8, 8);
        Bishop bishop = new Bishop(source);
        Board board = new Board();
        board.add(bishop);
        boolean result = board.move(source, dest);
    }

    @Rule
    public ExpectedException empty = ExpectedException.none();

    @Test
    public void whenBishopWrongMoveFigureNotFoundException1() throws FigureNotFoundException {
        empty.expect(FigureNotFoundException.class);
        empty.expectMessage("Фигуры нет на месте");
        Cell sourse = new Cell(8, 8);
        Board board = new Board();
        boolean result = board.move(sourse, sourse);
    }

    @Rule
    public ExpectedException emptyfully = ExpectedException.none();

    @Test
    public void whenBishopWrongMoveFigureNotFoundException2() throws FigureNotFoundException {
        emptyfully.expect(FigureNotFoundException.class);
        emptyfully.expectMessage("Фигуры нет на месте");
        Cell sourse = new Cell(8, 1);
        Cell dest = new Cell(8, 8);
        Bishop bishop = new Bishop(sourse);
        Board board = new Board();
        board.add(bishop);
        boolean result = board.move(dest, dest);
    }

    @Rule
    public ExpectedException notpass = ExpectedException.none();

    @Test
    public void whenBishopWrongMoveOccupiedWayException() throws OccupiedWayException {
        notpass.expect(OccupiedWayException.class);
        notpass.expectMessage("Фигура не может пройти");
        Cell sourse = new Cell(8, 1);
        Cell dest = new Cell(2, 7);
        Bishop bishop = new Bishop(sourse);
        Board board = new Board();
        board.add(bishop);
        Cell busy = new Cell(3, 6);
        Bishop bishop1 = new Bishop(busy);
        board.add(bishop1);
        boolean result = board.move(sourse, dest);
    }
}