package sfx;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SoundPlayer implements Runnable {

	private Queue<SoundInstance> clips;
	private Thread t;
	boolean running;

	public SoundPlayer() {
		clips = new ConcurrentLinkedQueue<SoundInstance>();
		t = new Thread(this);
	}

	@Override
	public void run() {
		while (running) {
			SoundInstance sound = clips.poll();
			if (sound != null) {
				sound.sound.setFramePosition(0);
				sound.sound.start();
				
				if (clips.isEmpty())
					try {
						//t.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		}

	}


	public void playClip(SoundInstance sound) {
		clips.add(sound);
	}

	public synchronized void start() {
		running = true;
		t.start();
	}
	
	public boolean containsSound(int ID) {
		for (SoundInstance s : clips) {
			if (s.ID == ID) return true;
		}
		return false;
	}
	
	public void wake() {
		//t.notify();
	}
}
