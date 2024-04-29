import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GSCaseMouseListener implements MouseListener {
    private GSCase casePanel;

    public GSCaseMouseListener(GSCase casePanel) {
        this.casePanel = casePanel;
    }

    public void mouseClicked(MouseEvent e) {
        if (!casePanel.isInitial) {
            casePanel.isActive = true;
            casePanel.setBackground(Color.GREEN);
            casePanel.parentGrid.testActivity(casePanel.positionX, casePanel.positionY);
        }
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {
        if (!casePanel.isInitial) {
            if (!casePanel.isActive) {
                casePanel.setBackground(Color.yellow);
            }
        }
    }

    public void mouseExited(MouseEvent e) {
        if (!casePanel.isInitial) {
            if (!casePanel.isActive) {
                casePanel.setBackground(Color.white);
            }
        }
    }
}
