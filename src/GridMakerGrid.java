import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;


/**
 * A custom JPanel class representing a Sudoku grid.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GridMakerGrid extends JPanel {

    private int[][] gridValues = new int[9][9]; // Stores the values of each cell in the grid
    private GridMakerCase[][] gridCases = new GridMakerCase[9][9]; // Represents the individual cells in the grid
    private int[] exportedGrid = new int[9]; // Stores the grid values in an exportable format

    /**
     * Constructs a new GridMakerGrid object and initializes the grid.
     */
    public GridMakerGrid() {
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
                gridCases[i][j] = new GridMakerCase();
                zones[zoneRow][zoneCol].add(gridCases[i][j]);

                // Add borders to cells based on their position in the grid
                if ((i + 1) % 3 == 0 && (j + 1) % 3 == 0) {
                    gridCases[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, Color.BLACK));
                } else if ((i + 1) % 3 == 0) {
                    gridCases[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, Color.BLACK));
                } else if ((j + 1) % 3 == 0) {
                    gridCases[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, Color.BLACK));
                } else {
                    gridCases[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                }
            }
        }
    }
    
    /**
     * Imports values to populate the Sudoku grid.
     *
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
