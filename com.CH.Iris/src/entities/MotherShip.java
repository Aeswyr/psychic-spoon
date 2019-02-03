package entities;

import java.awt.Graphics;
import game.Assets;
import game.Game;
import runtime.Handler;
import sfx.SoundInstance;
import utility.Hitbox;

public class MotherShip extends Entity {

	private int timer = 1;
	private int lives = 1;
	private int nextTrigger = (int) (Math.random() * 40) + 120;
	private int xSpeed;
	private int ySpeed;
	private static int spawned = 0;
	// SoundInstance instance;

	public MotherShip(Handler theHandler, int xPos, int yPos) {
		super.theHandler = theHandler;
		super.xPos = xPos;
		super.yPos = yPos;
		super.sprite = Assets.alienMothership;

		this.height = 32;
		this.width = 64;

		this.xSpeed = 0;
		this.ySpeed = 5;

		this.hitbox = new Hitbox(this, height * Game.GAMESCALE, width * Game.GAMESCALE, 0, 0);
		
		spawned++;

		// instance = Assets.alienSound.loop();

	}

	@Override
	public void update() {

		if (timer % nextTrigger == 0) {

			timer = 1;
			nextTrigger = (int) (Math.random() * 40) + 120;

			theHandler.getWorld().addEntity(new Beam(theHandler, xPos, yPos + 100, 4, 10));
			theHandler.getWorld().addEntity(new Beam(theHandler, xPos, yPos + 100, 2, 10));
			theHandler.getWorld().addEntity(new Beam(theHandler, xPos, yPos + 100, 0, 10));
			theHandler.getWorld().addEntity(new Beam(theHandler, xPos, yPos + 100, -2, 10));
			theHandler.getWorld().addEntity(new Beam(theHandler, xPos, yPos + 100, -4, 10));

			Assets.fireLazerSound.play();

			this.xSpeed = (int) (Math.random() * 7 - 5);

		}

		if (this.yPos + this.ySpeed > 800) {
			this.ySpeed = -3;
			this.xSpeed = (int) (Math.random() * 7 - 5);
		}

		if (this.xPos <= 0 + xSpeed || this.xPos >= 800 - 48 - xSpeed) {
			this.xSpeed *= -1;
			this.xPos += xSpeed;
			this.xPos += xSpeed;
			this.xPos += xSpeed;
		}

		timer++;

		this.ySpeed = -3;
		this.yPos += ySpeed;
		this.xPos += xSpeed;
		this.hitbox.update();

	}
	
	public static int getSpawned() {
		return spawned;
	}
	
	

	@Override
	public void render(Graphics g) {
		sprite.render(xPos - theHandler.getCamera().xOffset(), yPos - theHandler.getCamera().yOffset(), g);
	}

	@Override
	public void die() {

		if (lives > 0) {
			lives--;
		}

		else {
			super.die();
			// instance.stopLoop();
			Assets.explosionSound.play();
			Assets.explosionSound.play();
			Assets.explosionSound.play();
		}
	}

}