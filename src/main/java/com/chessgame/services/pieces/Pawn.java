package com.chessgame.services.pieces;

import com.chessgame.services.Board;
import com.chessgame.services.Piece;
import com.chessgame.services.Player;
import com.chessgame.services.Spot;
import com.chessgame.services.WinningStatus;

public class Pawn implements Piece{

	private String name;
	private boolean killed;
	private boolean white;
	
	public Pawn(boolean white) {
		
		if(white) {
			setName("PAWN");
		}
		else {
			setName("pawn");
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
		
		if(this.isWhite()) {
			//for single move
			if(end.getHorizontal()-start.getHorizontal()==1 
					&& board.boxes[end.getHorizontal()][end.getVertical()].getPiece()==null){
				return true;
			}
			
			//for killing opponent
			if(end.getPiece()!= null && !end.getPiece().isWhite()) {
				if(end.getHorizontal()-start.getHorizontal()==1
						&& end.getVertical()-start.getVertical()==1) {
					return true;
				}
				if(end.getHorizontal()-start.getHorizontal()==1
						&& end.getVertical()-start.getVertical()==-1) {
					return true;
				}
			}
			
			//for 2 block move
			if(start.getHorizontal() == 'b') {
				if(end.getHorizontal()-start.getHorizontal()==2
						&& board.boxes[end.getHorizontal()][end.getVertical()].getPiece()==null){
					return true;
				}
			}
		}
		else {
			if(end.getHorizontal()-start.getHorizontal()==-1
					&& board.boxes[end.getHorizontal()][end.getVertical()].getPiece()==null){
				return true;
			}
			if(end.getPiece()!=null && end.getPiece().isWhite()) {
				if(end.getHorizontal()-start.getHorizontal()==-1
						&& end.getVertical()-start.getVertical()==-1) {
					return true;
				}
				if(end.getHorizontal()-start.getHorizontal()==-1
						&& end.getVertical()-start.getVertical()==1) {
					return true;
				}
			}
			
			//for 2 block move
			if(start.getHorizontal() == 'g') {
				if(end.getHorizontal()-start.getHorizontal()==-2
						&& board.boxes[end.getHorizontal()][end.getVertical()].getPiece()==null){
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public boolean isNextMoveOnKing(WinningStatus status, Player player, Board board, Spot end) {
		// TODO Auto-generated method stub
		if(player.isWhite()) {
			char horizontalIncrement=end.getHorizontal();
			int verticalIncrement=end.getVertical();
			
			
			if(horizontalIncrement<'h' && verticalIncrement < 7) {
			Piece p=board.boxes[horizontalIncrement+1][verticalIncrement+1].getPiece();
			if(p!=null && p instanceof King) {
				status.identifyCheckMate(player, p);
			}
			}
			if(horizontalIncrement<'h' && verticalIncrement > 0) {
			Piece pLeftSide=board.boxes[horizontalIncrement+1][verticalIncrement-1].getPiece();
			if(pLeftSide!=null && pLeftSide instanceof King) {
				status.identifyCheckMate(player, pLeftSide);
			}
			}
			//for other direction		
		}else {
		
			char horizontalDecrement=end.getHorizontal();
			int verticalIncrement=end.getVertical();
			if(horizontalDecrement>'a' && verticalIncrement < 7) {
			Piece p=board.boxes[horizontalDecrement-1][verticalIncrement+1].getPiece();
			if(p!=null && p instanceof King) {
				status.identifyCheckMate(player, p);
			}
			}
			if(horizontalDecrement>'a' && verticalIncrement > 0) {
			Piece pLeftSide=board.boxes[horizontalDecrement-1][verticalIncrement-1].getPiece();
			if(pLeftSide!=null && pLeftSide instanceof King) {
				status.identifyCheckMate(player, pLeftSide);
			}
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
