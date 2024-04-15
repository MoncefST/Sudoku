import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrilleButtonClickListener implements ActionListener {
    private Window window;

    public GrilleButtonClickListener(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button sourceButton = (Button) e.getSource();
        String buttonText = sourceButton.getText();

        // Si le bouton "Retour au menu principal" est cliqué, on efface ce qui est présent et on met le menu jouer
        if (buttonText.equals("Retour au menu principal")) {
            if (window.getContentPane().getComponent(0) instanceof GrilleView) {
                GrilleView grilleView = (GrilleView) window.getContentPane().getComponent(0);
                grilleView.removeAllComponents(window);
                window.changeMenu(new PlayMenuView(this.window)); // PAS BON CAR ON VA CRÉE UN MENU JOUER À CHAQUE FOIS AU LIEU DE RÉUTILISER L'ANCIEN
            }
        }
    }
}
