package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PlayerList extends Observable {
	String name;

	public List<Player> player = new ArrayList<>();

	public void addPlayer(Player player) {
		this.player.add(player);
		setChanged();
		notifyObservers("player");
	}

	public List<Player> getPlayers() {
		return player;
	}

	public Player getPlayer(int i) {
		return player.get(i);

	}

}
