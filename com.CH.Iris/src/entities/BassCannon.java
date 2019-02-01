package entities;

import java.awt.Graphics;
import game.Assets;
import game.Game;
import runtime.Handler;
import utility.Hitbox;

public class BassCannon extends Entity {

	int xSpeed, ySpeed, lifeTime;

	public BassCannon(Handler theHandler, int xPos, int yPos, int xSpeed, int ySpeed) {

			super.theHandler = theHandler;
			super.xPos = xPos;
			super.yPos = yPos;
			super.sprite = Assets.bassCannon;

			this.height = 16;
			this.width = 5;

			this.hitbox = new Hitbox(this, height * Game.GAMESCALE, width * Game.GAMESCALE, 0, 0);
			this.xSpeed = xSpeed;
			this.ySpeed = ySpeed;
		}

	@Override
	public void update() {

		this.yPos += ySpeed;
		this.xPos += xSpeed;
		lifeTime++;
		hitbox.update();

		for (Entity e : theHandler.getWorld().getEntities()) {
			if (e instanceof Beam || e instanceof SuperBeam || e instanceof PierceBeam || e instanceof BassCannon) {
			} else {
				if (this.hitbox.contains(e.getHitBox())) {
					if (e instanceof SpaceShip) {
						theHandler.getPlayer().damage();
					} else {
						if (e instanceof Alien && this.ySpeed == -10)
							theHandler.getPlayer().addScore(100);
						if (e instanceof Asteroid && this.ySpeed == -10)
							theHandler.getPlayer().addScore(10);
						e.die();
					}

				}
			}
		}
		if (theHandler.getPlayer().getYPos() - this.yPos > 800 || theHandler.getPlayer().getYPos() - this.yPos < -800)
			theHandler.getWorld().removeEntity(this);
		
		this.die();
	}

	@Override
	public void render(Graphics g) {
		sprite.render(xPos - theHandler.getCamera().xOffset(), yPos - theHandler.getCamera().yOffset(), g);

	}

}
