import java.awt.*;
import javax.swing.*;

/**
 * GMCase représente une case dans une grille éditable.
 * Cette classe étend JPanel et utilise un GMCaseListener pour gérer les événements de touche.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GMCase extends JPanel {
    /**
     * Valeur actuelle de la case
     */
    private int cellValue = 0;
    /**
     * Texte à afficher dans la case
     */
    private String displayText = ""; 
    /**
     * Bouton pour afficher le texte
     */
    private JButton actionButton = new JButton(displayText);
    /**
     * Statut de la case
     */
    protected boolean isActive = false;

    /**
     * Ligne
     */
    private int row;

    /**
     * Colonne
     */
    private int col;

    /**
     * Grille
     */
    private GMGrid grille;

    /**
     * Constructeur de GMCase.
     * Initialise le bouton avec les propriétés nécessaires, crée un GMCaseListener et l'ajoute au bouton.
     * @param grille La grille à laquelle la case appartient.
     * @param row L'indice de ligne de la case.
     * @param col L'indice de colonne de la case.
     */
    public GMCase(GMGrid grille, int row, int col) {
        this.grille = grille;
        this.row = row;
        this.col = col;

        actionButton.setOpaque(false);
        actionButton.setContentAreaFilled(false);
        actionButton.setBorderPainted(false);
        actionButton.setPreferredSize(new Dimension(50, 50));
        Font buttonFont = actionButton.getFont();
        actionButton.setFont(new Font(buttonFont.getName(), Font.PLAIN, 60));

        BorderLayout gestionnaire = new BorderLayout();
        setLayout(gestionnaire);
        add(actionButton, BorderLayout.CENTER);

        setPreferredSize(new Dimension(60, 60));

        // Crée un GMCaseListener et l'ajoute au bouton
        GMCaseKeyListener listener = new GMCaseKeyListener(this,this.grille,this.row,this.col);
        actionButton.addKeyListener(listener);

        GMCaseMouseListener mouseListener = new GMCaseMouseListener();
        actionButton.addMouseListener(mouseListener);
    }

    /**
     * Met à jour l'affichage de la case avec la valeur actuelle.
     */
    public void updateDisplay() {
        actionButton.setText(displayText.isEmpty() ? "" : displayText);
        revalidate();
        repaint();
    }

    /**
     * Définit la valeur de la case et met à jour son affichage.
     * @param value La nouvelle valeur de la case.
     */
    public void setCellValue(int value) {
        this.cellValue = value;
        this.displayText = (value == 0) ? "" : String.valueOf(value); // Mettre à jour avec une chaîne vide si la valeur est 0
        updateDisplay();
    }

    /**
     * Récupère la valeur actuelle de la case.
     * @return La valeur actuelle de la case.
     */
    public int getCellValue() {
        return this.cellValue;
    }

    /**
     * Définit l'état d'activité de la case et met à jour son apparence en conséquence.
     * @param active true si la case doit être activée, false sinon.
     */
    public void setActive(boolean active) {
        this.isActive = active;
        if (isActive) {
            setBackground(Color.CYAN);
        } else {
            setBackground(Color.WHITE);
        }
        updateDisplay();
    }
}
