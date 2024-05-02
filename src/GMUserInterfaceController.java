import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contrôleur de l'interface utilisateur pour le GridMaker.
 */
public class GMUserInterfaceController implements ActionListener {
    /**
     * La fenêtre
     */
    private Window window;

    /**
     * Constructeur de GMUserInterfaceController
     * @param window fenêtre parente
     */
    public GMUserInterfaceController(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
