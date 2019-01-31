package world;

import java.awt.Graphics;

import game.Assets;
import gfx.Sprite;

public class Tile {
	
	private static Sprite[] tiles = 
		{Assets.starTile, Assets.bigStarTile, Assets.blackTile, Assets.manyStarTile};
	private Sprite tile;
	public int x;
	public int y;
	
	public Tile(int x, int y) {
		tile = tiles[(int)(Math.random()*4)];
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g) {
		tile.render(x, y, g);
	}
}
