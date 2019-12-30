package com.chessgame.services.pieces;

import com.chessgame.services.Board;
import com.chessgame.services.Piece;
import com.chessgame.services.Player;
import com.chessgame.services.Spot;
import com.chessgame.services.WinningStatus;

public class Rook implements Piece {

	private String name;
	private boolean killed;
	private boolean white;
	
	public Rook(boolean white) {
		
		if(white) {
			setName("ROOK");
		}
		else {
			setName("rook");
		}
		setWhite(white);
	}

	public boolean canMove(Board board,Spot start,Spot end) {
		if (end.getPiece()!=null && end.getPiece().isWhite() == this.isWhite()) { 
			return false; 
		} 

		if(start.getHorizontal()==end.getHorizontal()) {
			int i=start.getHorizontal();
			int min=Integer.MAX_VALUE;
			int max=Integer.MIN_VALUE;
			if(start.getVertical() < end.getVertical()) {
				min=start.getVertical();
				max=end.getVertical();
			}else {
				max=start.getVertical();
				min=end.getVertical();
			}
			for(int j=min+1;j<max-1;j++) { // added and subtracted to exclude in starting cells
				if(board.boxes[i][j].getPiece()!=null) {
					return false;
				}
			}
			
			return true;
		}
		if(start.getVertical()==end.getVertical()) {
			int i=start.getVertical();
			char min='k';
			char max='Z';
			if(start.getHorizontal() < end.getHorizontal()) {
				min=start.getHorizontal();
				max=end.getHorizontal();
			}else {
				min=end.getHorizontal();
				max=start.getHorizontal();
			}
			
			for(char j=(char)(min+1);j<max;j++) {
				if(board.boxes[j][i].getPiece()!=null) {
					return false;
				}
			}

			return true;
		}

		return false;
	}
	@Override
	public boolean isNextMoveOnKing(WinningStatus status, Player player, Board board, Spot end) {
		// TODO Auto-generated method stub
		char horizontalStart=end.getHorizontal();//checking from end spot
		int verticalStart=end.getVertical();
		for(int i=verticalStart+1;i<=7;i++) {
			Piece p=board.boxes[horizontalStart][i].getPiece();
			
			if(p!=null && !(p instanceof King)) {
				break;
			}
			else if(p!=null && p instanceof King) {
				status.identifyCheckMate(player, p);
			}
		}
		for(int i=verticalStart-1;i>=0;i--) {
			Piece p=board.boxes[horizontalStart][i].getPiece();
			if(p!=null && !(p instanceof King)) {
				break;
			}
			else if(p!=null && p instanceof King) {
				status.identifyCheckMate(player, p);
			}
		}
		
		for(char c=(char)(horizontalStart-1);c>='a';c--) {
			Piece p=board.boxes[c][verticalStart].getPiece();
			if(p!=null && !(p instanceof King)) {
				break;
			}
			else if(p!=null && p instanceof King) {
				status.identifyCheckMate(player, p);
			}
		}
		for(char c=(char)(horizontalStart+1);c<='h';c++) {
			Piece p=board.boxes[c][verticalStart].getPiece();
			if(p!=null && !(p instanceof King)) {
				break;
			}
			else if(p!=null && p instanceof King) {
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
