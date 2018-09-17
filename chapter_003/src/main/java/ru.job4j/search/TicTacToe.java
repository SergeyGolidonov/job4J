package ru.job4j.search;

public class TicTacToe {
    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        return isWinner() || whenNobodyWins();
    }

    public boolean isWinner() {
        for (int i = 0; i < values.length; i++) {
            if ((values[i][0] != values[i][1] && values[i][0] != values[i][2])
                    || (values[0][i] != values[1][i] && values[0][i] != values[2][i])) {
                return true;
            }
        }
        return false;
    }

    public boolean whenNobodyWins() {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (!isWinner()) {
                    return true;
                }
            }
        }
        return false;
    }
}