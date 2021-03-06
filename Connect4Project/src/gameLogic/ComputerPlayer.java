package gameLogic;

import Model.Board;
import Model.Disc.Color;
import Model.Player;

public class ComputerPlayer extends Player {

	private Strategy strategy;

	public ComputerPlayer(String name, Color color, Strategy strategy) {
		super(name, color);
		this.strategy = strategy;

	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	@Override
	public int[] determineMove(Board board) {
		return strategy.determineMove(board);
	}

}
