package com.derekporcelli.two_zero_four_eight;

import javafx.scene.Node;

public class Board
    {
        private int boardWidth;
        private int boardHeight;
        private int[][] board;
        
        public Board (int boardHeight, int boardWidth)
            {
                this.boardHeight = boardHeight;
                this.boardWidth = boardWidth;
                board = new int[boardHeight][boardWidth];
            }
        
        public Board (int[][] board)
            {
                this.board = board;
                boardHeight = board.length;
                boardWidth = board[0].length;
            }
        
        public int[][] getBoard ()
            {
                return board;
            }
        
        public void setBoard (int[][] board)
            {
                this.board = board;
            }
        
        public int getBoardWidth ()
            {
                return boardWidth;
            }
        
        public void setBoardWidth (int boardWidth)
            {
                this.boardWidth = boardWidth;
            }
        
        public int getBoardHeight ()
            {
                return boardHeight;
            }
        
        public void setBoardHeight (int boardHeight)
            {
                this.boardHeight = boardHeight;
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
                for (int i = 0; i < boardHeight; i++)
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
                        for (int j = 0; j < boardWidth; j++)
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
        public void generateNewTile ()
            {
                int i = (int) (Math.random() * boardHeight);
                int j = (int) (Math.random() * boardWidth);
                while (board[i][j] != 0)
                    {
                        i = (int) (Math.random() * boardHeight);
                        j = (int) (Math.random() * boardWidth);
                    }
                board[i][j] = 2;
            }
    }
