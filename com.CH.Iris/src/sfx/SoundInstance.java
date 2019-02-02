package sfx;

import javax.sound.sampled.Clip;

public class SoundInstance {

	public Clip sound;
	public int ID;
	
	public SoundInstance(Clip c, int ID) {
		sound = c;
		this.ID = ID;
	}
	
}
