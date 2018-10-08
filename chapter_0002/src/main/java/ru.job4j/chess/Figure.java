package ru.job4j.chess;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public abstract class Figure {
    final Cell position;

    public  Figure(Cell position) {
        this.position = position;
    }

    public abstract Cell[] way(Cell source, Cell dest)
            throws  ImpossibleMoveException;

    public abstract Figure copy(Cell dest);

}