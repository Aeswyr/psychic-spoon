package sfx;

import javax.sound.sampled.Clip;

public class SoundInstance implements Runnable {

	public Clip clip;

	public SoundInstance(Clip clip) {
		this.clip = clip;
	}

	@Override
	public void run() {
		clip.start();
			
		clip.setFramePosition(0);
	}
	
	public void tagLooped() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stopLoop() {
		clip.stop();
	}

}
