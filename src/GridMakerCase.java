import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GridMakerCase extends JPanel implements KeyListener {

    private int cellValue = 0;
    private String displayText = ""; // Case initialement vide
    private JButton actionButton = new JButton(displayText);

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

    @Override
    public void keyReleased(KeyEvent e) {
        // Pas de traitement nécessaire
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Pas de traitement nécessaire
    }

    public void updateDisplay() {
        actionButton.setText(displayText.isEmpty() ? "" : displayText);
        revalidate();
        repaint();
    }

    public void setCellValue(int value) {
        this.cellValue = value;
        this.displayText = (value == 0) ? "" : String.valueOf(value); // Mettre à jour avec une chaîne vide si la valeur est 0
        updateDisplay();
    }

    public int getCellValue() {
        return this.cellValue;
    }
}
