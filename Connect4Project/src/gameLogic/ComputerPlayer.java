package gameLogic;

import Model.Board;
import Model.Disc.Color;
import Model.Player;

public class ComputerPlayer extends Player {

	private Strategy strategy;
	private Color color;

	public ComputerPlayer(Color color, Strategy strategy) {
		this.color = color;
		this.strategy = strategy;

	}

	public ComputerPlayer(Color color) {
		this.color = color;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	@Override
	public int[] determineMove(Board board) {
		// TODO Auto-generated method stub
		return strategy.determineMove(board);
	}

}
