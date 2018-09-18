package ru.job4j.search;

public class TicTacToe {
    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        return checkWhenNobodyWins() || checkWinner();
    }

    public boolean checkWhenNobodyWins() {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (values[i][0] != values[0][j]) {
                    return true;
                } else if (values[i][0] == values[0][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWinner() {
        for (int i = 0; i < values.length; i++) {
            for (int j= 0; j < values[i].length; j++) {
                if (values[i][0] == values[0][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}