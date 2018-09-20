package ru.job4j.search;

public class TicTacToe {
    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        return checkWinnerHorizont() || checkWinnerVertical();
    }

    public boolean checkWinnerHorizont() {
        for (int i = 0; i < values.length; i++) {
            for (int j= 0; j < values[i].length; j++) {
                if (values[i][0] == values[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinnerVertical() {
        for (int i = 0; i < values.length; i++) {
            for (int j= 0; j < values[i].length; j++) {
                if (values[0][i] == values[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}