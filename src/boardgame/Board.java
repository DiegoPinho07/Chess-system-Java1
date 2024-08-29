package boardgame;

public class Board  {

	private int rows;
	private int columns;
	//matriz para construção do tabuleiro
	private Piece[][] pieces;
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro ao criar o tabuleiro: Deve haver ao menos uma linha e uma coluna");
		}
	
		this.rows = rows;
		this.columns = columns;
		//instanciando a classe piece incluindo como argumento as linhas e colunas
		pieces = new Piece[rows][columns];
		
	}
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	//sobrecarga do método piece para retornar a posição da peça
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Posição não existe no tabuleiro!!");
			
		}
		return pieces[row][column];
	}
	
		//método sobrecarregado para puxar os dados da classe board e retornar nessa classe.
		public Piece piece(Position position) {
			
				if (!positionExists(position)) {
					throw new BoardException("Posição não existe no tabuleiro!!");
			}
			
			return pieces[position.getRow()][position.getColumn()];
		}
		public void placePiece(Piece piece, Position position)
		{
			if(thereIsAPiece(position)) {
				throw new BoardException("Já existe uma peça na posição:" + position);
			}
			pieces[position.getRow()][position.getColumn()] = piece;
			piece.position = position;
		}
		
		private boolean positionExists(int row, int column) {
			return row >=0 && row < rows && column >=0 && column < columns;
		}
		public boolean positionExists(Position position) {
			return positionExists(position.getRow() , position.getColumn());
		}
		public boolean thereIsAPiece(Position position) {
			return piece(position) != null;
		}
	}



