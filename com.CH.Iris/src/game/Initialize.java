package game;

import sfx.SoundHandler;

public class Initialize {

	public static void main(String[] args) {
		Assets.initialize();
		SoundHandler.InitSound();
		Game game = new Game();
		game.start(); 
		
	}
	
}
