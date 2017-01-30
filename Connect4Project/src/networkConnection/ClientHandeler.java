package networkConnection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import Model.Board;
import Model.Disc.Color;
import Model.Player;
import networkConnection.Client.Error;

public class ClientHandeler extends Player implements Runnable {

	private Socket socket;
	private BufferedReader in;
	private BufferedWriter out;
	private String name;
	private Server server;
	private Client client;
	private Color color;

	// Client to Server Commands //
	public static final String SENDCAPABILITIES = "sendCapabilities";

	public static final String JOINROOM = "joinRoom";

	public static final String GETROOMLIST = "getRoomList";

	public static final String LEAVEROOM = "leaveRoom";

	public static final String MAKEMOVE = "makeMove";

	public static final String SENDMESSAGE = "sendMessage";

	public static final String REQUESTLEADERBOARD = "requestLeaderboard";

	// ------------------------------------------------------------------//

	public static final String SERVERCAPABILITIES = "serverCapabilities";

	public static final String SENDLISTROOMS = "sendListRooms";

	public static final String ASSIGNID = "assignID";

	public static final String STARTGAME = "startGame";

	public static final String TURNOFPLAYER = "playerTurn";

	public static final String NOTIFYMOVE = "notifyMove";

	public static final String NOTIFYEND = "notifyEnd";

	public static final String ERROR = "error";

	public static final String NOTIFYMESSAGE = "notifyMessage";

	public static final String SENDLEADERBOARD = "sendLeaderBoard";

	// -----------------------------------------------------------//

	/**
	 * 
	 * @param socket
	 * @throws IOException
	 */

	public ClientHandeler(Socket socket) throws IOException {
		this.socket = socket;

		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

	}

	/**
	 * 
	 */

	public void shutDown() {
		try {
			socket.close();
		} catch (IOException e) {
			System.out.println(Error.IO_EXCEPTION);

		}
	}

	public void processMove(String line) {
		String[] words = line.split(" ");
		int x = Integer.parseInt(words[1]);
		int y = Integer.parseInt(words[2]);

	}

	/**
	 * 
	 */

	public void handleTerminalInput() {
		String line = null;
	}

	/**
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void send(String message) throws IOException {
		out.write(message);
		out.newLine();
		out.flush();

	}

	/**
	 * 
	 */

	@Override
	public void run() {

	}

	/**
	 * 
	 * @param client
	 */
	public void addClient(Client client) {
		Server.waitingClients.add(client);

	}

	@Override
	public int[] determineMove(Board board) {
		return null;
	}

}
