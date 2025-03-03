import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ChangeListener;

import static javax.swing.BoxLayout.Y_AXIS;

/**
 * Contains all Graphical User Interface components of LandAnA
 */
public class LandAnAGUI extends JFrame {
    ImageIcon logo = new ImageIcon("LandAnALogo1.png");
    final String mint = "#BFE7CC";
    final String green = "#3DAC78";
    final String sage = "#D8F3DC";

    private JButton btnBack;
    private JTextField tfName;
    private JComboBox<String> cBoxHotels;
    private JComboBox<String> cBoxRooms;
    private JComboBox<String> cBoxReservations;
    private JComboBox<Integer> cBoxDay;
    private JSpinner spnAddRooms;
    private JSpinner spnDouble;
    private JSpinner spnIn;
    private JSpinner spnOut;

    private JButton btnCreateHotel;
    private JButton btnManageHotels;
    private JButton btnViewHotels;
    private JButton btnSimulateBooking;

    private JButton btnAddHotel;
    private JButton btnCreateRooms;
    private JSlider sldStandard;
    private JSlider sldDeluxe;
    private JSlider sldExecutive;
    private JLabel lblStd;
    private JLabel lblDeluxe;
    private JLabel lblExecutive;
    private JLabel lblTotal;

    private JButton btnManageHotel;
    private JButton btnChangeName;
    private JButton btnAddStandardRoom;
    private JButton btnAddDeluxeRoom;
    private JButton btnAddExecutiveRoom;

    private JButton btnRemoveRoom;

    private JButton btnUpdateBasePrice;

    private JButton btnRemoveReservation;

    private JButton btnModifyDate;
    private JSlider sldRate;
    private JLabel lblRate;

    private JButton btnRemoveHotel;

    private JButton btnChooseHotel;
    private JTextField tfDiscount;
    private JButton btnCheckAvailable;

    private JButton btnViewHotel;
    private JButton btnCheckDate;
    private JButton btnCheckRoom;
    private JButton btnCheckReservation;

    /**
     * JFrame maker
     */
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

    /**
     * Initializes all components for user interaction
     */
    private void init() {
        btnCreateHotel = new JButton("Create Hotel");
        btnBack = new JButton("Back");
        btnAddHotel = new JButton("Add Hotel");
        btnManageHotels = new JButton("Manage Hotels");
        btnViewHotels = new JButton("View Hotels");
        btnSimulateBooking = new JButton("Simulate Booking");

        btnCreateRooms = new JButton("Create Rooms");

        btnManageHotel = new JButton("Manage Hotel");
        btnChangeName = new JButton("Change Hotel Name");
        btnAddStandardRoom = new JButton("Add Standard Rooms");
        btnAddDeluxeRoom = new JButton("Add Deluxe Rooms");
        btnAddExecutiveRoom = new JButton("Add Executive Rooms");
        btnRemoveRoom = new JButton("Remove Room");
        btnUpdateBasePrice = new JButton("Update Base Price");
        btnRemoveReservation = new JButton("Remove Reservation");
        btnRemoveHotel = new JButton("Remove Hotel");
        btnChooseHotel = new JButton("Choose Hotel");
        btnCheckAvailable = new JButton("Check Availability");
        btnModifyDate = new JButton("Modify Date Price");
        btnViewHotel = new JButton("View Hotel");
        btnCheckDate = new JButton("Check Date");
        btnCheckRoom = new JButton("Check Room");
        btnCheckReservation = new JButton("Check Reservation");

        tfName = new JTextField(20);
        tfDiscount = new JTextField(20);

        sldStandard = new JSlider(SwingConstants.HORIZONTAL, 0, 50, 1);
        sldDeluxe = new JSlider(SwingConstants.HORIZONTAL, 0, 50, 0);
        sldExecutive = new JSlider(SwingConstants.HORIZONTAL, 0, 50, 0);
        sldRate = new JSlider(SwingConstants.HORIZONTAL, 50, 150, 100);
        sldRate.setMajorTickSpacing(25); // Major ticks at 75%, 100%, and 125%
        sldRate.setMinorTickSpacing(5);  // Minor ticks every 5%
        sldRate.setPaintTicks(true);
        sldRate.setPaintLabels(true);

        lblStd = new JLabel("Standard rooms: 1");
        lblDeluxe = new JLabel("Deluxe rooms: 0");
        lblExecutive = new JLabel("Executive rooms: 0");
        lblTotal = new JLabel("Total: 1");
        lblRate = new JLabel("100%");

        cBoxHotels = new JComboBox<>();
        cBoxRooms = new JComboBox<>();
        cBoxReservations = new JComboBox<>();
        cBoxDay = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            cBoxDay.addItem(i);
        }

