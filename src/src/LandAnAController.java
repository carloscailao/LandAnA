import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandAnAController implements ActionListener, DocumentListener {
    final LandAnAGUI gui;
    final LandAnAManager manager;

    public LandAnAController(LandAnAGUI gui, LandAnAManager manager) {
        this.gui =  gui;
        this.manager = manager;

        gui.setActionListener(this);
        gui.setDocumentListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create Hotel")) {
            gui.createHotelPanel(manager.returnHotelNames());
        }
        else if (e.getActionCommand().equals("Manage Hotel")) {
            gui.manageHotelPanel();
        }
        else if (e.getActionCommand().equals("View Hotels")) {
            gui.viewHotelsPanel();
        }
        else if (e.getActionCommand().equals("Simulate Booking")) {
            gui.simulateBookingPanel();
        }
        else if (e.getActionCommand().equals("Back")) {
            gui.mainMenuPanel();
        }
        else if (e.getActionCommand().equals("Enter")) {
            // TODO
        }

    }

    public void insertUpdate(DocumentEvent e) {

    }
    public void removeUpdate(DocumentEvent e) {

    }
    public void changedUpdate(DocumentEvent e) {

    }
}
