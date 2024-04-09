import javax.swing.JOptionPane;

public class HowToPlayDialogManager implements DialogManager {
    @Override
    public void showDialog() {
        HowToPlaySudoku howToPlay = new HowToPlaySudoku();
        JOptionPane.showMessageDialog(null, howToPlay, "Comment jouer ?", JOptionPane.PLAIN_MESSAGE);
    }
}