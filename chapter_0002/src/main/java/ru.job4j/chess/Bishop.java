package ru.job4j.chess;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Bishop extends Figure {
    /**
     * Конструктр класса Bishop, вызывается из класса Figure
     * @param dest ячейка с новыми координатами
     */
    Bishop(Cell dest) {
        super(dest);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        BiPredicate<Cell, Cell> predicate = this::diagonal;
        BiFunction<Cell, Cell, Cell[]> biFunction = this::difference;
        // координаты по x и по y должны быть равны по модулю, так как слол ходит только по диагонали
        if (predicate.test(source, dest)) {
            throw new ImpossibleMoveException("Movement can not be made");
        }

        return biFunction.apply(source, dest);
    }
    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }

    private boolean diagonal(Cell source, Cell dest) {
        Predicate<Cell> predicate = abs -> Math.abs(dest.getX() - source.getX()) != Math.abs(dest.getY() - source.getY());
        return predicate.test(dest);
    }

    private Cell[] difference(Cell source, Cell dest) {
        Function<Cell, Cell[]> function = cell -> {
            // счетчик индекса пути фигуры
            int count = 1;
            int size = source.getX() + 1;
            // путь фигуры
            Cell[] currentCourse = new Cell[size];
            // Проверяем, что разница между начальной и конечной координатой меньше либо равна -1, так как
            // слон ходит только по диагонали
            if ((source.getX() - dest.getX()) <= -1 && (source.getY() - dest.getY()) <= -1) {
                // проходим в цикле логику пути фигуры, где начальным точккам X и Y на первой итерации прибавляем  один шаг
                // затем инкрементируем
                for (int i = source.getX() + 1, j = source.getY() + 1; count <= Math.abs(dest.getX() - source.getX()); i++, j++) {
                    // Заполняем массив  ячеек координатами пройденных ячеек
                    currentCourse[count - 1] = new Cell(i, j);
                    count++;
                }
            }
            return currentCourse;
        };
        return function.apply(dest);
    }

}