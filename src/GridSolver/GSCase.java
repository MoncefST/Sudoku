import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * La classe GSCase représente une case individuelle dans une grille de Sudoku.
 */
public class GSCase extends JPanel implements MouseListener{

  private int primaryValue; // Valeur principale de la case
  private int secondaryValue; // Deuxième valeur de la case (utilisée pour les cas spéciaux)
  private int tertiaryValue; // Troisième valeur de la case (utilisée pour les cas spéciaux)
  private int quaternaryValue; // Quatrième valeur de la case (utilisée pour les cas spéciaux)
  private String text = ""; // Texte affiché dans la case
  private Boolean isInitial = false; // Indique si la valeur de la case est initiale (fournie avec le puzzle)
  private Boolean isActive; // Indique si la case est active (sélectionnée par l'utilisateur)
  JLabel label = new JLabel(); // Composant pour afficher le texte dans la case
  private byte digitCount = 0; // Compte le nombre de valeurs insérées dans la case
  private int positionX; // Position X de la case dans la grille
  private int positionY; // Position Y de la case dans la grille
  private GSGrid parentGrid; // Référence à la grille parente

  /**
   * Constructeur de la classe GSCase.
   * @param grid La grille parente à laquelle cette case appartient.
   * @param x Position X de la case dans la grille.
   * @param y Position Y de la case dans la grille.
   */
  public GSCase(GSGrid grid, int x, int y) {
    this.positionX = x;
    this.positionY = y;
    
    this.primaryValue = 0;
    this.secondaryValue = 0;
    this.tertiaryValue = 0;
    this.quaternaryValue = 0;
    
    this.setBackground(Color.white);
    this.addMouseListener(this);
    this.parentGrid = grid;
    this.add(label);
    deactivateCell();
    layoutSetup();
  }

  /**
   * Configure l'apparence initiale de la case.
   */
  public void layoutSetup() {
    this.label.setText(this.primaryValue != 0 ? this.text : "");
    this.label.setVisible(true);
    this.repaint();
  }

  /**
   * Initialise la case avec une valeur initiale.
   */
  public void initializeCell() {
      label.setText(this.text); 
      this.setBackground(this.isInitial ? Color.lightGray : Color.white); 
      layoutSetup(); 
  }

  /**
   * Définit la valeur de la case.
   * @param value La valeur à définir pour la case.
   */
  public void setValue(int value) {
      this.isInitial = (value != 0); 
      this.text = (value != 0) ? String.valueOf(value) : ""; 
      this.primaryValue = value; 
      initializeCell(); 
  }

  /**
   * Obtient la valeur de la case.
   * @return La valeur de la case.
   */
  public int getValue(){
    return this.primaryValue;
  }

  /**
   * Gère les actions de clic de souris sur la case.
   */
  public void mouseClicked(MouseEvent e) {
    if (!this.isInitial) {
      this.isActive = true;
      this.setBackground(Color.GREEN);
      this.parentGrid.testActivity(this.positionX, this.positionY);
    }
  }

  // D'autres méthodes de l'interface MouseListener
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {
    if (!isInitial) {
      if (!isActive) {
        this.setBackground(Color.yellow);
      }
    }
  }

  public void mouseExited(MouseEvent e) {
    if (!isInitial) {
      if (!isActive) {
        this.setBackground(Color.white);
      }
    }
  }

  /**
   * Désactive la case.
   */
  public void deactivateCell(){
    this.isActive = false;
    this.setBackground(Color.white);
  }

  /**
   * Obtient l'état d'activité de la case.
   * @return True si la case est active, sinon False.
   */
  public Boolean getActivity(){
    return this.isActive;
  }

  /**
   * Met à jour la valeur de la case.
   * @param value La nouvelle valeur de la case.
   */
  public void updateValue(int value){
    if (value == 0) {
      this.primaryValue = 0;
      this.digitCount = 0;
      layoutSetup();
    } else {
      if (!checkInputValue(value)) {
        if (this.primaryValue != value ) {
            if (this.digitCount == 0) {
              this.digitCount++;
              this.primaryValue = value;
              this.text = String.valueOf(this.primaryValue);
            } else if (this.digitCount == 1 && value != this.primaryValue) {
              this.secondaryValue = value;
              this.digitCount++;
              this.text = String.valueOf(this.primaryValue + ", " + this.secondaryValue);
            } else if (this.digitCount == 2 && value != this.primaryValue && value != this.secondaryValue) {
              this.tertiaryValue = value;
              this.digitCount++;
              this.text = String.valueOf(this.primaryValue + ", " + this.secondaryValue + ", " + this.tertiaryValue);
            } else if (this.digitCount == 3 && value != this.primaryValue && value != this.secondaryValue && value != this.tertiaryValue) {
              this.quaternaryValue = value;
              this.digitCount++;
              this.text = String.valueOf(this.primaryValue + ", " + this.secondaryValue + ", " + this.tertiaryValue + ", " + this.quaternaryValue);
            }
        }
        this.setBackground(Color.WHITE);
        layoutSetup();
      } else if (checkInputValue(value)){
        this.setBackground(Color.RED);
      }
    }
  }

  /**
   * Vérifie si la valeur entrée est valide pour la case.
   * @param val La valeur à vérifier.
   * @return True si la valeur est valide, sinon False.
   */
  public Boolean checkInputValue(int val){
      int temp = this.primaryValue; 
      this.primaryValue = val; 
      GSTest test = new GSTest(this.parentGrid); 
      Boolean isValid = test.test(); 
      this.primaryValue = temp; 
      return isValid; 
  }

  /**
   * Obtient le nombre de valeurs insérées dans la case.
   * @return Le nombre de valeurs insérées.
   */
  public int getDigitCount(){
    return this.digitCount;
  }

  /**
   * Insère une valeur dans la case.
   * @param value La valeur à insérer.
   */
  public void insertValue(int value){
    this.primaryValue = value;
    this.text = String.valueOf(this.primaryValue);
    layoutSetup();
  }
  
}
