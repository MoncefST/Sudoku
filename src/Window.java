import javax.swing.*;
import java.awt.*;

/**
 * Window est une classe représentant la fenêtre principale de l'application Sudoku.
 * Cette classe étend JFrame et gère l'affichage des différentes pages de l'application.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class Window extends JFrame {
    /**
     * La taille minimale de la fenêtre.
     */
    private static final Dimension MIN_WINDOW_SIZE = new Dimension(850, 700);
    /**
     * Le titre du programme.
     */
    private static final String PROGRAM_TITLE = "Sudoku";

    /**
     * La couleur d'arrière plan par défaut de la fenêtre
     */
    private static final Color BACKGROUND_COLOR = new Color(54, 91, 109);

    /**
     * Le titre de la page actuelle.
     */
    private String PAGE_TITLE = "";

    /**
     * Constructeur de la classe Window.
     * Initialise la fenêtre avec la taille minimale et la couleur de fond.
     */
    public Window() {
        super(PROGRAM_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(MIN_WINDOW_SIZE);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(BACKGROUND_COLOR);
    }

    /**
     * Définit le titre de la page actuelle.
     * Met à jour le titre de la fenêtre pour inclure le titre de la page et le titre du programme.
     * @param title Le titre de la page actuelle.
     */
    public void setPageTitle(String title) {
        this.PAGE_TITLE = title;
        this.setTitle(this.PAGE_TITLE + " - " + Window.PROGRAM_TITLE);
    }

    /**
     * Supprime tous les composants de la fenêtre.
     * Utilisé pour effacer le contenu de la fenêtre.
     * @param window La fenêtre à nettoyer.
     */
    public static void removeAllComponents(Window window) {
        window.getContentPane().removeAll(); // Supprime tous les composants de la fenêtre
        window.revalidate(); // Revalide la disposition des composants
        window.repaint(); // Redessine la fenêtre
    }
}
