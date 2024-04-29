import javax.swing.JOptionPane;

/**
 * Cette classe permet de crée une boîte de dialogue de félicitations pour afficher le temps de résolution d'un Sudoku.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class CongratulationsDialog extends JOptionPane {

    /**
     * Constructeur de la classe CongratulationsDialog.
     * @param solvingStartTime Le temps de démarrage de la résolution du Sudoku en nanosecondes.
     */
    public CongratulationsDialog(long solvingStartTime) {
        super();

        // Obtenir le temps actuel en nanosecondes
        long currentTime = System.nanoTime();

        // Calculer le temps de résolution en secondes
        long solvingTime = (currentTime - solvingStartTime) / 1_000_000_000;

        // Créer le message de félicitations en fonction du temps de résolution
        String message;
        long minutes = solvingTime / 60;
        long seconds = solvingTime % 60;

        // Gérer le pluriel pour les minutes
        String minutesString = (minutes <= 1) ? " minute" : " minutes";

        // Gérer le pluriel pour les secondes
        String secondsString = (seconds <= 1) ? " seconde" : " secondes";

        message = "Félicitations ! Vous avez résolu le Sudoku en " + minutes + minutesString + " et " + seconds + secondsString + ".";
        
        showMessageDialog(null, message, "Félicitations !", JOptionPane.PLAIN_MESSAGE);
    }
}
