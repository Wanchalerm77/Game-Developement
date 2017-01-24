package Connect4;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

public interface Strategy {
	public String getName();

	public int determineMove(Board b, Mark m);
	/*
	 * return a next legal move, given Board b, for the player with Mark m
	 */

}
