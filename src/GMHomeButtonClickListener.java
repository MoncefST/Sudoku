import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for button clicks in the menu.
 * It performs different actions based on the button clicked.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
class GMHomeButtonClickListener implements ActionListener {
    private Window window;
    private DialogManager rulesDialogManager;

    /**
     * Constructs a ButtonClickListener with the specified window.
     * @param window The window where the actions will be performed.
     */
    public GMHomeButtonClickListener(Window window) {
        this.window = window;
        this.rulesDialogManager = new RulesDialogManager();
    }

    /**
     * Performs an action based on the button clicked.
     * @param e The ActionEvent representing the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = ((Button) e.getSource()).getText();
        switch (buttonText) {
            case "Générer une grille":
                Window.removeAllComponents(this.window);
                GMUserInterfaceView vueCreationGrille = new GMUserInterfaceView(this.window); // Lancer le créateur de grille 
                break;
            case "Règles":
                rulesDialogManager.showDialog(); // Afficher les règles
                break;
            case "Quitter":
                System.exit(0); // Quitter le programme
                break;
            default:
                break;
        }
    }
}
