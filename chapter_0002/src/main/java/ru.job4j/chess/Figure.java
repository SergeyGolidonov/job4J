package ru.job4j.chess;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

abstract class Figure extends Board {

    final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }
    abstract Cell[] way(Cell source, Cell dest)throws ImpossibleMoveException;
    abstract Figure copy(Cell dest);

    public abstract Cell getPosition();

    public abstract Cell[] way(Cell dest);
}