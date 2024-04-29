import javax.swing.*;
import java.awt.*;

/**
 * HomeView représente la vue de la page d'accueil de l'application Sudoku.
 * Cette classe étend JPanel et affiche les éléments de la page d'accueil, y compris le titre, les boutons et les contrôles audio.
 * Elle utilise également les classes Title, Button, et MusicButton.
 *
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class GSHomeView extends JPanel {

    // Constantes pour les chemins des icônes et des fichiers audio, ainsi que pour les dimensions et les couleurs
    private final String AUDIO_ON = "img/iconeAudio.png";
    private final String AUDIO_OFF = "img/iconeAudioMuted.png";
    private final String MUSIC_FILE = "audio/musiqueDeFond.wav";
    private final Dimension BUTTON_SIZE = new Dimension(300, 60);
    private final Color BACKGROUND_COLOR = new Color(54, 91, 109);
    private final Color TITLE_TEXT_COLOR = Color.WHITE;
    private final Font TITLE_FONT = new Font("Copperplate", Font.BOLD, 75);
    private final Font SUBTITLE_FONT = new Font("Copperplate", Font.PLAIN, 24);
    private final Font BUTTON_FONT = new Font("Copperplate", Font.BOLD, 24);
    private final String[] BUTTON_TEXTS = {"Jouer", "Règles", "Quitter"};

    // Tableau de titres pour le titre principal et le sous-titre
    private final Title[] labels = {
            new Title("Sudoku Game", TITLE_FONT, TITLE_TEXT_COLOR),
            new Title("Par Moncef & Marco", SUBTITLE_FONT, TITLE_TEXT_COLOR)
    };

    private MusicButton musicButton; // Bouton pour contrôler la musique
    private final Window window; // Fenêtre parente
    private JPanel titlePanel; // Panneau pour le titre
    private JPanel buttonPanel; // Panneau pour les boutons
    private JLabel imageLabel; // Étiquette pour l'image

    /**
     * Constructeur de la classe HomeView.
     * Initialise la fenêtre parente et crée les composants de la page d'accueil.
     * @param window La fenêtre parente.
     */
    public GSHomeView(Window window) {
        this.window = window;
        createComponents();
        addComponentsToWindow();
    }

    /**
     * Crée les composants de la page d'accueil, y compris les panneaux de titre et de boutons.
     */
    private void createComponents() {
        titlePanel = new JPanel();
        buttonPanel = new JPanel();
        ImageIcon iconeSudoku = new ImageIcon("img/sudoku.png");
        imageLabel = new JLabel(iconeSudoku);

        // Configuration du panneau de titre
        GridLayout titleLayout = new GridLayout(2, 1);
        titlePanel.setLayout(titleLayout);
        titlePanel.setBackground(BACKGROUND_COLOR);
        // Utilisation de la classe Title pour le titre et le sous-titre
        for (Title label : labels) {
            titlePanel.add(label);
        }

        // Configuration du panneau de boutons
        GridLayout buttonLayout = new GridLayout(BUTTON_TEXTS.length, 1, 0, 10);
        buttonPanel.setLayout(buttonLayout);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(BACKGROUND_COLOR);
        GSHomeButtonClickListener listenerButton = new GSHomeButtonClickListener(window);
        for (String text : BUTTON_TEXTS) {
            Button button = new Button(text, BUTTON_SIZE, BUTTON_FONT, Color.white);
            button.addActionListener(listenerButton);
            buttonPanel.add(button);
        }

        musicButton = new MusicButton(AUDIO_ON, AUDIO_OFF, MUSIC_FILE); // Bouton pour contrôler la musique
    }

    /**
     * Ajoute les composants créés à la fenêtre parente.
     */
    public void addComponentsToWindow() {
        BorderLayout layout = new BorderLayout();
        window.getContentPane().setLayout(layout);
        window.add(titlePanel, BorderLayout.NORTH);
        window.add(buttonPanel, BorderLayout.WEST);
        window.add(imageLabel, BorderLayout.EAST);
        window.setPageTitle("Menu principal"); // Définit le titre de la page dans la fenêtre

        FlowLayout controlPanelLayout = new FlowLayout(FlowLayout.RIGHT);
        JPanel controlPanel = new JPanel(controlPanelLayout); // Panneau pour les contrôles audio
        controlPanel.setBackground(BACKGROUND_COLOR);
        controlPanel.add(musicButton); // Ajoute le bouton de contrôle audio
        window.add(controlPanel, BorderLayout.SOUTH); // Ajoute le panneau de contrôles à la fenêtre

        window.pack(); // Ajuste la taille de la fenêtre pour s'adapter à son contenu
        window.setVisible(true); // Rend la fenêtre visible
    }
}
