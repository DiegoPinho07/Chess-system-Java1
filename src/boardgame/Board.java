package boardgame;

public class Board {

	private int rows;
	private int columns;
	//matriz para construção do tabuleiro
	private Piece[][] pieces;
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		//instanciando a classe piece incluindo como argumento as linhas e colunas
		pieces = new Piece[rows][columns];
		
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	//sobrecarga do método piece para retornar a posição da peça
		public Piece piece(int row, int column) {
			return pieces[row][column];
			
		}
		//método sobrecarregado para puxar os dados da classe board e retornar nessa classe.
		public Piece piece(Position position) {
			
			return pieces[position.getRow()][position.getColumn()];
		}
		public void placePiece(Piece piece, Position position)
		{
			pieces[position.getRow()][position.getColumn()] = piece;
			piece.position = position;
		}
		
	}


