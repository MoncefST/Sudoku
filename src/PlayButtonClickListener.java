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
            
        }

        else if (buttonText.equals("Générer une grille")) {
            Window.removeAllComponents(this.window);
            new GridMakeUserInterfaceView(this.window);

        } else if (buttonText.equals("Charger une grille")) {
            
        } else if (buttonText.equals("Retour au menu principal")) {
            if (window.getContentPane().getComponent(0) instanceof PlayMenuView) {
                Window.removeAllComponents(window);
                HomeView homeView = new HomeView(window);
            }
        }
    }
}
