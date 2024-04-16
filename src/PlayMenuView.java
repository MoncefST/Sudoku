import javax.swing.*;
import java.awt.*;

public class PlayMenuView extends JPanel {

    // View components
    private final Dimension BUTTON_SIZE = new Dimension(300, 60);
    private final Color BACKGROUND_COLOR = new Color(54, 91, 109);
    private final Color TITLE_TEXT_COLOR = Color.WHITE;
    private final Font TITLE_FONT = new Font("Copperplate", Font.BOLD, 40);
    private final Font BUTTON_FONT = new Font("Copperplate", Font.BOLD, 24);
    private final String[] BUTTON_TEXTS = {"Jouer sans grille", "Générer une grille", "Charger une grille"};
    private Title titleLabel;
    private Button[] playModeButtons;
    private Button returnButton;
    private JPanel buttonPanel; // Declare buttonPanel here

    // Constructor to initialize components
    public PlayMenuView(Window window) {
        createComponents(window);
        addComponentsToWindow(window);
    }

    // Method to create all components
    private void createComponents(Window window) {
        // Title
        titleLabel = new Title("Choix du mode de jeu", TITLE_FONT, TITLE_TEXT_COLOR);

        // Button Panel
        GridLayout gestionnaireButtonPanel = new GridLayout(BUTTON_TEXTS.length, 1, 0, 10);
        buttonPanel = new JPanel(gestionnaireButtonPanel); // Initialize buttonPanel here
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(BACKGROUND_COLOR);

        // Buttons
        playModeButtons = new Button[BUTTON_TEXTS.length];
        for (int i = 0; i < BUTTON_TEXTS.length; i++) {
            Button button = new Button(BUTTON_TEXTS[i], BUTTON_SIZE, BUTTON_FONT, BACKGROUND_COLOR);
            playModeButtons[i] = button;
            PlayButtonClickListener ecouteurBouton = new PlayButtonClickListener(window);
            button.addActionListener(ecouteurBouton);
            buttonPanel.add(button);
        }

        // Return Button
        returnButton = new Button("Retour au menu principal", BUTTON_SIZE, BUTTON_FONT, BACKGROUND_COLOR);
        returnButton.addActionListener(new PlayButtonClickListener(window));
    }

    // Method to add components to the window
    private void addComponentsToWindow(Window window) {
        // Layout
        window.setPageTitle("Menu jouer");
        setLayout(new BorderLayout());
        setBackground(BACKGROUND_COLOR);

        // Adding components to the panel
        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER); 
        add(returnButton, BorderLayout.SOUTH);


        // Add panel to the window
        window.add(this);
    }
}
