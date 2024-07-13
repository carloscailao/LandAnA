import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.DocumentListener;

public class LandAnAGUI extends JFrame {
    ImageIcon logo = new ImageIcon("LandAnALogo1.png");
    final String mint = "#BFE7CC";
    final String green = "#3DAC78";
    final String sage = "#D8F3DC";

    private JButton btnCreateHotel;
    private JButton btnManageHotel;
    private JButton btnViewHotels;
    private JButton btnSimulateBooking;
    private JButton btnBack;
    private JButton btnEnter;

    private JTextField tfHotelName;

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
        btnCreateHotel = new JButton("Create Hotel");
        btnBack = new JButton("Back");
        btnEnter = new JButton("Enter");
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
        mainMenuPanel.setBackground(Color.decode(mint));
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));

        JLabel lblLandAnA = new JLabel("LandAnA");
        lblLandAnA.setForeground(Color.decode(green));
        lblLandAnA.setFont(new Font("Verdana", Font.BOLD, 40));
        ImageIcon logoDisplay = new ImageIcon(logo.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        lblLandAnA.setIcon(logoDisplay);
        lblLandAnA.setHorizontalTextPosition(JLabel.CENTER);
        lblLandAnA.setVerticalTextPosition(JLabel.BOTTOM);
        lblLandAnA.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuPanel.add(Box.createVerticalGlue());
        mainMenuPanel.add(lblLandAnA);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode(mint));
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

    public void createHotelPanel(ArrayList<String> hotelNames) {
        JPanel createHotelPanel = new JPanel();
        createHotelPanel.setBackground(Color.decode(mint));
        createHotelPanel.setLayout(new BorderLayout());

        // Top panel with GridBagLayout
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.decode(green));
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
        createHotelLabel.setForeground(Color.decode(sage));
        createHotelLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        topPanel.add(createHotelLabel, gbc);

        // Display current hotels at the south
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBackground(Color.decode(green));
        // Current Hotels label
        JLabel currHotels = new JLabel ("Current Hotels:", JLabel.CENTER);
        currHotels.setForeground(Color.decode(mint));
        currHotels.setFont(new Font("Arial", Font.BOLD, 20));
        southPanel.add(currHotels, BorderLayout.NORTH);
        // Display all current hotels
        JPanel hotelsPanel = new JPanel(new FlowLayout());
        hotelsPanel.setForeground((Color.decode(sage)));
        hotelsPanel.setBackground(Color.decode(green));
        for (String name : hotelNames) {
            JLabel hotelLabel = new JLabel(name);
            hotelsPanel.add(hotelLabel);
        }
        // Add note
        southPanel.add(hotelsPanel, BorderLayout.CENTER);
        JLabel note = new JLabel("note: each hotel must have a unique name", JLabel.CENTER);
        note.setForeground(Color.decode(sage));
        note.setFont(new Font("Arial", Font.ITALIC, 15));
        southPanel.add(note, BorderLayout.SOUTH);

        // center panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground((Color.decode(sage)));
        // Enter name
        JLabel enterName = new JLabel("Enter hotel name", JLabel.CENTER);
        enterName.setForeground(Color.decode(green));
        enterName.setFont(new Font("Arial", Font.BOLD, 20));
        centerPanel.add(enterName, BorderLayout.NORTH);
        // center center panel
        JPanel namePanel = new JPanel(new FlowLayout());
        namePanel.setBackground(Color.decode(sage));
        tfHotelName = new JTextField(20);
        namePanel.add(tfHotelName);
        namePanel.add(btnEnter);
        // TODO
        centerPanel.add(namePanel, BorderLayout.CENTER);


        // Add everything to createHotel panel
        createHotelPanel.add(topPanel, BorderLayout.NORTH);
        createHotelPanel.add(southPanel, BorderLayout.SOUTH);
        createHotelPanel.add(centerPanel, BorderLayout.CENTER);
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