        spnAddRooms = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        spnDouble = new JSpinner(new SpinnerNumberModel(100.0, 100.0, Double.POSITIVE_INFINITY, 0.1));
        spnIn = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
        spnOut = new JSpinner(new SpinnerNumberModel(2, 2, 31, 1));

        mainMenuPanel();
    }

    /**
     * Adds listener to buttons
     * @param listener controller
     */
    public void setActionListener(ActionListener listener) {
        btnCreateHotel.addActionListener(listener);
        btnManageHotels.addActionListener(listener);
        btnSimulateBooking.addActionListener(listener);
        btnViewHotels.addActionListener(listener);
        btnBack.addActionListener(listener);
        btnAddHotel.addActionListener(listener);
        btnCreateRooms.addActionListener(listener);
        btnManageHotel.addActionListener(listener);
        btnChangeName.addActionListener(listener);
        btnAddStandardRoom.addActionListener(listener);
        btnAddDeluxeRoom.addActionListener(listener);
        btnAddExecutiveRoom.addActionListener(listener);
        btnRemoveRoom.addActionListener(listener);
        btnUpdateBasePrice.addActionListener(listener);
        btnRemoveReservation.addActionListener(listener);
        btnRemoveHotel.addActionListener(listener);
        btnChooseHotel.addActionListener(listener);
        btnCheckAvailable.addActionListener(listener);
        btnModifyDate.addActionListener(listener);
        btnViewHotel.addActionListener(listener);
        btnCheckDate.addActionListener(listener);
        btnCheckRoom.addActionListener(listener);
        btnCheckReservation.addActionListener(listener);
    }

    /**
     * Change listeners to sliders
     * @param listener controller
     */
    public void setChangeListener(ChangeListener listener) {
        sldStandard.addChangeListener(listener);
        sldDeluxe.addChangeListener(listener);
        sldExecutive.addChangeListener(listener);
        sldRate.addChangeListener(listener);
    }

    /**
     * Main menu of program
     */
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

        // Panel to modify date prices
        JPanel modifyDatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        modifyDatePanel.setBackground(Color.decode(mint));
        modifyDatePanel.add(cBoxDay);
        modifyDatePanel.add(btnModifyDate);

        buttonPanel.add(btnCreateHotel);
        buttonPanel.add(btnManageHotels);
        buttonPanel.add(btnViewHotels);
        buttonPanel.add(btnSimulateBooking);
        buttonPanel.add(modifyDatePanel);

        mainMenuPanel.add(buttonPanel);
        mainMenuPanel.add(Box.createVerticalGlue());

        setContentPane(mainMenuPanel);
        revalidate();
        repaint();
    }

    /**
     * Creation of hotel GUI
     * @param hotelNames list of all current hotel names
     */
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
        tfName.setText("");
        namePanel.add(tfName);
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

    /**
     * Selection of hotel to manage
     */
    public void manageHotelsPanel() {
        JPanel manageHotelsPanel = new JPanel();
        manageHotelsPanel.setBackground(Color.decode(mint));
        manageHotelsPanel.setLayout(new BorderLayout());

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
        JLabel manageHotelsLabel = new JLabel("Manage Hotels", JLabel.CENTER);
        manageHotelsLabel.setForeground(Color.decode(sage));
        manageHotelsLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        topPanel.add(manageHotelsLabel, gbc);

        JPanel chooseHotelPanel = new JPanel();
        chooseHotelPanel.setLayout(new BoxLayout(chooseHotelPanel, Y_AXIS));
        chooseHotelPanel.setBackground(Color.decode(mint));

        JLabel chooseHotelLabel = new JLabel("Choose hotel:");
        chooseHotelPanel.setForeground(Color.decode(green));
        chooseHotelLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        chooseHotelLabel.setForeground(Color.decode(green));
        chooseHotelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        chooseHotelPanel.add(chooseHotelLabel);

        JPanel hotelsPanel = new JPanel();
        hotelsPanel.setLayout(new FlowLayout());
        hotelsPanel.setBackground(Color.decode(mint));
        hotelsPanel.add(cBoxHotels);
        hotelsPanel.add(btnManageHotel);
        chooseHotelPanel.add(hotelsPanel);

        manageHotelsPanel.add(chooseHotelPanel, BorderLayout.CENTER);
        manageHotelsPanel.add(topPanel, BorderLayout.NORTH);
        setContentPane(manageHotelsPanel);
        revalidate();
        repaint();
    }

    /**
     * Entails all managerial functions GUI
     * @param hotel hotel of operation
     */
    public void manageHotelPanel(Hotel hotel) {
        JPanel manageHotelPanel = new JPanel();
        manageHotelPanel.setBackground(Color.decode(mint));
        manageHotelPanel.setLayout(new BorderLayout());

        // Top panel with GridBagLayout
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.decode(green));
        GridBagConstraints gbc = new GridBagConstraints();
        // Back button
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(btnBack, gbc);
        // Create Hotel label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel manageHotelLabel = new JLabel("Manage Hotel " + hotel.getHotelName(), JLabel.CENTER);
        manageHotelLabel.setForeground(Color.decode(sage));
        manageHotelLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        topPanel.add(manageHotelLabel, gbc);

        JPanel managePanel = new JPanel();
        managePanel.setLayout(new BoxLayout(managePanel, BoxLayout.Y_AXIS));
        managePanel.setBackground(Color.decode(mint));

        // Change Hotel Name section
        JPanel changeNamePanel = new JPanel();
        changeNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // No gaps
        changeNamePanel.setBackground(Color.decode(mint));
        tfName.setPreferredSize(new Dimension(200, 30)); // Set preferred size for the text field
        tfName.setText("");
        changeNamePanel.add(tfName);
        changeNamePanel.add(btnChangeName);
        managePanel.add(changeNamePanel);

        // Buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // No gaps
        buttonsPanel.setBackground(Color.decode(mint));
        buttonsPanel.add(btnAddStandardRoom);
        buttonsPanel.add(btnAddDeluxeRoom);
        buttonsPanel.add(btnAddExecutiveRoom);
        managePanel.add(buttonsPanel);

        // Panel to hold remove room button
        JPanel removeRoomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)); // No gaps
        removeRoomPanel.setBackground(Color.decode(mint));
        removeRoomPanel.add(btnRemoveRoom);
        managePanel.add(removeRoomPanel);

        // Panel to update base price
        JPanel updatePricePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        updatePricePanel.setBackground(Color.decode(mint));
        spnDouble.setPreferredSize(new Dimension(200,30));
        updatePricePanel.add(spnDouble);
        updatePricePanel.add(btnUpdateBasePrice);
        managePanel.add(updatePricePanel);

        // Panel to remove reservation
        JPanel removeReservationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        removeReservationPanel.setBackground(Color.decode(mint));
        removeReservationPanel.add(btnRemoveReservation);
        managePanel.add(removeReservationPanel);

        // Panel to delete hotel
        JPanel removeHotelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        removeHotelPanel.setBackground(Color.decode(mint));
        removeHotelPanel.add(btnRemoveHotel);
        managePanel.add(removeHotelPanel);

        manageHotelPanel.add(topPanel, BorderLayout.NORTH);
        manageHotelPanel.add(managePanel, BorderLayout.CENTER);
        setContentPane(manageHotelPanel);
        revalidate();
        repaint();
    }

    /**
     * Selection of hotel to view
     */
    public void viewHotelsPanel() {
        JPanel viewHotelsPanel = new JPanel();
        viewHotelsPanel.setBackground(Color.decode(mint));
        viewHotelsPanel.setLayout(new BorderLayout());

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
        JLabel viewHotelsLabel = new JLabel("View Hotels", JLabel.CENTER);
        viewHotelsLabel.setForeground(Color.decode(sage));
        viewHotelsLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        topPanel.add(viewHotelsLabel, gbc);

        JPanel chooseHotelPanel = new JPanel();
        chooseHotelPanel.setLayout(new BoxLayout(chooseHotelPanel, Y_AXIS));
        chooseHotelPanel.setBackground(Color.decode(mint));

        JLabel chooseHotelLabel = new JLabel("Choose hotel:");
        chooseHotelPanel.setForeground(Color.decode(green));
        chooseHotelLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        chooseHotelLabel.setForeground(Color.decode(green));
        chooseHotelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        chooseHotelPanel.add(chooseHotelLabel);

        JPanel hotelsPanel = new JPanel();
        hotelsPanel.setLayout(new FlowLayout());
        hotelsPanel.setBackground(Color.decode(mint));
        hotelsPanel.add(cBoxHotels);
        hotelsPanel.add(btnViewHotel);
        chooseHotelPanel.add(hotelsPanel);

        viewHotelsPanel.add(chooseHotelPanel, BorderLayout.CENTER);
        viewHotelsPanel.add(topPanel, BorderLayout.NORTH);
        setContentPane(viewHotelsPanel);
        revalidate();
        repaint();
    }

    /**
     * Entails all view features of hotel
     * @param hotel hotel of operations
     */
    public void viewHotelPanel(Hotel hotel) {
        JPanel viewHotelPanel = new JPanel();
        viewHotelPanel.setBackground(Color.decode(mint));
        viewHotelPanel.setLayout(new BorderLayout());

        // Top panel with GridBagLayout
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.decode(green));
        GridBagConstraints gbc = new GridBagConstraints();
        // Back button
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(btnBack, gbc);
        // Create Hotel label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel lblView = new JLabel("View Hotel " + hotel.getHotelName(), JLabel.CENTER);
        lblView.setForeground(Color.decode(mint));
        lblView.setFont(new Font("Verdana", Font.BOLD, 30));
        topPanel.add(lblView, gbc);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.decode(mint));

        // Top of center panel with BoxLayout
        JPanel topCenterPanel = new JPanel();
        topCenterPanel.setLayout(new BoxLayout(topCenterPanel, BoxLayout.Y_AXIS));
        topCenterPanel.setBackground(Color.decode(mint));

        // Add three labels
        JLabel lblName = new JLabel("Hotel Name: " + hotel.getHotelName(), JLabel.CENTER);
        lblName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblName.setForeground(Color.decode(green));
        lblName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblRooms = new JLabel("Standard Rooms: " + hotel.getNStdRooms() +
                                        " Deluxe Rooms: " + hotel.getNDelRooms() +
                                        " Executive Rooms: " + hotel.getNExeRooms() +
                                        " Total Rooms: " + hotel.getTotalRooms(), JLabel.CENTER);
        lblRooms.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblRooms.setForeground(Color.decode(green));
        lblRooms.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblEstEarnings = new JLabel("Estimated Earnings: " + hotel.getEstEarnings(), JLabel.CENTER);
        lblEstEarnings.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblEstEarnings.setForeground(Color.decode(green));
        lblEstEarnings.setAlignmentX(Component.CENTER_ALIGNMENT);

        topCenterPanel.add(lblName);
        topCenterPanel.add(lblRooms);
        topCenterPanel.add(lblEstEarnings);

        JPanel midCenterPanel = new JPanel();
        midCenterPanel.setLayout(new BoxLayout(midCenterPanel, BoxLayout.Y_AXIS));
        midCenterPanel.setBackground(Color.decode(mint));
        centerPanel.add(topCenterPanel, BorderLayout.NORTH);

        JPanel checkDatePanel = new JPanel();
        checkDatePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        checkDatePanel.setBackground(Color.decode(mint));
        checkDatePanel.add(cBoxDay);
        checkDatePanel.add(btnCheckDate);
        midCenterPanel.add(checkDatePanel);

        JPanel checkRoomPanel = new JPanel();
        checkRoomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        checkRoomPanel.setBackground(Color.decode(mint));
        checkRoomPanel.add(cBoxRooms);
        checkRoomPanel.add(btnCheckRoom);
        midCenterPanel.add(checkRoomPanel);

        JPanel checkResPanel = new JPanel();
        checkResPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        checkResPanel.setBackground(Color.decode(mint));
        checkResPanel.add(cBoxReservations);
        checkResPanel.add(btnCheckReservation);
        midCenterPanel.add(checkResPanel);

        centerPanel.add(midCenterPanel, BorderLayout.CENTER);

        viewHotelPanel.add(topPanel, BorderLayout.NORTH);
        viewHotelPanel.add(centerPanel, BorderLayout.CENTER);
        setContentPane(viewHotelPanel);
        revalidate();
        repaint();
    }

    /**
     * Selection of hotel upon simulation of booking
     */
    public void simulateBookingPanel() {
        JPanel simulateBookingPanel = new JPanel();
        simulateBookingPanel.setBackground(Color.decode(mint));
        simulateBookingPanel.setLayout(new BorderLayout());

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
        JLabel manageHotelsLabel = new JLabel("Simulate Booking", JLabel.CENTER);
        manageHotelsLabel.setForeground(Color.decode(sage));
        manageHotelsLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        topPanel.add(manageHotelsLabel, gbc);

        JPanel chooseHotelPanel = new JPanel();
        chooseHotelPanel.setLayout(new BoxLayout(chooseHotelPanel, Y_AXIS));
        chooseHotelPanel.setBackground(Color.decode(mint));

        JLabel chooseHotelLabel = new JLabel("Choose hotel:");
        chooseHotelPanel.setForeground(Color.decode(green));
        chooseHotelLabel.setFont(new Font("Verdana", Font.BOLD, 20));
        chooseHotelLabel.setForeground(Color.decode(green));
        chooseHotelLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        chooseHotelPanel.add(chooseHotelLabel);

        JPanel hotelsPanel = new JPanel();
        hotelsPanel.setLayout(new FlowLayout());
        hotelsPanel.setBackground(Color.decode(mint));
        hotelsPanel.add(cBoxHotels);
        hotelsPanel.add(btnChooseHotel);
        chooseHotelPanel.add(hotelsPanel);

        simulateBookingPanel.add(chooseHotelPanel, BorderLayout.CENTER);
        simulateBookingPanel.add(topPanel, BorderLayout.NORTH);
        setContentPane(simulateBookingPanel);
        revalidate();
        repaint();
    }

    /**
     * Entails all features of hotel booking
     * @param hotel hotel of operation
     */
    public void bookingPanel(Hotel hotel) {
        JPanel bookingPanel = new JPanel();
        bookingPanel.setBackground(Color.decode(mint));
        bookingPanel.setLayout(new BorderLayout());

        // Top panel with GridBagLayout
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.decode(green));
        GridBagConstraints gbc = new GridBagConstraints();
        // Back button
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(btnBack, gbc);
        // Create Hotel label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel bookingLabel = new JLabel("Booking in hotel " + hotel.getHotelName(), JLabel.CENTER);
        bookingLabel.setForeground(Color.decode(sage));
        bookingLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        topPanel.add(bookingLabel, gbc);

        JPanel guestPanel = new JPanel();
        guestPanel.setLayout(new BoxLayout(guestPanel, BoxLayout.Y_AXIS));
        guestPanel.setBackground(Color.decode(mint));

        // name
        JPanel guestNamePanel = new JPanel();
        guestNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JLabel guestNameLabel = new JLabel("(REQUIRED) Name: ");
        guestNamePanel.setBackground(Color.decode(mint));
        guestNamePanel.setForeground(Color.decode(green));
        tfName.setText("");
        tfName.setPreferredSize(new Dimension(200, 30));
        guestNamePanel.add(guestNameLabel);
        guestNamePanel.add(tfName);
        guestPanel.add(guestNamePanel);

        // in and out
        JPanel inOutPanel = new JPanel();
        inOutPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JLabel inLabel = new JLabel("Check in: ");
        JLabel outLabel = new JLabel("Check out: ");
        inOutPanel.setBackground(Color.decode(mint));
        inOutPanel.setForeground(Color.decode(green));
        inOutPanel.add(inLabel);
        inOutPanel.add(spnIn);
        inOutPanel.add(outLabel);
        inOutPanel.add(spnOut);
        guestPanel.add(inOutPanel);

        //discount code
        JPanel discountPanel = new JPanel();
        discountPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        discountPanel.setBackground(Color.decode(mint));
        JLabel lblDiscount = new JLabel("(OPTIONAL) Discount code: ");
        tfDiscount.setText("");
        tfDiscount.setPreferredSize(new Dimension(200, 30));
        discountPanel.add(lblDiscount);
        discountPanel.add(tfDiscount);
        guestPanel.add(discountPanel);


        // check availability
        JPanel checkPanel = new JPanel();
        checkPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        checkPanel.setBackground(Color.decode(mint));
        checkPanel.add(btnCheckAvailable);
        guestPanel.add(checkPanel);

        bookingPanel.add(topPanel, BorderLayout.NORTH);
        bookingPanel.add(guestPanel, BorderLayout.CENTER);
        setContentPane(bookingPanel);
        revalidate();
        repaint();
    }

    /**
     * Prompt for not unique hotel name
     * @param hotelName attempted new hotel name
     */
    public void notUniquePrompt(String hotelName) {
        JOptionPane.showMessageDialog(null, "Hotel " + hotelName + " already exists!");
    }

    /**
     * Gets text field text for name
     * @return tfName
     */
    public String getTfNameText() {
        return tfName.getText();
    }

    /**
     * Creation of multiple rooms upon creation of hotel
     * @param hotel hotel of operation
     */
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

    /**
     * Gets slider for standard rooms creation
     * @return slider for standard rooms creation
     */
    public JSlider getSldStandard() {
        return sldStandard;
    }

    /**
     * Gets slider for deluxe rooms creation
     * @return slider for deluxe rooms creation
     */
    public JSlider getSldDeluxe() {
        return sldDeluxe;
    }

    /**
     * Gets slider for executive rooms creation
     * @return slider for executive rooms creation
     */
    public JSlider getSldExecutive() {
        return sldExecutive;
    }

    /**
     * Gets label for standard rooms count
     * @return label for standard rooms count
     */
    public JLabel getLblStd() {
        return lblStd;
    }

    /**
     * Gets label for deluxe rooms count
     * @return label for deluxe rooms count
     */
    public JLabel getLblDeluxe() {
        return lblDeluxe;
    }

    /**
     * Gets label for executive rooms count
     * @return label for executive rooms count
     */
    public JLabel getLblExecutive() {
        return lblExecutive;
    }

    /**
     * Gets label for total rooms count
     * @return label for total rooms count
     */
    public JLabel getLblTotal() {
        return lblTotal;
    }

    /**
     * Gets total number of rooms based on slider value
     * @return total number of rooms based on slider value
     */
    public int getRoomsTotal() {
        return sldStandard.getValue()+sldDeluxe.getValue()+sldExecutive.getValue();
    }

    /**
     * Prompt for maximum number of rooms
     */
    public void excessRoomsPrompt() {
        JOptionPane.showMessageDialog(null, "Maximum number of rooms is 50.");
    }

    /**
     * Prompt for minimum number of rooms
     */
    public void lackingRoomsPrompt() {
        JOptionPane.showMessageDialog(null, "Minimum number of rooms is 1.");
    }

    /**
     * Prompt for success of operation
     */
    public void successPrompt() {
        JOptionPane.showMessageDialog(null, "Success!");
    }

    /**
     * Prompt for no hotels yet
     */
    public void noHotelsPrompt() {
        JOptionPane.showMessageDialog(null, "You have no hotels!");
    }

    /**
     * Gets combo box of hotels
     * @return combo box of hotels
     */
    public JComboBox<String> getcBoxHotels() {
        return cBoxHotels;
    }

    /**
     * Prompt for an empty field
     */
    public void emptyFieldPrompt() {
        JOptionPane.showMessageDialog(null, "Empty field!");
    }

    /**
     * Confirmation prompt
     * @return user confirmation option
     */
    public int confirmPrompt() {
        return JOptionPane.showConfirmDialog(null, "Confirm changes?");
    }

    /**
     * Prompt for adding rooms
     * @return user option
     */
    public int addRoomPrompt() {
        return JOptionPane.showOptionDialog(null, spnAddRooms, "Enter number of rooms to add: ",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    }

    /**
     * Gets value of spinner of number of rooms
     * @return value of spinner of number of rooms
     */
    public int getSpnValue() {
        return (int)spnAddRooms.getValue();
    }

    /**
     * Prompt for picking a room
     * @return user option
     */
    public int pickRoomPrompt() {
        return JOptionPane.showOptionDialog(null, cBoxRooms,"Choose room: ",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    }

    /**
     * Gets combo box of room names
     * @return cBoxRooms
     */
    public JComboBox<String> getcBoxRooms() {
        return cBoxRooms;
    }

    /**
     * Updates combo box of room names
     * @param rooms array list of room names
     */
    public void updatecBoxRooms(ArrayList<String> rooms) {
        cBoxRooms.removeAllItems();
        for (String name : rooms) {
            cBoxRooms.addItem(name);
        }
    }

    /**
     * Gets value of spinner for double
     * @return value of spinner for double
     */
    public double getSpnDouble() {
        return (double)spnDouble.getValue();
    }

    /**
     * Prompt for minimum base price
     */
    public void minBasePrompt() {
        JOptionPane.showMessageDialog(null, "Minimum base price is 100.0");
    }

    /**
     * Prompt for ongoing reservations
     */
    public void stillHasReservationsPrompt() {
        JOptionPane.showMessageDialog(null, "There are ongoing reservations.");
    }

    /**
     * Updates combo box of reservation names
     * @param reservations array list of reservation names
     */
    public void updatecBoxReservations(ArrayList<String> reservations) {
        cBoxReservations.removeAllItems();
        for (String name : reservations) {
            cBoxReservations.addItem(name);
        }
    }

    /**
     * Prompt for picking a reservation
     * @return user option
     */
    public int pickReservationPrompt() {
        return JOptionPane.showOptionDialog(null, cBoxReservations, "Choose a reservation: ",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,null,null,null);
    }

    /**
     * Gets combo box of reservation names
     * @return cBoxReservations
     */
    public JComboBox<String> getcBoxReservations() {
        return cBoxReservations;
    }

    /**
     * Updates combo box of hotel names
     * @param hotels array list of hotel names
     */
    public void updatecBoxHotels(ArrayList<String> hotels) {
        cBoxHotels.removeAllItems();
        for (String name : hotels) {
            cBoxHotels.addItem(name);
        }
    }

    /**
     * Gets check in date
     * @return check in date
     */
    public int getIn() {
        return (int)spnIn.getValue();
    }

    /**
     * Gets check out date
     * @return check out date
     */
    public int getOut() {
        return (int)spnOut.getValue();
    }

    /**
     * Gets date to be modified
     * @return date to be modified
     */
    public int getModifyDate() {
        return (int)cBoxDay.getSelectedItem();
    }

    /**
     * Prompt for date rete modification
     * @return user option
     */
    public int modifyDatePrompt() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, Y_AXIS));
        panel.add(sldRate);
        panel.add(lblRate);
        return JOptionPane.showOptionDialog(null, panel, "Set date price rate: ",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 100);
    }

    /**
     * Gets rate value of sldRate
     * @return value of sldRate
     */
    public int getRate() {
        return sldRate.getValue();
    }

    /**
     * Gets sldRate
     * @return sldRate
     */
    public JSlider getSldRate() {
        return sldRate;
    }

    /**
     * Gets lblRate
     * @return lblRate
     */
    public JLabel getLblRate() {
        return lblRate;
    }

    /**
     * Gets text in discount code text field
     * @return discount code in text field
     */
    public String getTfDiscountText() {
        return tfDiscount.getText();
    }

    /**
     * Prompt for invalid discount code
     */
    public void invalidDiscountPrompt() {
        JOptionPane.showMessageDialog(null, "Invalid discount code");
    }

    /**
     * Prompt for invalid date
     */
    public void invalidDatePrompt() {
        JOptionPane.showMessageDialog(null, "Invalid dates");
    }

    /**
     * Prompt for no room available
     */
    public void noRoomsAvailablePrompt() {
        JOptionPane.showMessageDialog(null, "No rooms available.");
    }

    /**
     *  Prompt for feature view date
     * @param nAvail number of available rooms in a date
     * @param nBooked number of booked rooms in a date
     */
    public void checkDatePrompt(int nAvail, int nBooked) {
        JPanel dateInfoPanel = new JPanel();
        dateInfoPanel.setLayout(new GridLayout(2, 1, 0, 0)); // 2 rows, 1 column

        JLabel lblAvailRooms = new JLabel("Number of available Rooms: " + nAvail);
        JLabel lblBookedRooms = new JLabel("Number of booked Rooms: " + nBooked);

        dateInfoPanel.add(lblAvailRooms);
        dateInfoPanel.add(lblBookedRooms);

        JOptionPane.showMessageDialog(null, dateInfoPanel, "Date Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Gets selected day
     * @return selected day name
     */
    public int getDay() {
        return (int)cBoxDay.getSelectedItem();
    }

    /**
     * Prompt for feature view room
     * @param name name of room
     * @param rate rate of room
     * @param dates array list of dates available in room
     */
    public void checkRoomPrompt(String name, double rate, ArrayList<Integer> dates) {
        JPanel roomInfoPanel = new JPanel();
        roomInfoPanel.setLayout(new GridLayout(3, 1, 0, 0)); // 3 rows, 1 column

        JLabel lblName = new JLabel("Name: " + name);
        JLabel lblRate = new JLabel("Rate: " + rate);

        // Concatenate all dates into a single string
        StringBuilder datesStr = new StringBuilder("Available Dates: ");
        for (Integer date : dates) {
            datesStr.append(date).append(" ");
        }
        JLabel lblDates = new JLabel(datesStr.toString().trim());

        roomInfoPanel.add(lblName);
        roomInfoPanel.add(lblRate);
        roomInfoPanel.add(lblDates);

        JOptionPane.showMessageDialog(null, roomInfoPanel, "Room Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Prompt for feature view reservation
     * @param room room the reservation is in
     * @param reservation reservation selected
     */
    public void checkReservationPrompt(Room room, Reservation reservation) {
        JPanel resInfoPanel = new JPanel();
        resInfoPanel.setLayout(new GridLayout(10, 1, 0, 0)); // 10 rows, 1 column

        JLabel lblGuest = new JLabel("Guest: " + reservation.getGuestName());
        JLabel lblRoom = new JLabel("Room: " + room.getName());
        JLabel lblCheck = new JLabel("Check in: " + reservation.getIn() + " Check out: " + reservation.getOut());
        JLabel lblCost = new JLabel("Cost Breakdown:");
        JLabel lblRoomRate = new JLabel(" | Room Rate: " + room.getRate());

        // Create a string for modified dates
        StringBuilder modifiedDates = new StringBuilder(" | Dates Modified: ");
        for (Day day : reservation.getSpecialDays()) {
            modifiedDates.append(day.getName())
                    .append(" (")
                    .append(day.getRate())
                    .append("), ");
        }
        // Remove the last comma and space
        if (!modifiedDates.isEmpty()) {
            modifiedDates.setLength(modifiedDates.length() - 2);
        }
        JLabel lblModify = new JLabel(modifiedDates.toString());

        JLabel lblStayed = new JLabel(" | Days Stayed: " + reservation.getDaysStayed());
        JLabel lblFree = new JLabel(" | Days Free: " + reservation.getFree());
        JLabel lblDiscount = new JLabel(" | Discount Rate: " + reservation.getDiscount());
        JLabel lblTotal = new JLabel("Total cost: " + reservation.getNetPrice());

        resInfoPanel.add(lblGuest);
        resInfoPanel.add(lblRoom);
        resInfoPanel.add(lblCheck);
        resInfoPanel.add(lblCost);
        resInfoPanel.add(lblRoomRate);
        resInfoPanel.add(lblModify);
        resInfoPanel.add(lblStayed);
        resInfoPanel.add(lblFree);
        resInfoPanel.add(lblDiscount);
        resInfoPanel.add(lblTotal);

        JOptionPane.showMessageDialog(null, resInfoPanel, "Reservation Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
