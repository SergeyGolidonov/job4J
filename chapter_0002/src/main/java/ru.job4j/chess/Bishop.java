package ru.job4j.chess;

import java.util.Arrays;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] tmp = new Cell[SIZE - 1];
        int pos = 0;
        int x = source.getX();
        int y = source.getY();
        int testX = 0;
        int testY = 0;
        if (source.getY() < dest.getY()) {
            testY = 1;
        } else {
            testY = -1;
        }
        if (source.getX() < dest.getX()) {
            testX = 1;
        } else {
            testX = -1;
        }
        do {
            x += testX;
            y += testY;
            if (x < 1 || x > SIZE || y < 1 || y > SIZE) {
                throw new ImpossibleMoveException("Слон не может так ходить.");
            }
            tmp[pos++] = new Cell(x, y);
        }
        while (x != dest.getX() || y != dest.getY());
        return Arrays.copyOf(tmp, pos);
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}