package networkConnection;

import java.util.ArrayList;
import java.util.List;

import Model.Board;
import Model.Disc.Color;
import Model.Player;
import controller.Game;
import gameLogic.ComputerPlayer;
import gameLogic.DumbStrategy;
import gameLogic.HumanPlayer;
import gameLogic.SmartStrategy;

public class GameServer extends Thread {

	private Game game;
	private Board board;

	private List<Player> listOfClients;
	private Color color;

	public GameServer(String player1, String player2) {
		listOfClients = new ArrayList<>();
		listOfClients.add(createPlayerOne(player1));
		listOfClients.add(createPlayerTwo(player2));

	}

	public Player createPlayerOne(String name) {
		Player player;
		switch (name) {
		case "-S":
			player = new ComputerPlayer(name, Color.values()[0], new SmartStrategy());
		case "-N":
			player = new ComputerPlayer(name, Color.values()[0], new DumbStrategy());
		default:
			player = new HumanPlayer(name, Color.values()[0]);

		}
		return player;
	}

	public Player createPlayerTwo(String name) {
		Player player;
		switch (name) {
		case "-S":
			player = new ComputerPlayer(name, Color.values()[1], new SmartStrategy());
		case "-N":
			player = new ComputerPlayer(name, Color.values()[1], new DumbStrategy());
		default:
			player = new HumanPlayer(name, Color.values()[1]);

		}
		return player;
	}

	/**
	 * 
	 */

	public void run() {
		game = new Game(listOfClients.get(0), listOfClients.get(1));
		game.start();
	}

}
