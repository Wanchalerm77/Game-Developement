package viewTUI;

import Model.Board;
import Model.Player;
import controller.Game;

public interface BoardInterface {

	public void start();

	public void updatePlayer(Player p);

	public void updateBoard(Board b);

	public void updateScore(Player p);

	public void showStatus();

	public void setGame(Game g);

}
