package ru.job4j.chess;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Test;

import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.*;

public class BishopTest {

    private boolean compareCellArrays(Cell[] first, Cell[] second) {
        boolean result = true;

        int k = first.length;
        if (k != second.length) {
            result = false;
        } else {
            for (int i = 0; i < k; i++) {
                if (!first[i].equals(second[i])) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Test
    public void whenWayFrom3x5to5x4ThenProperWay() {
        Figure bishop = new Bishop(new Cell(3, 5));
        try {
            Cell[] result = bishop.way(new Cell(5, 3));
            Cell[] expected = {
                    new Cell(3, 5),
                    new Cell(4, 4),
                    new Cell(5, 3)
            };
            assertThat(compareCellArrays(result, expected), is(true));
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayFrom3x5to3x6ThenImpossibleWayException() throws ImpossibleMoveException {
        Figure bishop = new Bishop(new Cell(3, 5));
        bishop.way(new Cell(3, 6));
    }
}