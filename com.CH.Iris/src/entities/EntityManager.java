package entities;

import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {
	
	private ArrayList<Entity> entities;
	private ArrayList<Entity> remove;
	
	public EntityManager() {
		entities = new ArrayList<Entity>();
		remove = new ArrayList<Entity>();
	}
	
	public void update() {
		for (Entity e : entities) {
			e.update();
		}
		for (Entity e : remove) {
			entities.remove(e);
			remove.remove(e);
		}
	}
	
	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
	}
	
	public void add(Entity e) {
		entities.add(e);
	}
	
	public void remove(Entity e) {
		remove.add(e);
	}
}
