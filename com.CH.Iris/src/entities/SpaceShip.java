package entities;

import java.awt.Graphics;
import runtime.Handler;
import gfx.Sprite;

public class SpaceShip extends Entity{
    
    protected SpaceShip(Handler theHandler, int xPos, int yPos, Sprite sprite) {
        
        super.theHandler = theHandler;
        super.xPos = xPos;
        super.yPos = yPos;
        super.sprite = sprite;
        
        
    }
    
    public void update() {
        
    }
    
    public void render(Graphics g) {
        
    }
    

}
