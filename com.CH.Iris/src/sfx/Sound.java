package sfx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import utility.Loader;


public class Sound {

	String path;
	
	private Clip[] clips;
	private final int MAX_CHANNELS = 5;
	
	public Sound(String path) {	
		this.path = path;
		clips = new Clip[MAX_CHANNELS];
		
		
		for (int i = 0; i < MAX_CHANNELS; i++) {
			try {
				clips[i] = AudioSystem.getClip();
				clips[i].open(Loader.loadURLAudio(path));
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void play() {
		for (Clip c : clips) {
			if (!c.isActive()) {
				Sound.add(new SoundInstance(c));
				break;
			}
		}
	}

	public void loop() {
		
		for (Clip c : clips) {
			if (!c.isActive()) {
				SoundInstance instance = new SoundInstance(c);
				instance.tagLooped();
				loops.add(instance);
				Sound.add(instance);
				break;
			}
		}
	}

	private static ArrayList<SoundInstance> loops;
	private static ExecutorService pool;

	public static void InitSound() {
		pool = Executors.newFixedThreadPool(5);
		loops = new ArrayList<SoundInstance>();
	}

	public static void add(SoundInstance instance) {
		pool.execute(instance);
	}
	
	public static void shutdown() {
		for (SoundInstance instance : loops) {
			instance.stopLoop();
		}
		
		pool.shutdown();
	}



}
