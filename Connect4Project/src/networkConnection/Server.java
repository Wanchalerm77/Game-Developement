package networkConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	// Commands from the Client //

	public static final String SENDCAPABILITIES = "sendCapabilities";

	public static final String JOINROOM = "joinRoom";

	public static final String GETROOMLIST = "getRoomList";

	public static final String LEAVEROOM = "leaveRoom";

	public static final String MAKEMOVE = "makeMove";

	public static final String SENDMESSAGE = "sendMessage";

	public static final String REQUESTLEADERBOARD = "requestLeaderboard";

	// ----------------------------------------------------------------------//

	private static final String USAGE = "<port>";
	public static List<Client> clients;
	public static List<Client> waitingClients;

	public int port;

	public Server(int port) {
		this.port = port;
	}

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println(USAGE);
			System.exit(0);
		}

		int port = 0;
		clients = new ArrayList<>();
		waitingClients = new ArrayList<>();

		ServerSocket ss = null;
		Socket clientsocket = null;

		try {
			port = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println(USAGE);
			System.out.println("Error: port " + args[0] + " is not an integer");
			System.exit(0);
		}

		try {
			ss = new ServerSocket(port);
			System.out.println("Server starting");
			while (true) {
				clientsocket = ss.accept();

				Runnable r = new ClientHandeler(clientsocket);
				Thread t = new Thread(r);
				t.start();
			}
		} catch (IOException e) {
			System.out.println("ERROR: Could not create a serversocket on port " + port);
		}

		System.out.println("LOL");

	}

}
