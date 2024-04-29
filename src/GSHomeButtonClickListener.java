import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener pour les clics sur les boutons dans le menu.
 * Il effectue différentes actions en fonction du bouton cliqué.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
class GSHomeButtonClickListener implements ActionListener {
    private Window window;
    private DialogManager rulesDialogManager;
    private GSMenu menuJeu;

    /**
     * Construit un ButtonClickListener avec la fenêtre spécifiée.
     * @param window La fenêtre où les actions seront effectuées.
     */
    public GSHomeButtonClickListener(Window window) {
        this.window = window;
        this.rulesDialogManager = new RulesDialogManager();
    }

    /**
     * Effectue une action en fonction du bouton cliqué.
     * @param e L'ActionEvent représentant le clic sur le bouton.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = ((Button) e.getSource()).getText();
        switch (buttonText) {
            case "Jouer":
                Window.removeAllComponents(this.window);
                this.menuJeu = new GSMenu(this.window);
                GSMenuController menuController = new GSMenuController(this.menuJeu, this.window);
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
