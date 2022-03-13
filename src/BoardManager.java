import java.util.Random;

public class BoardManager {
	private int[][] board = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	private Random rand = new Random();;
	private int percentage;
	private int x;
	private int y;

	public BoardManager() {
		putRandomNumberInBoard(board);
		putRandomNumberInBoard(board);
	}

	public void putRandomNumberInBoard(int[][] b) {
		x = rand.nextInt(4);
		y = rand.nextInt(4);

		boolean flag = false;
		while (flag == false) {
			if (isEmpty(board, y, x)) {

				percentage = rand.nextInt(100);
				if (percentage > 89) {
					board[y][x] = 4;
				} else {
					board[y][x] = 2;
				}
				flag = true;
			} else {
				x = rand.nextInt(4);
				y = rand.nextInt(4);
			}
		}

	}

	public boolean isEmpty(int[][] b, int rows, int cols) {
		if (b[rows][cols] == 0) {
			return true;
		}
		return false;
	}

	public void printBoard(int[][] b, String msg) {
		System.out.printf("%s \n", msg);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.printf("%d ", b[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public int[][] getBoard() {
		return board;
	}

	public void left(int[][] b) {
		System.out.println("left");
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (!isEmpty(b, i, j)) {
					for (int k = j - 1; k >= 0; k--) {
						if (!isEmpty(b, i, k)) {
							if (b[i][k] == b[i][j]) {
								b[i][k] *= 2;
								b[i][j] = 0;
							} else {
								if (k + 1 != j) {
									b[i][k + 1] = b[i][j];
									b[i][j] = 0;
								}
							}
							break;
						} else if (k == 0) {
							b[i][k] = b[i][j];
							b[i][j] = 0;
						}
					}
				}
			}
		}
	}


	public void up(int[][] b) {
		System.out.println("up");
		//loops on matrix
		for (int i = b.length-1; i >=0; i--) {
			for (int j = 0; j < b.length; j++){
				//checks if cell is empty
				if(!isEmpty(b,i, j)){
					for(int k = i-1; k >= 0; k--){
						if (!isEmpty(b, k,j)){
							if(b[k][j] == b[i][j]){
								b[k][j]*=2;
								b[i][j] = 0;
							}else{
								if(k-1 !=i){
									b[k-1][j] = b[i][j];
									b[i][j] = 0;
								}
							}
							break;
						}else if(k == b.length-1){
							b[k][j] = b[i][j];
							b[i][j] = 0;
						}
					}
				}
			}
		}
	}

	public void right(int[][] b) {
		System.out.println("right");
		for (int i = b.length-1; i >=0; i--) {
			for (int j = b.length-1; j >=0; j--) {
				if (!isEmpty(b, i, j)) {
					for (int k = j + 1; k< b.length; k++) {
						if (!isEmpty(b, i, k)) {
							if (b[i][k] == b[i][j]) {
								b[i][k] *= 2;
								b[i][j] = 0;
							} else {
								if (k - 1 != j) {
									b[i][k - 1] = b[i][j];
									b[i][j] = 0;
								}
							}
							break;
						} else if (k == b.length-1) {
							b[i][k] = b[i][j];
							b[i][j] = 0;
						}
					}
				}
			}
		}
	}

	public void down(int[][] b) {
		System.out.println("down");
	}

	public boolean lostCheck(int[][] b) {
		int counter = 0;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (b[i][j] == 0) {
					counter++;
				}
			}
		}
		if (counter == 0) {
			return true;
		} else {
			return false;
		}
		
	}

}
