package game;

import gfx.Sprite;
import gfx.SpriteSheet;
import sfx.Sound;

public class Assets {

	private static final String ENTITY = "/entity/";
	private static final String WORLD = "/world/";
	private static final String SOUND = "/sound/";
	
	private static SpriteSheet s_tile;
	private static SpriteSheet s_ship;
	private static SpriteSheet s_asteroid;
	private static SpriteSheet s_beam;
	private static SpriteSheet s_powerup;
	private static SpriteSheet s_alien;
	
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
	public static Sprite alien;
	public static Sprite bassCannon;
	public static Sprite pierceBeam;
	public static Sprite scoreBoost;
	public static Sprite piercePickup;
	public static Sprite bassCannonPickup;
	
	public static Sound alienSound;
	public static Sound batterySound;
	public static Sound deathSound;
	public static Sound explosionSound;
	public static Sound fireBeamSound;
	public static Sound fireLazerSound;
	public static Sound fireSuperSound;
	public static Sound hurtSound;
	public static Sound pickupBeamSound;
	public static Sound pickupRepairSound;
	public static Sound pickupScoreSound;
	public static Sound pickupSuperSound;

	
	public static void initialize() {
		s_tile = new SpriteSheet(WORLD + "tile.png");
		s_ship = new SpriteSheet(ENTITY + "ship.png");
		s_asteroid = new SpriteSheet(ENTITY + "asteriod.png");
		s_powerup = new SpriteSheet(ENTITY + "boost.png");
		s_beam = new SpriteSheet(ENTITY + "shoot.png");
		s_alien = new SpriteSheet(ENTITY + "alien.png");
		
		blackTile = new Sprite(0, 0, 16, s_tile);
		starTile = new Sprite(16, 0, 16, s_tile);
		bigStarTile = new Sprite(0, 16, 16, s_tile);
		manyStarTile = new Sprite(16, 16, 16, s_tile);
		ship = new Sprite(0, 0, 16, s_ship);
		asteroid = new Sprite(0, 0, 32, s_asteroid);
		alien = new Sprite(0, 0, 16, s_alien);
		
		beam = new Sprite(0, 0, 16, s_beam);
		superBeam = new Sprite(16, 0, 16, s_beam);
		pierceBeam = new Sprite(32, 0, 16, s_beam);
		bassCannon = new Sprite(48, 0, 16, s_beam);
		repair = new Sprite(0, 0, 16, s_powerup);
		battery = new Sprite(16, 0, 16, s_powerup);
		superBoost = new Sprite(32, 0, 16, s_powerup);
		scoreBoost = new Sprite(48, 0, 16, s_powerup);
		piercePickup = new Sprite(64, 0, 16, s_powerup);
		bassCannonPickup = new Sprite(80, 0, 16, s_powerup);
		
		alienSound = new Sound(SOUND + "alien.wav");
		batterySound = new Sound(SOUND + "battery.wav");
		deathSound = new Sound(SOUND + "death.wav");
		explosionSound = new Sound(SOUND + "explosion.wav");
		fireBeamSound = new Sound(SOUND + "fireBeam.wav");
		fireLazerSound = new Sound(SOUND + "fireLazer.wav");
		fireSuperSound = new Sound(SOUND + "fireSuper.wav");
		hurtSound = new Sound(SOUND + "hurt.wav");
		pickupBeamSound = new Sound(SOUND + "pickupBeam.wav");
		pickupRepairSound = new Sound(SOUND + "pickupRepair.wav");
		pickupScoreSound = new Sound(SOUND + "pickupScore.wav");
		pickupSuperSound = new Sound(SOUND + "pickupSuper.wav");
		
	}
	
	
}
