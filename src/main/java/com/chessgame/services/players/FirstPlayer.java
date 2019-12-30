package com.chessgame.services.players;

import com.chessgame.services.Player;

public class FirstPlayer implements Player {
	
	private static Player player;
	private boolean white;
	
	private FirstPlayer(boolean whiteSide) {
		this.white=whiteSide;
		
	}
	
	public static Player getInstance(boolean whiteSide) {
		if(player==null) {
			player=new FirstPlayer(true);
		}
		return player;
	}

	@Override
	public boolean isWhite() {
		// TODO Auto-generated method stub
		return white;
	}
}
