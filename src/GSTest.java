/**
 * La classe GSTest contient les méthodes pour tester la validité d'une grille de Sudoku.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GSTest {
    /**
     * La grille
     */
    private GSGrid ma_Grille;

  /**
   * Constructeur de la classe GSTest.
   * @param Grid La grille de Sudoku à tester.
   */
  public GSTest(GSGrid Grid) {
    this.ma_Grille = Grid;
  }

  /**
   * Vérifie s'il y a des doublons dans la grille de Sudoku.
   * @return true s'il y a des doublons, false sinon.
   */
  public boolean test() {
    // Vérification colonne
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            for (int i_prime = i + 1; i_prime < 9; i_prime++) {
                if (this.ma_Grille.getCellValue(i, j) == this.ma_Grille.getCellValue(i_prime, j) && this.ma_Grille.getCellValue(i, j) != 0) {
                    return true;
                }
            }
        }
    }

    // Vérification ligne
    for (int j = 0; j < 9; j++) {
        for (int i = 0; i < 9; i++) {
            for (int j_prime = j + 1; j_prime < 9; j_prime++) {
                if (this.ma_Grille.getCellValue(i, j) == this.ma_Grille.getCellValue(i, j_prime) && this.ma_Grille.getCellValue(i, j) != 0) {
                    return true;
                }
            }
        }
    }

    // Vérification région
    for (int i = 0; i < 9; i += 3) {
        for (int j = 0; j < 9; j += 3) {
            if (verificationRegion(i, j)) {
                return true;
            }
        }
    }
    return false; // Aucun doublon trouvé dans la grille
  }

  /**
   * Vérifie s'il y a des doublons dans une région spécifique de la grille.
   * @param x L'indice x du coin supérieur gauche de la région.
   * @param y L'indice y du coin supérieur gauche de la région.
   * @return true s'il y a des doublons, false sinon.
   */
  public boolean verificationRegion(int x, int y) {
    final int REGION_SIZE = 3; // Taille de chaque région (3x3)

    // Calcul des coordonnées du coin supérieur gauche de la région spécifiée
    int regionX = (x / REGION_SIZE) * REGION_SIZE;
    int regionY = (y / REGION_SIZE) * REGION_SIZE;

    // Tableau pour suivre les valeurs déjà vues dans la région (de 1 à 9)
    boolean[] seen = new boolean[10];

    // Parcours de chaque cellule de la région spécifiée
    for (int i = 0; i < REGION_SIZE; i++) {
        for (int j = 0; j < REGION_SIZE; j++) {
            // Obtention de la valeur de la cellule
            int value = this.ma_Grille.getCellValue(regionX + i, regionY + j);
            // Vérification si la valeur est différente de zéro (cellule remplie)
            if (value != 0) {
                // Si la valeur a déjà été vue dans la région, il y a un doublon
                if (seen[value]) {
                    return true; // Valeur en double trouvée
                }
                seen[value] = true; // Marquage de la valeur comme vue
            }
        }
    }
    return false; // Aucune valeur en double trouvée dans la région
  }

  /**
   * Vérifie s'il y a des doublons dans une ligne spécifique de la grille.
   * @param x L'indice de la ligne à vérifier.
   * @return true s'il y a des doublons, false sinon.
   */
  public boolean verificationLigne(int x) {
    int i = x;

    for (int j = 0; j < 8; j++) { // Parcours des colonnes jusqu'à l'avant-dernière colonne
        for (int j_prime = j + 1; j_prime < 9; j_prime++) { // Parcours des colonnes suivantes
            // Comparaison des valeurs des cellules
            if (ma_Grille.getCellValue(i, j) == ma_Grille.getCellValue(i, j_prime) && ma_Grille.getCellValue(i, j) != 0) {
                return true; // Doublon trouvé, on peut retourner true directement
            }
        }
    }
    return false; // Aucun doublon trouvé dans la ligne
  }

  /**
   * Vérifie s'il y a des doublons dans une colonne spécifique de la grille.
   * @param y L'indice de la colonne à vérifier.
   * @return true s'il y a des doublons, false sinon.
   */
  public boolean verificationColonne(int y) {
    int j = y;
    for (int i = 0; i < 8; i++) { // Parcours des lignes jusqu'à l'avant-dernière ligne
        for (int i_prime = i + 1; i_prime < 9; i_prime++) { // Parcours des lignes suivantes
            // Comparaison des valeurs des cellules
            if (ma_Grille.getCellValue(i, j) == ma_Grille.getCellValue(i_prime, j) && ma_Grille.getCellValue(i, j) != 0) {
                return true; // Doublon trouvé, on peut retourner true directement
            }
        }
    }
    return false; // Aucun doublon trouvé dans la colonne
  }

  /**
   * Vérifie si une cellule spécifique de la grille est valide.
   * @param row L'indice de la ligne de la cellule.
   * @param column L'indice de la colonne de la cellule.
   * @return true si la cellule est valide, false sinon.
   */
  public Boolean isValid(int row, int column){
    return (!verificationLigne(row) && !verificationColonne(column) && !verificationRegion(row, column));
  }
}
