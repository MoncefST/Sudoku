/**
 * Classe pour résoudre un Sudoku.
 * @author Moncef STITI
 * @author Marco ORFAO
 * @version 1.0
 */
public class SudokuSolver {

    /**
     * Méthode pour résoudre un Sudoku en utilisant la récursivité.
     * @param grille La grille de Sudoku à résoudre
     * @return true si le Sudoku est résolu avec succès, false sinon
     */
    public boolean resoudreSudoku(Grille grille) {
        // Parcours de chaque case de la grille
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Vérification si la case est vide
                if (grille.case_vide(row, col)) {
                    // Essayer chaque chiffre de 1 à 9
                    for (int num = 1; num <= 9; num++) {
                        // Vérifier si le chiffre est valide dans cette case
                        if (grille.est_valide(row, col, num)) {
                            // Remplir la case avec le chiffre
                            grille.remplir_case(row, col, num);
                            // Appel récursif pour résoudre le reste du Sudoku
                            if (resoudreSudoku(grille)) {
                                return true; // Si le Sudoku est résolu, retourner true
                            }
                            // Si le Sudoku n'est pas résolu avec ce chiffre, vider la case et essayer un autre chiffre
                            grille.vider_case(row, col);
                        }
                    }
                    return false; // Si aucun chiffre ne convient, retourner false
                }
            }
        }
        return true; // Si toutes les cases sont remplies, le Sudoku est résolu
    }
}
