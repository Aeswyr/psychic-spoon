package entities;

import java.awt.Graphics;

import game.Assets;
import game.Game;
import runtime.Handler;
import utility.Hitbox;

public class PiercePickup extends Entity{

    public PiercePickup(Handler theHandler, int xPos, int yPos) {
        
        super.theHandler = theHandler;
        super.xPos = xPos;
        super.yPos = yPos;
        super.sprite = Assets.piercePickup;
        this.hitbox = new Hitbox(this, 16 * Game.GAMESCALE, 16 * Game.GAMESCALE, 0, 0);
        
        this.width = 16;
        this.height = 16;
        this.hitbox = new Hitbox(this, height * Game.GAMESCALE, width * Game.GAMESCALE, 0, 0);
        
    }
	
	@Override
	public void update() {
		hitbox.update();
		if (this.hitbox.contains(theHandler.getPlayer().getHitBox())) {
				theHandler.getPlayer().collect(new PierceBeam(theHandler, 0, 0, 0, -10));
				theHandler.getPlayer().collect(new PierceBeam(theHandler, 0, 0, 0, -10));
			theHandler.getWorld().removeEntity(this);
			Assets.pickupSuperSound.play();
		}
			
	}

	@Override
	public void render(Graphics g) {
		sprite.render(xPos - theHandler.getCamera().xOffset(), yPos - theHandler.getCamera().yOffset(), g);
		
	} 
	
}
