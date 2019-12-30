package com.chessgame.services.players;

import com.chessgame.services.Player;

public class SecondPlayer implements Player{

	private static Player player;
	private boolean black;
	
	private SecondPlayer(boolean whiteSide) {
		this.black=whiteSide;
	}
	
	public static Player getInstance(boolean whiteSide) {
		if(player==null) {
			player=new SecondPlayer(false);
		}
		return player;
	}
	@Override
	public boolean isWhite() {
		// TODO Auto-generated method stub
		return black;
	}

}


