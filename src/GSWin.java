/**
 * La classe GSWin gère l'affichage d'une fenêtre de félicitations pour avoir résolu le Sudoku.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GSWin implements DialogManager {

    private long solvingTime; // Temps de résolution du Sudoku

    /**
     * Constructeur de la classe GSWin.
     * @param solvingTime Le temps de résolution du Sudoku.
     */
    public GSWin(long solvingTime) {
        this.solvingTime = solvingTime;
    }

    /**
     * Affiche la fenêtre de félicitations pour avoir résolu le Sudoku.
     */
    @Override
    public void showDialog() {
        // Créer et afficher une nouvelle fenêtre de félicitations
        CongratulationsDialog congratsWindow = new CongratulationsDialog(solvingTime);
    }
}
