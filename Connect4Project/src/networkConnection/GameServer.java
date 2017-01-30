package networkConnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Board;
import controller.Game;

public class GameServer extends Thread {

	private Board board;
	private int current = 0;
	private Game game;
	private List<ClientHandeler> listOfClients;

	public GameServer(ClientHandeler client1, ClientHandeler client2) {
		listOfClients = new ArrayList<>();
		listOfClients.add(client1);
		listOfClients.add(client2);

	}

	/**
	 * 
	 * @param message
	 * @throws IOException
	 */

	private void notifyPlayers(String message) throws IOException {
		if (game.hasWinner()) {
			for (ClientHandeler c : listOfClients) {
				c.send(message);
			}

		}

	}

	public void start() {
		boolean keepPlaying = true;
		while (keepPlaying) {

			board.reset();
			game.play();
			try {
				notifyPlayers("We have a winner");
			} catch (IOException e) {
				e.printStackTrace();
			}
			keepPlaying = game.readBoolean("\n> Play another time? (yes/no)?", "y", "n");
		}

	}

	/**
	 * 
	 */

	public void run() {
		board = new Board();
		game = new Game(listOfClients.get(0), listOfClients.get(1));
		start();

	}

	/**
	 * 
	 */

}
