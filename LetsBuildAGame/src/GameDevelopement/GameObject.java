package GameDevelopement;

import java.awt.Graphics;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected int velX, velY;

	public GameObject(int x, int y, ID id) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public ID getID() {
		return id;

	}

	public void setID(ID id) {
		this.id = id;
	}

	public int getVelY() {
		return velY;
	}

	public int getVelX() {
		return velX;
	}

}
