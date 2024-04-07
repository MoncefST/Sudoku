import java.awt.*;
import javax.swing.*;

/**
 * A custom JButton designed to control music playback.
 * It provides a button that toggles between playing and stopping music when clicked.
 *
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */

public class MusicButton extends JButton {
    private boolean isMusicOn;
    private ImageIcon iconOn;
    private ImageIcon iconOff;
    private MusicPlayer musicPlayer;


    /**
    * Constructs a MusicButton.
    *    
    * @param onIconPath   The file path for the icon when music is on.
    * @param offIconPath  The file path for the icon when music is off.
    * @param musicFilePath The file path for the music file to be played.
    */

    public MusicButton(String onIconPath, String offIconPath, String musicFilePath) {

        iconOn = new ImageIcon(onIconPath);
        iconOff = new ImageIcon(offIconPath);
        setIcon(iconOff);
        isMusicOn = false;
        musicPlayer = new MusicPlayer(musicFilePath);

        addActionListener(e -> {
            if (isMusicOn) {
                musicPlayer.stop();
                setIcon(iconOff);
            } else {
                musicPlayer.play();
                setIcon(iconOn);
            }
            isMusicOn = !isMusicOn;
        });
    }
}
