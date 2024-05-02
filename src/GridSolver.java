/**
 * Classe principale pour le GridSolver.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GridSolver {
    /**
     * Constructeur par défaut de la classe GridSolver.
     */
    public GridSolver() {
        // Ce constructeur est laissé vide intentionnellement
    }


    /**
     * Méthode principale pour démarrer le GridSolver.
     * @param args Les arguments de la ligne de commande (non utilisés dans cette application).
     */
    public static void main(String[] args) {
        Window fenetre = new Window(); // Création d'une fenêtre
        String[] gsButtonTexts = {"Jouer", "Règles", "Quitter"}; // Texte des boutons pour le menu du GridSolver
        HomeView gsHomeView = new HomeView(fenetre, "Sudoku Game", "Par Moncef & Marco", gsButtonTexts);
    }
}
