package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import runtime.Handler;

public class Game implements Runnable{

	private Thread t;
	private boolean running;
	private Screen screen;
	private BufferStrategy bs;
	private Graphics g;
	private Handler handler;
	
	public Game() {
		
		setup();
		handler = new Handler();
		
		
	}
	
	public void setup() {
		screen = new Screen();

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
		
	}
	
	public void render() {
		bs = screen.getBufferStrategy();
		
		if (bs == null) {
		screen.createBufferStrategy(3);
		return;
		}
		
		g = bs.getDrawGraphics();
		
	    //Draw Here!
	    g.clearRect(0, 0, screen.getWidth(), screen.getHeight());
	    handler.render(g);
	    
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
