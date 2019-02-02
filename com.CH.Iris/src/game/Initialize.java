package game;

import sfx.Sound;

public class Initialize {

	public static void main(String[] args) {
		Assets.initialize();
		Sound.InitSound();
		Game game = new Game();
		game.start(); 
		//Sound.shutdown();
	}
	
}
