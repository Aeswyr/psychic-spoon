package entities;

import runtime.Handler;
import java.awt.Graphics;
import gfx.Sprite;

public abstract class Entity {
    protected Handler theHandler;
    protected int xPos;
    protected int yPos;
    protected Sprite sprite; 

    public abstract void update();
    public abstract void render(Graphics g);
    
    public int getXPos() {
        return this.xPos;
    }
    
    public int getYPos() {
        return this.yPos;
    }
}
