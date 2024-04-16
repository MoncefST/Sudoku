import java.awt.event.*;

public class GridMakerRules implements ActionListener {
    private RulesDialogManager rulesDialog;

    public GridMakerRules(){
        this.rulesDialog = new RulesDialogManager();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        rulesDialog.showDialog(); // On appelle la méthode qui affiche la fenêtre de dialogue
    }
}
