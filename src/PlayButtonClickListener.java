import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonClickListener implements ActionListener {
    private Window window;

    public PlayButtonClickListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button sourceButton = (Button) e.getSource();
        String buttonText = sourceButton.getText();

        // Handle different button actions based on their text
        if (buttonText.equals("Générer une grille")) {
            System.out.println("Générer une grille");
        } else if (buttonText.equals("Charger une grille")) {
            System.out.println("Chargement de la grille");
        } else if (buttonText.equals("Retour au menu principal")) {
            if (window.getContentPane().getComponent(0) instanceof PlayMenuView) {
                PlayMenuView playMenuView = (PlayMenuView) window.getContentPane().getComponent(0);
                playMenuView.removeAllComponents(window);
                HomeView homeView = new HomeView(window);
            }
        }
    }
}
