package com.chessgame.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chessgame.services.players.FirstPlayer;
import com.chessgame.services.players.SecondPlayer;

@Service
public class Game { 
	private Player[] players=new Player[2]; 
	@Autowired
	private Board board; 
	private Player currentTurn; 
	@Autowired
	private WinningStatus status; 
 
	public void initialize(Player p1, Player p2) 
	{ 
		players[0] = p1; 
		players[1] = p2; 

		if (p1.isWhite()) { 
			this.currentTurn = p1; 
		} 
		else { 
			this.currentTurn = p2; 
		} 
		board.resetBoard();
	} 


	public boolean playerMove(char startHorizontal,  
			int startVertical, char endHorizontal, int endVertical) throws Exception 
	{ 
		
		Spot startBox = board.getLocation(startHorizontal, startVertical); 
		Spot endBox = board.getLocation(endHorizontal, endVertical);
		Piece p=board.boxes[startHorizontal][startVertical].getPiece();
		Player player=null;
		if(p!=null) {
			if(p.isWhite()) {
				player=FirstPlayer.getInstance(true);
			}else {
				player=SecondPlayer.getInstance(false);
			}
		}
		Move move = new Move(player, startBox, endBox); 
		return this.makeMove(move, player); 
	} 

	private boolean makeMove(Move move,Player player) {

		Piece piece=move.getStart().getPiece();
		
		Piece destPiece=move.getEnd().getPiece();
		
		if (piece == null) { 
			return false; 
		} 
		if (player != currentTurn) { 
			return false; 
		}
		if(!piece.canMove(board, move.getStart(), move.getEnd())) {
			return false;
		}
		
			
		
		
		if(destPiece!=null) {
			destPiece.setKilled(true);
			move.setSetPieceKilled(destPiece);
		}

		//moving piece from source to destination
		move.getEnd().setPiece(move.getStart().getPiece());
		move.getStart().setPiece(null);
		piece.isNextMoveOnKing(status,player, board,move.getEnd());
				if (this.currentTurn == players[0]) { 
			this.currentTurn = players[1]; 
		} 
		else { 
			this.currentTurn = players[0]; 
		} 
		return true;
	}

}