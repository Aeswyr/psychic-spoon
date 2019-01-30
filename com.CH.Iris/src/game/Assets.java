package game;

import gfx.Sprite;
import gfx.SpriteSheet;

public class Assets {

	private static final String ENTITY = "/entity/";
	private static final String WORLD = "/world/";
	
	private static SpriteSheet s_tile;
	private static SpriteSheet s_ship;
	private static SpriteSheet s_asteroid;
	
	public static Sprite blackTile;
	public static Sprite starTile;
	public static Sprite bigStarTile;
	public static Sprite manyStarTile;
	public static Sprite ship;
	public static Sprite asteroid;
	
	public static void initialize() {
		s_tile = new SpriteSheet(WORLD + "tile.png");
		s_ship = new SpriteSheet(ENTITY + "ship.png");
		s_asteroid = new SpriteSheet(ENTITY + "asteriod.png");
		
		blackTile = new Sprite(0, 0, 16, s_tile);
		starTile = new Sprite(16, 0, 16, s_tile);
		bigStarTile = new Sprite(0, 16, 16, s_tile);
		manyStarTile = new Sprite(16, 16, 16, s_tile);
		ship = new Sprite(0, 0, 16, s_ship);
		asteroid = new Sprite(0, 0, 32, s_asteroid);
		
	}
	
	
}
