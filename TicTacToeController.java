package com.games.www;

import java.util.Scanner;

/*
@author prachi.shah
@date 10-11-2024
 */
public class TicTacToeController {

    private static final String PLAYER = "Player ";
    private static final String WINS = " wins!";
    private static final String DRAW = "It's a draw!";
    private static final String INVALID_MOVE = "Invalid move. Try again.";

    private final TicTacToeModel model;
    private final TicTacToeViews view;
    private final Scanner scanner;

    public TicTacToeController(TicTacToeModel model, TicTacToeViews view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        boolean gameEnded = false;

        while (!gameEnded) {
            view.displayBoard(model.getBoard());
            view.showMessage(PLAYER + model.getCurrentPlayer() + ", enter your move (row and column): ");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Attempt to make a move
            if (model.makeMove(row, col)) {
                if (model.checkWin()) { // Check if there's a win or draw
                    view.displayBoard(model.getBoard());
                    view.showMessage(PLAYER + model.getCurrentPlayer() + WINS);
                    gameEnded = true;
                } else if (model.checkDraw()) {
                    view.displayBoard(model.getBoard());
                    view.showMessage(DRAW);
                    gameEnded = true;
                } else {
                    model.switchPlayer();   // Switch player if no win or draw
                }
            } else {
                view.showMessage(INVALID_MOVE);
            }
        }
        scanner.close();
    }
}
