package gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Game;

public class Sprite {

	BufferedImage sprite;
	
	public Sprite(int x, int y, int size, SpriteSheet sheet) {

		sprite = new BufferedImage(size * Game.GAMESCALE, size * Game.GAMESCALE, BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics g = sprite.getGraphics();
		g.drawImage(sheet.cut(x, y, size), 0, 0, size * Game.GAMESCALE, size * Game.GAMESCALE, null);
		g.dispose();
			
	}
	
	public void render(int x, int y, Graphics g) {
		g.drawImage(sprite, x, y, null);
	}
	
	
	
	
}
