package sfx;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import utility.Loader;

public class Sound {

  private int channel;
  public Clip clip;
  
  public Sound(String path) {
      AudioInputStream stream = Loader.loadURLAudio(path);
      try {
        clip = AudioSystem.getClip();
      } catch (LineUnavailableException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      try {
        clip.open(stream);
      } catch (LineUnavailableException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
  }
  
  public void play() {
    this.channel = SoundHandler.play(clip);
  }
  
  public void loop(int channel) {
    this.channel = SoundHandler.reserveChannel(clip, channel);
  }
  
  public void stop(int channel) {
    SoundHandler.stop(channel);
  }
  
  public int getChannel() {
    return channel;
  }
  
  
}
