import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GMSaverActionListener est un ActionListener utilisé pour écouter les événements de clic sur le bouton de sauvegarde.
 * Lorsque l'événement se produit, il crée une instance de GMSaver et appelle la méthode saveGridIfNeeded().
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GMSaverActionListener implements ActionListener {
    /**
     * Fenêtre parente
     */
    private Window parentFrame;

    /**
     * Grille à sauvegarder
     */
    private GMGrid grid;

    /**
     * Constructeur de GMSaverActionListener.
     * @param parentFrame La fenêtre parente.
     * @param grid La grille à sauvegarder.
     */
    public GMSaverActionListener(Window parentFrame, GMGrid grid) {
        this.parentFrame = parentFrame;
        this.grid = grid;
    }

    /**
     * Méthode appelée lorsqu'un événement de clic se produit.
     * Crée une instance de GMSaver et appelle la méthode saveGridIfNeeded().
     * @param e L'événement d'action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        GMSaver gMSaver = new GMSaver(parentFrame, grid);
        gMSaver.saveGridIfPossible();
    }
}
