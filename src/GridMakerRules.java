import java.awt.event.*;

/**
 * GridMakerRules gère les actions liées aux règles du jeu.
 * Cette classe implémente ActionListener pour réagir aux clics sur un bouton.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GridMakerRules implements ActionListener {
    private RulesDialogManager rulesDialog; // Gestionnaire de la boîte de dialogue des règles

    /**
     * Constructeur de GridMakerRules.
     * Initialise le gestionnaire de boîte de dialogue des règles.
     */
    public GridMakerRules(){
        this.rulesDialog = new RulesDialogManager();
    }

    /**
     * Méthode appelée lorsqu'une action est effectuée, comme un clic sur un bouton.
     * Affiche la boîte de dialogue des règles.
     * @param e L'événement d'action qui a déclenché cette méthode.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        rulesDialog.showDialog(); // On appelle la méthode qui affiche la fenêtre de dialogue
    }
}

