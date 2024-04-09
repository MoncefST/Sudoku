import javax.swing.JOptionPane;

public class RulesDialogManager implements DialogManager {
    @Override
    public void showDialog() {
        RulesSudoku rulesPanel = new RulesSudoku();
        JOptionPane.showMessageDialog(null, rulesPanel, "Règles du Sudoku", JOptionPane.PLAIN_MESSAGE);
    }
}