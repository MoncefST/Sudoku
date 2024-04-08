import javax.swing.*;
import java.awt.*;

public class MenuView {

    private static final String AUDIO_ON = "../img/iconeAudio.png";                                     // Chemin vers l'image iconeAudio
    private static final String AUDIO_OFF = "../img/iconeAudioMuted.png";                               // Chemin vers l'image iconeAudioMuted
    private static final String MUSIC_FILE = "../audio/musiqueDeFond.wav";                              // Chemin vers la musique de fond
    private static final Dimension BUTTON_SIZE = new Dimension(300, 60);                                // Dimension des boutons
    private static final Color BACKGROUND_COLOR = new Color(54, 91, 109);                               // Couleur de l'arrière plan
    private static final Color TITLE_TEXT_COLOR = Color.WHITE;                                          // Couleur du titre
    private static final Font TITLE_FONT = new Font("Copperplate", Font.BOLD, 75);                      // Police des titres
    private static final Font SUBTITLE_FONT = new Font("Copperplate", Font.PLAIN, 24);                  // Police des sous-titres
    private static final Font BUTTON_FONT = new Font("Copperplate", Font.BOLD, 24);                     // Police des boutons
    private static final String[] BUTTON_TEXTS = {"Jouer", "Comment jouer ?", "Paramètres", "Quitter"}; // Texte des boutons
    private static final JLabel[] labels = {
        new JLabel("Sudoku Solver", SwingConstants.CENTER),                                             // Titre
        new JLabel("Par Moncef & Marco", SwingConstants.CENTER)};                                       // Sous Titre

    private final MusicButton musicButton;
    private Window window;

    public MenuView(Window window) {
        this.window = window;
        JPanel titlePanel = createTitlePanel();
        JPanel buttonPanel = createButtonPanel();
        ImageIcon iconeSudoku = new ImageIcon("../img/sudoku.png");
        JLabel imageLabel = new JLabel(iconeSudoku);

        BorderLayout gestionnaireFenetre = new BorderLayout();
        this.window.getContentPane().setLayout(gestionnaireFenetre);
        this.window.add(titlePanel, BorderLayout.NORTH);
        this.window.add(buttonPanel, BorderLayout.WEST);
        this.window.add(imageLabel, BorderLayout.EAST);
        this.window.setPageTitle("Menu");

        musicButton = new MusicButton(AUDIO_ON, AUDIO_OFF, MUSIC_FILE);
        FlowLayout gestionnaireControlPanel = new FlowLayout(FlowLayout.RIGHT);
        JPanel controlPanel = new JPanel(gestionnaireControlPanel);
        controlPanel.setBackground(BACKGROUND_COLOR);
        controlPanel.add(musicButton);
        this.window.add(controlPanel, BorderLayout.SOUTH);

        this.window.pack();
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);
    }

    private JPanel createTitlePanel() {
        GridLayout gestionnairePanel = new GridLayout(2, 1);
        JPanel panel = new JPanel(gestionnairePanel);
        panel.setBackground(BACKGROUND_COLOR);
        for (JLabel label : this.labels) {
            label.setFont(label == this.labels[0] ? TITLE_FONT : SUBTITLE_FONT);
            label.setForeground(TITLE_TEXT_COLOR);
            panel.add(label);
        }
        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(BUTTON_TEXTS.length, 1, 0, 10);
        panel.setLayout(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Permet de ne pas coller les boutons à la fenêtre
        panel.setBackground(BACKGROUND_COLOR);
        ButtonClickListener listenerButton = new ButtonClickListener(this.window);
        for (String text : BUTTON_TEXTS) {
            Button button = new Button(text, BUTTON_SIZE, BUTTON_FONT, BACKGROUND_COLOR);
            button.addActionListener(listenerButton);
            panel.add(button);
        }
        return panel;
    }
}
