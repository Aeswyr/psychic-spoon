package runtime;

import java.awt.Graphics;
import entities.SpaceShip;
import input.KeyHandler;
import world.World;

public class Handler {

	KeyHandler keyHandler;
	SpaceShip ship;
	World world;
	
	public Handler() {
		keyHandler = new KeyHandler();
		ship = new SpaceShip(this, 0, 0);
		world = new World(ship);
	}
	
	public void render(Graphics g) {
		world.render(g);
	}
	
	public void update() {
		keyHandler.update();
		world.update();
	}
	
	public KeyHandler getKeyHandler() {
		return keyHandler;
	}
	
}
