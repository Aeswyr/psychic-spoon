package entities;

import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {
	
	private ArrayList<Entity> entities;
	private ArrayList<Entity> remove;
	private ArrayList<Entity> add;
	
	public EntityManager() {
		entities = new ArrayList<Entity>();
		remove = new ArrayList<Entity>();
		add = new ArrayList<Entity>();
	}
	
	public void update() {
		for (Entity e : entities) {
			e.update();
		}
		for (Entity e : remove) {
			entities.remove(e);
		}
		for (Entity e : add) {
			entities.add(e);
		}
		remove.clear();
		add.clear();
	}
	
	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
	}
	
	public void add(Entity e) {
		add.add(e);
	}
	
	public void remove(Entity e) {
		remove.add(e);
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
}
