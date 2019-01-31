package entities;

import java.awt.Graphics;

import game.Assets;
import game.Game;
import gfx.Sprite;
import runtime.Handler;
import utility.Hitbox;

public class Asteroid extends Entity {

	public Asteroid(Handler theHandler, int xPos, int yPos) {

		super.theHandler = theHandler;
		super.xPos = xPos;
		super.yPos = yPos;
		super.sprite = Assets.asteroid;
		this.hitbox = new Hitbox(this, 24 * Game.GAMESCALE, 17 * Game.GAMESCALE, 2 * Game.GAMESCALE, 3 * Game.GAMESCALE);
	}

	public void update() {
		hitbox.update();
		if (this.yPos > theHandler.getPlayer().getYPos() + 240) theHandler.getWorld().removeEntity(this);
	}

	public void render(Graphics g) {
		
		sprite.render(xPos - theHandler.getCamera().xOffset(), yPos - theHandler.getCamera().yOffset(), g);

	}

}
