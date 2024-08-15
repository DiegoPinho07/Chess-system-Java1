package boardgame;

public class Piece {

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

		
		
	
}