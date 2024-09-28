package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	//criando as classes turn e currentPlayer para indicar o turno e o jogador atual
	private int turn;
	private Color currentPlayer;
    private Board board;
	//classe que vai construir o xadrez e instanciar as regras da cada peça
	public ChessMatch() {
		//instanciando  o tabuleiro com os valores de linhas e colunas e os turnos e jogadores
		board = new Board(8 , 8);
		turn = 1;
		currentPlayer = Color.WHITE;
		initialSetup();
		}
	//criando os GETs e SETs para possibilitar o chamamento do objeto em outras classes
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer(){
		return currentPlayer;
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
	//método criado para que se possa imprimir as posições possíveis a partir da posição de origem
	public boolean[][] possibleMoves(ChessPosition sourcePosition){
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	
	//método para demonstrar a performace da peça, como movimento, captura, etc
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		//convertendo o método para a string do chassMatch
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		//validação se na posição existe alguma peça
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		//DownCasting do método pois capturedPiece é da classe Piece, que é uma classe abaixo da classe chassMatch
		nextTurn();
		return (ChessPiece) capturedPiece;
	}

	//excessão para validação da existência da posição da peça.
	private void validateSourcePosition(Position position) {
		if(!board.thereIsAPiece(position)) {
			throw new chessException("Existe uma peça na posição de origem!!");
		}
		if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()){
			throw new chessException("A peça escolhida não é sua!");
		}
		//verificando se existe algum movimento possível para a peça indicada
		if(!board.piece(position).isThereAnyPossibleMoves()) {
			throw new chessException("Nao existem movimentos possiveis para a peca escolhida!");
		}
	}
	
	//validando se a posição de destino é válida em relação à posição de origem
		private void validateTargetPosition(Position source, Position target) {
			if(!board.piece(source).possibleMoves(target)) {
				throw new chessException("A peça de origem não pode se mover ao destino");
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
	
	private void nextTurn() {
		turn ++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
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
