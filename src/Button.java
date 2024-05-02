import javax.swing.*;
import java.awt.*;

/**
 * Class containing custom settings for JButtons.
 * @version 1.0
 * @author Moncef STITI
 * @author Marco ORFAO
 */
public class Button extends JButton {
    /**
     * Constructor
     * @param text The text of the button
     */
    public Button (String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 15));
        setBackground(new Color(96, 175, 255));
    }
    
    /**
    * Constructor
    * @param text The text of the button
    * @param color The background color of the button
    */
    public Button (String text,Color color) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 15));
        setBackground(color);
    }

    /**
     * Constructor
     * @param text The text of the button
     * @param dimension The dimension of the button
     */
    public Button(String text, Dimension dimension) {
        super(text);
        setPreferredSize(dimension);
        setFont(new Font("Arial", Font.BOLD, 20));
        setBackground(new Color(96, 175, 255));
    }

    /**
     * Constructor
     * @param text The text of the button
     * @param dimension The dimension of the button
     * @param font The font of the text in the button
     */
    public Button(String text, Dimension dimension, Font font) {
        super(text);
        setPreferredSize(dimension);
        setFont(font);
        setBackground(new Color(96, 175, 255));
    }

    /**
     * Constructor
     * @param text The text of the button
     * @param dimension The dimension of the button
     * @param font The font of the text in the button
     * @param color The background color of the button
     */
    public Button(String text, Dimension dimension, Font font, Color color) {
        super(text);
        setPreferredSize(dimension);
        setFont(font);
        setBackground(color);
    }

}