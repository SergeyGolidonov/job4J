package ru.job4j.chess;

import java.util.function.Predicate;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Board {
    /**
     * Массив фигур доски
     */
    Figure[] figures = new Figure[32];
    /**
     * Счетчик добавления фигуры
     */
    private int count = 0;

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        for (int index = 0; index < figures.length; index++) {
            Predicate<Cell> predicate = p -> p.equals(figures[index].position);
            if (source != null && predicate.test(source)) {
                Cell[] route = figures[index].way(source, dest);
                for (Cell busy: route) {
                    if (busy != null && predicate.test(busy)) {
                        throw  new OccupiedWayException("the route is busy");
                    }
                }
            } else {
                throw new FigureNotFoundException("404 Figure not found");
            }
            figures[index] = figures[index].copy(dest);
            return true;
        }
        return false;
    }

    /**
     * Метод добавления новой фигуры.
     * @param figure новая вигура
     */
    public void  add(Figure figure) {
        figures[count++] = figure;
    }
}