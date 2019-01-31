package runtime;

import java.awt.Graphics;
import entities.SpaceShip;
import input.KeyHandler;
import world.World;

public class Handler {

	KeyHandler keyHandler;
	SpaceShip ship;
	World world;
	Camera camera;
	
	public Handler() {
		keyHandler = new KeyHandler();
		camera = new Camera(this);
		ship = new SpaceShip(this, 360, 500);
		world = new World(ship, this);
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
	
	public World getWorld() {
		return world;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
}
