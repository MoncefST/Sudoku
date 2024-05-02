public class GridMaker{
    public static void main(String[] args) {
        Window fenetre = new Window(); // Création d'une fenêtre
        String[] gmButtonTexts = {"Générer une grille", "Règles", "Quitter"}; // Texte des boutons pour le menu du GridMaker
        HomeView gmHomeView = new HomeView(fenetre, "Sudoku Grid Creator", "Par Moncef & Marco", gmButtonTexts);
    }
}