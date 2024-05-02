import javax.swing.*;
import java.awt.*;

/**
 * RulesSudoku représente le panneau affichant les règles du Sudoku.
 * Cette classe étend JPanel et définit le contenu des règles.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class RulesSudoku extends JPanel {
    /**
     * Taille de la fenêtre des règles
     */
    private Dimension FRAME_SIZE = new Dimension(400, 500);
    /**
     * Couleur d'arrière-plan du panneau
     */
    private Color BACKGROUND_COLOR = new Color(54, 91, 109); 

    /**
     * Constructeur par défaut de RulesSudoku.
     * Initialise le contenu des règles et configure l'apparence du panneau.
     */
    public RulesSudoku() {
        BorderLayout gestionnaireBorderLayout = new BorderLayout();
        this.setLayout(gestionnaireBorderLayout);
        this.setBackground(this.BACKGROUND_COLOR); // Couleur d'arrière-plan du panneau

        Title titleLabel = new Title("Règles du Sudoku",new Font("Copperplate", Font.BOLD, 40),Color.WHITE);

        JTextArea rulesTextArea = new JTextArea();
        rulesTextArea.setText("Les règles du Sudoku :\n\n" +
                "1. Le but du jeu est de remplir la grille avec une série de chiffres de 1 à 9 de telle sorte que chaque ligne, chaque colonne et chaque région de 3x3 contienne tous les chiffres de 1 à 9 sans répétition.\n\n" +
                "2. Certains chiffres sont déjà placés dans la grille au départ et ne peuvent pas être modifiés.\n\n" +
                "3. Utilisez la logique et le raisonnement pour remplir la grille avec les chiffres manquants.\n\n" +
                "4. Le jeu est terminé lorsqu'il n'y a plus de cases vides et que toutes les règles sont respectées.");
        rulesTextArea.setEditable(false);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setWrapStyleWord(true);
        rulesTextArea.setFont(new Font("Arial", Font.PLAIN, 20)); // Police du texte des règles
        rulesTextArea.setForeground(Color.WHITE); // Couleur du texte des règles
        rulesTextArea.setBackground(this.BACKGROUND_COLOR); // Couleur d'arrière-plan du texte des règles

        JScrollPane scrollPane = new JScrollPane(rulesTextArea);

        this.add(titleLabel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        this.setPreferredSize(this.FRAME_SIZE); // Taille de la fenêtre des règles
    }
}

