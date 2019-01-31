package world;

import java.awt.Graphics;

import entities.Asteroid;
import entities.EntityManager;
import entities.SpaceShip;
import game.Screen;
import runtime.Handler;

public class World {
	
	EntityManager entityManager;
	Handler handler;
	
	public World(SpaceShip ship, Handler handler) {
		entityManager = new EntityManager();
		this.handler = handler;
		entityManager.add(ship);
		entityManager.add(new Asteroid(handler, 15, 150));
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
