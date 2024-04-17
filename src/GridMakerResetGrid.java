import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe GridMakerResetGrid sert à crée une nouvelle grille de 0.
 *
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */

public class GridMakerResetGrid implements ActionListener {

  /**
   * La grille à réinitialiser.
   */
  private GridMakerGrid myGrid;

  /**
   * Constructeur pour créer une instance de GridMakerResetGrid.
   * @param grid Grille à réinitialiser
   */
  public GridMakerResetGrid(GridMakerGrid grid) {
    this.myGrid = grid;
  }

  /**
   * Lance la réinitialisation de la grille lors du clic sur le bouton Reset.
   * @param e ActionEvent lié à la classe
   */
  @Override
  public void actionPerformed(ActionEvent e) { // TEMPORAIRE !! À MODIFIER DANS UN FICHIER SÉPARÉ
    ResetGrid();
  }

  /**
   * Cette méthode crée une grille vide.
   */
  public void ResetGrid() {
    int[] array = new int[9];

    for (int i = 0; i < 9 ; i++) {
      array[i] = 0;
    }

    this.myGrid.importGrid(array);
  }
}
