package com.games.www;

import java.time.LocalDateTime;

/*
@author prachi.shah
@date 10-11-2024
 */
public class TicTacToeGameApp {

    public static void main(String[] args) {

        TicTacToeGameApp ticTacToeGameApp = new TicTacToeGameApp();
        ticTacToeGameApp.start();

        TicTacToeModel model = new TicTacToeModel();
        TicTacToeViews view = new TicTacToeViews();
        TicTacToeController controller = new TicTacToeController(model, view);

        controller.startGame();
    }

    private void start() {
        System.out.printf("Starting Tic Tac Toe game at %s...", LocalDateTime.now());
    }
}
