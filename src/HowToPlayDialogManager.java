import javax.swing.JOptionPane;

public class HowToPlayDialogManager {
    public static void showHowToPlayDialog() {
        HowToPlaySudoku howToPlay = new HowToPlaySudoku();
        JOptionPane.showMessageDialog(null, howToPlay, "Comment jouer ?", JOptionPane.PLAIN_MESSAGE);
    }
}
