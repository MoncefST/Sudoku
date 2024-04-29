import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe GSCaseMouseListener implémente l'interface MouseListener
 * pour gérer les événements de la souris sur un GSCase.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GSCaseMouseListener implements MouseListener {
    private GSCase casePanel;

    /**
     * Constructeur prenant un GSCase en paramètre.
     * @param casePanel Le GSCase à associer à cet écouteur.
     */
    public GSCaseMouseListener(GSCase casePanel) {
        this.casePanel = casePanel;
    }

    /**
     * Gère l'événement de clic de la souris.
     * Active le GSCase et effectue des actions associées.
     * @param e L'événement MouseEvent associé au clic.
     */
    public void mouseClicked(MouseEvent e) {
        if (!casePanel.isInitial) {
            casePanel.isActive = true;
            casePanel.setBackground(Color.GREEN);
            casePanel.parentGrid.testActivity(casePanel.positionX, casePanel.positionY);
        }
    }

    /**
     * Gère l'événement de pression de la souris.
     * (Non utilisé dans cette implémentation)
     * @param e L'événement MouseEvent associé à la pression.
     */
    public void mousePressed(MouseEvent e) {}

    /**
     * Gère l'événement de relâchement de la souris.
     * (Non utilisé dans cette implémentation)
     * @param e L'événement MouseEvent associé au relâchement.
     */
    public void mouseReleased(MouseEvent e) {}

    /**
     * Gère l'événement de survol de la souris.
     * Change la couleur du GSCase lors du survol.
     * @param e L'événement MouseEvent associé au survol.
     */
    public void mouseEntered(MouseEvent e) {
        if (!casePanel.isInitial) {
            if (!casePanel.isActive) {
                casePanel.setBackground(Color.yellow);
            }
        }
    }

    /**
     * Gère l'événement de sortie de la souris.
     * Rétablit la couleur du GSCase lors de la sortie.
     * @param e L'événement MouseEvent associé à la sortie.
     */
    public void mouseExited(MouseEvent e) {
        if (!casePanel.isInitial) {
            if (!casePanel.isActive) {
                casePanel.setBackground(Color.white);
            }
        }
    }
}
