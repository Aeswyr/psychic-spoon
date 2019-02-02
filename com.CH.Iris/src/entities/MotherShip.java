package entities;

import java.awt.Graphics;
import game.Assets;
import game.Game;
import runtime.Handler;
import utility.Hitbox;

public class MotherShip extends Entity {

	private int timer = 1;
	private int nextTrigger = (int)(Math.random() * 20) + 120;
	private int xSpeed;
	
	public MotherShip(Handler theHandler) {
		super.theHandler = theHandler;
		super.xPos = 400;
		super.yPos = 50;
		//super.sprite = Assets.mothership;
		
		//this.height;
		//this.width;
		
		this.xSpeed = 0;
		
		this.hitbox = new Hitbox(this, height * Game.GAMESCALE, width * Game.GAMESCALE, 0, 0);
		
		
	}
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}