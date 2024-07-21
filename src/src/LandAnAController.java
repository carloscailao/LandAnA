import javax.swing.*;
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
                gui.updatecBoxHotels(manager.getHotelNames());
                gui.manageHotelsPanel();
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
            if (manager.getNHotels() >= 1) {
                gui.updatecBoxHotels(manager.getHotelNames());
                gui.simulateBookingPanel();
            }
            else if (manager.getNHotels() == 0) {
                gui.noHotelsPrompt();
            }
        }
        else if (e.getActionCommand().equals("Back")) {
            gui.mainMenuPanel();
        }
        else if (e.getActionCommand().equals("Add Hotel")) {
            String hotelName = gui.getTfNameText();
            if (gui.getTfNameText().isEmpty()) {
                gui.emptyFieldPrompt();
            }
            else if (manager.isUniqueHotel(hotelName)) {
                manager.addHotel(new Hotel(hotelName));
                gui.createRoomsPanel(manager.getHotel(manager.getNHotels() - 1));
            }
            else {
                gui.notUniquePrompt(hotelName);
            }
            manager.setHotelIndex(manager.getNHotels()-1);
        }
        else if(e.getActionCommand().equals("Create Rooms")) {
            if (gui.getRoomsTotal() > 50) {
                gui.excessRoomsPrompt();
            }
            else if (gui.getRoomsTotal() < 1) {
                gui.lackingRoomsPrompt();
            }
            else if (gui.getRoomsTotal() >= 1 && gui.getRoomsTotal()<=50) {
                manager.createRooms(manager.getNHotels() - 1, gui.getSldStandard().getValue(),
                                    gui.getSldDeluxe().getValue(), gui.getSldExecutive().getValue());
                gui.successPrompt();
                gui.mainMenuPanel();
            }
            gui.updatecBoxRooms(manager.getRoomsNames(manager.getHotelIndex()));
        }
        else if(e.getActionCommand().equals("Manage Hotel")) {
            manager.setHotelIndex(gui.getcBoxHotels().getSelectedIndex());
            gui.manageHotelPanel(manager.getHotel(manager.getHotelIndex()));
        }
        else if(e.getActionCommand().equals("Change Hotel Name")) {
            if (gui.getTfNameText().isEmpty()) {
                gui.emptyFieldPrompt();
            }
            else if(!manager.isUniqueHotel(gui.getTfNameText())) {
                gui.notUniquePrompt(gui.getTfNameText());
            }
            else {
                if (gui.confirmPrompt() == 0) {
                    manager.setHotelName(manager.getHotelIndex(), gui.getTfNameText());
                    gui.successPrompt();
                    gui.manageHotelPanel(manager.getHotel(manager.getHotelIndex()));
                }
            }
        }
        else if (e.getActionCommand().equals("Add Standard Rooms")) {
            if (gui.addRoomPrompt() == JOptionPane.OK_OPTION) {
                if ((gui.getSpnValue() + manager.getHotel(manager.getHotelIndex()).getTotalRooms()) > 50) {
                    gui.excessRoomsPrompt();
                }
                else if ((gui.getSpnValue() + manager.getHotel(manager.getHotelIndex()).getTotalRooms()) <= 50) {
                    if (gui.confirmPrompt() == 0) {
                        manager.createRooms(manager.getHotelIndex(), gui.getSpnValue(), 0, 0);
                        gui.updatecBoxRooms(manager.getRoomsNames(manager.getHotelIndex()));
                        gui.successPrompt();
                    }
                }
                gui.manageHotelPanel(manager.getHotel(manager.getHotelIndex()));
            }
        }
        else if (e.getActionCommand().equals("Add Deluxe Rooms")) {
            if (gui.addRoomPrompt() == JOptionPane.OK_OPTION) {
                if ((gui.getSpnValue() + manager.getHotel(manager.getHotelIndex()).getTotalRooms()) > 50) {
                    gui.excessRoomsPrompt();
                }
                else if ((gui.getSpnValue() + manager.getHotel(manager.getHotelIndex()).getTotalRooms()) <= 50) {
                    if (gui.confirmPrompt() == 0) {
                        manager.createRooms(manager.getHotelIndex(), 0, gui.getSpnValue(), 0);
                        gui.updatecBoxRooms(manager.getRoomsNames(manager.getHotelIndex()));
                        gui.successPrompt();
                    }
                }
                gui.manageHotelPanel(manager.getHotel(manager.getHotelIndex()));
            }
        }
        else if (e.getActionCommand().equals("Add Executive Rooms")) {
            if (gui.addRoomPrompt() == JOptionPane.OK_OPTION) {
                if ((gui.getSpnValue() + manager.getHotel(manager.getHotelIndex()).getTotalRooms()) > 50) {
                    gui.excessRoomsPrompt();
                }
                else if ((gui.getSpnValue() + manager.getHotel(manager.getHotelIndex()).getTotalRooms()) <= 50) {
                    if (gui.confirmPrompt() == 0) {
                        manager.createRooms(manager.getHotelIndex(), 0, 0, gui.getSpnValue());
                        gui.updatecBoxRooms(manager.getRoomsNames(manager.getHotelIndex()));
                        gui.successPrompt();
                    }
                }
                gui.manageHotelPanel(manager.getHotel(manager.getHotelIndex()));
            }
        }
        else if (e.getActionCommand().equals("Remove Room")) {
            //gui.updatecBoxRooms(manager.getRoomsNames(manager.getHotelIndex()));
            if (manager.getHotel(manager.getHotelIndex()).getTotalRooms()>1) {
                if (gui.pickRoomPrompt() == JOptionPane.OK_OPTION) {
                    if (manager.roomHasNoReservations(manager.getHotelIndex(), gui.getcBoxRooms().getSelectedIndex())) {
                        if (gui.confirmPrompt() == 0) {
                            System.out.println("Deleting room");
                            manager.deleteRoom(manager.getHotelIndex(), gui.getcBoxRooms().getSelectedIndex());
                            gui.updatecBoxRooms(manager.getRoomsNames(manager.getHotelIndex()));
                            gui.successPrompt();
                        }
                    }
                }
            }
            else if (manager.getHotel(manager.getHotelIndex()).getTotalRooms()<=1) {
                gui.lackingRoomsPrompt();
            }
            gui.manageHotelPanel(manager.getHotel(manager.getHotelIndex()));
        }
        else if (e.getActionCommand().equals("Update Base Price")) {
            if (gui.getSpnDouble() < 100) {
                gui.minBasePrompt();
            }
            else if (gui.getSpnDouble() >= 100) {
                System.out.println("Valid base price");
                if (manager.hotelHasNoReservations(manager.getHotelIndex())) {
                    System.out.println("Hotel has no reservations");
                    if (gui.confirmPrompt() == 0) {
                        System.out.println("Confirmed");
                        manager.setBasePrice(manager.getHotelIndex(), gui.getSpnDouble());
                        gui.successPrompt();
                    }
                }
                else {
                    gui.stillHasReservationsPrompt();
                }
            }
        }
        else if (e.getActionCommand().equals("Remove Reservation")) {
            if (gui.pickRoomPrompt() == JOptionPane.OK_OPTION) {
                gui.updatecBoxReservations(manager.getReservationNames(manager.getHotelIndex(), gui.getcBoxRooms().getSelectedIndex()));
                if (gui.pickReservationPrompt() == JOptionPane.OK_OPTION) {
                    if (gui.getcBoxReservations().getSelectedIndex() != -1) {
                        if (gui.confirmPrompt() == 0) {
                            manager.removeReservation(manager.getHotelIndex(), gui.getcBoxRooms().getSelectedIndex(),
                                    gui.getcBoxReservations().getSelectedIndex());
                            gui.updatecBoxReservations(manager.getReservationNames(manager.getHotelIndex(), gui.getcBoxRooms().getSelectedIndex()));
                            gui.successPrompt();
                        }
                    }
                }
            }
        }
        else if(e.getActionCommand().equals("Modify Date Price")) {
            if (gui.modifyDatePrompt() == 0) {
                if (gui.confirmPrompt() == 0) {
                    manager.setSpecial(gui.getModifyDate(), gui.getRate());
                    gui.successPrompt();
                }
            }
        }
        else if(e.getActionCommand().equals("Remove Hotel")) {
            if (gui.confirmPrompt() == 0) {
                manager.removeHotel(manager.getHotelIndex());
                gui.successPrompt();
                gui.mainMenuPanel();
            }
        }
        else if (e.getActionCommand().equals("Choose Hotel")) {
            manager.setHotelIndex(gui.getcBoxHotels().getSelectedIndex());
            gui.bookingPanel(manager.getHotel(manager.getHotelIndex()));
        }
        else if (e.getActionCommand().equals("Check Availability")) {
            if (gui.getTfNameText().isEmpty()) {
                gui.emptyFieldPrompt();
            }
            else {
                gui.updatecBoxRooms(manager.getAvailRooms(gui.getIn(), gui.getOut()));
                gui.pickRoomPrompt();
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
        } else if(e.getSource() == gui.getSldRate()) {
            gui.getLblRate().setText(gui.getRate()+"%");
        }
    }
}
