package entities;

import java.awt.Graphics;
import gfx.Sprite;
import runtime.Handler;

public class Asteroid extends Entity {

	public Asteroid(Handler theHandler, int xPos, int yPos, Sprite sprite) {

		super.theHandler = theHandler;
		super.xPos = xPos;
		super.yPos = yPos;
		super.sprite = sprite;

	}

	public void update() {

	}

	public void render(Graphics g) {

		sprite.render(xPos, xPos, g);

	}

}
