package com.chessgame.services;

import org.springframework.stereotype.Component;

import com.chessgame.services.pieces.*;

@Component
public class Board {

	public Spot[][] boxes = new Spot['i'][8];
	
	public Spot getLocation(int horizontal,int vertical) throws Exception {
		
		if(horizontal < 'a' || horizontal > 'h' || vertical < 0 || vertical > 7) {
			throw new Exception("moving out of the board");
		}
		
		return boxes[horizontal][vertical];
	}
	
	public void resetBoard() {
		
		boxes['a'][0]=new Spot('a',0,new Rook(true));
		boxes['a'][1]=new Spot('a',1,new Knight(true));
		boxes['a'][2]=new Spot('a',2,new Bishop(true));
		boxes['a'][3]=new Spot('a',3,new Queen(true));
		boxes['a'][4]=new Spot('a',4,new King(true));
		boxes['a'][5]=new Spot('a',5,new Bishop(true));
		boxes['a'][6]=new Spot('a',6,new Knight(true));
		boxes['a'][7]=new Spot('a',7,new Rook(true));
		
		char k='b';
		for(int i=0;i<=7;i++) {
			boxes[k][i]=new Spot(k,i,new Pawn(true));
		}
		
		k='g';
		for(int i=0;i<8;i++) {
			boxes[k][i]=new Spot(k,i,new Pawn(false));
		}
		
		boxes['h'][0]=new Spot('h',0,new Rook(false));
		boxes['h'][1]=new Spot('h',1,new Knight(false));
		boxes['h'][2]=new Spot('h',2,new Bishop(false));
		boxes['h'][3]=new Spot('h',3,new Queen(false));
		boxes['h'][4]=new Spot('h',4,new King(false));
		boxes['h'][5]=new Spot('h',5,new Bishop(false));
		boxes['h'][6]=new Spot('h',6,new Knight(false));
		boxes['h'][7]=new Spot('h',7,new Rook(false));
		
		for (char i = 'c'; i <= 'f'; i++) { 
            for (int j = 0; j < 8; j++) { 
                boxes[i][j] = new Spot(i, j, null); 
            } 
        } 
	}
	
}
