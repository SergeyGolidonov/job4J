package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TicTacToeTest {
    @Test
    public void wheWinInDiagonalThenWinner() {
        TicTacToe game = new TicTacToe(
                new int[][] {
                        {1, 0, 0},
                        {1, 1, 0},
                        {0, 0, 1}
                }
        );
        boolean result = game.hasWinner();
        assertThat(result, is(true));
    }

    @Test
    public void wheWinInLastLineThenWinner() {
        TicTacToe game = new TicTacToe(
                new int[][] {
                        {1, 0, 1},
                        {1, 1, 0},
                        {0, 0, 0}
                }
        );
        boolean result = game.hasWinner();
        assertThat(result, is(true));
    }

    @Test
    public void whenWinInVertThenWinner() {
        TicTacToe game = new TicTacToe(
                new int[][] {
                        {1, 0, 0},
                        {1, 0, 0},
                        {1, 0, 1}
                }
        );
        boolean result = game.hasWinner();
        assertThat(result, is(true));
    }

    @Test
    public void whenWinInHorThenWinner() {
        TicTacToe game = new TicTacToe(
                new int[][] {
                        {1, 1, 1},
                        {0, 0, 0},
                        {0, 0, 1}
                }
        );
        boolean result = game.hasWinner();
        assertThat(result, is(true));
    }

    @Test
    public void whenNotWinThenFalse() {
        TicTacToe game = new TicTacToe(
                new int[][] {
                        {1, 0, 1},
                        {1, 0, 0},
                        {0, 1, 1}
                }
        );
        boolean result = game.hasWinner();
        assertThat(result, is(false));
    }


    @Test
    public void whenFieldNotNormalThenWinner() {
        TicTacToe game = new TicTacToe(
                new int[][] {
                        {0, 0, 1, 0},
                        {1, 1, 0, 1},
                        {0, 1, 1, 1},
                        {1, 0, 0, 0},
                }
        );
        boolean result = game.hasWinner();
        assertThat(result, is(true));
    }
}