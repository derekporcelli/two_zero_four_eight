package com.derekporcelli.two_zero_four_eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game
    {
        private Board board;
        private int boardHeight;
        private int boardWidth;
        
        public Game (int boardHeight, int boardWidth)
            {
                this.boardHeight = boardHeight;
                this.boardWidth = boardWidth;
                board = new Board(boardHeight, boardWidth);
                board.generateNewTile();
                board.generateNewTile();
            }
        
        public Board getBoard ()
            {
                return board;
            }
        
        public void setBoard (Board board)
            {
                this.board = board;
            }
        
        public int getBoardHeight ()
            {
                return boardHeight;
            }
        
        public void setBoardHeight (int boardHeight)
            {
                this.boardHeight = boardHeight;
            }
        
        public int getBoardWidth ()
            {
                return boardWidth;
            }
        
        public void setBoardWidth (int boardWidth)
            {
                this.boardWidth = boardWidth;
            }
        
        public void moveUp ()
            {
                board.moveUp();
                board.generateNewTile();
            }
        
        public void moveDown ()
            {
                board.moveDown();
                board.generateNewTile();
            }
        
        public void moveLeft ()
            {
                board.moveLeft();
                board.generateNewTile();
            }
        
        public void moveRight ()
            {
                board.moveRight();
                board.generateNewTile();
            }
        
        public void gameLoop () throws IOException
            {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while (true)
                    {
                        System.out.println(board.toString());
                        System.out.println("Enter a move: ");
                        String move = reader.readLine();
                        switch (move)
                            {
                                case "w" -> moveUp();
                                case "s" -> moveDown();
                                case "a" -> moveLeft();
                                case "d" -> moveRight();
                                default -> System.out.println("Invalid move.");
                            }
                    }
            }
        
        public static void main(String[] args) throws IOException
            {
                Game game = new Game(4, 4);
                game.gameLoop();
            }
    }
