import javax.swing.*;
import java.awt.*;

/**
 * La classe GMHowToCreateView est une vue qui affiche les instructions pour créer une grille dans une boîte de dialogue.
 * Elle hérite de JPanel pour servir de composant d'interface utilisateur.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GMHowToCreateView extends JPanel {
    /**
     * La taille de la fenêtre de la boîte de dialogue.
     */
    private Dimension FRAME_SIZE = new Dimension(600, 500);

    /**
     * La couleur de fond de la boîte de dialogue.
     */
    private Color BACKGROUND_COLOR = new Color(54, 91, 109);

    /**
     * Le titre affiché dans la boîte de dialogue.
     */
    private String TITLE = "Comment créer une grille";

    /**
     * La couleur du titre affiché dans la boîte de dialogue.
     */
    private Color TITLE_COLOR = new Color(255, 255, 255);

    /**
     * La police du titre affiché dans la boîte de dialogue.
     */
    private Font TITLE_FONT = new Font("Copperplate", Font.BOLD, 40);

    /**
     * Le texte des instructions affiché dans la boîte de dialogue.
     */
    private String TEXT = "1. Cliquez sur le menu 'Fichier'.\n" +
                          "2. Sélectionnez l'option 'Nouveau'.\n" +
                          "3. Entrez les valeurs pour chaque cellule de la grille. (Entrez 0 si vous souhaitez supprimer une valeur de la grille)\n" +
                          "4. Cliquez sur 'Sauvegarder' pour enregistrer votre grille.\n\n" +
                          "Vous pouvez également charger une grille existante en sélectionnant 'Charger' depuis le menu 'Fichier'.";

    /**
     * La couleur du texte des instructions affiché dans la boîte de dialogue.
     */
    private Color TEXT_COLOR = new Color(255, 255, 255);

    /**
     * La police du texte des instructions affiché dans la boîte de dialogue.
     */
    private Font TEXT_FONT = new Font("Arial", Font.PLAIN, 20);

    /**
     * Constructeur pour créer une instance de GMHowToCreateView.
     * Initialise les composants de la vue et les dispose selon un BorderLayout.
     */
    public GMHowToCreateView() {
        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        this.setBackground(this.BACKGROUND_COLOR); // Définit la couleur d'arrière-plan du panneau

        JLabel titleLabel = new JLabel(this.TITLE);
        titleLabel.setFont(this.TITLE_FONT); // Définit la police du titre
        titleLabel.setForeground(this.TITLE_COLOR); // Définit la couleur du titre

        JTextArea textArea = new JTextArea();
        textArea.setText(this.TEXT);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(this.TEXT_FONT); // Définit la police du texte
        textArea.setForeground(this.TEXT_COLOR); // Définit la couleur du texte
        textArea.setBackground(this.BACKGROUND_COLOR); // Définit la couleur d'arrière-plan du texte

        JScrollPane scrollPane = new JScrollPane(textArea);

        this.add(titleLabel, BorderLayout.NORTH); // Ajoute le titre en haut du panneau
        this.add(scrollPane, BorderLayout.CENTER); // Ajoute le texte avec barre de défilement au centre du panneau

        this.setPreferredSize(this.FRAME_SIZE); // Définit la taille préférée du panneau
    }
}
