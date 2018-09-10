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
        boolean res = true;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (values[i][j] == values[i][0]) {
                    res = true;
                    break;
                }
            }
        }
        return res;
    }

    private boolean checkWinnerVertical() {
        boolean res = true;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (values[i][j] == values[0][j]) {
                    res = true;
                    break;
                }
            }
        }
        return res;
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
        if (!checkWinnerVertical() && !checkWinnerHorizontal() && !checkWinnerDiagonals()) {
            return false;
        }
        return false;
    }
}