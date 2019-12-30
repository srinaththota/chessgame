package com.chessgame.services.pieces;

import com.chessgame.services.Board;
import com.chessgame.services.Piece;
import com.chessgame.services.Player;
import com.chessgame.services.Spot;
import com.chessgame.services.WinningStatus;

public class Bishop implements Piece{

	private String name;
	private boolean killed;
	private boolean white;


	public Bishop(boolean white) {

		if(white) {
			setName("BISHOP");
		}
		else {
			setName("bishop");
		}
		setWhite(white);

	}

	//it moves diagonally
	@Override
	public boolean canMove(Board board, Spot start, Spot end) {

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
		return false;
	}
	@Override
	public boolean isNextMoveOnKing(WinningStatus status, Player player, Board board, Spot end) {
		// TODO Auto-generated method stub
	
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
		return false;
	}

	@Override
	public boolean isWhite() {
		// TODO Auto-generated method stub
		return this.white;
	}
	public void setWhite(boolean white) {
		this.white = white;
	}

	public boolean isKilled() {
		return killed;
	}

	public void setKilled(boolean killed) {
		this.killed = killed;
	}

}
