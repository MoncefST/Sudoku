import javax.swing.*;
import java.awt.*;

/**
 * A menu view for a Sudoku application.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */

public class MenuView extends JFrame {
    private String scheminIconAudio = new String("../img/iconeAudio.png");
    private String scheminIconAudioMuted = new String("../img/iconeAudioMuted.png");
    private String scheminMusique = new String("../audio/musiqueDeFond.wav"); 
    private ImageIcon iconAudio = new ImageIcon(scheminIconAudio);
    private ImageIcon iconAudioMuted = new ImageIcon(scheminIconAudioMuted);
    private ImageIcon imageSudoku = new ImageIcon("../img/sudoku.png");                                // Image Sudoku
    private Dimension tailleFenetre = new Dimension(1000,700);                                         // Taille de la fenêtre
    private Dimension tailleBouton = new Dimension(300, 60);                                           // Taille des boutons
    private Color couleurFond = new Color(54, 91, 109);                                                // Couleur du fond de la fenêtre
    private Color couleurTexteTitre = Color.WHITE;                                                     // Couleur du texte du titre et sous-titre
    private Font policeTitre = new Font("Copperplate", Font.BOLD, 75);                                 // Police du titre
    private Font policeSousTitre = new Font("Copperplate", Font.PLAIN, 24);                            // Police du sous-titre
    private Font policeBouton = new Font("Copperplate", Font.BOLD, 24);                                // Police des boutons
    private String[] boutonTextes = {"Jouer", "Générer une grille", "Résoudre une grille", "Quitter"}; // Textes des boutons
    private JLabel[] labels = {new JLabel("Sudoku Solver", SwingConstants.CENTER),                     // Texte du titre
                               new JLabel("Par Moncef & Marco", SwingConstants.CENTER)};               // Texte du sous-titre   


             
    /**
    * Constructs a MenuView.
    * Initializes and configures the menu window with buttons and controls.
    */
    public MenuView() {
        // Création et configuration de la fenêtre
        JFrame fenetre = new JFrame("Sudoku - Menu principal");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setMinimumSize(tailleFenetre);
        fenetre.getContentPane().setBackground(couleurFond);
        BorderLayout gestionnaireBorderLayout = new BorderLayout();
        fenetre.setLayout(gestionnaireBorderLayout);

        // Création et ajout du panneau de titre
        JPanel panneauTitre = new JPanel(new GridLayout(2, 1));
        panneauTitre.setBackground(couleurFond);

        Font[] fonts = {policeTitre, policeSousTitre};
        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(fonts[i]);
            labels[i].setForeground(couleurTexteTitre);
            panneauTitre.add(labels[i]);
        }
        fenetre.add(panneauTitre, BorderLayout.NORTH);

        // Création et ajout du panneau de boutons
        JPanel panneauBouton = new JPanel();
        GridLayout gestionnairePanneauBouton = new GridLayout(boutonTextes.length, 1, 0, 10);
        panneauBouton.setLayout(gestionnairePanneauBouton);
        panneauBouton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panneauBouton.setBackground(couleurFond);
        Button[] boutons = new Button[boutonTextes.length];
        for (int i = 0; i < boutons.length; i++) {
            boutons[i] = new Button(boutonTextes[i], tailleBouton, policeBouton, couleurFond);
            panneauBouton.add(boutons[i]);
        }
        fenetre.add(panneauBouton, BorderLayout.WEST);

        // Ajout de l'image "sudoku.png"
        JLabel imageLabel = new JLabel(imageSudoku);
        fenetre.add(imageLabel, BorderLayout.EAST);

        // Ajout du bouton de contrôle de la musique
        MusicButton musicButton = new MusicButton(scheminIconAudio, scheminIconAudioMuted, scheminMusique);
        FlowLayout gestionnaireControlPanel = new FlowLayout(FlowLayout.RIGHT);
        JPanel controlPanel = new JPanel(gestionnaireControlPanel);
        controlPanel.setBackground(couleurFond);
        controlPanel.add(musicButton);
        fenetre.add(controlPanel, BorderLayout.SOUTH);

        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }
}