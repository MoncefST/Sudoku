import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

// CODE TEMPORAIRE
// A AMÉLIORER FORTEMENT !!!!!!


/**
 * Classe pour gérer les opérations de sauvegarde et de chargement de grille.
 * @author Moncef STITI
 * @author Marco ORFAO
 * @version 1.0
 */
public class FileManager {

    /**
     * Méthode pour sauvegarder une grille dans un fichier.
     * @param grille La grille à sauvegarder
     */
    public static void sauvegarderGrille(Grille grille) {
        // Création d'un sélecteur de fichier
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Enregistrer la grille");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Fichiers de grille (.gri)", "gri"));
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Obtention du nom de fichier choisi par l'utilisateur
            String nomFichier = fileChooser.getSelectedFile().getAbsolutePath();
            // Vérification et ajout de l'extension .gri si nécessaire
            if (!nomFichier.endsWith(".gri")) {
                nomFichier += ".gri";
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))) {
                // Écriture des valeurs de la grille dans le fichier
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        int valeur = grille.getValeur(i, j);
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
            String nomFichier = fileChooser.getSelectedFile().getAbsolutePath();
            try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
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
