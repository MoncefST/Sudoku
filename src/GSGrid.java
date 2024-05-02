import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

/**
 * Cette classe représente la grille de jeu pour le Sudoku.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GSGrid extends JLabel {

    /**
     * Taille de la grille de Sudoku.
     */
    private static final int GRID_SIZE = 9;

    /**
     * Tableau représentant les données de la grille de Sudoku.
     */
    private int[][] tableauGrille = new int[GRID_SIZE][GRID_SIZE];

    /**
     * Tableau bidimensionnel de cases représentant la grille de Sudoku.
     */
    private GSCase[][] cases = new GSCase[GRID_SIZE][GRID_SIZE];

    /**
     * Menu associé à la grille de Sudoku.
     */
    private GSMenu menu;

    /**
     * Coordonnée X de la case active.
     */
    private int activeX = 0;

    /**
     * Coordonnée Y de la case active.
     */
    private int activeY = 0;

    /**
     * Indique si le jeu est en cours.
     */
    private Boolean isPlaying;

    /**
     * Constructeur de la classe GSGrid.
     * @param menu Le menu associé à la grille.
     */
    public GSGrid(GSMenu menu) {
        this.menu = menu;
        initializeGrid();
    }

    /**
     * Initialise la grille avec des cases vides
     */
    private void initializeGrid() {
        FlowLayout gestionnaire = new FlowLayout();
        this.setLayout(gestionnaire);
        JPanel gridContainer = new JPanel();
        gridContainer.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        Dimension cellSize = new Dimension(91, 71);

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                cases[i][j] = new GSCase(this, i, j);
                setCellBorder(i, j);
                cases[i][j].setPreferredSize(cellSize);
                gridContainer.add(cases[i][j]);
            }
        }
        this.add(gridContainer);
    }

    /**
     * Détermine les bordures des cellules de la grille
     * @param i L'indice de la ligne
     * @param j L'indice de la colonne
     * @return la bordure de la grille
     */
    private Border determineBorder(int i, int j) {
        int top = (i == 0) ? 5 : 1; 
        int bottom = ((i + 1) % 3 == 0) ? 5 : 1; 
        int left = (j == 0) ? 5 : 1; 
        int right = ((j + 1) % 3 == 0) ? 5 : 1; 
        return BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK); 
    }

    /**
     * Applique les bordures aux cellules de la grille
     * @param i L'indice de la ligne.
     * @param j L'indice de la colonne.
     */
    private void setCellBorder(int i, int j) {
        cases[i][j].setBorder(determineBorder(i, j));
    }

    /**
     * Importe les données du Sudoku dans la grille.
     * @param go Tableau d'entiers représentant les données du Sudoku.
     */
    public void importGrid(int[] go){
        int i,j;
        int longueur;
        for (i = 0; i < 9 ;  i++) {
            longueur = String.valueOf(go[i]).length();

            for ( j = 0; j < 9 - longueur; j++) {
                this.tableauGrille[i][j] = 0;
                this.cases[i][j].setValue(this.tableauGrille[i][j]);
                this.cases[i][j].repaint();
            }
            int[] transfert = new int[longueur];
            String str = Integer.toString(go[i]);
            for ( j = 0; j < longueur; j++) {
                transfert[j] = (int) Character.getNumericValue(str.charAt(j));
            }
            int k = 0;
            for ( j = 9 - longueur; j < 9; j++) {
                this.tableauGrille[i][j] = transfert[k];
                k++;
                this.cases[i][j].setValue(this.tableauGrille[i][j]);
                this.cases[i][j].repaint();
            }
        }
        this.menu.enablePlayOptions();
    }

    /**
     * Récupère la valeur d'une case à une position spécifique dans la grille.
     * @param i L'indice de ligne de la case.
     * @param j L'indice de colonne de la case.
     * @return La valeur de la case à la position spécifiée.
     */
    public int getCellValue(int i, int j) {
        return cases[i][j].getValue();
    }

    /**
     * Désactive les cases autres que celle indiquée
     * @param x L'indice de ligne.
     * @param y L'indice de la colonne.
     */
    public void disableAllExcept(int x, int y){
        for (int i = 0 ; i < GRID_SIZE ; i++ ) {
            for (int j = 0 ; j < GRID_SIZE ; j++ ) {
                if (cases[i][j].getActivity() && (i != x || j != y)) {
                    activeX = x;
                    activeY = y;
                    cases[i][j].deactivateCell();
                }
            }
        }
    }

    /**
     *  Retourne l'index X de la case active
     * @return l'index X de la case active
     */
    public int whoIsActive_X() {
        return activeX;
    }

    /**
     * Retourne l'index Y de la case active
     * @return l'index Y de la case active
     */
    public int whoIsActive_Y() {
        return activeY;
    }

    /**
     * Met à jour la valeur d'une case dans la grille
     * @param x L'indice de la ligne.
     * @param y L'indice de la colonne.
     * @param val La nouvelle valeur à assigner.
     */
    public void setValuetoCase(int x, int y, int val) {
        if (cases[x][y].getActivity() && getMode()) {
            cases[x][y].updateValue(val);
        }
    }

    /**
     * Vérifie si la grille est complète
     * @return True si la grille est complète, false sinon.
     */
    public Boolean isComplete(){
        for (int i = 0 ; i < 9 ; i++ ) {
            for (int j = 0 ; j < 9 ; j++ ) {
                if (this.cases[i][j].getDigitCount() != 1 && this.cases[i][j].getValue() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Active ou désactive le mode de jeu
     * @param isPlayingOrNot Un booléen indiquant si le mode de jeu est activé ou désactivé.
     */
    public void isPlaying(Boolean isPlayingOrNot) {
        this.isPlaying = isPlayingOrNot;
    }

    /**
     * Retourne si le jeu est en cours ou non
     * @return si le jeu est en cours ou non
     */
    public Boolean getMode() {
        return this.isPlaying;
    }

    /**
     * Résout le Sudoku
     * @return true si le Sudoku est résolu avec succès, sinon false.
     */
    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (this.tableauGrille[row][column] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        this.tableauGrille[row][column] = k;
                        this.cases[row][column].insertValue(k);
                        GSTest _test = new GSTest(this);
                        if (_test.isValid(row, column) && solve()) {
                            return true;
                        }
                        this.tableauGrille[row][column] = 0;
                        this.cases[row][column].insertValue(0);
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
}
