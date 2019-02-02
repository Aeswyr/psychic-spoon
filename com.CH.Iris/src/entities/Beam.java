package entities;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Assets;
import game.Game;
import runtime.Handler;
import utility.Hitbox;

public class Beam extends Entity{

	int xSpeed, ySpeed;
	
    public Beam(Handler theHandler, int xPos, int yPos, int xSpeed, int ySpeed) {
        
        super.theHandler = theHandler;
        super.xPos = xPos;
        super.yPos = yPos;
        super.sprite = Assets.beam;
        
        this.height = 16;
        this.width = 1;
        
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
				if (this.hitbox.contains(e)) {
					theHandler.getWorld().removeEntity(e);
					theHandler.getWorld().removeEntity(this);
				}
			}
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		sprite.render(xPos - theHandler.getCamera().xOffset(), yPos - theHandler.getCamera().yOffset(), g);
		
	}

	
}
