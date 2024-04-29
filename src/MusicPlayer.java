import java.io.File;
import javax.sound.sampled.*;

/**
 * Classe contenant un lecteur de musique simple qui permet de jouer et d'arrêter la musique.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */

public class MusicPlayer {
    private Clip clip;
    private boolean isPlaying;

    /**
    * Construit un MusicPlayer avec le chemin de fichier spécifié.
    * @param filePath Le chemin du fichier musical à jouer.
    */
    public MusicPlayer(String filePath) {
        try {
            File file = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            this.clip = AudioSystem.getClip();
            this.clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * Démarre la lecture de la musique.
    */
    public void play() {
        if (this.clip != null && !this.isPlaying) {
            this.clip.start();
            this.isPlaying = true;
        }
    }

    /**
    * Arrête la lecture de la musique.
    */
    public void stop() {
        if (this.clip != null && this.isPlaying) {
            this.clip.stop();
            this.isPlaying = false;
        }
    }

    /**
     * Vérifie si la musique est en train de jouer actuellement.
     * @return true si la musique est en train de jouer, false sinon.
     */
    public boolean isPlaying() {
        return this.isPlaying;
    }
}
