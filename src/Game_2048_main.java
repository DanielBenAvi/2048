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
				boardManager.left(board);
				break;
			case 8:
				boardManager.up(board);
				break;
			case 6:
				boardManager.right(board);
				break;
			case 2:
				boardManager.down(board);
				break;
			default:
				break;
			}
			counter++;
			
			if (boardManager.lostCheck(board)) {
				System.out.println("You Lost");
				break;
			}
			boardManager.putRandomNumberInBoard(board);
			
			boardManager.printBoard(board, "Step: " + counter);
			user = getNumFromUser();
		}

	}

	private static int getNumFromUser() {
		System.out.println("Please enter an action");
		return input.nextInt();
	}

}
