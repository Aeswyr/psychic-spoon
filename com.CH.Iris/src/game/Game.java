package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import runtime.Handler;

public class Game implements Runnable{

	private Thread t;
	private boolean running;
	private Screen screen;
	private BufferStrategy bs;
	private Graphics g;
	private Handler handler;
	
	public static int GAMESCALE = 3;
	
	public Game() {
		
		setup();
		handler = new Handler();
		screen.addListener(handler.getKeyHandler());
		
	}
	
	public void setup() {
		screen = new Screen();
		screen.setBackground(Color.BLACK);
	}

	@Override
	public void run() {

		long lastTime = System.nanoTime();
		long delta = 1000000000 / 60;
		int fps = 0;
		long lastFPS = System.nanoTime();
		long deltaFPS = 1000000000;		
		
		while (running) {
			long currentTime = System.nanoTime();
			
			if (currentTime - lastTime > delta) {
				update();
				render();
				
				lastTime = currentTime;
				fps++;
			}
			
			if (currentTime - lastFPS > deltaFPS) {
			System.out.println("FPS: " + fps);
			fps = 0;
			lastFPS = currentTime;
			}
		}		
	}
	
	
	public void update() {
		handler.update();
	}
	
	public void render() {
		bs = screen.getBufferStrategy();
		Font score = new Font("Score", Font.ROMAN_BASELINE + Font.BOLD, 20);
		Font gameOver = new Font("Score", Font.HANGING_BASELINE + Font.BOLD, 50);
		
		if (bs == null) {
		screen.createBufferStrategy(3);
		return;
		}
		
		g = bs.getDrawGraphics();
		
		//Graphics Manipulation
	    g.setFont(score);
	    g.setColor(Color.WHITE);
		
	    //Draw Here!
	    g.clearRect(0, 0, screen.getWidth(), screen.getHeight());
	    handler.render(g);	    
	    g.drawString("Score: " + handler.getPlayer().getScore(), 650, 30);
	    
	    if(handler.getPlayer().getLives() < 0) {
	    	g.setFont(gameOver);
	    	g.drawString("GAME OVER", 225, 65);
	    	g.drawString("Score: " + handler.getPlayer().getScore(), 250, 115);
	    }
	    
	    
	    //End Drawing!
	    bs.show();
	    g.dispose();
	}
	
	public synchronized void start() {
		running = true;
		t = new Thread(this);
		t.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
