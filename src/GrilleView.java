import javax.swing.*;
import java.awt.*;

public class GrilleView extends JPanel {
    private final Font BUTTON_FONT = new Font("Copperplate", Font.BOLD, 24);
    private final String[] BUTTON_TEXTS = {"Retour au menu principal"};
    private final Dimension BUTTON_SIZE = new Dimension(450, 60);
    private Grille grille;
    private Window window;
    private JTextField[][] cases;

    public GrilleView(Grille grille, Window window) {
        super();
        this.grille = grille;
        this.window = window;
        initialize();
    }

    private void initialize() {
        // Définir le style de fond similaire à HomeView
        this.setBackground(new Color(54, 91, 109));

        // Définir le gestionnaire de disposition et créer le tableau de cases
        this.setLayout(new BorderLayout());
        JPanel grillePanel = new JPanel(new GridLayout(9, 9));
        grillePanel.setBackground(new Color(54, 91, 109));
        this.add(grillePanel, BorderLayout.CENTER);

        this.cases = new JTextField[9][9];

        // Créer les cases et les ajoutez à la grille
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int valeur = this.grille.getValeur(row, col);
                JTextField caseField = new JTextField(1);
                if (valeur != 0) {
                    caseField.setText(Integer.toString(valeur));
                }
                caseField.setHorizontalAlignment(JTextField.CENTER);
                caseField.setEditable(false);
                this.cases[row][col] = caseField;
                grillePanel.add(caseField);
            }
        }

        // Ajouter un bouton "Retour au menu principal" en bas
        Button retourButton = new Button(BUTTON_TEXTS[0], BUTTON_SIZE, BUTTON_FONT);
        retourButton.addActionListener(new GrilleButtonClickListener(window));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(54, 91, 109));
        buttonPanel.add(retourButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addComponentsToWindow() {
        window.getContentPane().add(this);
        window.setPageTitle("Grille");
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    // Method to remove all components from the window
    public void removeAllComponents(Window window) {
        window.remove(this);
        window.revalidate();
        window.repaint();
    }
}
