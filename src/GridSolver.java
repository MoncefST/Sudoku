public class GridSolver{
    public static void main(String[] args) {
        Window fenetre = new Window(); // Création d'une fenêtre
        String[] gsButtonTexts = {"Jouer", "Règles", "Quitter"}; // Texte des boutons pour le menu du GridSolver
        HomeView gsHomeView = new HomeView(fenetre, "Sudoku Game", "Par Moncef & Marco", gsButtonTexts);
    }
}