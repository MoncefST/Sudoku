import javax.swing.*;

/**
 * It provides a button that toggles between playing and stopping music when clicked.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
 public class MusicButton extends JButton {
    private static MusicPlayer currentMusicPlayer;
    private ImageIcon iconOn;
    private ImageIcon iconOff;
    private MusicPlayer musicPlayer;

    /**
    * Constructs a MusicButton.
    * @param onIconPath   The file path for the icon when music is on.
    * @param offIconPath  The file path for the icon when music is off.
    * @param musicFilePath The file path for the music file to be played.
    */
    public MusicButton(String onIconPath, String offIconPath, String musicFilePath) {

        this.iconOn = new ImageIcon(onIconPath);
        this.iconOff = new ImageIcon(offIconPath);
        setIcon(this.iconOff);

        // Vérifie s'il y a déjà une musique en cours de lecture et l'arrête si nécessaire
        if (currentMusicPlayer != null && currentMusicPlayer.isPlaying()) {
            currentMusicPlayer.stop();
            currentMusicPlayer = null;
        }

        this.musicPlayer = new MusicPlayer(musicFilePath);

        addActionListener(e -> {
            if (currentMusicPlayer != null && currentMusicPlayer.isPlaying()) {
                currentMusicPlayer.stop();
                currentMusicPlayer = null;
                setIcon(this.iconOff);
            } else {
                this.musicPlayer.play();
                setIcon(this.iconOn);
                currentMusicPlayer = this.musicPlayer;
            }
        });
    }
}
