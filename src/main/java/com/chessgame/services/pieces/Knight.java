package com.chessgame.services.pieces;

import com.chessgame.services.Board;
import com.chessgame.services.Piece;
import com.chessgame.services.Player;
import com.chessgame.services.Spot;
import com.chessgame.services.WinningStatus;

public class Knight implements Piece{
	
	private String name;
	private boolean killed;
	private boolean white;
	
	public Knight(boolean white) {
		
		if(white) {
			setName("KNIGHT");
		}
		else {
			setName("knight");
		}
		setWhite(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Spot start, Spot end) {
		// TODO Auto-generated method stub
		
		if (end.getPiece()!=null && end.getPiece().isWhite() == this.isWhite()) { 
			return false; 
		} 
		
		if(start.getHorizontal()!=end.getHorizontal()-1 
				&& start.getHorizontal()!=end.getHorizontal()+1
				&& start.getHorizontal() != end.getHorizontal()+2 
				&& start.getHorizontal() != end.getHorizontal()-2) {
			return false;
		}
		if(start.getVertical()!=end.getVertical()+2 
				&& start.getVertical() != end.getVertical()-2
				&& start.getVertical()!=end.getVertical()-1
				&& start.getVertical()!=end.getVertical()+1) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean isNextMoveOnKing(WinningStatus status,Player player,Board board, Spot end) {
		if(end.getHorizontal()+1 <= 'h' && end.getVertical()+2 <=7) {
			Piece p=board.boxes[end.getHorizontal()+1][end.getVertical()+2]
					.getPiece();			
			 if(p!=null && p instanceof King) {
				status.identifyCheckMate(player, p);
			}
		}
		if(end.getHorizontal()-1 <= 'a' && end.getVertical()-2 >= 0) {
			Piece p=board.boxes[end.getHorizontal()-1][end.getVertical()-2]
					.getPiece();
			 if(p!=null && p instanceof King) {
					status.identifyCheckMate(player, p);
				}
		}
		if(end.getHorizontal()-1 <= 'a' && end.getVertical()+2 <= 7) {
			Piece p=board.boxes[end.getHorizontal()-1][end.getVertical()+2]
					.getPiece();
			 if(p!=null && p instanceof King) {
					status.identifyCheckMate(player, p);
				}
		}
		if(end.getHorizontal()+1 >= 'a' && end.getVertical()-2 <= 0) {
			Piece p=board.boxes[end.getHorizontal()-1][end.getVertical()-2]
					.getPiece();
			 if(p!=null && p instanceof King) {
					status.identifyCheckMate(player, p);
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

	

}
