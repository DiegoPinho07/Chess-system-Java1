package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;

public class Program {

	public Program() {
		
	}

	public static void main(String[] args) {
		//instanciando a classe Board
         ChessMatch chessMatch = new ChessMatch();
         UI.printBoard(chessMatch.getPieces());
}
	
}