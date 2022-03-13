import java.util.Scanner;

public class Game_2048_main {

	private static int user;
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		BoardManager boardManager = new BoardManager();

		int[][] board = boardManager.getBoard();

		boardManager.printBoard(board, "init board");

		int counter = 0;
		user = getNumFromUser();
		while (user != 0) {
			switch (user) {

			case 4:
				if (boardManager.leftValid(board) || boardManager.doubleLeft(board)) {
					boardManager.left(board);
					boardManager.putRandomNumberInBoard(board);
				}else {
					System.out.println("you can`t go left");
				}
				break;
			case 8:
				if (boardManager.upValid(board) || boardManager.doubleUp(board)) {
					boardManager.up(board);
					boardManager.putRandomNumberInBoard(board);
				}else {
					System.out.println("you can`t go up");
				}
				break;
			case 6:
				if (boardManager.rightValid(board) || boardManager.doubleRight(board)) {
					boardManager.right(board);
					boardManager.putRandomNumberInBoard(board);
				}else {
					System.out.println("you can`t go right");
				}
				break;
			case 2:
				if (boardManager.downValid(board) || boardManager.doubleDown(board)) {
					boardManager.down(board);
					boardManager.putRandomNumberInBoard(board);
				}else {
					System.out.println("you can`t go down");
				}
				break;
			default:
				break;
			}
			counter++;
			
			if (boardManager.lostCheck(board)) {
				System.out.println("You Lost");
				break;
			}else if(boardManager.winCheck(board)) {
				System.out.println("you won");
				break;
			}
			
			boardManager.printBoard(board, "Step: " + counter);
			user = getNumFromUser();
		}

	}

	private static int getNumFromUser() {
		System.out.println("Please enter an action");
		return input.nextInt();
	}

}
