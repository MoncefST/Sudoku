import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe GMCheckerListener est utilisée pour gérer les événements liés à la vérification de la grille.
 */
public class GMCheckerListener implements ActionListener {

    private GMChecker gridMakerChecker;

    /**
     * Constructeur de GMCheckerListener.
     * @param gridMakerChecker L'instance de GMChecker à utiliser.
     */
    public GMCheckerListener(GMChecker gridMakerChecker) {
        this.gridMakerChecker = gridMakerChecker;
    }

    /**
     * Méthode invoquée lorsqu'un bouton est cliqué.
     * Lance la vérification de la grille.
     * @param e L'événement d'action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        gridMakerChecker.checkGrid();
    }
}
