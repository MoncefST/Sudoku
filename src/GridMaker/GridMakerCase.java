import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * GridMakerCase représente une case dans une grille éditable.
 * Cette classe étend JPanel et implémente KeyListener pour permettre à l'utilisateur de saisir des valeurs dans la case.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GridMakerCase extends JPanel implements KeyListener {

    private int cellValue = 0; // Valeur actuelle de la case
    private String displayText = ""; // Texte à afficher dans la case
    private JButton actionButton = new JButton(displayText); // Bouton pour afficher le texte

    /**
     * Constructeur par défaut de GridMakerCase.
     * Initialise le bouton avec les propriétés nécessaires, ajoute un KeyListener et configure le layout.
     */
    public GridMakerCase() {
        actionButton.setOpaque(false);
        actionButton.setContentAreaFilled(false);
        actionButton.setBorderPainted(false);
        actionButton.setPreferredSize(new Dimension(50, 50));
        actionButton.addKeyListener(this); // Ajout du KeyListener au bouton

        BorderLayout gestionnaire = new BorderLayout();
        setLayout(gestionnaire);
        add(actionButton, BorderLayout.CENTER);

        setPreferredSize(new Dimension(60, 60));
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
                setCellValue(num);
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
}

