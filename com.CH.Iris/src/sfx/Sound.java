package sfx;

import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import utility.Loader;

public class Sound {
	
	public static int idGenerator = 0;
	public final int ID;

	private SoundInstance[] channels;
	private static final int MAX_CHANNELS = 3;

	public Sound(String path) {
		this.ID = idGenerator;
		idGenerator++;
		channels = new SoundInstance[MAX_CHANNELS];
		
		for (int i = 0; i < MAX_CHANNELS; i++) {
			try {
				AudioInputStream stream = Loader.loadURLAudio(path);
				
				channels[i] = new SoundInstance(AudioSystem.getClip(), ID);
				channels[i].sound.open(stream);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void play() {
		int i = 0;
		for (SoundInstance c : channels) {
			if (!c.sound.isActive()) {
				Sound.add(c, ID);
				System.out.println("Added " + i + " instance of " + this.toString());
				break;
			}
			i++;
		}
	}

	public void loop(int channel) {
		for (SoundInstance c : channels) {

			if (!c.sound.isActive()) {
				c.sound.loop(Clip.LOOP_CONTINUOUSLY);
				Sound.add(c, ID);
				break;
			}
		}
	}

	private static ArrayList<SoundPlayer> soundList;

	public static void InitSound() {
		soundList = new ArrayList<SoundPlayer>();
		for (int i = 0; i < MAX_CHANNELS; i++) {
			SoundPlayer instance = new SoundPlayer();
			instance.start();
		soundList.add(instance);
		
		}
	}

	public static void add(SoundInstance c, int ID) {
		for (SoundPlayer s : soundList) {
			if (!s.containsSound(ID)) {
				s.wake();
			s.playClip(c);
			break;
			}
		}
	}

	public static void remove(SoundPlayer instance) {
		soundList.remove(instance);
	}


}
