package game;

import gfx.Sprite;
import gfx.SpriteSheet;

public class Assets {

	private static final String ENTITY = "/entity/";
	private static final String WORLD = "/world/";
	
	private static SpriteSheet s_tile;
	private static SpriteSheet s_ship;
	private static SpriteSheet s_asteroid;
	private static SpriteSheet s_beam;
	private static SpriteSheet s_powerup;
	
	public static Sprite blackTile;
	public static Sprite starTile;
	public static Sprite bigStarTile;
	public static Sprite manyStarTile;
	public static Sprite ship;
	public static Sprite asteroid;
	public static Sprite beam;
	public static Sprite superBeam; 
	public static Sprite repair;
	public static Sprite battery;
	public static Sprite superBoost;
	
	public static void initialize() {
		s_tile = new SpriteSheet(WORLD + "tile.png");
		s_ship = new SpriteSheet(ENTITY + "ship.png");
		s_asteroid = new SpriteSheet(ENTITY + "asteriod.png");
		s_powerup = new SpriteSheet(ENTITY + "boost.png");
		s_beam = new SpriteSheet(ENTITY + "shoot.png");
		
		blackTile = new Sprite(0, 0, 16, s_tile);
		starTile = new Sprite(16, 0, 16, s_tile);
		bigStarTile = new Sprite(0, 16, 16, s_tile);
		manyStarTile = new Sprite(16, 16, 16, s_tile);
		ship = new Sprite(0, 0, 16, s_ship);
		asteroid = new Sprite(0, 0, 32, s_asteroid);
		
		beam = new Sprite(0, 0, 16, s_beam);
		superBeam = new Sprite(16, 0, 16, s_beam);
		repair = new Sprite(0, 0, 16, s_powerup);
		battery = new Sprite(16, 0, 16, s_powerup);
		superBoost = new Sprite(32, 0, 16, s_powerup);
		
	}
	
	
}
