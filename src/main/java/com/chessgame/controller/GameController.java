package com.chessgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chessgame.services.Board;
import com.chessgame.services.Game;
import com.chessgame.services.Piece;
import com.chessgame.services.Player;
import com.chessgame.services.Spot;
import com.chessgame.services.WinningStatus;
import com.chessgame.services.players.FirstPlayer;
import com.chessgame.services.players.SecondPlayer;

@RestController
public class GameController {

	@Autowired
	Game game;
	@Autowired
	Board board;
	@Autowired
	WinningStatus status;

	@RequestMapping(value="/upload",method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam("file")	MultipartFile file){
		return new ResponseEntity<>("file is uploaded",HttpStatus.OK);
	}

	@GetMapping("/startgame")
	public String startgame() {
		Player fp=FirstPlayer.getInstance(true);
		Player sp=SecondPlayer.getInstance(false);
		//Game initGame=new Game();
		game.initialize(fp, sp);
		return "Game started";

	}

	@PostMapping("/move")
	public String movePiece(@RequestBody String movement) throws Exception {

		try {
			if(board.boxes['a'][0]==null) {
				return "please start the game before making a move"; 
			}
			System.out.println("*******"+movement+"*******");
			//game.playerMove('b', 0, 'c', 0);
			//game.playerMove('g', 0, 'e', 0);
			game.playerMove(movement.charAt(0),Character.getNumericValue(movement.charAt(1)), 
					movement.charAt(2), 
					Character.getNumericValue(movement.charAt(3)));
			if(status.isWhiteWin()) {
				return "FirstPlayer has Won";
			}
			else if(status.isBlackWin()) {
				return "SeconPlayer has Won";
			}
		}
		catch(Exception e) {
			throw new WrongMovesException();
		}
		return displayPiecesOn(board.boxes);

	}

	String displayPiecesOn(Spot[][] spots){
		String currentBoardStatus="";
		for(char i='a';i<='h';i++) {
			for(int j=0;j<8;j++) {
				Piece p=spots[i][j].getPiece();
				if(p==null || p.isKilled(true)) {
					currentBoardStatus += i+""+j+" ";
				}else {
					currentBoardStatus += p.getName();
				}

			}
			currentBoardStatus += "\n";
		}
		System.out.println(currentBoardStatus);
		return currentBoardStatus;


	}
	
	@PostMapping("/movepiece")
	public BoardStatus movePieces(@RequestBody String movement) throws Exception {

		try {
			if(board.boxes[0][0]==null) {
				return new BoardStatus(board.boxes,"start the game");
			}
			System.out.println("*******"+movement+"*******");
			//game.playerMove('b', 0, 'c', 0);
			//game.playerMove('g', 0, 'e', 0);
			game.playerMove(movement.charAt(0),Character.getNumericValue(movement.charAt(1)), 
					movement.charAt(2), 
					Character.getNumericValue(movement.charAt(3)));
			if(status.isWhiteWin()) {
				return new BoardStatus(board.boxes,"White win");
			}
			else if(status.isBlackWin()) {
				return new BoardStatus(board.boxes,"Black win");
			}
		}
		catch(Exception e) {
			throw new WrongMovesException();
		}
		return new BoardStatus(board.boxes,"continue");

	}
}
