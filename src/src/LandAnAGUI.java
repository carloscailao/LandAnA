import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentListener;

import static javax.swing.SwingConstants.WEST;

public class LandAnAGUI extends JFrame {
    ImageIcon logo = new ImageIcon("LandAnALogo1.png");
    final String  bgColor = "#BFE7CC";
    final String fontColor = "#3DAC78";
    final String lightFontColor = "#D8F3DC";

    private JButton btnCreateHotel;
    private JButton btnManageHotel;
    private JButton btnViewHotels;
    private JButton btnSimulateBooking;
    private JButton btnBack;

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
        btnBack = new JButton("Back");
        btnCreateHotel = new JButton("Create Hotel");
        btnManageHotel = new JButton("Manage Hotels");
        btnViewHotels = new JButton("View Hotels");
        btnSimulateBooking = new JButton("Simulate Booking");
        mainMenuPanel();
    }

    // Add action listeners to buttons
    public void setActionListener(ActionListener listener) {
        btnCreateHotel.addActionListener(listener);
        btnManageHotel.addActionListener(listener);
        btnSimulateBooking.addActionListener(listener);
        btnViewHotels.addActionListener(listener);
        btnBack.addActionListener(listener);
    }

    public void setDocumentListener(DocumentListener listener) {

    }

    public void mainMenuPanel() {
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setBackground(Color.decode(bgColor));
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));

        JLabel lblLandAnA = new JLabel("LandAnA");
        lblLandAnA.setForeground(Color.decode(fontColor));
        lblLandAnA.setFont(new Font("Verdana", Font.BOLD, 40));
        ImageIcon logoDisplay = new ImageIcon(logo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        lblLandAnA.setIcon(logoDisplay);
        lblLandAnA.setHorizontalTextPosition(JLabel.CENTER);
        lblLandAnA.setVerticalTextPosition(JLabel.BOTTOM);
        lblLandAnA.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuPanel.add(Box.createVerticalGlue());
        mainMenuPanel.add(lblLandAnA);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode(bgColor));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        buttonPanel.add(btnCreateHotel);
        buttonPanel.add(btnManageHotel);
        buttonPanel.add(btnViewHotels);
        buttonPanel.add(btnSimulateBooking);

        mainMenuPanel.add(buttonPanel);
        mainMenuPanel.add(Box.createVerticalGlue());

        setContentPane(mainMenuPanel);
        revalidate();
        repaint();
    }

    public void createHotelPanel() {
        JPanel createHotelPanel = new JPanel();
        createHotelPanel.setBackground(Color.decode(bgColor));
        createHotelPanel.setLayout(new BorderLayout());

        // Top panel with GridBagLayout
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.decode(fontColor));
        GridBagConstraints gbc = new GridBagConstraints();

        // Back button
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(btnBack, gbc);

        // Create Hotel label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel createHotelLabel = new JLabel("Create Hotel", JLabel.CENTER);
        createHotelLabel.setForeground(Color.decode(lightFontColor));
        createHotelLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        topPanel.add(createHotelLabel, gbc);

        createHotelPanel.add(topPanel, BorderLayout.NORTH);
        setContentPane(createHotelPanel);
        revalidate();
        repaint();
    }
    // Methods to switch panels or frames

    public void manageHotelPanel() {
        // Example: Replace center panel with ManageHotelsPanel
        JPanel manageHotelsPanel = new JPanel();
        manageHotelsPanel.setBackground(Color.WHITE);
        JLabel label = new JLabel("Manage Hotels Interface");
        manageHotelsPanel.add(label);
        setContentPane(manageHotelsPanel);
        revalidate();
        repaint();
    }

    public void viewHotelsPanel() {
        // Example: Replace center panel with ViewHotelsPanel
        JPanel viewHotelsPanel = new JPanel();
        viewHotelsPanel.setBackground(Color.WHITE);
        JLabel label = new JLabel("View Hotels Interface");
        viewHotelsPanel.add(label);
        setContentPane(viewHotelsPanel);
        revalidate();
        repaint();
    }

    public void simulateBookingPanel() {
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
