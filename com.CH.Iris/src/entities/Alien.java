package entities;

import java.awt.Graphics;

import game.Assets;
import game.Game;
import runtime.Handler;
import sfx.SoundInstance;
import utility.Hitbox;

public class Alien extends Entity {

	private int timer = 1;
	private int nextTrigger = (int)(Math.random() * 30) + 120;
	private int xSpeed;
	private int ySpeed;
	SoundInstance instance;
	
	public Alien(Handler theHandler, int xPos, int yPos) {
        super.theHandler = theHandler;
        super.xPos = xPos;
        super.yPos = yPos;
        super.sprite = Assets.alien;
        
        this.height = 16;
        this.width = 16;
        
        this.hitbox = new Hitbox(this, height * Game.GAMESCALE, width * Game.GAMESCALE, 0, 0);
        this.xSpeed = 0;
        this.ySpeed = 0;
        
		instance = Assets.alienSound.loop();
	}

	@Override
	public void update() {
		if (timer % nextTrigger == 0) {
			nextTrigger = (int)(Math.random() * 30) + 90;
			timer = 1;
			
			theHandler.getWorld().addEntity(new Beam(theHandler, xPos, yPos + 64, 0, 10));
			this.xSpeed = (int)(Math.random() * 9) - 4;
			this.ySpeed = -3;
			Assets.fireLazerSound.play();
			
		}
		
		timer++;
		
		if (this.xPos <= 0 + xSpeed || this.xPos >= 800 - 48 - xSpeed) {
			this.xSpeed *= -1;
			this.xPos += xSpeed;
			this.xPos += xSpeed;
			this.xPos += xSpeed;
		}
		
		
		
		this.yPos += ySpeed;
		this.xPos += xSpeed;
		this.hitbox.update();
		
	}

	@Override
	public void render(Graphics g) {
		sprite.render(xPos - theHandler.getCamera().xOffset(), yPos - theHandler.getCamera().yOffset(), g);
		
	}
	
	@Override
	public void die() {
		super.die();
		instance.stopLoop();
		Assets.explosionSound.play();
		
	}
	
}
