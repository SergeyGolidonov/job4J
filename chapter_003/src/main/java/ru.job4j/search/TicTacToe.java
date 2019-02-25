package ru.job4j.search;

/**
 * @author Sergey Golidonov (3apa3a86@inbox.ru)
 * @version $Id$
 * @since 0.1
 */


public class TicTacToe {
    private final int[][] values;

    public TicTacToe(final int[][] values) {
        this.values = values;
    }

    public boolean hasWinner() {
        return checkWinnerHorizont()
                || checkWinnerVertical()
                || checkWinnerDiagonal();
    }

    boolean checkWinnerHorizont() {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - 2; j++) {
                if (values[i][j] == values[i][j+1] && values[i][j] == values[i][j+2])
                    return true;
            }
        }
        return false;
    }

    public boolean checkWinnerVertical() {
        for (int i = 0; i < values.length; i++) {
                if (values[0][i] == values[1][i] && values[1][i] == values[2][i]) {
                    return true;
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
}