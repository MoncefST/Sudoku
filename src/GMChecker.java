import javax.swing.*;

/**
 * GMChecker est utilisée pour vérifier la cohérence de la grille.
 * Elle vérifie si les lignes, les colonnes et les régions de la grille respectent les règles du jeu.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GMChecker {
    /**
     * La grille
     */
    private GMGrid grid;

    /**
     * Constructeur pour créer une instance de GMChecker.
     * @param grid La grille à vérifier
     */
    public GMChecker(GMGrid grid) {
        this.grid = grid;
    }


    /**
     * Vérifie si la grille est correcte et envoie un message.
     * @return true si la grille est correcte, false sinon
     */
    public boolean checkGridMessage() {
        boolean isGridCorrect = checkGrid();
        if (isGridCorrect) {
            showMessage("Grille cohérente !", "Votre grille est cohérente. Aucune erreur n'a été trouvée. Vous pouvez maintenant sauvegarder votre grille !");
        } else {
            showMessage("Grille incorrecte !", "Deux mêmes chiffres sont présents dans la même ligne/colonne/région. Veuillez modifier votre grille !");
        }
        return isGridCorrect;
    }

    /**
     * Vérifie si la grille est correcte.
     * @return true si la grille est correcte, false sinon
     */
    public boolean checkGrid() {
        if (checkRows() || checkColumns() || checkRegions()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Affiche un message d'information.
     * @param title Le titre du message
     * @param message Le contenu du message
     */
    private void showMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Vérifie les lignes de la grille.
     * @return true si une ligne contient des doublons, false sinon
     */
    private boolean checkRows() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int j_prime = j + 1; j_prime < 9; j_prime++) {
                    if (grid.getCellValueAt(i, j) == grid.getCellValueAt(i, j_prime) && grid.getCellValueAt(i, j) != 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Vérifie les colonnes de la grille.
     * @return true si une colonne contient des doublons, false sinon
     */
    private boolean checkColumns() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int i_prime = i + 1; i_prime < 9; i_prime++) {
                    if (grid.getCellValueAt(i, j) == grid.getCellValueAt(i_prime, j) && grid.getCellValueAt(i, j) != 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Vérifie les régions de la grille.
     * @return true si une région contient des doublons, false sinon
     */
    private boolean checkRegions() {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (checkRegion(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Vérifie une région de la grille.
     * @param x La coordonnée x de la région
     * @param y La coordonnée y de la région
     * @return true si la région contient des doublons, false sinon
     */
    private boolean checkRegion(int x, int y) {
        int[] regionValues = new int[9];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                regionValues[index++] = grid.getCellValueAt(x + i, y + j);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (regionValues[i] == regionValues[j] && regionValues[i] != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Vérifie si la grille est correcte.
     * @return true si la grille est correcte, false sinon
     */
    public boolean isCorrect() {
        return checkGrid();
    }
}
