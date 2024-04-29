import javax.swing.JOptionPane;

/**
 * RulesDialogManager gère l'affichage de la boîte de dialogue des règles.
 * Cette classe implémente DialogManager pour définir la méthode showDialog.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class RulesDialogManager implements DialogManager {
    /**
     * Affiche la boîte de dialogue des règles du Sudoku.
     */
    @Override
    public void showDialog() {
        RulesSudoku rulesPanel = new RulesSudoku(); // Création du panneau contenant les règles
        JOptionPane.showMessageDialog(null, rulesPanel, "Règles du Sudoku", JOptionPane.PLAIN_MESSAGE); // Affichage de la boîte de dialogue
    }
}

