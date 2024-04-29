import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GSCase extends JPanel {
    private int primaryValue;
    private int secondaryValue = 0;
    private int tertiaryValue = 0;
    private int quaternaryValue = 0;

    private String text = "";
    protected boolean isInitial = false;
    protected boolean isActive;
    private JLabel label = new JLabel();
    private byte digitCount = 0;
    protected int positionX;
    protected int positionY;
    protected GSGrid parentGrid;
    private GSCaseMouseListener mouseListener; // Instance de la classe qui gère les événements de souris

    public GSCase(GSGrid grid, int x, int y) {
        this.positionX = x;
        this.positionY = y;

        this.primaryValue = 0;

        this.setBackground(Color.white);

        this.parentGrid = grid;
        this.add(label);
        layoutSetup();

        // Initialisation de l'écouteur de souris
        this.mouseListener = new GSCaseMouseListener(this);
        this.addMouseListener(this.mouseListener);
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