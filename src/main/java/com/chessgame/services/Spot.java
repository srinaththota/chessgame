package com.chessgame.services;

public class Spot {
	
	private Piece piece;
	private char horizontal;
	private int vertical;
	
	public Spot(char horizontal, int vertical,Piece piece) {
		super();
		this.piece = piece;
		this.horizontal = horizontal;
		this.vertical = vertical;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public char getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(char horizontal) {
		this.horizontal = horizontal;
	}

	public int getVertical() {
		return vertical;
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;
	}
	
	

}
