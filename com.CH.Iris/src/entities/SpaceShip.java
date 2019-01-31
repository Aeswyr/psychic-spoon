package entities;

import java.awt.Graphics;
import game.Assets;
import runtime.Handler;
import gfx.Sprite;

public class SpaceShip extends Entity{
    
    public SpaceShip(Handler theHandler, int xPos, int yPos) {
        
        super.theHandler = theHandler;
        super.xPos = xPos;
        super.yPos = yPos;
        super.sprite = Assets.ship;
        
        
    }
    
    public void update() {
        move();
    }
    
    public void render(Graphics g) {
        sprite.render(xPos, yPos, g);
        
    }

    public void move() {
      if(theHandler.getKeyHandler().left && xPos > 10) {
        xPos -= 10;
      }
      if(theHandler.getKeyHandler().right && xPos < 800 - 58) {
        xPos += 10;
      }
    }

}
