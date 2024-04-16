import javax.swing.*;
import java.awt.*;

/**
 * La classe GridMakerHowToCreateView est une vue qui affiche les instructions pour créer une grille dans une boîte de dialogue.
 * Elle hérite de JPanel pour servir de composant d'interface utilisateur.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GridMakerHowToCreateView extends JPanel {
    private Dimension FRAME_SIZE = new Dimension(600, 500);
    private Color BACKGROUND_COLOR = new Color(54, 91, 109);

    private String TITLE = "Comment créer une grille";
    private Color TITLE_COLOR = new Color(255, 255, 255);
    private Font TITLE_FONT = new Font("Copperplate", Font.BOLD, 40);

    private String TEXT = "Comment créer une grille :\n\n 1. EXPLICATION \n\n 2. EXPLICATION\n\n 3. EXPLICATION.\n\n 4. EXPLICATION";
    private Color TEXT_COLOR = new Color(255, 255, 255);
    private Font TEXT_FONT = new Font("Arial", Font.PLAIN, 20);

    /**
     * Constructeur pour créer une instance de GridMakerHowToCreateView.
     * Initialise les composants de la vue et les dispose selon un BorderLayout.
     */
    public GridMakerHowToCreateView() {
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
