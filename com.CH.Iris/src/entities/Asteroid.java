package entities;

import java.awt.Graphics;

import game.Assets;
import game.Game;
import gfx.Sprite;
import runtime.Handler;
import utility.Hitbox;

public class Asteroid extends Entity {

	int xSpeed;
	int ySpeed;
	
	public Asteroid(Handler theHandler, int xPos, int yPos) {

		super.theHandler = theHandler;
		super.xPos = xPos;
		super.yPos = yPos;
		super.sprite = Assets.asteroid;
		
		this.height = 24;
		this.width = 17;
		this.hitbox = new Hitbox(this, height * Game.GAMESCALE, width * Game.GAMESCALE, 2 * Game.GAMESCALE, 3 * Game.GAMESCALE);
	
		xSpeed = (int)(Math.random() * 9) - 4;
		ySpeed = (int)(Math.random() * 6);
	
	}

	public void update() {
		move();
		hitbox.update();
		if (this.hitbox.contains(theHandler.getPlayer())) {
			theHandler.getPlayer().damage();
			theHandler.getWorld().removeEntity(this);
		}
		if (this.yPos > theHandler.getPlayer().getYPos() + 240) theHandler.getWorld().removeEntity(this);
	}

	public void render(Graphics g) {
		
		sprite.render(xPos - theHandler.getCamera().xOffset(), yPos - theHandler.getCamera().yOffset(), g);

	}
	
	public void move() {
		this.xPos += xSpeed;
		this.yPos += ySpeed;
	}

}
