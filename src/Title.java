import javax.swing.*;
import java.awt.*;

public class Title extends JLabel {

    public Title(String text, Font font, Color color) {
        super(text, SwingConstants.CENTER);
        setFont(font);
        setForeground(color);
    }
}
