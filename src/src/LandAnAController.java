import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandAnAController implements ActionListener, DocumentListener, ChangeListener {
    final LandAnAGUI gui;
    final LandAnAManager manager;

    public LandAnAController(LandAnAGUI gui, LandAnAManager manager) {
        this.gui =  gui;
        this.manager = manager;

        gui.setActionListener(this);
        gui.setDocumentListener(this);
        gui.setChangeListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create Hotel")) {
            gui.createHotelPanel(manager.returnHotelNames());
        }
        else if (e.getActionCommand().equals("Manage Hotels")) {
            if (manager.getNHotels() >= 1) {
                gui.manageHotelsPanel(manager.getHotels());
            }
            else if (manager.getNHotels() == 0) {
                gui.noHotelsPrompt();
            }
        }
        else if (e.getActionCommand().equals("View Hotels")) {
            if (manager.getNHotels() >= 1) {
                System.out.println("View hotels");
                //gui.manageHotelsPanel();
            }
            else if (manager.getNHotels() == 0) {
                gui.noHotelsPrompt();
            }
        }
        else if (e.getActionCommand().equals("Simulate Booking")) {
            gui.simulateBookingPanel();
        }
        else if (e.getActionCommand().equals("Back")) {
            gui.mainMenuPanel();
        }
        else if (e.getActionCommand().equals("Add Hotel")) {
            String hotelName = gui.getHotelName();
            if (gui.getHotelName().isEmpty()) {
                gui.emptyFieldPrompt();
            }
            else if (manager.isUniqueHotel(hotelName)) {
                manager.addHotel(new Hotel(hotelName));
                gui.createRoomsPanel(manager.getHotel(manager.getNHotels() - 1));
            }
            else {
                gui.notUniquePrompt(hotelName);
            }
        }
        else if(e.getActionCommand().equals("Create Rooms")) {
            if (gui.getRoomsTotal() > 50) {
                gui.excessRoomsPrompt();
            }
            else if (gui.getRoomsTotal() < 1) {
                gui.lackingRoomsPrompt();
            }
            else if (gui.getRoomsTotal() >= 1 && gui.getRoomsTotal()<=50) {
                manager.createRooms(manager.getNHotels() - 1, gui.getSldStandard().getValue(), gui.getSldDeluxe().getValue(), gui.getSldStandard().getValue());
                gui.successPrompt();
                gui.mainMenuPanel();
            }
        }
        else if(e.getActionCommand().equals("Manage Hotel")) {
            gui.manageHotelPanel(manager.getHotel(gui.getcBoxHotels().getSelectedIndex()));
        }
        else if(e.getActionCommand().equals("Change Hotel Name")) {
            if (gui.getHotelName().isEmpty()) {
                gui.emptyFieldPrompt();
            }
            else if(!manager.isUniqueHotel(gui.getHotelName())) {
                gui.notUniquePrompt(gui.getHotelName());
            }
            else {
                if (gui.confirmPrompt() == 0) {
                    manager.setHotelName(gui.getcBoxHotels().getSelectedIndex(), gui.getHotelName());
                    gui.manageHotelPanel(manager.getHotel(gui.getcBoxHotels().getSelectedIndex()));
                }
            }
        }
    }

    public void insertUpdate(DocumentEvent e) {}

    public void removeUpdate(DocumentEvent e) {}

    public void changedUpdate(DocumentEvent e) {}

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == gui.getSldStandard()) {
            gui.getLblStd().setText("Standard rooms: " + gui.getSldStandard().getValue());
            gui.getLblTotal().setText("Total: " + (gui.getSldStandard().getValue()+gui.getSldDeluxe().getValue()+gui.getSldExecutive().getValue()));
        } else if (e.getSource() == gui.getSldDeluxe()) {
            gui.getLblDeluxe().setText("Deluxe rooms: " + gui.getSldDeluxe().getValue());
            gui.getLblTotal().setText("Total: " + (gui.getSldStandard().getValue()+gui.getSldDeluxe().getValue()+gui.getSldExecutive().getValue()));
        } else if (e.getSource() == gui.getSldExecutive()) {
            gui.getLblExecutive().setText("Executive rooms: " + gui.getSldExecutive().getValue());
            gui.getLblTotal().setText("Total: " + (gui.getSldStandard().getValue()+gui.getSldDeluxe().getValue()+gui.getSldExecutive().getValue()));
        }
    }
}
