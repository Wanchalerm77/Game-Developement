package ss.week7.cmdline;

//import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server.
 * 
 * @author Theo Ruys
 * @version 2005.02.21
 */
public class Server {
	private static final String USAGE = "usage: " + Server.class.getName() + " <name> <port>";

	/** Starts a Server-application. */
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println(USAGE);
			System.exit(0);
		}

		String name = args[0];
		int port = 0;
		ServerSocket ss = null;
		Socket clientsocket = null;

		try {
			port = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.out.println(USAGE);
			System.out.println("ERROR: port " + args[1] + " is not an integer");
			System.exit(0);
		}

		try {
			ss = new ServerSocket(port);
			System.out.println("Server starting");
			clientsocket = ss.accept();
		} catch (IOException e) {
			System.out.println("ERROR: could not create a serversocket on port " + port);

		}

		System.out.println("Server.peer");

		try {
			Peer server = new Peer(name, clientsocket);
			Thread streamInputHandler = new Thread(server);
			streamInputHandler.start();
			server.handleTerminalInput();
			server.shutDown();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}