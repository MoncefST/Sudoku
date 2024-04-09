import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    /**
    * The minimum size of the window.
    */
    private static final Dimension MIN_WINDOW_SIZE = new Dimension(850, 700);
    /**
    * The title of the program.
    */
    private static final String PROGRAM_TITLE = "Sudoku";


    /**
    * The title of the current page.
    */
    private String PAGE_TITLE = "";

    /**
    * Constructor
    */
    public Window() {
        super(PROGRAM_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(this.MIN_WINDOW_SIZE);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(54, 91, 109));
    }

    /**
    * Get the title of the current page.
    * @return The title of the current page.
    */
    public String getPageTitle() {
        return this.PAGE_TITLE;
    }

    /**
    * Set the title of the current page.
    * @param title The title of the current page.
    */
    public void setPageTitle(String title) {
        this.PAGE_TITLE = title;
        this.setTitle(this.PAGE_TITLE + " - " + Window.PROGRAM_TITLE);
    }

    public void changeMenu(JPanel menuPanel) {
        getContentPane().removeAll();
        getContentPane().add(menuPanel);
        revalidate();
        repaint();
    }

}
