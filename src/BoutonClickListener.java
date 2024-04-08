import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 * Listener for button clicks in the menu.
 * It performs different actions based on the button clicked.
 */
class ButtonClickListener implements ActionListener {
    private Window window;

    /**
     * Constructs a ButtonClickListener with the specified window.
     * @param window The window where the actions will be performed.
     */
    public ButtonClickListener(Window window) {
        this.window = window;
    }

    /**
     * Performs an action based on the button clicked.
     * @param e The ActionEvent representing the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = ((Button) e.getSource()).getText();
        switch (buttonText) {
            case "Jouer":
                System.out.println("JOUER"); // À SUPPRIMER APRÈS DEBUG
                break;
            case "Comment jouer ?":
                RulesDialogManager.showRulesDialog(); // Ouvre une fenêtre de dialogue avec les règles
                break;
            case "Paramètres":
                // Code pour les paramètres
                break;
            case "Quitter":
                System.exit(0); // Quitter le programme
                break;
            default:
                break;
        }
    }

}
