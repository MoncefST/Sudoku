import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class to manage grid saving and loading operations.
 * @author Moncef STITI
 * @author Marco ORFAO
 * @version 1.0
 */
public class FileManager {

    /**
     * Method to save a grid in a file.
     * @param grille The grid to save
     */
    public static void saveGrille(Grille grille) {
        // Creating a file selector
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Enregistrer la grille");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers de grille (.gri)", "gri"));
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Obtain user-selected file name
            String fileName = fileChooser.getSelectedFile().getAbsolutePath();
            // Check and add .gri extension if necessary
            if (!fileName.endsWith(".gri")) {
                fileName += ".gri";
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                // Writing grid values to file.
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        int valeur = grille.getValue(i, j);
                        writer.write(valeur == 0 ? "0" : String.valueOf(valeur));
                    }
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Méthode pour charger une grille à partir d'un fichier.
     * @return La grille chargée depuis le fichier
     */
    public static Grille chargerGrille() {
        // Création d'un sélecteur de fichier
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Charger une grille");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers de grille (.gri)", "gri"));
        int userSelection = fileChooser.showOpenDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Obtention du nom de fichier choisi par l'utilisateur
            String fileName = fileChooser.getSelectedFile().getAbsolutePath();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                Grille grille = new Grille();
                String ligne;
                int row = 0;
                // Lecture des lignes du fichier et remplissage de la grille
                while ((ligne = reader.readLine()) != null && row < 9) {
                    for (int col = 0; col < 9 && col < ligne.length(); col++) {
                        char caractere = ligne.charAt(col);
                        if (caractere != ' ') {
                            int valeur = Character.getNumericValue(caractere);
                            grille.remplir_case(row, col, valeur);
                        }
                    }
                    row++;
                }
                return grille;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
