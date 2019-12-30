package com.chessgame.services.pieces;

import com.chessgame.services.Board;
import com.chessgame.services.Piece;
import com.chessgame.services.Player;
import com.chessgame.services.Spot;
import com.chessgame.services.WinningStatus;

public class King implements Piece {

	private String name;
	private boolean killed;
	private boolean white;
	public King(boolean white) {
		
		if(white) {
			setName("KING");
		}
		else {
			setName("king");
		}
		setWhite(white);
	}

	@Override
	public boolean canMove(Board board, Spot start, Spot end) {
		// TODO Auto-generated method stub
		if (end.getPiece().isWhite() == this.isWhite()) { 
			return false; 
		} 
		int x = Math.abs(start.getHorizontal()- end.getHorizontal()); 
        int y = Math.abs(start.getVertical() - end.getVertical());
        
        if(start.getHorizontal() == end.getHorizontal() || start.getVertical() == end.getVertical()) {
        	if(x+y==1) {
            	return true;
            }	
        }else {
        	if(x+y==2) {
            	return true;
            }
        }
        
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isKilled(boolean state) {
		// TODO Auto-generated method stub
		return this.killed;
	}

	@Override
	public boolean isWhite() {
		// TODO Auto-generated method stub
		return this.white;
	}

	public void setWhite(boolean white) {
		this.white = white;
	}

	@Override
	public void setKilled(boolean killed) {
		this.killed=killed;
	}

	@Override
	public boolean isNextMoveOnKing(WinningStatus status, Player player, Board board, Spot end) {
		//King cannot check mate
		return false;
	}

}
