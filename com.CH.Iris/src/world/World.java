package world;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.Asteroid;
import entities.Entity;
import entities.EntityManager;
import entities.SpaceShip;
import game.Assets;
import game.Game;
import game.Screen;
import gfx.Sprite;
import runtime.Handler;

public class World {
	
	EntityManager entityManager;
	Handler handler;
	int count = 0;
	SpaceShip ship;
	int bottomline;
	int lineNumber;
	
	ArrayList<Tile[]> tiles;
	
	public World(SpaceShip ship, Handler handler) {
		entityManager = new EntityManager();
		this.handler = handler;
		this.ship = ship;
		entityManager.add(ship);
		
		bottomline = 16*Game.GAMESCALE*20;
		lineNumber = 1;
		
		tiles = new ArrayList<Tile[]>();
		for(int i=-16*Game.GAMESCALE*10; i<=bottomline; i+=16*Game.GAMESCALE) {
			Tile[] tileRow = new Tile[20];
			for(int j=0; j<tileRow.length; j++) {
				tileRow[j] = new Tile(i,-10+16*Game.GAMESCALE*j,handler);
			}
			tiles.add(tileRow);
		}
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
		updateTiles();
		
	}
	
	public void updateTiles() {
		//System.out.println(tiles.get(tiles.size()-1)[0].y-handler.getCamera().yOffset());
		if(-handler.getCamera().yOffset()/(16*Game.GAMESCALE)>=lineNumber) {
			lineNumber++;
			tiles.remove(tiles.size()-1);
			Tile[] tileRow = new Tile[20];
			for(int i=0; i<tileRow.length; i++) {
				tileRow[i] = new Tile(-10+16*Game.GAMESCALE*i, tiles.get(0)[0].y-16*Game.GAMESCALE,handler);
			}
			tiles.add(0,tileRow);
		}
	}
	
	public void render(Graphics g) {
		for(int i=0; i<tiles.size(); i++) {
			for(Tile t:tiles.get(i)) {
				t.render(g);
			}
		}
		entityManager.render(g);
	}
	
	public void addEntity(Entity e) {
		entityManager.add(e);
	}
	
	public void removeEntity(Entity e) {
		entityManager.remove(e);
	}
}
