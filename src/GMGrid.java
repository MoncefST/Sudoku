import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.Border;

/**
 * GMGrid hérite de JPanel et représente une grille de Sudoku.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GMGrid extends JPanel {

    /**
     * Stocke les valeurs de chaque cellule dans la grille.
     */
    private int[][] gridValues = new int[9][9];

    /**
     * Représente les cellules individuelles dans la grille.
     */
    private GMCase[][] gridCases = new GMCase[9][9];

    /**
     * Stocke les valeurs de la grille dans un format exportable.
     */
    private int[] exportedGrid = new int[9];

    /**
     * Construit un nouvel objet GMGrid et initialise la grille.
     */
    public GMGrid() {
        setupGrid();
        setBackground(new Color(54, 91, 109)); // Changer la couleur de fond (les côtés de la grille)
    }

    /**
     * Met en place la disposition de la grille Sudoku.
     */
    private void setupGrid() {
        // Ajouter du remplissage autour du panneau
        setBorder(new EmptyBorder(15, 15, 15, 15)); // Ajuster les valeurs selon le remplissage désiré
        setLayout(new GridLayout(3, 3)); // Définir la disposition pour le panneau principal de la grille

        // Créer 9 zones de 3x3
        JPanel[][] zones = new JPanel[3][3];
        setLayout(new GridLayout(3, 3));

        // Créer des zones individuelles et les ajouter au panneau principal de la grille
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                zones[i][j] = new JPanel();
                zones[i][j].setLayout(new GridLayout(3, 3));
                add(zones[i][j]);
            }
        }

        // Créer et ajouter des cellules à chaque zone
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int zoneRow = i / 3;
                int zoneCol = j / 3;
                gridCases[i][j] = new GMCase(this,i,j);
                zones[zoneRow][zoneCol].add(gridCases[i][j]);
                gridCases[i][j].setBorder(determineBorder(i, j)); // Utiliser la fonction pour déterminer les bordures
                gridCases[i][j].setBackground(Color.WHITE);
            }
        }
    }

    /**
     * Détermine les bordures à appliquer à une cellule de la grille en fonction de ses coordonnées.
     * Les cellules des coins et des bords ont des bordures plus épaisses.
     * @param i L'indice de ligne de la cellule.
     * @param j L'indice de colonne de la cellule.
     * @return La bordure à appliquer à la cellule.
     */
    private Border determineBorder(int i, int j) {
        int top = (i == 0) ? 5 : 1; // Bordure supérieure plus épaisse pour la première ligne
        int bottom = ((i + 1) % 3 == 0) ? 5 : 1; // Bordure inférieure plus épaisse pour chaque troisième ligne
        int left = (j == 0) ? 5 : 1; // Bordure gauche plus épaisse pour la première colonne
        int right = ((j + 1) % 3 == 0) ? 5 : 1; // Bordure droite plus épaisse pour chaque troisième colonne
        return BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK); // Créer et retourner la bordure
    }
    
    /**
     * Importe des valeurs pour peupler la grille Sudoku.
     * @param values Un tableau d'entiers représentant les valeurs de la grille Sudoku.
     */
    public void importGrid(int[] values) {
        for (int i = 0; i < 9; i++) {
            int length = String.valueOf(values[i]).length();

            for (int j = 0; j < 9 - length; j++) {
                gridValues[i][j] = 0;
                gridCases[i][j].setCellValue(gridValues[i][j]);
            }

            String str = Integer.toString(values[i]);
            for (int j = 9 - length, k = 0; j < 9; j++, k++) {
                gridValues[i][j] = Character.getNumericValue(str.charAt(k));
                gridCases[i][j].setCellValue(gridValues[i][j]);
            }
        }
    }

    /**
     * Exporte les valeurs actuelles de la grille Sudoku.
     * @return Un tableau d'entiers représentant les valeurs actuelles de la grille Sudoku.
     */
    public int[] exportGrid() {
        for (int i = 0; i < 9; i++) {
            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < 9; j++) {
                temp.append(gridCases[i][j].getCellValue());
            }
            exportedGrid[i] = Integer.parseInt(temp.toString());
        }
        return exportedGrid;
    }

    /**
     * Récupère la valeur d'une cellule dans la grille Sudoku.
     * @param row L'indice de ligne de la cellule.
     * @param column L'indice de colonne de la cellule.
     * @return La valeur de la cellule aux indices de ligne et de colonne spécifiés.
     */
    public int getCellValueAt(int row, int column) {
        return gridCases[row][column].getCellValue();
    }
}
