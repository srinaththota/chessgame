package com.chessgame.controller;

import com.chessgame.services.Spot;

public class BoardStatus {

	Spot[][] spots;
	String gamestatus;
	
	
	public BoardStatus(Spot[][] boxes, String gamestatus) {
		this.spots=boxes;
		this.gamestatus=gamestatus;
	}
	public Spot[][] getSpots() {
		return spots;
	}
	public void setSpots(Spot[][] spots) {
		this.spots = spots;
	}
	public String getGamestatus() {
		return gamestatus;
	}
	public void setGamestatus(String gamestatus) {
		this.gamestatus = gamestatus;
	}
	
	
}
