package gfx;

import java.awt.image.BufferedImage;

public class Sprite {

	BufferedImage sprite;
	
	public Sprite(int x, int y, int size, SpriteSheet sheet) {
		sheet.cut(x, y, size); 
	}
	
	
	
	
}
