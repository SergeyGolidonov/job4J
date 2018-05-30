package ru.job4j.chess;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Board {

    private static final int FINIFH = 32;

    Figure[] figures = new Figure[FINIFH];

    private int pos = 0;

    public void add(Figure figure) {
        this.figures[pos++] = figure;
    }

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        int index = this.getIndexOfFigureFromCell(source);
        if (index < 0) {
            throw new FigureNotFoundException("Фигуры нет на месте");
        }
        Cell[] cells = this.figures[index].way(source, dest);
        for (Cell cell : cells) {
            int obstacle = this.getIndexOfFigureFromCell(cell);
            if (obstacle >= 0) {
                throw new OccupiedWayException("Фигура не может пройти");
            }
        }

        figures[index].copy(dest);
        return true;
    }

    private int getIndexOfFigureFromCell(Cell cell) {
        int index = -1;
        for (int i = 0; i < this.pos; i++) {
            if (figures[i] != null && figures[i].position.getX() == cell.getX()
                    && figures[i].position.getY() == cell.getY()) {
                index = i;
                break;
            }
        }
        return index;
    }
}