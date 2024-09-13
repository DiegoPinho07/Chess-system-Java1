package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;
	//classe que vai construir o xadrez e instanciar as regras da cada peça
	public ChessMatch() {
		//instanciando  o tabuleiro com os valores de linhas e colunas
		board = new Board(8 , 8);
		initialSetup();
		
		
	}
	
	public ChessPiece[][] getPieces(){
		//construindo a matriz do tabuleiro por meio do laço de repetição "for"
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i<board.getRows(); i++) {
			for(int j = 0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i , j);
			}
		}
			return mat;
		}
	//método para demonstrar a performace da peça, como movimento, captura, etc
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		//convertendo o método para a string do chassMatch
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		//validação se na posição existe alguma peça
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		//DownCasting do método pois capturedPiece é da classe Piece, que é uma classe abaixo da classe chassMatch
		return (ChessPiece) capturedPiece;
	}
	//excessão para validação da existência da posição da peça.
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new chessException("Existe uma peça na posição de origem!!");
		}
	}
	private Piece makeMove(Position source, Position target) {
		
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		return capturedPiece;
		
		
	}
	
	
	
	//método que coloca as peças no tabuleiro, instanciando a classe board para puxar as posições do tabuleiro
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	//método que vai colocar as peças no tabuleiro 
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));
		
		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));
}
       

	}
