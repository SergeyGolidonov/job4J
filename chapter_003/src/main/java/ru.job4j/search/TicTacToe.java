package ru.job4j.search;

public class TicTacToe {
    private int size;
    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        return checkWinnerHorizontal() ||
                checkWinnerVertical() ||
                checkWinnerDiagonals() ||
                checkWhenNobodyWins();
    }

    private boolean checkWhenNobodyWins() {

        for (int i = 0; i < size; i++) {
            boolean res = true;
            for (int j = 0; j < size && res; j++)
                res = values[i][j] != values[i][0] &&
                        values[j][i] != values[0][i] &&
                        values[i][i] != values[0][0] &&
                        values[size - j - 1][j] != values[size - 1][0];
            if (res)
                return false;
        }
        return true;
    }

    private boolean checkWinnerHorizontal() {
        for (int i = 0; i < size; i++) {
            boolean res = true;
            for (int j = 1; j < size && res; j++)
                res = values[i][j] == values[i][0];
            if (res)
                return true;
        }
        return false;
    }

    private boolean checkWinnerVertical() {
        for (int i = 0; i < size; i++) {
            boolean res = true;
            for (int j = 1; j < size && res; j++)
                res = values[j][i] == values[0][i];
            if (res)
                return true;
        }
        return false;
    }

    private boolean checkWinnerDiagonals() {
        boolean res = true;
        for (int i = 1; i < size && res; i++)
            res = values[i][i] == values[0][0];
        if (res)
            return true;
        res = true;
        for (int j = 1; j < size && res; j++)
            res = values[size - j - 1][j] == values[size - 1][0];
        return res;
    }
}