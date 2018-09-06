package ru.job4j.search;

public class TicTacToe {
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

    private boolean checkWinnerHorizontal() {
        for (int i = 0; i < values.length; i++) {
            boolean res = true;
            for (int j = 1; j < values.length; j++)
                res = values[i][j] == values[i][0];
            if (res)
                return true;
        }
        return false;
    }

    private boolean checkWinnerVertical() {
        for (int i = 0; i < values.length; i++) {
            boolean res = true;
            for (int j = 1; j < values.length; j++)
                res = values[j][i] == values[0][i];
            if (res)
                return true;
        }
        return false;
    }

    private boolean checkWinnerDiagonals() {
        boolean res = true;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != values[i + 1]) {
                res = false;
                break;
            }
        }
        return res;
    }

    private boolean checkWhenNobodyWins() {
        if (!checkWinnerVertical() & !checkWinnerHorizontal() & !checkWinnerDiagonals()) {
            return true;
        }
        return false;
    }
}