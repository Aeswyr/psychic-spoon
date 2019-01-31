package entities;

import java.awt.Graphics;
import game.Assets;
import game.Game;
import runtime.Handler;
import utility.Hitbox;
import gfx.Sprite;

public class SpaceShip extends Entity{
	
    private static int moveMent = 5;
    int lives = 3;
    
    public SpaceShip(Handler theHandler, int xPos, int yPos) {
        
        super.theHandler = theHandler;
        super.xPos = xPos;
        super.yPos = yPos;
        super.sprite = Assets.ship;
        this.hitbox = new Hitbox(this, 7 * Game.GAMESCALE, 15 * Game.GAMESCALE, 5 * Game.GAMESCALE, 0);
        
    }
    
    public void update() {
        move();
        this.hitbox.update();
        theHandler.getCamera().centerOnEntity(this);
    }
    
    public void render(Graphics g) {
        sprite.render(xPos - theHandler.getCamera().xOffset(), yPos - theHandler.getCamera().yOffset(), g);
        renderUI(g);
    }

    public void move() {
      
      if(theHandler.getKeyHandler().left && xPos > 10) {
        xPos -= moveMent;
      }
      if(theHandler.getKeyHandler().right && xPos < 800 - 58) {
        xPos += moveMent;
      }
      yPos -= 3;
      
    }
    
    public void damage() {
    	this.lives--;
    }
    
    public void renderUI(Graphics g) {
    	for (int i = 0; i < lives; i++) {
    		Assets.ship.render(64 * i, 550, g);
    	}
    }
    

}
