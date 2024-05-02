import java.awt.event.*;

/**
 * La classe GMHowToCreateController est un contrôleur qui gère l'affichage de la fenêtre de création de grille.
 * Elle implémente l'interface ActionListener pour réagir aux événements de clic sur un bouton.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GMHowToCreateController implements ActionListener {
    /**
     * Le gestionnaire de dialogue pour la création de grille.
     */
    private GMHowToCreateDialogManager howToCreateGrid;

    /**
     * Constructeur pour créer une instance de GMHowToCreateController.
     * Initialise le gestionnaire de dialogue pour la création de grille.
     */
    public GMHowToCreateController(){
        this.howToCreateGrid = new GMHowToCreateDialogManager();
    }

    /**
     * Méthode invoquée lorsqu'un événement d'action est déclenché, comme un clic sur un bouton.
     * Affiche la fenêtre de dialogue pour expliquer comment créer une grille.
     * @param e L'événement d'action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        howToCreateGrid.showDialog(); // On appelle la méthode qui affiche la fenêtre de dialogue
    }
}
