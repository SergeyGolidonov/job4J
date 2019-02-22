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

    public boolean checkWinnerHorizont() {
        for (int i = 0; i < values.length; i++) {
            if (values[i][0] == values[i][1] && values[i][1] == values[i][2]) {
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

//    public boolean checkWhenNobodyWins() {
//        for (int i = 0; i < values.length; i++) {
//            if (hasWinner()) {
//                return true;
//            }
//        }
//        return false;
//    }
}