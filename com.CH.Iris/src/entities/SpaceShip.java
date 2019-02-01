package entities;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Assets;
import game.Game;
import runtime.Handler;
import utility.Hitbox;


public class SpaceShip extends Entity{
	
    private static int moveMent = 5;
    private int lives = 2;
    boolean fired = false;
    private int score;
    int fireBassCannon = 180;
    
    ArrayList<Entity> attacks;
    
    public SpaceShip(Handler theHandler, int xPos, int yPos) {
        
        super.theHandler = theHandler;
        super.xPos = xPos;
        super.yPos = yPos;
        super.sprite = Assets.ship;
        attacks = new ArrayList<Entity>();
        
        this.height = 15;
        this.width = 7;
        this.hitbox = new Hitbox(this, height * Game.GAMESCALE, width * Game.GAMESCALE, 5 * Game.GAMESCALE, 0);
        
		this.collect(new Beam(theHandler, 0, 0, 0, -10));
		this.collect(new Beam(theHandler, 0, 0, 0, -10));
		this.collect(new Beam(theHandler, 0, 0, 0, -10));
		
		score = 0;
        
    }
    
    public void update() {
        move();
        ability();
        this.hitbox.update();
        theHandler.getCamera().centerOnEntity(this);
        
        if (fireBassCannon < 180) {
        	theHandler.getWorld().addEntity(new BassCannon(theHandler, this.xPos + 24, this.yPos - 64, 0, -10));
        }
        
        fireBassCannon++;
        score++;
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
    	if (lives < 0) {
    		Assets.deathSound.play();
    		theHandler.getWorld().removeEntity(this);
    	}
    }
    
    public void repair() {
    	if (lives < 5) this.lives++;
    }
    
    public void renderUI(Graphics g) {
    	for (int i = 0; i < lives; i++) {
    		Assets.ship.render(64 * i, 550, g);
    	}
    	
    	for (int i = 0; i < attacks.size(); i++) {
    		attacks.get(i).xPos = 800 - (48 * (i+1)) + theHandler.getCamera().xOffset();
    		attacks.get(i).yPos = 550 + theHandler.getCamera().yOffset();
    		attacks.get(i).render(g);
    	}
    }
    
    public void ability() {
    	if (theHandler.getKeyHandler().space && !fired && !attacks.isEmpty()) {
    		fired = true;
    		attacks.get(0).xPos = this.xPos + 24;
    		attacks.get(0).yPos = this.yPos - 64;
    		theHandler.getWorld().addEntity(attacks.get(0));
    		
    		if(attacks.get(0) instanceof Beam) {
    			Assets.fireLazerSound.play();
    		}
    		
    		if(attacks.get(0) instanceof Super || attacks.get(0) instanceof PierceBeam) {
    			Assets.fireSuperSound.play();
    		}
    		
    		if (attacks.get(0) instanceof BassCannon) {
    			fireBassCannon = 1;
    			Assets.fireBeamSound.play();
    		}
    		
    		
    		
    		attacks.remove(0);
    		    		
    	}
    	if (!theHandler.getKeyHandler().space) fired = false;
    }
    
    public void collect(Entity e) {
    	if (attacks.size() < 8) attacks.add(e);
    }
    
    public int getScore() {
    	return this.score;
    }
    
    public void addScore(int score) {
    	this.score += score;
    }
    
    public int getLives() {
    	return lives;
    }
    
}
