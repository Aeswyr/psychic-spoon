package game;

public class Initialize {

	public static void main(String[] args) {
		Assets.initialize();
		Game game = new Game();
		game.start(); 
		
	}
	
}
