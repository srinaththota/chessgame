package com.chessgame.services.pieces;

import com.chessgame.services.Board;
import com.chessgame.services.Piece;
import com.chessgame.services.Player;
import com.chessgame.services.Spot;
import com.chessgame.services.WinningStatus;

public class Queen implements Piece{
	private String name;
	private boolean killed;
	private boolean white;
	public Queen(boolean white) {
		if(white) {
			setName("QUEEN");
		}
		else {
			setName("queen");
		}
		setWhite(white);
	}

	@Override
	public boolean canMove(Board board, Spot start, Spot end) {
		// TODO Auto-generated method stub

		if (end.getPiece()!=null && end.getPiece().isWhite() == this.isWhite()) { 
			return false; 
		} 
		if(Math.abs(start.getHorizontal()-end.getHorizontal())==Math.abs(start.getVertical()-end.getVertical())) {

			if(start.getHorizontal() < end.getHorizontal() && start.getVertical() < end.getVertical()) {// forward move check any pieces fall in between
				for(int i=start.getHorizontal()+1,j=start.getVertical()+1;i<end.getHorizontal() && j< end.getVertical();i++,j++) {
					if(board.boxes[i][j].getPiece()!=null) {
						return false;
					}
				}
			}
			if(start.getHorizontal() > end.getHorizontal() && start.getVertical() > end.getVertical()) {// backward move check any pieces fall in between
				for(int i=start.getHorizontal()-1,j=start.getVertical()-1;i>end.getHorizontal() && j>end.getVertical();i--,j--) {
					if(board.boxes[i][j].getPiece()!=null) {
						return false;
					}
				}
			}

			if(start.getHorizontal() > end.getHorizontal() && start.getVertical() < end.getVertical()) {
				for(int i=start.getHorizontal()-1,j=start.getVertical()+1;i>end.getHorizontal() && j<end.getVertical();i--,j++) {
					if(board.boxes[i][j].getPiece()!=null) {
						return false;
					}
				}
			}
			if(start.getHorizontal() < end.getHorizontal() && start.getVertical() > end.getVertical()) {
				for(int i=start.getHorizontal()+1,j=start.getVertical()-1;i<end.getHorizontal() && j>end.getVertical();i++,j--) {
					if(board.boxes[i][j].getPiece()!=null) {
						return false;
					}
				}
			}
			return true;
		}

		if(start.getHorizontal()==end.getHorizontal()) {
			int i=start.getHorizontal();
			int min=Math.min(start.getVertical(),end.getVertical());
			int max=Math.max(start.getVertical(), end.getVertical());
			for(int j=min;j<max;j++) {
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
			
			for(char j=min;j<max;j++) {
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
		
		
		////for diagonal movements
	
		char horozontalIncrementalCheck=end.getHorizontal();
		int verticalIncrementCheck=end.getVertical();
		while(verticalIncrementCheck<7
				&& horozontalIncrementalCheck < 'h' ) {
			verticalIncrementCheck++;
			horozontalIncrementalCheck++;

			Piece p=board
					.boxes[horozontalIncrementalCheck][verticalIncrementCheck]
							.getPiece();
			
			if(p!=null && !(p instanceof King)) {
				break;
			}
			else if(p!=null && p instanceof King) {
				status.identifyCheckMate(player, p);
			}
		}
		horozontalIncrementalCheck=end.getHorizontal();
		int verticalDecrementCheck=end.getVertical();
		while(horozontalIncrementalCheck < 'h' 
				&& verticalDecrementCheck > 0) {
			horozontalIncrementalCheck++;
			verticalDecrementCheck--;
			Piece p=board
					.boxes[horozontalIncrementalCheck][verticalDecrementCheck]
							.getPiece();
			
			if(p!=null && !(p instanceof King)) {
				break;
			}
			else if(p!=null && p instanceof King) {
				status.identifyCheckMate(player, p);
			}

		}
		char horozontalDecrementCheck=end.getHorizontal();
		verticalIncrementCheck=end.getVertical();
		while(horozontalDecrementCheck > 'a' 
		&& verticalIncrementCheck < 7) {
			horozontalDecrementCheck--;
			verticalIncrementCheck++;
			Piece p=board
					.boxes[horozontalDecrementCheck][verticalIncrementCheck]
							.getPiece();
			
			if(p!=null && !(p instanceof King)) {
				break;
			}
			else if(p!=null && p instanceof King) {
				status.identifyCheckMate(player, p);
			}

		}
		horozontalDecrementCheck=end.getHorizontal();
		verticalDecrementCheck=end.getVertical();
		while(horozontalDecrementCheck > 'a' 
		&& verticalDecrementCheck > 0) {
			horozontalDecrementCheck--;
			verticalDecrementCheck--;
			Piece p=board
					.boxes[horozontalDecrementCheck][verticalDecrementCheck]
							.getPiece();
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
