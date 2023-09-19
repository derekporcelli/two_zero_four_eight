package com.derekporcelli.two_zero_four_eight;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameFX extends Application
    {
        
        public static void main (String[] args)
            {
                launch(args);
            }
        public Board board;
        public GridPane gameBoard;
        
        @Override
        public void start (Stage primaryStage)
            {
                gameBoard = new GridPane();
                Scene scene = new Scene(gameBoard);
                board = new Board(8, 8);
                board.generateNewTile();
                board.generateNewTile();
                KeyHandler keyHandler = new KeyHandler(board, gameBoard);
                keyHandler.updateBoard(board, gameBoard);
                scene.setOnKeyPressed(keyHandler);
                primaryStage.setTitle("2048");
                primaryStage.setScene(scene);
                primaryStage.show();
            }
    }
