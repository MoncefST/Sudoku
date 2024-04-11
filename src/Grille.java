public class Grille {
    private int[][] grille;

    public Grille() {
        grille = new int[9][9];
        // Initialiser la grille avec des zéros pour représenter des cases vides
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grille[i][j] = 0;
            }
        }
    }

    public boolean est_valide(int row, int col, int num) {
        // Vérifier si le nombre est présent dans la même ligne ou colonne
        for (int i = 0; i < 9; i++) {
            if (grille[row][i] == num || grille[i][col] == num) {
                return false;
            }
        }

        // Vérifier si le nombre est présent dans le carré 3x3
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grille[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public void remplir_case(int row, int col, int num) {
        grille[row][col] = num;
    }

    public boolean case_vide(int row, int col) {
        return grille[row][col] == 0;
    }

    public void vider_case(int row, int col) {
        grille[row][col] = 0;
    }

    public int getValeur(int row, int col) {
        return grille[row][col];
    }
}

