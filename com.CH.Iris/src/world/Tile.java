package world;

import java.awt.Graphics;

import game.Assets;
import gfx.Sprite;
import runtime.Handler;

public class Tile {
	
	
	private Handler handler;
	private static Sprite[] tiles = 
		{Assets.starTile, Assets.bigStarTile, Assets.blackTile, Assets.manyStarTile};
	private Sprite tile;
	public int x;
	public int y;
	
	public Tile(int x, int y, Handler h) {
		tile = tiles[(int)(Math.random()*4)];
		this.x = x;
		this.y = y;
		handler = h;
	}
	
	public void render(Graphics g) {
		tile.render(x-handler.getCamera().xOffset(), y-handler.getCamera().yOffset(), g);
	}
}
