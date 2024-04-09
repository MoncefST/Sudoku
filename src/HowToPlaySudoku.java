import javax.swing.*;
import java.awt.*;

public class HowToPlaySudoku extends JPanel {
    
    public HowToPlaySudoku() {
        BorderLayout gestionnaireBorderLayout = new BorderLayout();
        this.setLayout(gestionnaireBorderLayout);
        this.setBackground(new Color(54, 91, 109)); // Couleur d'arrière-plan du menu principal

        JLabel titleLabel = new JLabel("Comment jouer ?");
        titleLabel.setFont(new Font("Copperplate", Font.BOLD, 40)); // Police du titre
        titleLabel.setForeground(Color.WHITE); // Couleur du titre

        JTextArea rulesTextArea = new JTextArea();
        rulesTextArea.setText("1. EXPLIQUER CE QU'IL FAUT FAIRE\n\n" +
                "2. EXPLIQUER CE QU'IL FAUT FAIRE \n\n" +
                "3. EXPLIQUER CE QU'IL FAUT FAIRE \n\n" +
                "4. EXPLIQUER CE QU'IL FAUT FAIRE");
        rulesTextArea.setEditable(false);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setWrapStyleWord(true);
        rulesTextArea.setFont(new Font("Arial", Font.PLAIN, 20)); // Police du texte 
        rulesTextArea.setForeground(Color.WHITE); // Couleur du texte 
        rulesTextArea.setBackground(new Color(54, 91, 109)); // Couleur d'arrière-plan du JLabel

        JScrollPane scrollPane = new JScrollPane(rulesTextArea);

        this.add(titleLabel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(400, 500)); // Taille de la fenêtre
    }
}
