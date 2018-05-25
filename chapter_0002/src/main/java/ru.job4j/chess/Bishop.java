package ru.job4j.chess;

import javafx.scene.control.Cell;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Bishop extends Figure {

    Bishop(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell dest) throws ImpossibleMoveException {
        if (!Cell.checkCell(dest) || !Cell.checkCell(this.position)) {
            throw new ImpossibleMoveException();
        }
        int srcX = this.getPosition().getX();
        int srcY = this.getPosition().getY();
        int destX = dest.getX();
        int destY = dest.getY();
        if (Math.abs(destX - srcX) != (Math.abs(destY - srcY))) {
            throw new ImpossibleMoveException();
        }
        int wayLength = Math.abs(srcX - destX);
        int xstep = (destX - srcX) / wayLength;
        int ystep = (destY - srcY) / wayLength;
        Cell[] result = new Cell[wayLength + 1];
        for (int i = 0; i <= wayLength; i++) {
            result[i] = new Cell(srcX + i * xstep, srcY + i * ystep);
        }
        return result;
    }

    @Override
    Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}