package com.chessgame.services;

public class Move { 
    private Player player; 
    private Spot start; 
    private Spot end; 
    private Piece pieceMoved; 
    private Piece setPieceKilled;
   
   
    public Move(Player player, Spot start, Spot end) 
    { 
        this.setPlayer(player); 
        this.setStart(start); 
        this.setEnd(end); 
        this.setPieceMoved(start.getPiece()); 
    }


	public Piece getPieceMoved() {
		return pieceMoved;
	}


	public void setPieceMoved(Piece pieceMoved) {
		this.pieceMoved = pieceMoved;
	}


	public Spot getStart() {
		return start;
	}


	public void setStart(Spot start) {
		this.start = start;
	}


	public Spot getEnd() {
		return end;
	}


	public void setEnd(Spot end) {
		this.end = end;
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}


	public Piece getSetPieceKilled() {
		return setPieceKilled;
	}


	public void setSetPieceKilled(Piece setPieceKilled) {
		this.setPieceKilled = setPieceKilled;
	}  
} 
