package utility;

import entities.Entity;

public class Hitbox {

	// Height and width of current object
	private int height;
	private int width;

	// Offset to trim the hitbox of the current object
	private int offsetX;
	private int offsetY;

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

		if (this.getBounds()[0] > h.getBounds()[0] && this.getBounds()[0] < h.getBounds()[2]) {

			if (this.getBounds()[1] > h.getBounds()[1] && this.getBounds()[1] < h.getBounds()[3]) {
				return true;
			}

			if (this.getBounds()[3] > h.getBounds()[1] && this.getBounds()[3] < h.getBounds()[3]) {
				return true;
			}

		}

		if (this.getBounds()[2] > h.getBounds()[0] && this.getBounds()[2] < h.getBounds()[2]) {

			if (this.getBounds()[1] > h.getBounds()[1] && this.getBounds()[1] < h.getBounds()[3]) {
				return true;
			}

			if (this.getBounds()[3] > h.getBounds()[1] && this.getBounds()[3] < h.getBounds()[3]) {
				return true;
			}

		}
		
		
		
		if (h.getBounds()[0] > this.getBounds()[0] && h.getBounds()[0] < this.getBounds()[2]) {

			if (h.getBounds()[1] > this.getBounds()[1] && h.getBounds()[1] < this.getBounds()[3]) {
				return true;
			}

			if (h.getBounds()[3] > this.getBounds()[1] && h.getBounds()[3] < this.getBounds()[3]) {
				return true;
			}

		}

		if (h.getBounds()[2] > this.getBounds()[0] && h.getBounds()[2] < this.getBounds()[2]) {

			if (h.getBounds()[1] > this.getBounds()[1] && h.getBounds()[1] < this.getBounds()[3]) {
				return true;
			}

			if (h.getBounds()[3] > this.getBounds()[1] && h.getBounds()[3] < this.getBounds()[3]) {
				return true;
			}

		}

		return false;
	}

	public void update() {
		positionX = e.getXPos();
		positionY = e.getYPos();
	}

	public int[] getBounds() {
		int[] bounds = { this.positionX + this.offsetX, this.positionY + this.offsetY,
				this.positionX + this.offsetX + this.width, this.positionY + this.offsetY + this.height };

		return bounds;
	}
	
	public void setX(int x) {
		positionX = x;
	}
	
	public void setY(int y) {
		positionY = y;
	}

}
