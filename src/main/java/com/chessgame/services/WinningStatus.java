package com.chessgame.services;

import org.springframework.stereotype.Component;



@Component
public class WinningStatus {
	
	private boolean blackWin;
	private boolean whiteWin;
	
	public boolean isBlackWin() {
		return blackWin;
	}
	public void setBlackWin(boolean blackWin) {
		this.blackWin = blackWin;
	}
	public boolean isWhiteWin() {
		return whiteWin;
	}
	public void setWhiteWin(boolean whiteWin) {
		this.whiteWin = whiteWin;
	}
	
	public void identifyCheckMate(Player player,Piece p) {
		if(player.isWhite()!=p.isWhite()) {	
				if(player.isWhite()) {
				whiteWin=true;
				}else {
					blackWin=true;
				}
			}
		}
	
	
}
