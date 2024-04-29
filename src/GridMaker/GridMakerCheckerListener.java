import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe GridMakerCheckerListener est utilisée pour gérer les événements liés à la vérification de la grille.
 */
public class GridMakerCheckerListener implements ActionListener {

    private GridMakerChecker gridMakerChecker;

    /**
     * Constructeur de GridMakerCheckerListener.
     * @param gridMakerChecker L'instance de GridMakerChecker à utiliser.
     */
    public GridMakerCheckerListener(GridMakerChecker gridMakerChecker) {
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
