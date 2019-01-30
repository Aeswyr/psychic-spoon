package runtime;

import java.awt.Graphics;
import entities.SpaceShip;
import world.World;

public class Handler {

	SpaceShip ship;
	World world;
	
	public Handler() {
		ship = new SpaceShip(this, 160, 160);
		world = new World(ship);
	}
	
	public void render(Graphics g) {
		world.render(g);
	}
	
	public void update() {
		world.update();
	}
	
}
