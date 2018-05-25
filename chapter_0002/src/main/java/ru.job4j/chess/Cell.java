package ru.job4j.chess;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */

public class Cell {
    private int x, y;

    private static final int MAX_X = 8;
    private static final int MAX_Y = 8;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean equals(Cell other) {
        return (this.x == other.x && this.y == other.y);
    }

    @Override
    public int hashCode() {
        return this.x * 8 + this.y;
    }

    public static boolean checkCell(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        return (x > 0) && (x <= MAX_X) && (y > 0) && (y <= MAX_Y);
    }
}