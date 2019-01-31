package entities;

import java.awt.Graphics;
import game.Assets;
import runtime.Handler;
import gfx.Sprite;

public class SpaceShip extends Entity{
    private static int moveMent = 5;
    public SpaceShip(Handler theHandler, int xPos, int yPos) {
        
        super.theHandler = theHandler;
        super.xPos = xPos;
        super.yPos = yPos;
        super.sprite = Assets.ship;
        
        
    }
    
    public void update() {
        move();
        theHandler.getCamera().centerOnEntity(this);
    }
    
    public void render(Graphics g) {
        sprite.render(xPos - theHandler.getCamera().xOffset(), yPos - theHandler.getCamera().yOffset(), g);
        
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

}
