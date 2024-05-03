/**
 * Classe principale pour le GridMaker.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GridMaker {
    /**
     * Constructeur par défaut de la classe GridMaker.
     */
    public GridMaker() {
        // Ce constructeur est laissé vide intentionnellement
    }

    /**
     * Méthode principale pour démarrer le GridMaker.
     * @param args Les arguments de la ligne de commande (non utilisés dans cette application).
     */
    public static void main(String[] args) {
        Window fenetre = new Window(); // Création d'une fenêtre
        String[] gmButtonTexts = {"Créer une grille", "Règles", "Quitter"}; // Texte des boutons pour le menu du GridMaker
        HomeView gmHomeView = new HomeView(fenetre, "Sudoku Grid Creator", "Par Moncef & Marco", gmButtonTexts);
    }
}
