import javax.swing.*;
import java.awt.*;

public class HomeView extends JPanel {

    private final String AUDIO_ON = "img/iconeAudio.png";
    private final String AUDIO_OFF = "img/iconeAudioMuted.png";
    private final String MUSIC_FILE = "audio/musiqueDeFond.wav";
    private final Dimension BUTTON_SIZE = new Dimension(300, 60);
    private final Color BACKGROUND_COLOR = new Color(54, 91, 109);
    private final Color TITLE_TEXT_COLOR = Color.WHITE;
    private final Font TITLE_FONT = new Font("Copperplate", Font.BOLD, 75);
    private final Font SUBTITLE_FONT = new Font("Copperplate", Font.PLAIN, 24);
    private final Font BUTTON_FONT = new Font("Copperplate", Font.BOLD, 24);
    private final String[] BUTTON_TEXTS = {"Jouer", "Règles", "Comment jouer ?", "Quitter"};
    private final Title[] labels = {
        new Title("Sudoku Solver", TITLE_FONT, TITLE_TEXT_COLOR),
        new Title("Par Moncef & Marco", SUBTITLE_FONT, TITLE_TEXT_COLOR)
        };
    private final MusicButton musicButton;
    private Window window;

    public HomeView(Window window) {
        this.window = window;
        JPanel titlePanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        ImageIcon iconeSudoku = new ImageIcon("img/sudoku.png");
        JLabel imageLabel = new JLabel(iconeSudoku);

        GridLayout titleLayout = new GridLayout(2, 1);
        titlePanel.setLayout(titleLayout);
        titlePanel.setBackground(BACKGROUND_COLOR);
        // Utilisation de la classe Title pour le titre et le sous-titre
        for(Title label : labels){
            titlePanel.add(label);
        }

        // Button Panel
        GridLayout buttonLayout = new GridLayout(BUTTON_TEXTS.length, 1, 0, 10);
        buttonPanel.setLayout(buttonLayout);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(BACKGROUND_COLOR);
        HomeButtonClickListener listenerButton = new HomeButtonClickListener(window);
        for (String text : BUTTON_TEXTS) {
            Button button = new Button(text, BUTTON_SIZE, BUTTON_FONT, BACKGROUND_COLOR);
            button.addActionListener(listenerButton);
            buttonPanel.add(button);
        }

        BorderLayout layout = new BorderLayout();
        this.window.getContentPane().setLayout(layout);
        this.window.add(titlePanel, BorderLayout.NORTH);
        this.window.add(buttonPanel, BorderLayout.WEST);
        this.window.add(imageLabel, BorderLayout.EAST);
        this.window.setPageTitle("Menu");

        this.musicButton = new MusicButton(AUDIO_ON, AUDIO_OFF, MUSIC_FILE);
        FlowLayout controlPanelLayout = new FlowLayout(FlowLayout.RIGHT);
        JPanel controlPanel = new JPanel(controlPanelLayout);
        controlPanel.setBackground(BACKGROUND_COLOR);
        controlPanel.add(this.musicButton);
        this.window.add(controlPanel, BorderLayout.SOUTH);

        this.window.pack();
        this.window.setLocationRelativeTo(null);
        this.window.setVisible(true);
    }
}
