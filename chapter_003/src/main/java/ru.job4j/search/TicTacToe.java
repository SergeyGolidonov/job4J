package ru.job4j.search;

public class TicTacToe {
    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        return checkWinnerHorizont()
                || checkWinnerVertical()
                || checkWinnerDiagonal()
                || checkWhenNobodyWins();
    }

    public boolean checkWinnerHorizont() {
        for (int i = 0; i < values.length; i++) {
            for (int j= 1; j < values.length; j++) {
                if (values[i][0] == values[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinnerVertical() {
        for (int i = 0; i < values.length; i++) {
            for (int j= 1; j < values.length; j++) {
                if (values[0][i] == values[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkWinnerDiagonal() {
        boolean result = true;
        for (int i = 1; i < values.length; i++) {
            if (values[0][0] != values[i][i]) {//проверяем первую диагональ
                result = false;
                break;
            }
        }
        if (!result) {//если победителя нет то проверяем вторую
            for (int i = 1; i < values.length; i++) {
                if (values[0][values.length - 1] != values[i][values.length - 1 - i]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public boolean checkWhenNobodyWins() {
        for (int i = 0; i < values.length; i++) {
            if (!checkWinnerHorizont() && !checkWinnerVertical() && !checkWinnerDiagonal()) {
                return true;
            }
        }
        return false;
    }
}