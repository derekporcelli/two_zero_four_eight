package com.derekporcelli.two_zero_four_eight;

import javafx.scene.Node;

public class Board
    {
        private final int boardWidth;
        private final int boardHeight;
        private int[][] board;
        private int startingValue;
        
        public Board (int boardHeight, int boardWidth, int startingValue)
            {
                this.boardHeight = boardHeight;
                this.boardWidth = boardWidth;
                this.startingValue = startingValue;
                board = new int[boardHeight][boardWidth];
                generateNewTile();
                generateNewTile();
            }
        
        
        public int[][] getBoard ()
            {
                return board;
            }
        
        public int getBoardWidth ()
            {
                return boardWidth;
            }
        
        
        public int getBoardHeight ()
            {
                return boardHeight;
            }
        
        
        public String toString ()
            {
                String boardString = "";
                for (int i = 0; i < boardHeight; i++)
                    {
                        for (int j = 0; j < boardWidth; j++)
                            {
                                boardString += board[i][j] + " ";
                            }
                        boardString += "\n";
                    }
                return boardString;
            }
        
        public boolean moveUp ()
            {
                boolean hasMoved = false;
                for (int i = 1; i < boardHeight; i++)
                    {
                        for (int j = 0; j < boardWidth; j++)
                            {
                                if (board[i][j] == 0)
                                    {
                                        continue;
                                    }
                                int k = i;
                                while (k > 0 && board[k - 1][j] == 0)
                                    {
                                        hasMoved = true;
                                        board[k - 1][j] = board[k][j];
                                        board[k][j] = 0;
                                        k--;
                                    }
                                if (k > 0 && board[k - 1][j] == board[k][j])
                                    {
                                        hasMoved = true;
                                        board[k - 1][j] *= 2;
                                        board[k][j] = 0;
                                        k--;
                                    }
                            }
                    }
                return hasMoved;
            }
        
        public boolean moveDown ()
            {
                boolean hasMoved = false;
                for (int i = boardHeight - 1; i >= 0; i--)
                    {
                        for (int j = 0; j < boardWidth; j++)
                            {
                                if (board[i][j] == 0)
                                    {
                                        continue;
                                    }
                                int k = i;
                                while (k < boardHeight - 1 && board[k + 1][j] == 0)
                                    {
                                        hasMoved = true;
                                        board[k + 1][j] = board[k][j];
                                        board[k][j] = 0;
                                        k++;
                                    }
                                if (k < boardHeight - 1 && board[k + 1][j] == board[k][j])
                                    {
                                        hasMoved = true;
                                        board[k + 1][j] *= 2;
                                        board[k][j] = 0;
                                        k++;
                                    }
                            }
                    }
                return hasMoved;
            }
        
        public boolean moveLeft ()
            {
                boolean hasMoved = false;
                for (int i = 0; i < boardHeight; i++)
                    {
                        for (int j = 1; j < boardWidth; j++)
                            {
                                if (board[i][j] == 0)
                                    {
                                        continue;
                                    }
                                int k = j;
                                while (k > 0 && board[i][k - 1] == 0)
                                    {
                                        hasMoved = true;
                                        board[i][k - 1] = board[i][k];
                                        board[i][k] = 0;
                                        k--;
                                    }
                                if (k > 0 && board[i][k - 1] == board[i][k])
                                    {
                                        hasMoved = true;
                                        board[i][k - 1] *= 2;
                                        board[i][k] = 0;
                                        k--;
                                    }
                            }
                    }
                return hasMoved;
            }
        
        public boolean moveRight ()
            {
                boolean hasMoved = false;
                for (int i = 0; i < boardHeight; i++)
                    {
                        for (int j = boardWidth - 1; j >= 0; j--)
                            {
                                if (board[i][j] == 0)
                                    {
                                        continue;
                                    }
                                int k = j;
                                while (k < boardWidth - 1 && board[i][k + 1] == 0)
                                    {
                                        hasMoved = true;
                                        board[i][k + 1] = board[i][k];
                                        board[i][k] = 0;
                                        k++;
                                    }
                                if (k < boardWidth - 1 && board[i][k + 1] == board[i][k])
                                    {
                                        hasMoved = true;
                                        board[i][k + 1] *= 2;
                                        board[i][k] = 0;
                                        k++;
                                    }
                            }
                    }
                return hasMoved;
            }
        
        public void move(Direction direction)
            {
                boolean moved = false;
                switch (direction)
                    {
                        case UP:
                            moved = this.moveUp();
                            break;
                        case DOWN:
                            moved = this.moveDown();
                            break;
                        case LEFT:
                            moved = this.moveLeft();
                            break;
                        case RIGHT:
                            moved = this.moveRight();
                            break;
                    }
                if (moved)
                    {
                        this.generateNewTile();
                    }
            }
        
        public boolean checkGameOver ()
            {
                for (int i = 0; i < boardHeight; i++)
                    {
                        for (int j = 0; j < boardWidth; j++)
                            {
                                if (board[i][j] == 0)
                                    {
                                        return false;
                                    }
                                if (i > 0 && board[i][j] == board[i - 1][j])
                                    {
                                        return false;
                                    }
                                if (i < boardHeight - 1 && board[i][j] == board[i + 1][j])
                                    {
                                        return false;
                                    }
                                if (j > 0 && board[i][j] == board[i][j - 1])
                                    {
                                        return false;
                                    }
                                if (j < boardWidth - 1 && board[i][j] == board[i][j + 1])
                                    {
                                        return false;
                                    }
                            }
                    }
                return true;
            }
        
        public Board reset ()
            {
                return new Board(boardHeight, boardWidth, startingValue);
            }
        
        public void generateNewTile ()
            {
                int i = (int) (Math.random() * boardHeight);
                int j = (int) (Math.random() * boardWidth);
                while (board[i][j] != 0)
                    {
                        i = (int) (Math.random() * boardHeight);
                        j = (int) (Math.random() * boardWidth);
                    }
                if (Math.random() < 0.9)
                    {
                        board[i][j] = startingValue;
                    }
                else
                    {
                        board[i][j] = startingValue * 2;
                    }
                board[i][j] = startingValue;
            }
    }
