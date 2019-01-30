package world;

import java.awt.Graphics;

import entities.EntityManager;

public class World {
	
	EntityManager entityManager;
	
	public World() {
		entityManager = new EntityManager();
	}
	
	
	public void update() {
		entityManager.update();
	}
	
	public void render(Graphics g) {
		entityManager.render(g);
	}
}
