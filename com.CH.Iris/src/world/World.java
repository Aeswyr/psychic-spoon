package world;

import java.awt.Graphics;

import entities.EntityManager;
import entities.SpaceShip;

public class World {
	
	EntityManager entityManager;
	
	public World(SpaceShip ship) {
		entityManager = new EntityManager();
		entityManager.add(ship);
	}
	
	
	public void update() {
		entityManager.update();
	}
	
	public void render(Graphics g) {
		entityManager.render(g);
	}
}
