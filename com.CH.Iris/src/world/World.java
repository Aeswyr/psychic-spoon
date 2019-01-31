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
	int count = 0;
	SpaceShip ship;
	
	public World(SpaceShip ship, Handler handler) {
		entityManager = new EntityManager();
		this.handler = handler;
		this.ship = ship;
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
		
		
		
		if (count % (int)(Math.random() * 120 + 1) == 0) {
			entityManager.add(new Asteroid(handler, (int)(Math.random() * 800), ship.getYPos() - 800));
		}
		
		
		count++;
		
		
		
	}
	
	public void render(Graphics g) {
		entityManager.render(g);
	}
}
