package boardgame;

public abstract class Piece {

	//protegido para não ser acessado pela classe tabuleiro
		protected Position position;
		private Board board;
		
		public Piece(Board board) {
			
			this.board = board;
			position = null;//será nulo para indicar uma peça recém criada, logo não está no tabuleiro
		}
//será feito somente o get pois não deverá ser apontado ao tabuleiro
		protected Board getBoard() {
			return board;
		}
//instancianod o método para verificar se é possível realizar o movimento, retornado uma matriz
		public abstract boolean[][] possibleMoves();
		//rook méthods pois é um método concreto utilizando um método abstrato, e não o contrário
		public boolean possibleMoves(Position position) {
			return possibleMoves()[position.getRow()][position.getColumn()];
		}
		
		public boolean isThereAnyPossibleMoves(){
			
			boolean[][] mat = possibleMoves();
			for(int i = 0; i<mat.length; i++) {
				for(int j = 0; j<mat.length; j++) {
					if (mat[i][j]) {
						
						return true;
					}
				}
			}
		return false;
		}
		
	
}