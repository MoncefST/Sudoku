import javax.swing.*;
import java.awt.*;

/**
 * La classe GSSolver résout une grille de Sudoku et affiche le résultat dans une fenêtre.
 * @version 1.O
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GSSolver {
    /**
     * Grille de Sudoku à résoudre
     */
    private GSGrid grid;

    /**
     * Fenêtre dans laquelle afficher la résolution
     */
    private Window window;

    /**
     * Étiquette pour afficher le statut de la résolution
     */
    private JLabel label = new JLabel("Resolution en cours...");

    /**
     * Temps de début de la résolution
     */
    private long startTime;

    /**
     * Constructeur de la classe GSSolver.
     * @param grid La grille de Sudoku à résoudre.
     * @param window La fenêtre dans laquelle afficher la résolution.
     */
    public GSSolver(GSGrid grid, Window window) {
        this.grid = grid;
        this.window = window;
        Window.removeAllComponents(this.window); // Efface tous les composants de la fenêtre
        this.window.setPageTitle("Résolution automatique");
        this.startSolving(); // Démarre la résolution
    }

    /**
     * Démarre le processus de résolution de la grille de Sudoku.
     */
    private void startSolving() {
        startTime = System.nanoTime(); // Enregistre le temps de début de la résolution
        BorderLayout layout = new BorderLayout(); // Gestionnaire de mise en page pour la fenêtre
        window.setLayout(layout); // Définit le gestionnaire de mise en page pour la fenêtre
        window.getContentPane().add(label, BorderLayout.SOUTH); // Ajoute l'étiquette au bas de la fenêtre
        window.getContentPane().add(grid, BorderLayout.CENTER); // Ajoute la grille au centre de la fenêtre
        grid.solve(); // Résout la grille de Sudoku

        // Vérifie si le jeu est terminé
        if (isGameOver()) {
            double time = (double) (System.nanoTime() - startTime) / 1_000_000_000; // Calcule le temps écoulé en secondes
            label.setText("Résolu en " + time + " secondes."); // Met à jour le texte de l'étiquette avec le temps écoulé
            label.setForeground(Color.WHITE); // Définit la couleur du texte sur blanc
        }
    }

    /**
     * Vérifie si le jeu est terminé.
     * @return true si le jeu est terminé, false sinon.
     */
    private boolean isGameOver() {
        return !grid.isComplete(); // Vérifie si la grille est complète
    }
}
