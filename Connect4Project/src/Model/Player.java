package Model;

import Model.Disc.Color;

public abstract class Player {

	private String name;
	private Disc.Color disc;
	private int score;
	public Board board;
	public int[] xy = new int[2];

	/*
	 * Constructor creates a Player with a name and a disc
	 */

	public Player(String name, Disc.Color disc) {
		this.name = name;
		this.disc = disc;
		this.score = 0;

	}

	public Player() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return disc object
	 */
	public Color getDisc() {
		return disc;
	}

	/**
	 * 
	 * @return score
	 */

	public int getScore() {
		return score;
	}

	public void makeMove(Board board) {
		xy = determineMove(board);
		int x = xy[0];
		int y = xy[1];

		board.dropDisc(board, x, y, getDisc());

	}

	public abstract int[] determineMove(Board board);

}

/**
 * Checkks a row if it is full and places a disc if it cannot drop a disc it
 * returns false
 * 
 * 
 * @param board
 * @param columnPosition
 * @param disc
 */
