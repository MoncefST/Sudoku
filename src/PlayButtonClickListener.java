import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class PlayButtonClickListener implements ActionListener {
    private Window window;

    public PlayButtonClickListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button sourceButton = (Button) e.getSource();
        String buttonText = sourceButton.getText();

        if (buttonText.equals("Jouer sans grille")) {
            Grille nouvelleGrille = new Grille();
            SudokuGenerator sudokuGenerator = new SudokuGenerator(nouvelleGrille,81); // 81 = générer une grille avec 81 espaces vides
            Grille grilleGeneree = sudokuGenerator.genererGrille(); // Générer la grille
            GrilleView grilleView1 = new GrilleView(grilleGeneree, window); // Créer la vue de la grille
            window.changeMenu(grilleView1);  // Modifier le menu pour afficher la grille générée
        }

        else if (buttonText.equals("Générer une grille")) {
            // Demander à l'utilisateur combien de cases vides ils souhaite sur sa grille
            String input = JOptionPane.showInputDialog(window, "Combien de cases vides voulez-vous sur la grille ?", "Nombre de cases vides", JOptionPane.QUESTION_MESSAGE);
    
            // Vérifier si l'utilisateur a annulé la saisie ou a fermé la fenêtre de dialogue
            if (input != null && !input.isEmpty()) {
                int nombreChiffres = Integer.parseInt(input);
        
                // Vérifier que le nombre est compris entre 0 et 81
                if (nombreChiffres >= 0 && nombreChiffres <= 81) {
                    Grille nouvelleGrille = new Grille();
                    SudokuGenerator sudokuGenerator = new SudokuGenerator(nouvelleGrille, nombreChiffres);
                    Grille grilleGeneree = sudokuGenerator.genererGrille(); // Générer la grille
            
                    // Créer la vue de la grille
                    GrilleView grilleView1 = new GrilleView(grilleGeneree, window);
            
                    // Modifier le menu pour afficher la grille générée
                    window.changeMenu(grilleView1);
                } else {
                    JOptionPane.showMessageDialog(window, "Veuillez saisir un nombre entre 0 et 81.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // L'utilisateur a annulé la saisie ou fermé la fenêtre de dialogue, traitement en conséquence
            }
        } else if (buttonText.equals("Charger une grille")) {
            Grille grille = FileManager.loadGrid();
            GrilleView grilleView = new GrilleView(grille, window);
            window.changeMenu(grilleView);

        } else if (buttonText.equals("Retour au menu principal")) {
            if (window.getContentPane().getComponent(0) instanceof PlayMenuView) {
                PlayMenuView playMenuView = (PlayMenuView) window.getContentPane().getComponent(0);
                playMenuView.removeAllComponents(window);
                HomeView homeView = new HomeView(window);
            }
        }
    }
}
