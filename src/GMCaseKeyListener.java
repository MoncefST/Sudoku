import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 * GMCaseKeyListener est un KeyListener utilisé pour écouter les événements de touche dans GMCase.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GMCaseKeyListener implements KeyListener {
    /**
     * Le vérificateur de grille pour vérifier si les règles du Sudoku sont respectées.
     */
    private GMChecker checker;

    /**
     * La case GMCase à écouter.
     */
    private GMCase gridMakerCase;

    /**
     * La grille GMGrid à laquelle la case appartient.
     */
    private GMGrid grille;

    /**
     * L'indice de ligne de la case dans la grille.
     */
    private int row;

    /**
     * L'indice de colonne de la case dans la grille.
     */
    private int col;

    /**
     * Constructeur de GridMakerCaseListener.
     * @param gridMakerCase La case à écouter.
     * @param grille La grille à laquelle la case appartient.
     * @param row L'indice de ligne de la case.
     * @param col L'indice de colonne de la case.
     */
    public GMCaseKeyListener(GMCase gridMakerCase,GMGrid grille, int row, int col) {
        this.gridMakerCase = gridMakerCase;
        this.grille = grille;
        this.row = row;
        this.col = col;
        this.checker = new GMChecker(this.grille);
    }

    /**
     * Méthode appelée lorsqu'une touche est enfoncée.
     * Si la touche est un chiffre, met à jour la valeur de la case avec ce chiffre.
     * @param e L'événement KeyEvent généré lorsque la touche est enfoncée.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
        // Vérifier si la touche enfoncée est un chiffre entre 1 et 9
        if (Character.isDigit(keyChar) && keyChar >= '0' && keyChar <= '9') {
            int value = Character.getNumericValue(keyChar);
            // Sauvegarder temporairement la valeur actuelle de la case
            int previousValue = gridMakerCase.getCellValue();
            // Mettre temporairement la nouvelle valeur dans la case
            gridMakerCase.setCellValue(value);
            // Vérifier si la grille respecte les règles du Sudoku
            if (checker.checkGrid()) {
                // Si oui, pas besoin de faire autre chose car la valeur est déjà mise à jour
            } else {
                // Si non, restaurer la valeur précédente et afficher un message d'erreur
                gridMakerCase.setCellValue(previousValue);
                JOptionPane.showMessageDialog(null, "La valeur ne respecte pas les règles du Sudoku.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else if (!e.isShiftDown()){
            // Afficher un message d'erreur si la touche enfoncée n'est pas valide
            JOptionPane.showMessageDialog(null, "Veuillez entrer un chiffre entre 1 et 9.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Méthode appelée lorsqu'une touche est relâchée.
     * Aucun traitement n'est nécessaire dans ce cas.
     * @param e L'événement KeyEvent généré lorsque la touche est relâchée.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        // Pas de traitement nécessaire
    }

    /**
     * Méthode appelée lorsqu'une touche est tapée (enfoncée puis relâchée).
     * Aucun traitement n'est nécessaire dans ce cas.
     * @param e L'événement KeyEvent généré lorsque la touche est tapée.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // Pas de traitement nécessaire
    }
}
