package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	public Board(int rows, int columns) {
		super();
		this.rows = rows;
		this.columns = columns;
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
		
	}


