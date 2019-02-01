package sfx;

import javax.sound.sampled.Clip;

public class SoundHandler {

  private static final int MAXIMUM_CHANNELS = 20;
  private static Clip[] audioPlayer;
  private static boolean activeChannel[];
  private static boolean channelReserved[];
  
  public static void InitSound() {
    audioPlayer = new Clip[MAXIMUM_CHANNELS];
    activeChannel = new boolean[MAXIMUM_CHANNELS];
    channelReserved = new boolean[MAXIMUM_CHANNELS];
    for (int i = 0; i < MAXIMUM_CHANNELS; i++) {
        activeChannel[i] = false;
        channelReserved[i] = false;
    }

  }
  
  public static void cleanChannels() {
    for (int i = 0; i < MAXIMUM_CHANNELS; i++) {
     if (activeChannel[i] && !audioPlayer[i].isActive() && !channelReserved[i]) {
       stop(i);
     }
    }
  }
  
  public static int play(Clip clip) {
    for (int i = 0; i < MAXIMUM_CHANNELS; i++) {
      if (!activeChannel[i]) {
          activeChannel[i] = true;
          audioPlayer[i] = clip;
          audioPlayer[i].start();
          return i;
      }
    }
    return -1;
  }
  
  public static int reserveChannel(Clip clip, int i) {//reserves an audio channel for looping, returns the reserved channel index
      stop(i);
    activeChannel[i] = true;
    channelReserved[i] = true;
    audioPlayer[i] = clip;
    audioPlayer[i].loop(Clip.LOOP_CONTINUOUSLY);
    return i;
  }
  
  public static void stop(int i) {
    audioPlayer[i].setFramePosition(0);
    activeChannel[i] = false;
    channelReserved[i] = false;
  }
  
  public static void flushAudio() {
    for (int i = 0; i < MAXIMUM_CHANNELS; i++) {
        audioPlayer[i].close();
        activeChannel[i] = false;
        channelReserved[i] = false;
     }
  }
  
}
