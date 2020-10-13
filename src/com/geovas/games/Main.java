package com.geovas.games;

public class Main {

    public static void main(String[] args) {
	int size=3;
	if(args.length > 0){
		size = Integer.valueOf(args[0]);
	}
	new TicTacToe(size);
    }
}
