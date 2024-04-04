import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    // Attributs
    private Dimension tailleBouton = new Dimension(300, 60);                                           // Taille des boutons
    private Color couleurFond = new Color(54, 91, 109);                                                // Couleur du fond de la fenêtre
    private Color couleurTexteTitre = Color.WHITE;                                                     // Couleur du texte du titre et sous-titre
    private int tailleTitre = 75;                                                                      // Taille du texte du titre
    private int tailleSousTitre = 24;                                                                  // Taille du texte du sous-titre
    private int tailleTexteBouton = 24;                                                                // Taille du texte des boutons
    private Dimension tailleFenetre = new Dimension(1000,700);                                         // Taille de la fenêtre
    private Font policeTitre = new Font("Copperplate", Font.BOLD, tailleTitre);                        // Police du titre
    private Font policeSousTitre = new Font("Copperplate", Font.PLAIN, tailleSousTitre);               // Police du sous-titre
    private Font policeBouton = new Font("Copperplate", Font.BOLD, tailleTexteBouton);                 // Police des boutons
    private String[] boutonTextes = {"Jouer", "Générer une grille", "Résoudre une grille", "Quitter"}; // Textes des boutons
    private JLabel[] labels = {new JLabel("Sudoku Solver", SwingConstants.CENTER),                     // Texte du titre et sous-titre
                               new JLabel("Par Moncef & Marco", SwingConstants.CENTER)};               

    // Constructeurs 
    public Menu() {
        // Création et configuration de la fenêtre (taille, fermeture)
        JFrame fenetre = new JFrame("Sudoku - Menu principal");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setMinimumSize(tailleFenetre);
        fenetre.getContentPane().setBackground(couleurFond);
        fenetre.setLayout(new BorderLayout());

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
        panneauBouton.setLayout(new GridLayout(boutonTextes.length, 1, 0, 10));
        panneauBouton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Permet de ne pas coller les boutons aux bords de la fenêtre
        panneauBouton.setBackground(couleurFond);
        JButton[] boutons = new JButton[boutonTextes.length];
        for (int i = 0; i < boutons.length; i++) {
            boutons[i] = new JButton(boutonTextes[i]);
            boutons[i].setFont(policeBouton);
            boutons[i].setPreferredSize(tailleBouton);
            panneauBouton.add(boutons[i]);
        }
        fenetre.add(panneauBouton, BorderLayout.WEST);

        // Ajout de l'image "sudoku.png"
        ImageIcon imageSudoku = new ImageIcon("../img/sudoku.png");
        JLabel imageLabel = new JLabel(imageSudoku);
        fenetre.add(imageLabel, BorderLayout.EAST);

        fenetre.pack();
        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);
    }
    
    /* À SUPPRIMER APRÈS LA PHASE DE DEBUG
    public static void main(String[] args) {
        Menu menu = new Menu();
    }
    */
    
}
