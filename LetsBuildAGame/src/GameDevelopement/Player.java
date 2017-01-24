package GameDevelopement;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();

	public Player(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		velX = r.nextInt(5) + 1;
		velY = r.nextInt(5);

	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub

		x += velX;
		y += velY;

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 32, 32);

	}

}
