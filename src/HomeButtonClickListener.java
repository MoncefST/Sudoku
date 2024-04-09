import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;


/**
 * Listener for button clicks in the menu.
 * It performs different actions based on the button clicked.
 */
class HomeButtonClickListener implements ActionListener {
    private Window window;
    private DialogManager rulesDialogManager;
    private DialogManager howToPlayDialogManager;

    /**
     * Constructs a ButtonClickListener with the specified window.
     * @param window The window where the actions will be performed.
     */
    public HomeButtonClickListener(Window window) {
        this.window = window;
        this.rulesDialogManager = new RulesDialogManager();
        this.howToPlayDialogManager = new HowToPlayDialogManager();
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
                // à faire
                break;
            case "Règles":
                rulesDialogManager.showDialog(); 
                break;
            case "Comment jouer ?":
                howToPlayDialogManager.showDialog(); 
                break;
            case "Quitter":
                System.exit(0); // Quitter le programme
                break;
            default:
                break;
        }
    }
}
