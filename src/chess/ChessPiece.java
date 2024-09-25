package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

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
	
	//método protegido, pois somente as classes piece e chess piece poderão acessar
	//método para acessar a posição do tabuleiro e verificar se há uma peça do oponente
	protected boolean isThereOpponentPiece(Position position) {
		//verificando se na posição do movimento tem uma peça de uma cor diferente da cor da peça em movimento
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
	
	

}
