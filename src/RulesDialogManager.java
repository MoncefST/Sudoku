import javax.swing.JOptionPane;

public class RulesDialogManager {
    public static void showRulesDialog() {
        RulesSudoku rulesPanel = new RulesSudoku();
        JOptionPane.showMessageDialog(null, rulesPanel, "Règles du Sudoku", JOptionPane.PLAIN_MESSAGE);
    }
}
