package com.derekporcelli.two_zero_four_eight;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class KeyHandler implements EventHandler<KeyEvent>
    {
        public Board board;
        public GridPane gameBoard;
        public StackPane game;
        
        public KeyHandler (Board board, StackPane game)
            {
                this.board = board;
                this.game = game;
                this.gameBoard = (GridPane) game.getChildren().get(0);
            }
        
        @Override
        public void handle (KeyEvent event)
            {
                switch (event.getCode())
                    {
                        case W, UP:
                            board.move(Direction.UP);
                            break;
                        case A, LEFT:
                            board.move(Direction.LEFT);
                            break;
                        case S, DOWN:
                            board.move(Direction.DOWN);
                            break;
                        case D, RIGHT:
                            board.move(Direction.RIGHT);
                            break;
                        case R:
                            board = board.reset();
                            game.getChildren().get(1).setVisible(false);
                            break;
                    }
                updateBoard(board, game);
            }
        public void updateBoard (Board board, StackPane game)
            {
                if (board.checkGameOver())
                    {
                        game.getChildren().get(1).setVisible(true);
                    }
                gameBoard.getChildren().clear();
                for (int i = 0; i < board.getBoardHeight(); i++)
                    {
                        for (int j = 0; j < board.getBoardWidth(); j++)
                            {
                                int tile = board.getBoard()[i][j];
                                String label = Integer.toString(tile);
                                Label tileText = new Label(label.equals("0") ? "" : label);
                                tileText.setFont(new Font("Arial", 30));
                                gameBoard.add(new StackPane(new Rectangle(GameFX.tileSize, GameFX.tileSize, ColorMapping.getColor(tile)), tileText), j, i);
                            }
                    }
            }
    }
