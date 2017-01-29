package gameLogic;

import Model.Board;

public interface Strategy {

	public String getName();

	public int[] determineMove(Board b);

}
