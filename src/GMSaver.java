import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Cette classe implémente un gestionnaire d'enregistrement de grille de jeu.
 * Elle permet à l'utilisateur de sauvegarder une grille de jeu dans un fichier spécifié.
 * Les fichiers de grille sont sauvegardés avec l'extension ".gri".
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GMSaver {

    /**
     * Le fichier sélectionné pour sauvegarde
     */
    private File selectedFile;

    /**
     * La fenêtre parent
     */
    private JFrame parentFrame;

    /**
     * La grille de jeu à sauvegarder
     */
    private GMGrid grid;

    /**
     * Le testeur de grille
     */
    private GMChecker testGrille;

    /**
     * Constructeur de la classe GMSaver.
     * @param parentFrame La fenêtre parent.
     * @param grid La grille de jeu à sauvegarder.
     */
    public GMSaver(JFrame parentFrame, GMGrid grid) {
        this.parentFrame = parentFrame;
        this.grid = grid;
        this.testGrille = new GMChecker(this.grid);
    }

    /**
     * Vérifie si la grille est valide, puis la sauvegarde si possible.
     * Si la grille n'est pas valide, affiche un message d'erreur.
     */
    public void saveGridIfPossible() {
        if (isValidGrid()) {
            saveGrid();
        } else {
            JOptionPane.showMessageDialog(parentFrame, "Format de grille non valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Vérifie si la grille est valide en utilisant un test spécifique.
     * @return true si la grille est valide, sinon false.
     */
    private boolean isValidGrid() {
        return this.testGrille.isCorrect();
    }

    /**
     * Sauvegarde la grille de jeu dans un fichier spécifié par l'utilisateur.
     * Affiche un message de succès ou d'erreur selon le résultat de la sauvegarde.
     */
    private void saveGrid() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Enregistrer la grille");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichiers de grille (*.gri)", "gri");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile(); // on stock le fichier choisie au cas ou

            try (FileOutputStream fileOutputStream = new FileOutputStream(selectedFile);
                 DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {

                int[] gridData = grid.exportGrid();
                for (int i = 0; i < 9; i++) {
                    dataOutputStream.writeInt(gridData[i]);
                }

                JOptionPane.showMessageDialog(parentFrame, "Grille sauvegardée avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parentFrame, "Erreur lors de la sauvegarde de la grille : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
