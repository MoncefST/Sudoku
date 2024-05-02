import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

/**
 * La classe GSImport est utilisée pour importer une grille à partir d'un fichier.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GSImport {
  
  /**
   * Fenêtre précédente
   */
  private Window previousFrame;

  /**
   * Indique si le fichier est accessible
   */
  private boolean accessible;

  /**
   * Fichier sélectionné pour l'importation
   */
  private File file;

  /**
   * Tableau des valeurs importées
   */
  private int[] importedValues = new int[9];

  /**
   * Constructeur pour créer une instance de GridMakerImport.
   * @param frame La fenêtre précédente
   * @param sudokuGrid La grille Sudoku
   */
  public GSImport(Window frame) {
    this.previousFrame = frame;
  }

  /**
   * Affiche une boîte de dialogue de sélection de fichier et importe la grille à partir du fichier sélectionné.
   */
  public void importGrid() {
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Grid files (*.gri)", "gri");
    fileChooser.setFileFilter(filter);
    int returnVal = fileChooser.showOpenDialog(previousFrame);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      file = fileChooser.getSelectedFile();
      if (readFile()) {
        accessible = true;
      } else {
        accessible = false;
      }
    }
  }

  /**
   * Lit les données à partir du fichier sélectionné et les stocke dans un tableau.
   * @return true si la lecture est réussie, false sinon
   */
  public boolean readFile() {
    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      DataInputStream dataInputStream = new DataInputStream(fileInputStream);
      int incrementable = 0;
      while (dataInputStream.available() > 0 && incrementable < 9) {
        importedValues[incrementable] = dataInputStream.readInt();
        incrementable++;
      }
      dataInputStream.close();
      return true;
    } catch (FileNotFoundException e) {
      System.err.println("File not found.");
      return false;
    } catch (IOException e) {
      System.err.println("IOException.");
      return false;
    } catch (NumberFormatException e) {
      System.err.println("NumberFormatException.");
      return false;
    }
  }

  /**
  * Permet de savoir si le fichier est accessible
  * @return le booleen accessible
  */
  public boolean isAccessible() {
    return accessible;
  }

  /**
  * Récupère le tableau des valeurs importées.
  * @return le tableau des valeurs importées
  */
  public int[] getImportedValues() {
    return importedValues;
  }
}
