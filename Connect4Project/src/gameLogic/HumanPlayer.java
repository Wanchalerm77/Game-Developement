package gameLogic;

import java.util.Scanner;

import Model.Board;
import Model.Disc;
import Model.Player;

public class HumanPlayer extends Player {

	public HumanPlayer(String name, Disc.Color disc) {
		// TODO Auto-generated constructor stub
		super(name, disc);

	}

	public void instructions() {
		System.out.println("Where do you want to drop your disc? X - Y  :");
	}

	@Override
	public int[] determineMove(Board board) {

		int columnPosition = -1;
		int rowPosition = -1;
		int[] list = new int[2];
		boolean test = true;

		while (test && columnPosition < 0 || columnPosition > 4 || rowPosition < 0 || rowPosition > 4) {
			instructions();

			Scanner input = new Scanner(System.in);

			Scanner scannerLine = new Scanner(input.nextLine());
			if (scannerLine.hasNextInt()) {
				columnPosition = scannerLine.nextInt();
				rowPosition = scannerLine.nextInt();
				list[0] = rowPosition;
				list[1] = columnPosition;
				if (columnPosition < 0 || columnPosition > 4 || rowPosition < 0 || rowPosition > 4) {
					System.out.println("Your move is not allowed");
					System.out.println("");
				}

				if (columnPosition > 0 || columnPosition < 4 && rowPosition > 0 || rowPosition < 4) {
					test = false;

				}

			}
		}

		return list;

	}
}
