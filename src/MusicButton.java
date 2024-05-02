import javax.swing.*;

/**
 * Fournit un bouton qui bascule entre la lecture et l'arrêt de la musique lorsqu'il est cliqué.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class MusicButton extends JButton {
/**
 * Représente le lecteur de musique actuellement en cours de lecture.
 */
private static MusicPlayer currentMusicPlayer;

    /**
     * L'icône à afficher lorsque la musique est activée.
     */
    private ImageIcon iconOn;

    /**
     * L'icône à afficher lorsque la musique est désactivée.
     */
    private ImageIcon iconOff;

    /**
     * Le lecteur de musique associé à ce bouton.
     */
    private MusicPlayer musicPlayer;


    /**
    * Constructeur : Construit un MusicButton.
    * @param onIconPath   Le chemin du fichier d'icône lorsque la musique est activée.
    * @param offIconPath  Le chemin du fichier d'icône lorsque la musique est désactivée.
    * @param musicFilePath Le chemin du fichier musical à jouer.
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

        this.addActionListener(e -> {
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
