import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe GSMenuController gère les actions déclenchées par les boutons du menu.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GSMenuController implements ActionListener {
    /**
     * Menu Sudoku
     */
    private GSMenu gsMenu;

    /**
     * Fenêtre principale
     */
    private Window mainWindow;

    /**
     * Grille de Sudoku
     */
    private GSGrid sudokuGrid;

    /**
     * Constructeur de la classe GSMenuController.
     * @param gsMenu Le menu Sudoku à contrôler.
     * @param mainWindow La fenêtre principale.
     */
    public GSMenuController(GSMenu gsMenu, Window mainWindow) {
        this.gsMenu = gsMenu;
        this.mainWindow = mainWindow;
        this.sudokuGrid = new GSGrid(gsMenu); // Initialise la grille de Sudoku
        
        // Ajout de l'action listener pour les boutons du menu
        gsMenu.getImporterButton().addActionListener(this);
        gsMenu.getJouerButton().addActionListener(this);
        gsMenu.getAutoSolveButton().addActionListener(this);
    }

    /**
     * Méthode appelée lorsqu'une action est effectuée (clic sur un bouton).
     * @param e L'événement associé à l'action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Si le bouton "Importer" est cliqué
        if (e.getSource() == gsMenu.getImporterButton()) {
            GSImport importer = new GSImport(mainWindow); // Crée un gestionnaire d'importation de grille
            importer.importGrid(); // Importe une grille
            if (importer.isAccessible()) {
                sudokuGrid.importGrid(importer.getImportedValues()); // Met à jour la grille avec les valeurs importées
                // Réactive les options de jeu dans le menu
                gsMenu.enablePlayOptions();
                sudokuGrid.isPlaying(true); // Indique que le jeu est en cours
            }
        } 
        // Si le bouton "Jouer" est cliqué
        else if (e.getSource() == gsMenu.getJouerButton()) {
            GSPlay jeu = new GSPlay(this.mainWindow,this.sudokuGrid); // Crée un jeu Sudoku
            GSPlayController jeuController = new GSPlayController(jeu); // Crée un contrôleur pour le jeu
            gsMenu.getJouerButton().addKeyListener(jeuController); // Ajoute un écouteur de touches pour le jeu
            jeu.showGame(); // Affiche le jeu
        } 
        // Si le bouton "Résoudre automatiquement" est cliqué
        else if (e.getSource() == gsMenu.getAutoSolveButton()) {
            GSSolver resolveurDeGrille = new GSSolver(this.sudokuGrid,this.mainWindow); // Crée un résolveur de grille
        }
    }
}
