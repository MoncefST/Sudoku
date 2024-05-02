import javax.swing.*;
import java.awt.*;

/**
 * La classe GSMenu représente le menu jouer du jeu Sudoku.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GSMenu {
    /**
     * Fenêtre dans laquelle le menu est affiché
     */
    private Window window; 

    /**
     * Panneau pour le titre
     */
    private JPanel titlePanel;

    /**
     * Panneau pour les boutons
     */
    private JPanel buttonPanel;

    /**
     * Étiquette pour le titre
     */
    private Title titleLabel;

    /**
     * Bouton pour importer une grille
     */
    private Button importerButton;

    /**
     * Bouton pour commencer à jouer
     */
    private Button jouerButton;

    /**
     * Bouton pour résoudre automatiquement la grille
     */
    private Button autoSolveButton;

    /**
     * Constructeur de la classe GSMenu.
     * @param window La fenêtre dans laquelle afficher le menu.
     */
    public GSMenu(Window window) {
        this.window = window;
        this.window.setLayout(new BorderLayout());

        // Initialisation du panneau de titre
        this.titlePanel = new JPanel();
        this.titlePanel.setBackground(new Color(54, 91, 109));
        this.titlePanel.setLayout(new GridLayout(2, 1));

        // Création des étiquettes de titre et sous-titre
        this.titleLabel = new Title("Jouer", new Font("Copperplate", Font.BOLD, 45), Color.WHITE);

        // Ajout des étiquettes au panneau de titre
        this.titlePanel.add(this.titleLabel);

        // Initialisation du panneau de boutons
        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new GridLayout(1, 3, 10, 0));
        this.buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.buttonPanel.setBackground(new Color(54, 91, 109));

        // Création des boutons
        this.importerButton = new Button("Charger une grille",Color.white);
        this.jouerButton = new Button("Jouer",Color.white);
        this.jouerButton.setEnabled(false); // Le bouton "Jouer" est désactivé par défaut
        this.autoSolveButton = new Button("Résolution automatique",Color.white);
        this.autoSolveButton.setEnabled(false); // Le bouton "Résolution automatique" est désactivé par défaut

        // Ajout des boutons au panneau de boutons
        this.buttonPanel.add(this.importerButton);
        this.buttonPanel.add(this.jouerButton);
        this.buttonPanel.add(this.autoSolveButton);

        // Ajout des panneaux à la fenêtre
        this.window.add(this.titlePanel, BorderLayout.NORTH);
        this.window.add(this.buttonPanel, BorderLayout.CENTER);

        // Définition du titre de la page
        this.window.setPageTitle("Menu jouer");

        // Ajustement de la taille de la fenêtre en fonction de son contenu
        this.window.pack();
    }

    /**
     * Active les options de jeu dans le menu.
     */
    public void enablePlayOptions() {
        this.jouerButton.setEnabled(true); // Active le bouton "Jouer"
        this.autoSolveButton.setEnabled(true); // Active le bouton "Résolution automatique"
    }

    /**
     * Renvoie le bouton pour l'importation.
     * @return Le bouton pour l'importation.
     */
    public Button getImporterButton() {
        return this.importerButton;
    }

    /**
     * Renvoie le bouton pour démarrer le jeu.
     * @return Le bouton pour démarrer le jeu.
     */
    public Button getJouerButton() {
        return this.jouerButton;
    }
    
    /**
     * Renvoie le bouton pour résoudre automatiquement la grille.
     * @return Le bouton pour résoudre automatiquement la grille.
     */
    public Button getAutoSolveButton() {
        return this.autoSolveButton;
    }
}
