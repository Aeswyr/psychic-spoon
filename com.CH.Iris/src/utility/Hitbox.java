package utility;

import entities.Entity;

public class Hitbox {

	// Height and width of current object
	private int height;
	private int width;

	// Height and width of another enity
	private int eHeight;
	private int eWidth;

	// Offset to trim the hitbox of the current object
	private int offsetX;
	private int offsetY;

	// Offset to trim the hitbox of another entity
	private int eOffsetX;
	private int eOffsetY;

	// Position of the current object
	private int positionX;
	private int positionY;

	private Entity e;

	public Hitbox(Entity e, int height, int width, int offsetX, int offsetY) {
		this.height = height;
		this.width = width;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.e = e;
		positionX = e.getXPos();
		positionY = e.getYPos();
	}

	/*
	 * Checks if any part of this entity is touching another entity
	 * 
	 * 
	 * 
	 */
	public boolean contains(Hitbox h) {
		
		return false;
	}

	public void update() {
		positionX = e.getXPos();
		positionY = e.getYPos();
	}
	
	public int[] getBounds() {
		int[] bounds =  {
			this.positionX + this.offsetX,
			this.positionY + this.offsetY,
			this.positionX + this.offsetX + this.width,
			this.positionY + this.offsetY + this.height
		};
		
		return bounds;
	}

}
