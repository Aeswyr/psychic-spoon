package world;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.Asteroid;
import entities.Entity;
import entities.EntityManager;
import entities.SpaceShip;
import game.Game;
import game.Screen;
import runtime.Handler;

public class World {
	
	EntityManager entityManager;
	Handler handler;
	int count = 0;
	SpaceShip ship;
	
	int topline;
	int bottomline;
	ArrayList<Tile[]> tiles;
	
	public World(SpaceShip ship, Handler handler) {
		entityManager = new EntityManager();
		this.handler = handler;
		this.ship = ship;
		entityManager.add(ship);
		
		topline = ship.getYPos()-Game.GAMESCALE*16*20;
		
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
	
	public void addEntity(Entity e) {
		entityManager.add(e);
	}
	
	public void removeEntity(Entity e) {
		entityManager.remove(e);
	}
}
