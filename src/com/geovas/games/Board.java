package com.geovas.games;

public class Board {
    private int size;
    private int board[][];

    public Board(int size) {
        board = new int[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                board[x][y] = 0;
            }
        }
        this.size = size;
    }

    public Board() {
        this(3);
    }

    public boolean setXY(int x, int y, int symbol) {
        if (x < 0 || x >= size || y < 0 || y >= size) {
            return false;
        }

        if (board[x][y] != 0) {
            return false;
        }

        if (symbol != -1 && symbol != 1) {
            return false;
        }

        board[x][y] = symbol;
        return true;
    }

    public int getXY(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return board[x][y];
        } else {
            return 0;
        }
    }

    public int getSize(){
        return size;
    }
}
