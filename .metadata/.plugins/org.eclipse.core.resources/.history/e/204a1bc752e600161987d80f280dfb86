package networkConnection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.Game;

public class Client implements Runnable {

	private Socket socket;
	private BufferedWriter writer;
	private BufferedReader reader;
	private Game game;
	private static final String USAGE = "Arguments: <name> <adress> <port>";
	private String name;
	private static final String EXIT = "exit";
	private Error error = Error.NONE;

	public enum Error {
		NONE, SOCKET_ERROR, PLAYER_DISCONNECTED, CONNECTION_PROBLEM, IO_EXCEPTION, UNKNOWN_HOST
	}

	/**
	 * 
	 * 
	 * @param name
	 * @param player
	 * @param socket
	 */

	public Client(String name, Socket socket) throws IOException {
		this.socket = socket;
		this.name = name;
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	}

	@Override
	public void run() {
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(Error.IO_EXCEPTION);
			;

		}

	}

	public void shutDown() {
		try {
			socket.close();
		} catch (IOException e) {
			System.out.println(Error.IO_EXCEPTION);

		}
	}

	public String getName() {
		return name;
	}

	public InetAddress getIP(String host) {
		InetAddress adress = null;
		try {
			adress = InetAddress.getByName(host);

		} catch (UnknownHostException e) {
			System.out.println(Error.UNKNOWN_HOST);
		}
		return adress;
	}

	public int getPort(String portString) {
		int port = 0;
		try {
			port = Integer.parseInt(portString);
		} catch (NumberFormatException e) {
			System.out.println("sry mate");
		}
		return port;
	}

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println(USAGE);
			System.exit(0);
		}

		String name = args[0];
		InetAddress addres = null;
		int port = 0;
		Socket socket = null;

		//

		try {
			addres = InetAddress.getByName(args[1]);
		} catch (UnknownHostException e) {
			System.out.println(USAGE);
			System.out.println("ERROR: host " + args[1] + " unkown");
			System.exit(0);
		}

		//
		try {
			port = Integer.parseInt(args[2]);

		} catch (NumberFormatException e) {
			System.out.println(USAGE);
			System.out.println("ERROR: port " + args[2] + " is not an integer");
			System.exit(0);
		}
		try {
			socket = new Socket(addres, port);
		} catch (IOException e) {
			System.out.println("ERROR: could not create a socket on" + addres + " and port " + port);
		}
	}
}

// creates a Game object and starts the two way communication
