import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GridMakerCaseListener est un KeyListener utilisé pour écouter les événements de touche dans GridMakerCase.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GridMakerCaseListener implements KeyListener {

    private GridMakerCase gridMakerCase;

    /**
     * Constructeur de GridMakerCaseListener.
     * @param gridMakerCase La case à écouter.
     */
    public GridMakerCaseListener(GridMakerCase gridMakerCase) {
        this.gridMakerCase = gridMakerCase;
    }

    /**
     * Méthode appelée lorsqu'une touche est enfoncée.
     * Si la touche est un chiffre, met à jour la valeur de la case avec ce chiffre.
     * @param e L'événement KeyEvent généré lorsque la touche est enfoncée.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyChar = e.getKeyChar();
        if (Character.isDigit(keyChar)) {
            int num = Character.getNumericValue(keyChar);
            if (num >= 0 && num <= 9) {
                gridMakerCase.setCellValue(num);
            }
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
