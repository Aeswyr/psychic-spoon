package entities;

import java.awt.Graphics;

import game.Assets;
import game.Game;
import runtime.Handler;
import utility.Hitbox;

public class SuperBeam extends Entity{

	int xSpeed, ySpeed;
	
    public SuperBeam(Handler theHandler, int xPos, int yPos, int xSpeed, int ySpeed) {
        
        super.theHandler = theHandler;
        super.xPos = xPos;
        super.yPos = yPos;
        super.sprite = Assets.superBeam;
        
        this.height = 16;
        this.width = 7;
        
        this.hitbox = new Hitbox(this, height * Game.GAMESCALE, width * Game.GAMESCALE, 0, 0);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
	
	@Override
	public void update() {
		this.yPos += ySpeed;
		this.xPos += xSpeed;
		hitbox.update();
		
		for (Entity e : theHandler.getWorld().getEntities()) {
			if (e instanceof Beam || e instanceof SuperBeam) {
			} else {
				if (this.hitbox.contains(e.getHitBox())) {
					e.die();
					theHandler.getWorld().addEntity(new Beam(theHandler, xPos, yPos, 2, -10));
					theHandler.getWorld().addEntity(new Beam(theHandler, xPos, yPos, 0, -10));
					theHandler.getWorld().addEntity(new Beam(theHandler, xPos, yPos, -2, -10));
					
					if (e instanceof Alien && this.ySpeed == -10) theHandler.getPlayer().addScore(500);
					if (e instanceof Asteroid && this.ySpeed == -10) theHandler.getPlayer().addScore(100);
					
					this.die();
					break;
				}
			}
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		sprite.render(xPos - theHandler.getCamera().xOffset(), yPos - theHandler.getCamera().yOffset(), g);
		
	}

	
}


