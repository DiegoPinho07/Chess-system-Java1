package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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

	//método para identificar os movimentos possíveis
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	

	
	//Método para retornar as posições possíveis de movimento do rei, entretanto por padrão, na matriz só terá posições falsas. Como se o rei estivesse preso
	@Override
	public boolean[][] possibleMoves() {
		boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		//Movimentos acima
		p.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//Movimentos abaixo
				p.setValues(position.getRow() +1, position.getColumn());
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//Movimentos à esquerda
				p.setValues(position.getRow() , position.getColumn() -1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//Movimentos à direita
				p.setValues(position.getRow() , position.getColumn() + 1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
		
				//Movimentos à noroeste
				p.setValues(position.getRow() - 1, position.getColumn() -1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//Movimentos à nordeste
				p.setValues(position.getRow() -1, position.getColumn() +1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//Movimentos à sudoeste
				p.setValues(position.getRow() +1, position.getColumn() -1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
				
				//Movimentos à sudeste
				p.setValues(position.getRow() +1, position.getColumn() +1);
				if(getBoard().positionExists(p) && canMove(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
		return mat;
	}

}
