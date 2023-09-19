package com.derekporcelli.two_zero_four_eight;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class KeyHandler implements EventHandler<KeyEvent>
    {
        public Board board;
        public GridPane gameBoard;
        
        public KeyHandler (Board board, GridPane gameBoard)
            {
                this.board = board;
                this.gameBoard = gameBoard;
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
                    }
                updateBoard(board, gameBoard);
            }
        public void updateBoard (Board board, GridPane gameBoard)
            {
                gameBoard.getChildren().clear();
                for (int i = 0; i < board.getBoardHeight(); i++)
                    {
                        for (int j = 0; j < board.getBoardWidth(); j++)
                            {
                                int tile = board.getBoard()[i][j];
                                String label = Integer.toString(tile);
                                gameBoard.add(new StackPane(new Rectangle(100, 100, ColorMapping.getColor(tile)), new Label(label.equals("0") ? "" : label)), j, i);
                            }
                    }
            }
    }
