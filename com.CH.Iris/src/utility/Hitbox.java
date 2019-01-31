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
	
	public Hitbox(Entity e, int height, int width, int offsetX, int offsetY, int eOffsetX, int eOffsetY) {
		this.height = height;
		this.width = width;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.eOffsetX = eOffsetX;
		this.eOffsetY = eOffsetY;
	}	
	
	/*
	 * Checks if any part of this entity is touching another entity
	 * 
	 * 
	 * 
	 */
	public boolean contains(Entity e2) {
		
		int positionXR = positionX + width;
		int positionYB = positionY + height;
		eWidth = e2.getWidth();
		eHeight = e2.getHeight();
		
		
		if (positionX + offsetX > e2.getXPos() + offsetX + eOffsetX && positionXR < e2.getXPos() + eWidth) {
			
			if (positionY + offsetY < e2.getYPos() + offsetY + eOffsetY && positionYB > e2.getYPos() + eHeight) {
				return true;
			}
			
		}
		
		return false;
				
	}
	
	public void update() {
		positionX = e.getXPos();
		positionY = e.getYPos();
	}
	
	
}
