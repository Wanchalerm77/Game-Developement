package gameLogic;

import java.util.Random;

import Model.Board;

public class DumbStrategy implements Strategy {

	private Random random = new Random();
	private static final String NAME = "Dumb Player";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return NAME;
	}

	@Override
	public int[] determineMove(Board board) {

		int columnPosition = -1;
		int rowPosition = -1;
		int[] list = new int[2];

		do {
			columnPosition = random.nextInt(4);
			rowPosition = random.nextInt(4);

			list[0] = rowPosition;
			list[1] = columnPosition;

		} while (columnPosition < 0 || columnPosition > 4 || rowPosition < 0 || rowPosition > 4
				|| board.canDrop(columnPosition, rowPosition) == false);

		return list;

	}

}
