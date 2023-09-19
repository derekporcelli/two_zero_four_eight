package com.derekporcelli.two_zero_four_eight;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameFX extends Application
    {
        
        public static void main (String[] args)
            {
                launch(args);
            }
        public Board board;
        public GridPane gameBoard;
        public StackPane game;
        public static int gridWidth = 2;
        public static int gridHeight = 10;
        public static int tileSize = 100;
        public static final int startingValue = 7;
        
        @Override
        public void start (Stage primaryStage)
            {
                gameBoard = new GridPane();
                gameBoard.setHgap(tileSize / 20);
                gameBoard.setVgap(tileSize / 20);
                VBox gameOverText = new VBox(new Label("Game Over"), new Label("Press R to restart"));
                gameOverText.getChildren().forEach(node -> ((Label) node).setFont(new Font(50)));
                gameOverText.setAlignment(Pos.CENTER);
                StackPane gameOverScreen = new StackPane(new Rectangle(gridHeight * tileSize * 1.05, gridWidth * tileSize * 1.05, Color.RED), gameOverText);
                gameOverScreen.setVisible(false);
                game = new StackPane(gameBoard, gameOverScreen);
                Scene scene = new Scene(game);
                board = new Board(gridWidth, gridHeight, startingValue);
                KeyHandler keyHandler = new KeyHandler(board, game);
                keyHandler.updateBoard(board, game);
                scene.setOnKeyPressed(keyHandler);
                primaryStage.setTitle("2048");
                primaryStage.setScene(scene);
                primaryStage.show();
            }
    }
