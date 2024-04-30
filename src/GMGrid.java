import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.Border;

/**
 * A custom JPanel class representing a Sudoku grid.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GMGrid extends JPanel {

    private int[][] gridValues = new int[9][9]; // Stores the values of each cell in the grid
    private GMCase[][] gridCases = new GMCase[9][9]; // Represents the individual cells in the grid
    private int[] exportedGrid = new int[9]; // Stores the grid values in an exportable format

    /**
     * Constructs a new GMGrid object and initializes the grid.
     */
    public GMGrid() {
        setupGrid();
        setBackground(new Color(54, 91, 109)); // On change la couleur de fond (les cotés de la grille)
    }

    /**
     * Sets up the layout of the Sudoku grid.
     */
    private void setupGrid() {
        // Add padding around the panel
        setBorder(new EmptyBorder(15, 15, 15, 15)); // Adjust the values as needed for desired padding

        setLayout(new GridLayout(3, 3)); // Set layout for the main grid panel

        // Create 9 zones of 3x3
        JPanel[][] zones = new JPanel[3][3];
        setLayout(new GridLayout(3, 3));

        // Create individual zones and add them to the main grid panel
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                zones[i][j] = new JPanel();
                zones[i][j].setLayout(new GridLayout(3, 3));
                add(zones[i][j]);
            }
        }

        // Create and add cells to each zone
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int zoneRow = i / 3;
                int zoneCol = j / 3;
                gridCases[i][j] = new GMCase(this,i,j);
                zones[zoneRow][zoneCol].add(gridCases[i][j]);
                gridCases[i][j].setBorder(determineBorder(i, j)); // Utilisation de la fonction pour définir les bordures
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
        return BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK); // Crée et retourne la bordure
    }
    
    /**
     * Imports values to populate the Sudoku grid.
     * @param values An array of integers representing the Sudoku grid values.
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
     * Exports the current Sudoku grid values.
     *
     * @return An array of integers representing the current Sudoku grid values.
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
     * Retrieves the value of a cell in the Sudoku grid.
     *
     * @param row The row index of the cell.
     * @param column The column index of the cell.
     * @return The value of the cell at the specified row and column indices.
     */
    public int getCellValueAt(int row, int column) {
        return gridCases[row][column].getCellValue();
    }
}