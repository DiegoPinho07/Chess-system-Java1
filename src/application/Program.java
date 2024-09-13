package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//instanciando a classe Chessmatch
         ChessMatch chessMatch = new ChessMatch();
         
         
         while(true) {
         UI.printBoard(chessMatch.getPieces());
         System.out.println();
         System.out.print("Origem: ");
         ChessPosition source = UI.readChessPosition(sc);
         
         System.out.println();
         System.out.print("Destino: ");
         ChessPosition target = UI.readChessPosition(sc);
         //instanciar o método performChessMove da classe chessMatch para realizar a movimentação da peça
         ChessPiece capturedChessPiece = chessMatch.performChessMove(source, target);
       }
	}
	
}