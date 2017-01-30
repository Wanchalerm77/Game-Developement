package networkConnection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import networkConnection.Client.Error;

public class ClientHandeler implements Runnable {

	private Socket socket;
	private BufferedReader in;
	private BufferedWriter out;
	private String name;

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

	/**
	 * 
	 */

	public void handleTerminalInput() {
		String line = null;
		try {
			out.write(name + ":  " + " Let�s go");
			out.newLine();
			out.flush();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while ((line = readString("--")) != null) {
			if (line.equals("exit")) {
				shutDown();
				return;
			}
			try {
				out.write(name + ":  " + line);
				out.newLine();
				out.flush();
			} catch (IOException e) {
				System.out.println("Could not write to outputstream, pipe broken!");
				shutDown();
			}
		}
	}

	/**
	 * 
	 * @param host
	 * @return
	 */

	public InetAddress getIP(String host) {
		InetAddress adress = null;
		try {
			adress = InetAddress.getByName(host);

		} catch (UnknownHostException e) {
			System.out.println(Error.UNKNOWN_HOST);
		}
		return adress;
	}

	/**
	 * 
	 * @param tekst
	 * @return
	 */
	static public String readString(String tekst) {
		System.out.print(tekst);
		String antw = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			antw = in.readLine();
		} catch (IOException e) {
		}

		return (antw == null) ? "" : antw;
	}

	/**
	 * 
	 * @param portString
	 * @return
	 */

	public int getPort(String portString) {
		int port = 0;
		try {
			port = Integer.parseInt(portString);
		} catch (NumberFormatException e) {
			System.out.println("sry mate");
		}
		return port;

	}

	/**
	 * 
	 */

	@Override
	public void run() {

		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			Scanner input = new Scanner(in);
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	/**
	 * 
	 * @param client
	 */
	public void addClient(Client client) {
		Server.waitingClients.add(client);

	}

}
