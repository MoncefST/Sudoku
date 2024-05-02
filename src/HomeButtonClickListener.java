import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener pour les clics sur les boutons dans le menu.
 * Il effectue différentes actions en fonction du bouton cliqué.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
    public class HomeButtonClickListener implements ActionListener {
        /**
         * La fenêtre
         */
        private Window window;

        /**
         * Construit un ButtonClickListener avec la fenêtre spécifiée.
         * @param window La fenêtre où les actions seront effectuées.
         */
        public HomeButtonClickListener(Window window) {
            this.window = window;
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
                    GSMenu menuJeu = new GSMenu(this.window);
                    GSMenuController menuController = new GSMenuController(menuJeu, this.window);
                    break;
                case "Générer une grille":
                    Window.removeAllComponents(this.window);
                    GMUserInterfaceView vueCreationGrille = new GMUserInterfaceView(this.window);
                    break;
                case "Règles":
                    DialogManager rulesDialogManager = new RulesDialogManager();
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