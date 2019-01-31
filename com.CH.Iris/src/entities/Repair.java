package entities;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Assets;
import game.Game;
import runtime.Handler;
import utility.Hitbox;

public class Repair extends Entity{

    public Repair(Handler theHandler, int xPos, int yPos) {
        
        super.theHandler = theHandler;
        super.xPos = xPos;
        super.yPos = yPos;
        super.sprite = Assets.repair;

        this.width = 16;
        this.height = 16;
        this.hitbox = new Hitbox(this, height * Game.GAMESCALE, width * Game.GAMESCALE, 0, 0);
        
    }
	
	@Override
	public void update() {
		hitbox.update();
		if (this.hitbox.contains(theHandler.getPlayer().getHitBox()))
			theHandler.getPlayer().repair();
	}

	@Override
	public void render(Graphics g) {
		sprite.render(xPos - theHandler.getCamera().xOffset(), yPos - theHandler.getCamera().yOffset(), g);
		
	} 
	
}
