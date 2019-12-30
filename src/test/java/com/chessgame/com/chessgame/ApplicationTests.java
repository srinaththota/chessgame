package com.chessgame.com.chessgame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.chessgame.Application;
import com.chessgame.services.Game;
import com.chessgame.services.WinningStatus;
import com.chessgame.services.players.FirstPlayer;
import com.chessgame.services.players.SecondPlayer;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
class ApplicationTests {

	@Autowired
	Game game;
	@Autowired
	WinningStatus status;


	@Test void knightWhiteCheckMate() throws Exception {
		game.initialize(FirstPlayer.getInstance(true),
				SecondPlayer.getInstance(false)); 
		File resource = new File("src\\test\\resources\\checkMateByBlackBishop");
		BufferedReader br=new BufferedReader(new FileReader(resource)); 
		String eachPos="";
		while((eachPos=br.readLine())!=null) { 
			System.out.println(eachPos);
			assert(game.playerMove(eachPos.charAt(0) ,
					Character.getNumericValue(eachPos.charAt(1)) , 
					eachPos.charAt(2) ,
					Character.getNumericValue(eachPos.charAt(3)))); 
		}
		assert(status.isWhiteWin()); 
		br.close();
	}

	@Test
	void bishopBlackCheckMate() throws Exception{
		game.initialize(FirstPlayer.getInstance(true), 
				SecondPlayer.getInstance(false));
		File resource = new File("src\\test\\resources\\checkMateByWhiteKnight");
		BufferedReader br=new BufferedReader(new FileReader(resource));
		String eachPos="";
		while((eachPos=br.readLine())!=null) {
			assert(game.playerMove(eachPos.charAt(0) 
					,Character.getNumericValue(eachPos.charAt(1)) 
					,eachPos.charAt(2)
					,Character.getNumericValue(eachPos.charAt(3))));
		}
		assert(status.isBlackWin());
		br.close();
	}
	
	@Test
	void queenWhiteCheckMate() throws Exception{
		game.initialize(FirstPlayer.getInstance(true), 
				SecondPlayer.getInstance(false));
		File resource = new File("src\\test\\resources\\checkMateByWhitePawn");
		BufferedReader br=new BufferedReader(new FileReader(resource));
		String eachPos="";
		while((eachPos=br.readLine())!=null) {
			assert(game.playerMove(eachPos.charAt(0) 
					,Character.getNumericValue(eachPos.charAt(1)) 
					,eachPos.charAt(2)
					,Character.getNumericValue(eachPos.charAt(3))));
		}
		assert(status.isBlackWin());
		br.close();
	}
	@Test
	void killingPawnByWhite() throws Exception{
		game.initialize(FirstPlayer.getInstance(true), 
				SecondPlayer.getInstance(false));
		File resource = new File("src\\test\\resources\\checkMateByWhiteQueen");
		BufferedReader br=new BufferedReader(new FileReader(resource));
		String eachPos="";
		while((eachPos=br.readLine())!=null) {
			assert(game.playerMove(eachPos.charAt(0) 
					,Character.getNumericValue(eachPos.charAt(1)) 
					,eachPos.charAt(2)
					,Character.getNumericValue(eachPos.charAt(3))));
		}
		assert(status.isWhiteWin());	
		br.close();
	}
	@Test
	void rookByBlackCheckMate() throws Exception{
		game.initialize(FirstPlayer.getInstance(true), 
				SecondPlayer.getInstance(false));
		File resource = new File("src\\test\\resources\\checkMateByBlackRook");
		BufferedReader br=new BufferedReader(new FileReader(resource));
		String eachPos="";
		while((eachPos=br.readLine())!=null) {
			assert(game.playerMove(eachPos.charAt(0) 
					,Character.getNumericValue(eachPos.charAt(1)) 
					,eachPos.charAt(2)
					,Character.getNumericValue(eachPos.charAt(3))));
		}
		assert(status.isWhiteWin());	
		br.close();
	}
}



