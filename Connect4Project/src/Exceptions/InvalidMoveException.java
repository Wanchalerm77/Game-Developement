package Exceptions;

public class InvalidMoveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMoveException() {
		super("Move is not allowed");
	}

}
