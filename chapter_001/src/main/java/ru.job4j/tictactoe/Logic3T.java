package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        for (int i = 0; i < table.length; i++) {
            if ((table[i][0] != table[i][1] && table[i][0] != table[i][2])
                    || (table[0][i] != table[1][i] && table[0][i] != table[2][i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isWinnerO() {
        for (int i = 0; i < table.length; i++) {
            if ((table[i][0] != table[i][1] && table[i][0] != table[i][2])
                    || (table[0][i] != table[1][i] && table[0][i] != table[2][i])) {
                return true;
            }
        }
        return false;
    }

    public boolean hasGap() {
        for (int i = 0; i < table.length; i++) {
            if ((table[i][0] == table[i][1] && table[i][0] == table[i][2])
                    || (table[0][i] == table[1][i] && table[0][i] == table[2][i])) {
                return false;
            }
        }
        return true;
    }
}