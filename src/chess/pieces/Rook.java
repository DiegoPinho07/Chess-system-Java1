package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
	super(board, color);
	
	}
	
	@Override
	public String toString() {
		return "R";
	}
	//Verificando a possibilidade de movimentos
	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		//Verificando movimentos acima
		Position p = new Position (0 , 0);
		
		p.setValues(position.getRow() - 1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			//indicou que a posição está vaga e qua a peça pode se mover até lá
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		//identificou se na posição tem uma peça de oposição, podendo então, ser movida para lá
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
        //verificando movimentos à esquerda
		
		p.setValues(position.getRow(), position.getColumn() - 1);
		while(getBoard().positionExists(p) && ! getBoard().thereIsAPiece(p)){
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//verificando movimentos à direita
		
		p.setValues(position.getRow(), position.getColumn() +1);
		while(getBoard().positionExists(p) && ! getBoard().thereIsAPiece(p)){
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() +1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() +1, position.getColumn());
		while(getBoard().positionExists(p) && ! getBoard().thereIsAPiece(p)){
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() +1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		
		return mat;
	}


}
