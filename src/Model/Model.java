package Model;

import java.util.Scanner;

public class Model {

	private static int user;
	private static Scanner input = new Scanner(System.in);
	BoardManager boardManager = new BoardManager();
	int[][] board = boardManager.getBoard();

	public Model() {
		//boardManager.printBoard(board, "init board");

	}

	public int[][] moveRight() {
		if (boardManager.rightValid(board) || boardManager.doubleRight(board)) {
			board = boardManager.right(board);
			board = boardManager.putRandomNumberInBoard(board);
		} else {
			System.out.println("you can`t go right");
		}
		return board;
	}
	public int[][] moveLeft() {
		if (boardManager.leftValid(board) || boardManager.doubleLeft(board)) {
			board = boardManager.left(board);
			board = boardManager.putRandomNumberInBoard(board);
		} else {
			System.out.println("you can`t go left");
		}
		return board;

	}
	public int[][] moveUp() {
		if (boardManager.upValid(board) || boardManager.doubleUp(board)) {
			board = boardManager.up(board);
			board = boardManager.putRandomNumberInBoard(board);
		} else {
			System.out.println("you can`t go up");
		}
		return board;

	}
	public int[][] moveDown() {
		if (boardManager.downValid(board) || boardManager.doubleDown(board)) {
			board = boardManager.down(board);
			board = boardManager.putRandomNumberInBoard(board);
		} else {
			System.out.println("you can`t go down");
		}
		return board;
	}
	
	public void gamePlay() {



		int counter = 0;
		user = getNumFromUser();
		while (user != 0) {
			switch (user) {

			case 4:
				if (boardManager.leftValid(board) || boardManager.doubleLeft(board)) {
					boardManager.left(board);
					boardManager.putRandomNumberInBoard(board);
				} else {
					System.out.println("you can`t go left");
				}
				break;
			case 8:
				if (boardManager.upValid(board) || boardManager.doubleUp(board)) {
					boardManager.up(board);
					boardManager.putRandomNumberInBoard(board);
				} else {
					System.out.println("you can`t go up");
				}
				break;
			case 6:
				if (boardManager.rightValid(board) || boardManager.doubleRight(board)) {
					boardManager.right(board);
					boardManager.putRandomNumberInBoard(board);
				} else {
					System.out.println("you can`t go right");
				}
				break;
			case 2:
				if (boardManager.downValid(board) || boardManager.doubleDown(board)) {
					boardManager.down(board);
					boardManager.putRandomNumberInBoard(board);
				} else {
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
			} else if (boardManager.winCheck(board)) {
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
