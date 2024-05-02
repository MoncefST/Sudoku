import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * GMCaseMouseListener est un écouteur de souris pour les cases de la grille
 * @version 1.O
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GMCaseMouseListener extends MouseAdapter {
    /**
     * Variable statique pour stocker la dernière case activée
     */
    private static GMCase lastActiveCase;

    /**
     * Constructeur par défaut de GMCaseMouseListener.
     */
    public GMCaseMouseListener() {
        // Ce constructeur est laissé vide intentionnellement
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        // Vérifie si la source de l'événement est un JButton
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            // Vérifie si le bouton est contenu dans une instance de GMCase
            if (button.getParent() instanceof GMCase) {
                GMCase gmCase = (GMCase) button.getParent();
                // Si la dernière case activée est différente de la case actuelle
                if (lastActiveCase != null && lastActiveCase != gmCase) {
                    lastActiveCase.setActive(false); // Désactiver la dernière case activée
                }
                // Activer la case actuelle
                gmCase.setActive(true);
                // Mettre à jour la référence de la dernière case activée
                lastActiveCase = gmCase;
            }
        }
    }
}
