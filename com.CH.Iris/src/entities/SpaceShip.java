package entities;

import java.awt.Graphics;
import game.Assets;
import runtime.Handler;
import gfx.Sprite;

public class SpaceShip extends Entity{
    
    protected SpaceShip(Handler theHandler, int xPos, int yPos) {
        
        super.theHandler = theHandler;
        super.xPos = xPos;
        super.yPos = yPos;
        super.sprite = Assets.ship;
        
        
    }
    
    public void update() {
        
    }
    
    public void render(Graphics g) {
        
        sprite.render(xPos, yPos, g);
        
    }
    

}
