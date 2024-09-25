package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
	super(board, color);
	
	}
	
	@Override
	public String toString() {
		return "K";
	}

	//Método para retornar as posições possíveis de movimento do rei, entretanto por padrão, na matriz só terá posições falsas. Como se o rei estivesse preso
	
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}

}
