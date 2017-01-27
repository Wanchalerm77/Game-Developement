package networkConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import Model.Board;
import Model.Player;

public class Client extends Thread {

	private Socket socket;
	private PrintWriter writer;
	private BufferedReader reader;
	private Player player;
	private Board board;
	private static final String USAGE = "Arguments: <name> <adress> <port>";
	private String name;

	public Client(String name, Player player, Socket socket) {
		this.socket = socket;
		this.player = player;
		this.name = name;

		try {
			writer = new PrintWriter(socket.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.err.println("ERROR: Connection failed");
			e.printStackTrace();

		}
	}

	@Override
	public void run() {
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] words = line.split(" ");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

	public void send(String message) {
		writer.println(message);
		writer.flush();
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
		
		// creates a Game object and starts the two way communication 
		try {
			
		}
		

	}
}
