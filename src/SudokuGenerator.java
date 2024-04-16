import java.util.Random;

public class SudokuGenerator {
    private int nombreCasesVides = 40;
    private Grille grille;

    public SudokuGenerator(Grille grille) {
        this.grille = grille;
    }

    public Grille genererGrille() {
        remplirDiagonales(); // Remplir les diagonales pour assurer la validité initiale
        // Remplir le reste de la grille de manière récursive
        remplirGrille(0);
        // Supprimer certains nombres pour obtenir une grille incomplète mais résolva ble
        supprimerNombres();
        return grille;
    }

    private void supprimerNombres() {
        Random random = new Random();
        while (this.nombreCasesVides > 0) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if (grille.case_vide(row, col)) {
                continue; // La case est déjà vide, passer à la suivante
            }

            int temp = grille.getValue(row, col);
            grille.vider_case(row, col);
            // Vérifier s'il existe une seule solution après avoir vidé la case
            if (aUneSeuleSolution()) {
                // Il y a encore une solution, la suppression est sûre
                this.nombreCasesVides--;
            } else {
                // Il n'y a plus de solution, remettre le nombre dans la case
                grille.remplir_case(row, col, temp);
            }
        }
    }

    private boolean aUneSeuleSolution() {
        Grille grilleTemp = new Grille();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grilleTemp.remplir_case(i, j, grille.getValue(i, j));
            }
        }
        SudokuSolver solver = new SudokuSolver();
        return solver.resoudreSudoku(grilleTemp);
    }



    // Méthode de remplissage de la grille et remplissage des diagonales...
    private void remplirDiagonales() {
        for (int i = 0; i < 9; i += 3) {
            remplirCarre(i, i);
        }
    }

    private void remplirCarre(int row, int col) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num;
                do {
                    num = random.nextInt(9) + 1; // Générer un nombre aléatoire entre 1 et 9
                } while (!grille.est_valide(row + i, col + j, num)); // Vérifier la validité du nombre
                grille.remplir_case(row + i, col + j, num);
            }
        }
    }

    private boolean remplirGrille(int position) {
        if (position == 81) {
            return true; // La grille est remplie
        }

        int row = position / 9;
        int col = position % 9;

        if (grille.case_vide(row, col)) {
            for (int num = 1; num <= 9; num++) {
                if (grille.est_valide(row, col, num)) {
                    grille.remplir_case(row, col, num);

                    if (remplirGrille(position + 1)) {
                        return true;
                    }

                    grille.vider_case(row, col);
                }
            }
            return false;
        } else {
            return remplirGrille(position + 1);
        }
    }
}
