import javax.swing.*;
import java.awt.*;

/**
 * Title est une étiquette Swing personnalisée utilisée pour afficher un titre centré avec une police et une couleur spécifiées.
 * Cette classe étend JLabel.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class Title extends JLabel {

    /**
     * Constructeur de Title.
     * Crée une étiquette avec le texte, la police et la couleur spécifiés, et la centre horizontalement.
     * @param text Le texte à afficher.
     * @param font La police à utiliser pour le texte.
     * @param color La couleur du texte.
     */
    public Title(String text, Font font, Color color) {
        super(text, SwingConstants.CENTER); // Centre le texte horizontalement
        setFont(font); // Définit la police du texte
        setForeground(color); // Définit la couleur du texte
    }
}

