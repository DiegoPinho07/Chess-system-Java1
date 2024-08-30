package chess;

import boardgame.Position;

public class ChessPosition {
    //para indicar a posição do xadrez com base no desenho do tabuleiro
	private char column;
	private int row;
	//programação defensiva para evitar erro na construção do tabuleiro
	public ChessPosition(char column, int row ) {
		if(column < 'a' || column > 'h' || row < 1 || row >8 ) {
			
			throw new chessException("Erro ao instaciar a posição no xadrez, Posição válida somente entre A a H e entre 1 e 8");
			
		}
		this.column = column;
		this.row = row;
	}
     //na criação dos construtores padrão, nos excluímos os "sets", para evitar alterações nesses atributos
	public char getColumn() {
		return column;
	}

	

	public int getRow() {
		return row;
	}
     //método para receber as informações do usuário para indicar a posição da peça
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
		
	}
	//método para o sistema converter os parâmetros da matriz
     protected static ChessPosition fromPosition(Position position) {
    	 return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
     }
     //método para o retorno na tela da formatação do tabuleiro
     @Override
     public String toString() {
    	 return "" + column + row;
     }
}
