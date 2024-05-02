import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * HomeView représente la vue de la page d'accueil de l'application Sudoku.
 * Cette classe étend JPanel et affiche les éléments de la page d'accueil, y compris le titre, les boutons et les contrôles audio.
 * Elle utilise également les classes Title, Button, et MusicButton.
 *
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class HomeView extends JPanel {

    /**
     * La chemin pour accéder à l'image "iconeAudio.png"
     */
    private final String AUDIO_ON = "img/iconeAudio.png";

    /**
     * La chemin pour accéder à l'image "AudioMuted.png"
     */
    private final String AUDIO_OFF = "img/iconeAudioMuted.png";

    /**
     * Le chemin pour accéder à la musique
     */
    private final String MUSIC_FILE = "audio/musiqueDeFond.wav";

    /**
     * La taille des boutons
     */
    private final Dimension BUTTON_SIZE = new Dimension(300, 60);

    /**
     * La couleur d'arrière plan
     */
    private final Color BACKGROUND_COLOR = new Color(54, 91, 109);

    /**
     * La couleur du texte du titre
     */
    private final Color TITLE_TEXT_COLOR = Color.WHITE;

    /**
     * La police d'écriture du texte du titre
     */
    private final Font TITLE_FONT = new Font("Copperplate", Font.BOLD, 75);

    /**
     * La police d'écriture du sous-titre
     */
    private final Font SUBTITLE_FONT = new Font("Copperplate", Font.PLAIN, 24);

    /**
     * La police d'écriture du texte des boutons
     */
    private final Font BUTTON_FONT = new Font("Copperplate", Font.BOLD, 24);

    /**
     * Textes des boutons
     */
    private final String[] BUTTON_TEXTS;

    /**
     * Tableau de titres pour le titre principal et le sous-titre
     */
    private final Title[] labels;

    /**
     * Bouton pour contrôler la musique
     */
    private MusicButton musicButton;

    /**
     * Fenêtre parente
     */
    private final Window window;

    /**
     * Panneau pour le titre
     */
    private JPanel titlePanel;

    /**
     * Panneau pour les boutons
     */
    private JPanel buttonPanel;

    /**
     * Étiquette pour l'image
     */
    private JLabel imageLabel;

    /**
     * Liste des boutons créés
     */
    private List<Button> buttonsList;

    /**
     * Constructeur de la classe HomeView.
     * Initialise la fenêtre parente et crée les composants de la page d'accueil.
     * @param window     La fenêtre parente.
     * @param mainTitle  Le titre principal de la page.
     * @param subTitle   Le sous-titre de la page.
     * @param buttonTexts Les textes des boutons.
     */
    public HomeView(Window window, String mainTitle, String subTitle, String[] buttonTexts) {
        this.window = window;
        this.BUTTON_TEXTS = buttonTexts;
        this.labels = new Title[]{new Title(mainTitle, TITLE_FONT, TITLE_TEXT_COLOR),
                new Title(subTitle, SUBTITLE_FONT, TITLE_TEXT_COLOR)};
        buttonsList = new ArrayList<>();
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
        HomeButtonClickListener listenerButton = new HomeButtonClickListener(window);
        for (String text : BUTTON_TEXTS) {
            Button button = new Button(text, BUTTON_SIZE, BUTTON_FONT, Color.white);
            button.addActionListener(listenerButton);
            buttonPanel.add(button);
            buttonsList.add(button); // Ajout du bouton à la liste
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

    /**
     * Récupère le premier bouton créé.
     *
     * @return Le premier bouton.
     */
    public Button getFirstButton() {
        return buttonsList.get(0);
    }

    /**
     * Récupère le deuxième bouton créé.
     *
     * @return Le deuxième bouton.
     */
    public Button getSecondButton() {
        return buttonsList.get(1);
    }

    /**
     * Récupère le troisième bouton créé.
     *
     * @return Le troisième bouton.
     */
    public Button getThirdButton() {
        return buttonsList.get(2);
    }
}
