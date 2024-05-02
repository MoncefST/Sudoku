import java.awt.*;
import java.awt.event.*;

/**
 * Classe GSPlay pour jouer au Sudoku.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GSPlay {

    /**
     * Valeur représentant une case vide
     */
    private static final int EMPTY_VALUE = 0;
    
    /**
     * Codes des touches numériques du pavé numérique
     */
    private static final int[] NUM_KEYS = {KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD4, KeyEvent.VK_NUMPAD5,
            KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD7, KeyEvent.VK_NUMPAD8, KeyEvent.VK_NUMPAD9};
    
    /**
    * Codes des touches numériques du clavier
    */
    private static final int[] KEY_NUMBERS = {KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4, KeyEvent.VK_5,
            KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9};
    
    /**
     * Code de la touche de suppression
     */ 
    private static final int DELETE_KEY = KeyEvent.VK_BACK_SPACE;

    /**
     * Container pour le contenu de la fenêtre
     */
    private Container content;

    /**
     * Grille de Sudoku
     */
    private GSGrid ma_Grille;

    /**
     * Bouton "Valider" pour valider la grille
     */
    private Button boutonValider;

    /**
     * Temps de démarrage du jeu
     */
    private long startTime;

    /**
     * Temps écoulé depuis le démarrage du jeu
     */
    private long vraiTime;

    /**
     * Fenêtre de jeu
     */
    private Window gameplay;

    /**
     * Contrôleur pour gérer les événements de jeu
     */
    private GSPlayController gsPlayController;

    /**
     * Constructeur de la classe GSPlay.
     * @param grille La grille de Sudoku.
     * @param frame La fenêtre principale.
     */
    public GSPlay(Window window, GSGrid grille) {
        this.ma_Grille = grille;
        this.gameplay = window;
        this.gsPlayController = new GSPlayController(this);
        this.boutonValider = new Button("Valider",Color.lightGray);
    }

    /**
     * Méthode pour afficher la fenêtre de jeu.
     */
    public void showGame() {
        Window.removeAllComponents(this.gameplay);
        this.gameplay.setPageTitle("Jouer");
        this.startTime = System.nanoTime();
        content = this.gameplay.getContentPane();
        BorderLayout gestionnaireGameplay = new BorderLayout();
        this.gameplay.setLayout(gestionnaireGameplay);
        this.gameplay.setSize(650, 730);
        this.gameplay.setFocusable(true);
        this.gameplay.requestFocusInWindow();
        this.gameplay.addKeyListener(gsPlayController);
        this.boutonValider.setEnabled(false);
        this.vraiTime = System.nanoTime() - this.startTime;
        boutonValider.addActionListener(gsPlayController);
        this.gameplay.add(boutonValider, BorderLayout.SOUTH);
        content.add(this.ma_Grille, BorderLayout.CENTER);
    }

    /**
     * Méthode pour obtenir la valeur associée à une touche.
     * @param e L'événement KeyEvent associé à la touche.
     * @return La valeur correspondante à la touche ou -1 si aucune correspondance.
     */
    public int getKeyValue(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == DELETE_KEY) {
            return EMPTY_VALUE;
        }
        for (int i = 0; i < NUM_KEYS.length; i++) {
            if (keyCode == NUM_KEYS[i] || keyCode == KEY_NUMBERS[i]) {
                return i + 1;
            }
        }
        return -1;
    }

    /**
     * Méthode pour vérifier si le jeu est terminé.
     * @return true si le jeu est terminé, sinon false.
     */
    public Boolean isGameOver() {
        return !this.ma_Grille.isComplete();
    }

    /**
    * Méthode pour obtenir le bouton valider.
    * @return le bouton valider
    */
    public Button getBoutonValider() {
        return boutonValider;
    }

    /**
    * Méthode pour obtenir la grille jouer
    * @return la grille
    */
    public GSGrid getMaGrille() {
        return ma_Grille;
    }

    /**
    * Méthode pour obtenir le temps de démarrage du jeu.
    * @return Le temps de démarrage du jeu.
    */
    public long getStartTime() {
        return this.startTime;
    }
}
