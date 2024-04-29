import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GMSaverActionListener implements ActionListener {

    private Window parentFrame;
    private GMGrid grid;

    public GMSaverActionListener(Window parentFrame, GMGrid grid) {
        this.parentFrame = parentFrame;
        this.grid = grid;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GMSaver gMSaver = new GMSaver(parentFrame, grid);
        gMSaver.saveGridIfNeeded();
    }
}
