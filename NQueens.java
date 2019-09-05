public class NQueens {

	private int[][] board;
	private int size;
	
	public NQueens(int n){
		
		board = new int[n][n];
		size = n;
		
	}

	public boolean placeNQueens () {
		if (size <= 0){
			throw new IllegalArgumentException();
		} else if (placeNQueens(board, 0)){
			return true;
		}
		 
		return false;
	}

	public boolean placeNQueens (int[][] board, int column) {
		//base case
		if(column >= size){
			return true;
		}

		for(int i = 0; i < size; i ++){
			if (isSafe (board, i, column)){
				board[i][column] = 1;

				if (placeNQueens(board, column + 1) == true){
					return true;
				}
				board[i][column] = 0;
			}
		}

		return false;
	}	

	public boolean isSafe (int[][] board, int row, int column){
		int i, j;
		//condense to one loop? Would this make it more efficient?
		for(i = 0; i < column; i ++){
			if (board[row][i] == 1){
				return false;
			} 
		}

		for(i = row, j = column; i >= 0 && j >= 0; i --, j --){
			if (board[i][j] == 1){
				return false;
			} 
		}

		for(i = row, j = column; i < size && j >= 0; i ++, j --){
			if (board[i][j] == 1){
				return false;
			} 
		}

		return true;
	}

	public void printToConsole() {
		for(int i = 0; i < size; i ++){
			for (int j = 0; j < size; j ++){
				if (board[i][j] == 1){
					System.out.println("Q");
				} else { 
					System.out.println("_");
				}
			}
			System.out.println();
		}
	}
}