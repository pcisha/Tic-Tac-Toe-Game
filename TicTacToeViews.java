package com.games.www;

/*
@author prachi.shah
@date 10-11-2024
 */
public class TicTacToeViews {

    private static final String LINE = " | ";
    private static final String DASHES = "---------";

    // Print the board to the console
    public void displayBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < board[i].length - 1) System.out.print(LINE);
            }
            System.out.println();
            if (i < board.length - 1) System.out.println(DASHES);
        }
    }

    public void showMessage(String message) {   // Display a message
        System.out.println(message);
    }
}
