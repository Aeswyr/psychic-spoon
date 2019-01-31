package entities;

import runtime.Handler;
import utility.Hitbox;

import java.awt.Graphics;
import gfx.Sprite;

public abstract class Entity {
    protected Handler theHandler;
    protected int xPos, yPos;
    protected int width, height;
    protected Sprite sprite; 
    protected Hitbox hitbox;

    public abstract void update();
    public abstract void render(Graphics g);
    
    public int getXPos() {
        return this.xPos;
    }
    
    public int getYPos() {
        return this.yPos;
    }
    
    public int getWidth() {
    	return width;
    }
    
    public int getHeight() {
    	return height;
    }
    
    public Hitbox getHitBox() {
    	return hitbox;
    }
}
