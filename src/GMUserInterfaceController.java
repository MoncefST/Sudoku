import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GMUserInterfaceController implements ActionListener {
    private Window window;

    public GMUserInterfaceController(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
