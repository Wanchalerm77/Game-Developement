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

	@Override
	public int[] determineMove(Board board) {

		int columnPosition = 0;
		int rowPosition = 0;
		int[] list = new int[2];
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("Where do you want to drop your disc? X - Y  :");
		try (Scanner scannerLine = new Scanner(input.nextLine())) {
			if (scannerLine.hasNextInt()) {
				columnPosition = scannerLine.nextInt();
				rowPosition = scannerLine.nextInt();
				list[0] = rowPosition;
				list[1] = columnPosition;
				while (columnPosition < 0 || columnPosition > 4 || rowPosition < 0 || rowPosition > 4) {
					System.out.println("NOPE");

				}

			}

		}
		return list;

	}

}
