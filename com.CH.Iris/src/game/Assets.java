package game;

import gfx.Sprite;
import gfx.SpriteSheet;

public class Assets {

	private static final String ENTITY = "./res/entity/";
	private static final String WORLD = "./res/world/";
	
	private static SpriteSheet s_tile;
	private static SpriteSheet s_ship;
	private static SpriteSheet s_asteriod;
	
	public static Sprite blackTile;
	public static Sprite starTile;
	public static Sprite bigStarTile;
	public static Sprite manyStarTile;
	public static Sprite ship;
	public static Sprite asteroid;
	
	public static void initialize() {
		s_tile = new SpriteSheet(WORLD + "tile.png");
		s_ship = new SpriteSheet(ENTITY + "ship.png");
		s_asteriod = new SpriteSheet(ENTITY + "asteriod.png");
		
		
		
	}
	
	
}
