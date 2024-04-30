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
     * Constructeur par défaut de GMCase.
     * Initialise le bouton avec les propriétés nécessaires, crée un GMCaseListener et l'ajoute au bouton.
     */
    public GMCase() {
        actionButton.setOpaque(false);
        actionButton.setContentAreaFilled(false);
        actionButton.setBorderPainted(false);
        actionButton.setPreferredSize(new Dimension(50, 50));

        BorderLayout gestionnaire = new BorderLayout();
        setLayout(gestionnaire);
        add(actionButton, BorderLayout.CENTER);

        setPreferredSize(new Dimension(60, 60));

        // Crée un GMCaseListener et l'ajoute au bouton
        GMCaseKeyListener listener = new GMCaseKeyListener(this);
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
