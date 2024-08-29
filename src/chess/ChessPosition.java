package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;
	
	public ChessPosition(char column, int row ) {
		if(column < 'a' || column > 'h' || row < 1 || row >8 ) {
			throw new chessException("Erro ao instaciar a posição no xadrez, Posição válida somente entre A a H e entre 1 e 8");
			
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	

	public int getRow() {
		return row;
	}

	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
		
	}

}
