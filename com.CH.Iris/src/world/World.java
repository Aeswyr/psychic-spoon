package world;

import java.awt.Graphics;

import entities.EntityManager;
import entities.SpaceShip;
import game.Screen;

public class World {
	
	EntityManager entityManager;
	
	public World(SpaceShip ship) {
		entityManager = new EntityManager();
		entityManager.add(ship);
	}
	
	public int getWidth() {
		return (int)Screen.dim.getWidth();
	}
	
	public int getHeight() {
		return (int)Screen.dim.getHeight();
	}
	
	public void update() {
		entityManager.update();
	}
	
	public void render(Graphics g) {
		entityManager.render(g);
	}
}
