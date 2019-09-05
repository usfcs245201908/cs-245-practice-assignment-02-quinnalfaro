public class NQueens {

	private int[][] board;
	private int size;
	
	public NQueens(int n){
		if (n < 0){
			throw new IllegalArgumentException();
		} else {
			board = new int[n][n];
			size = n;
		}
	}

	public boolean placeNQueens () {
		if (placeNQueens(board, 0)){
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
			}
		}

		return true;
	}	

	public boolean isSafe (int[][] board, int row, int column){
		System.out.println("HERE");
		for(int i = 0; i < size; i ++){
			if (board[row][i] == 1){
				return false;
			} else if (board[i][column] == 1){
				return false;
			} else if (board[row + i][column + i] == 1){
				return false;
			} else if (board[row - i][column - i] == 1){
				return false;
			} else if (board[row - i][column + i] == 1){
				return false;
			} else if (board[row + i][column - i] == 1){
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