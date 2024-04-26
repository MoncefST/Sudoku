import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Le contrôleur pour le jeu de la grille.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GSPlayController implements KeyListener, ActionListener {
    private GSPlay gsPlay;

    /**
     * Constructeur du contrôleur du jeu de la grille.
     * @param gsPlay Le jeu de la grille associé à ce contrôleur.
     */
    public GSPlayController(GSPlay gsPlay) {
        this.gsPlay = gsPlay;
    }

    /**
     * Gère les actions lorsqu'un événement se produit.
     * @param e L'événement déclenché.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gsPlay.getBoutonValider()) {
            // Crée une fenêtre de dialogue pour afficher le temps écoulé depuis le début du jeu.
            GSWin gestionVictoire = new GSWin(gsPlay.getStartTime());
            gestionVictoire.showDialog();
        }
    }

    /**
     * Gère les événements lorsque la touche est enfoncée.
     * @param e L'événement de la touche enfoncée.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyValue = gsPlay.getKeyValue(e);
        if (keyValue != -1) {
            // Met à jour la valeur dans la case active de la grille avec la touche appuyée.
            gsPlay.getMaGrille().setValuetoCase(gsPlay.getMaGrille().whoIsActive_X(), gsPlay.getMaGrille().whoIsActive_Y(), keyValue);
            // Active le bouton de validation si le jeu est terminé.
            if (gsPlay.isGameOver()) {
                gsPlay.getBoutonValider().setEnabled(true);
            }
        }
    }

    /**
     * Gère les événements lorsque la touche est relâchée.
     * @param e L'événement de la touche relâchée.
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Gère les événements lorsque la touche est tapée.
     * @param e L'événement de la touche tapée.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // Non utilisé
    }
}
