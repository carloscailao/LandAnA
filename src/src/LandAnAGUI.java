import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentListener;

import static javax.swing.BoxLayout.Y_AXIS;

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
    private JButton btnAddHotel;
    private JButton btnCreateRooms;

    private JTextField tfHotelName;

    private JSlider sldStandard;
    private JSlider sldDeluxe;
    private JSlider sldExecutive;

    private JLabel lblStd;
    private JLabel lblDeluxe;
    private JLabel lblExecutive;
    private JLabel lblTotal;

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
        btnAddHotel = new JButton("Add Hotel");
        btnManageHotel = new JButton("Manage Hotels");
        btnViewHotels = new JButton("View Hotels");
        btnSimulateBooking = new JButton("Simulate Booking");
        btnCreateRooms = new JButton("Create Rooms");

        tfHotelName = new JTextField(20);

        sldStandard = new JSlider(SwingConstants.HORIZONTAL, 0, 50, 1);
        sldDeluxe = new JSlider(SwingConstants.HORIZONTAL, 0, 50, 0);
        sldExecutive = new JSlider(SwingConstants.HORIZONTAL, 0, 50, 0);

        lblStd = new JLabel("Standard rooms: 1");
        lblDeluxe = new JLabel("Deluxe rooms: 0");
        lblExecutive = new JLabel("Executive rooms: 0");
        lblTotal = new JLabel("Total: 1");

        mainMenuPanel();
    }

    // Add action listeners to buttons
    public void setActionListener(ActionListener listener) {
        btnCreateHotel.addActionListener(listener);
        btnManageHotel.addActionListener(listener);
        btnSimulateBooking.addActionListener(listener);
        btnViewHotels.addActionListener(listener);
        btnBack.addActionListener(listener);
        btnAddHotel.addActionListener(listener);
        btnCreateRooms.addActionListener(listener);
    }

    public void setDocumentListener(DocumentListener listener) {
        tfHotelName.getDocument().addDocumentListener(listener);
    }

    public void setChangeListener(ChangeListener listener) {
        sldStandard.addChangeListener(listener);
        sldDeluxe.addChangeListener(listener);
        sldExecutive.addChangeListener(listener);
    }

    public void mainMenuPanel() {
        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setBackground(Color.decode(mint));
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, Y_AXIS));

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
            hotelLabel.setForeground(Color.decode(sage));
            hotelLabel.setFont(new Font("Verdana", Font.BOLD, 15));
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
        // center of center panel
        JPanel namePanel = new JPanel(new FlowLayout());
        namePanel.setBackground(Color.decode(sage));
        namePanel.add(tfHotelName);
        namePanel.add(btnAddHotel);
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

    public void notUniquePrompt(String hotelName) {
        JOptionPane.showMessageDialog(null, "Hotel " + hotelName + " already exists!");
    }

    public String getHotelName() {
        return tfHotelName.getText();
    }

    public void createRoomsPanel(Hotel hotel) {
        JPanel createRoomsPanel = new JPanel(new BorderLayout());
        createRoomsPanel.setBackground(Color.decode(mint));
        JLabel addRoomsLabel = new JLabel("Create Rooms for " + hotel.getHotelName(), JLabel.CENTER);
        addRoomsLabel.setForeground(Color.decode(green));
        addRoomsLabel.setBackground(Color.decode(green));
        addRoomsLabel.setFont(new Font("Verdana", Font.BOLD, 20));

        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, Y_AXIS));
        sliderPanel.setBackground(Color.decode(mint));

        sldStandard.setPaintLabels(true);
        sldStandard.setMajorTickSpacing(1);
        sldStandard.setFont(new Font("Verdana", Font.PLAIN, 8));
        sldStandard.setOrientation(SwingConstants.HORIZONTAL);
        sldStandard.setBackground(Color.decode(sage));
        sldStandard.setPreferredSize(new Dimension(400, 50));

        sldDeluxe.setPaintLabels(true);
        sldDeluxe.setMajorTickSpacing(1);
        sldDeluxe.setFont(new Font("Verdana", Font.PLAIN, 8));
        sldDeluxe.setOrientation(SwingConstants.HORIZONTAL);
        sldDeluxe.setBackground(Color.decode(sage));
        sldDeluxe.setPreferredSize(new Dimension(400, 50));

        sldExecutive.setPaintLabels(true);
        sldExecutive.setMajorTickSpacing(1);
        sldExecutive.setFont(new Font("Verdana", Font.PLAIN, 8));
        sldExecutive.setOrientation(SwingConstants.HORIZONTAL);
        sldExecutive.setBackground(Color.decode(sage));
        sldExecutive.setPreferredSize(new Dimension(400, 50));

        sliderPanel.add(lblStd);
        sliderPanel.add(sldStandard);
        sliderPanel.add(lblDeluxe);
        sliderPanel.add(sldDeluxe);
        sliderPanel.add(lblExecutive);
        sliderPanel.add(sldExecutive);
        sliderPanel.add(lblTotal);
        sliderPanel.add(btnCreateRooms);

        createRoomsPanel.add(addRoomsLabel, BorderLayout.NORTH);
        createRoomsPanel.add(sliderPanel, BorderLayout.CENTER);

        setContentPane(createRoomsPanel);
        revalidate();
        repaint();
    }

    // Getters for sliders and labels
    public JSlider getSldStandard() {
        return sldStandard;
    }

    public JSlider getSldDeluxe() {
        return sldDeluxe;
    }

    public JSlider getSldExecutive() {
        return sldExecutive;
    }

    public JLabel getLblStd() {
        return lblStd;
    }

    public JLabel getLblDeluxe() {
        return lblDeluxe;
    }

    public JLabel getLblExecutive() {
        return lblExecutive;
    }

    public JLabel getLblTotal() {
        return lblTotal;
    }

    public int getRoomsTotal() {
        return sldStandard.getValue()+sldDeluxe.getValue()+sldExecutive.getValue();
    }

    public void excessRoomsPrompt() {
        JOptionPane.showMessageDialog(null, "Maximum number of rooms is 50.");
    }

    public void lackingRoomsPrompt() {
        JOptionPane.showMessageDialog(null, "Minimum number of rooms is 1.");
    }

    public void successPrompt() {
        JOptionPane.showMessageDialog(null, "Success!");
    }

    public void noHotelsPrompt() {
        JOptionPane.showMessageDialog(null, "You have no hotels!");
    }
}
