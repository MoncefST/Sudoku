import javax.swing.JOptionPane;

/**
 * La classe GridMakerHowToCreateDialogManager est un gestionnaire de dialogue qui affiche des instructions
 * sur la manière de créer une grille dans une boîte de dialogue.
 * Elle implémente l'interface DialogManager.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GridMakerHowToCreateDialogManager implements DialogManager {

    /**
     * Méthode pour afficher la boîte de dialogue avec les instructions de création de grille.
     */
    @Override
    public void showDialog() {
        GridMakerHowToCreateView howToCreateGrid = new GridMakerHowToCreateView();
        JOptionPane.showMessageDialog(null, howToCreateGrid, "Comment créer une grille ?", JOptionPane.PLAIN_MESSAGE);
    }
}
