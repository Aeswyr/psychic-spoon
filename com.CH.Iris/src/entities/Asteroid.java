package entities;

import java.awt.Graphics;

import game.Assets;
import gfx.Sprite;
import runtime.Handler;

public class Asteroid extends Entity {

	public Asteroid(Handler theHandler, int xPos, int yPos) {

		super.theHandler = theHandler;
		super.xPos = xPos;
		super.yPos = yPos;
		super.sprite = Assets.asteroid;

	}

	public void update() {

	}

	public void render(Graphics g) {

		sprite.render(xPos - theHandler.getCamera().xOffset(), yPos - theHandler.getCamera().yOffset(), g);

	}

}
