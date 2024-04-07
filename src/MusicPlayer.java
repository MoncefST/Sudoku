import java.io.File;
import javax.sound.sampled.*;

/**
 * Class containign a simple music player that allows playing and stopping music.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */

public class MusicPlayer {
    private Clip clip;
    private boolean isPlaying;

    /**
    * Constructs a MusicPlayer with the specified file path.
    * 
    * @param filePath The path to the music file to be played.
    */
    public MusicPlayer(String filePath) {
        try {
            File file = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * Starts playing the music.
    */
    public void play() {
        if (clip != null && !isPlaying) {
            clip.start();
            isPlaying = true;
        }
    }

    /**
    * Stops the music.
    */
    public void stop() {
        if (clip != null && isPlaying) {
            clip.stop();
            isPlaying = false;
        }
    }

    /**
     * Checks if the music is currently playing.
     *
     * @return true if the music is playing, false otherwise.
     */
    public boolean isPlaying() {
        return isPlaying;
    }
}
