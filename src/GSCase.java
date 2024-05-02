import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * GSCase représente une case dans une grille de jeu.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GSCase extends JPanel {
    private int primaryValue; // Valeur principale de la case
    private int secondaryValue = 0; // Deuxième valeur de la case (optionnelle)
    private int tertiaryValue = 0; // Troisième valeur de la case (optionnelle)
    private int quaternaryValue = 0; // Quatrième valeur de la case (optionnelle)

    private String text = ""; // Texte affiché dans la case
    protected boolean isInitial = false; // Indique si la valeur de la case est initiale
    protected boolean isActive = true; // Indique si la case est active
    private JLabel label = new JLabel(); // Étiquette pour afficher le texte
    private byte digitCount = 0; // Compteur du nombre de valeurs insérées dans la case
    protected int positionX; // Position X de la case dans la grille
    protected int positionY; // Position Y de la case dans la grille
    protected GSGrid parentGrid; // Grille parente de la case
    private GSCaseMouseListener mouseListener; // Écouteur pour les événements de souris

    /**
     * Constructeur de la classe GSCase.
     * @param grid La grille parente de la case.
     * @param x La position X de la case dans la grille.
     * @param y La position Y de la case dans la grille.
     */
    public GSCase(GSGrid grid, int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.primaryValue = 0; // Valeur par défaut
        this.setBackground(Color.white); // Couleur de fond par défaut
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
        Font font = label.getFont();
        label.setFont(font.deriveFont(font.getSize() + 15f));

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
                        this.text = String.valueOf(this.primaryValue + " " + this.secondaryValue);
                    } else if (this.digitCount == 2 && value != this.primaryValue && value != this.secondaryValue) {
                        this.tertiaryValue = value;
                        this.digitCount++;
                        this.text = String.valueOf(this.primaryValue + " " + this.secondaryValue + " " + this.tertiaryValue);
                    } else if (this.digitCount == 3 && value != this.primaryValue && value != this.secondaryValue && value != this.tertiaryValue) {
                        this.quaternaryValue = value;
                        this.digitCount++;
                        this.text = String.valueOf(this.primaryValue + " " + this.secondaryValue + " " + this.tertiaryValue + " " + this.quaternaryValue);
                    }
                }
                this.setBackground(Color.PINK);
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
