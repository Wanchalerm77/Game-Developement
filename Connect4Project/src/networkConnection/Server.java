package networkConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	private static final String USAGE = "<port>";
	private static List<Client> clients;

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println(USAGE);
			System.exit(0);
		}

		int port = 0;
		clients = new ArrayList<>();
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
			clientsocket = ss.accept();
		} catch (IOException e) {
			System.out.println("ERROR: Could not create a serversocket on port " + port);
		}

		System.out.println("LOL");

	}

}
