package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece {

	private Color color;
    //construtores para indicar a classe Piece extendida no inicio da classe
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	public Color getColor() {
		return color;
	}
	
	

}
