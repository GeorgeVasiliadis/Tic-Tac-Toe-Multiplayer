package com.geovas.games;

public class Pair {
    public int x;
    public int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return '(' + String.valueOf(x) + ',' + String.valueOf(y) + ')';
    }
}
