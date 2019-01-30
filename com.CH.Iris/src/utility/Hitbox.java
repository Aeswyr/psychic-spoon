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
	
	// Entity being compared to the current object
	private Entity e2;
	
	
	public Hitbox(int height, int width) {
		this.height = height;
		this.width = width;
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
		
		
		if (positionX > e2.getXPos() && positionX < e2.getXPos() + eWidth) {
			
			if (positionY < e2.getYPos() && positionY > e2.getYPos() + eHeight) {
				return true;
			}
			
		}
		
		return false;
				
	}
	
}
