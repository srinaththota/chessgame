package com.chessgame.services;

public interface Piece {
	
	public String getName();
	public boolean isKilled(boolean state);
	public boolean isWhite();
	
	public abstract boolean canMove(Board board, Spot start , Spot end);
	public void setKilled(boolean killed);
	public boolean isNextMoveOnKing(WinningStatus status,
			Player player ,
			Board board,
			Spot end);// we took return type boolean to handle checkmate

}
