package com.games.www;

/*
@author prachi.shah
@date 10-11-2024
 */
public class TicTacToeModel {

    private static final int SIZE = 3;
    private static final char X = 'X';
    private static final char O = 'O';
    private static final char SPACE = ' ';
    private final char[][] board;
    private char currentPlayer;

    public TicTacToeModel() {
        board = new char[SIZE][SIZE];
        currentPlayer = X;
        initializeBoard();
    }

    // Initialize the board with empty spaces
    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = SPACE;
            }
        }
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean makeMove(int row, int col) {
        if (isMoveValid(row, col)) {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public void switchPlayer() {    // Switch player
        currentPlayer = (currentPlayer == X) ? O : X;
    }

    // Check if the move is valid
    private boolean isMoveValid(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == SPACE;
    }

    // Check if the current player has won
    public boolean checkWin() {
        for (int i = 0; i < SIZE; i++) {    // Check rows, columns, and diagonals
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) || (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) || (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    public boolean checkDraw() {    // Check if it's a draw
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == SPACE) {
                    return false;
                }
            }
        }
        return true;
    }
}
