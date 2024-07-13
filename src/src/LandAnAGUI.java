import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;

public class LandAnAGUI extends JFrame {
    ImageIcon logo = new ImageIcon("LandAnALogo1.png");
    private String bgColor = "#BFE7CC";
    private String fontColor = "#3DAC78";

    private JButton btnCreateHotel;
    private JButton btnManageHotel;
    private JButton btnViewHotels;
    private JButton btnSimulateBooking;

    public LandAnAGUI() {
        super("LandAnA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(750, 625);
        init();
        setVisible(true);
        setResizable(false);
        setIconImage(logo.getImage());
    }

    private void init() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.decode(bgColor));

        JLabel lblLandAnA = new JLabel();
        lblLandAnA.setText("LandAnA");
        lblLandAnA.setForeground(Color.decode(fontColor));
        lblLandAnA.setFont(new Font("Verdana", Font.BOLD, 40));
        ImageIcon logoDisplay = new ImageIcon(logo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        lblLandAnA.setIcon(logoDisplay);
        lblLandAnA.setHorizontalTextPosition(JLabel.CENTER);
        lblLandAnA.setVerticalTextPosition(JLabel.BOTTOM);
        lblLandAnA.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(lblLandAnA);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#BFE7CC"));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Create raised bevel border
        Border raisedBevelBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createRaisedBevelBorder(),
                BorderFactory.createEmptyBorder(10, 20, 10, 20) // Adjust padding as needed
        );

        btnCreateHotel = new JButton("Create Hotel");
        btnCreateHotel.setBorder(raisedBevelBorder); // Set raised bevel border
        btnManageHotel = new JButton("Manage Hotels");
        btnManageHotel.setBorder(raisedBevelBorder); // Set raised bevel border
        btnViewHotels = new JButton("View Hotels");
        btnViewHotels.setBorder(raisedBevelBorder); // Set raised bevel border
        btnSimulateBooking = new JButton("Simulate Booking");
        btnSimulateBooking.setBorder(raisedBevelBorder); // Set raised bevel border

        buttonPanel.add(btnCreateHotel);
        buttonPanel.add(btnManageHotel);
        buttonPanel.add(btnViewHotels);
        buttonPanel.add(btnSimulateBooking);

        centerPanel.add(buttonPanel);
        centerPanel.add(Box.createVerticalGlue());

        add(centerPanel, BorderLayout.CENTER);

        // Add action listeners to buttons
        btnCreateHotel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Example: Switch to CreateHotelPanel
                switchToCreateHotelPanel();
            }
        });

        btnManageHotel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Example: Switch to ManageHotelsPanel
                switchToManageHotelsPanel();
            }
        });

        btnViewHotels.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Example: Switch to ViewHotelsPanel
                switchToViewHotelsPanel();
            }
        });

        btnSimulateBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Example: Switch to SimulateBookingPanel
                switchToSimulateBookingPanel();
            }
        });
    }

    // Methods to switch panels or frames
    private void switchToCreateHotelPanel() {
        // Example: Replace center panel with CreateHotelPanel
        JPanel createHotelPanel = new JPanel();
        createHotelPanel.setBackground(Color.WHITE);
        JLabel label = new JLabel("Create Hotel Interface");
        createHotelPanel.add(label);
        setContentPane(createHotelPanel);
        revalidate();
        repaint();
    }

    private void switchToManageHotelsPanel() {
        // Example: Replace center panel with ManageHotelsPanel
        JPanel manageHotelsPanel = new JPanel();
        manageHotelsPanel.setBackground(Color.WHITE);
        JLabel label = new JLabel("Manage Hotels Interface");
        manageHotelsPanel.add(label);
        setContentPane(manageHotelsPanel);
        revalidate();
        repaint();
    }

    private void switchToViewHotelsPanel() {
        // Example: Replace center panel with ViewHotelsPanel
        JPanel viewHotelsPanel = new JPanel();
        viewHotelsPanel.setBackground(Color.WHITE);
        JLabel label = new JLabel("View Hotels Interface");
        viewHotelsPanel.add(label);
        setContentPane(viewHotelsPanel);
        revalidate();
        repaint();
    }

    private void switchToSimulateBookingPanel() {
        // Example: Replace center panel with SimulateBookingPanel
        JPanel simulateBookingPanel = new JPanel();
        simulateBookingPanel.setBackground(Color.WHITE);
        JLabel label = new JLabel("Simulate Booking Interface");
        simulateBookingPanel.add(label);
        setContentPane(simulateBookingPanel);
        revalidate();
        repaint();
    }
}
