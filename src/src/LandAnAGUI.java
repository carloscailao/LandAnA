import javax.swing.*;
import java.awt.*;

public class LandAnAGUI extends JFrame{

    public LandAnAGUI () {
        super("LandAnA");
        setLayout(new BorderLayout());

        setSize(1000, 750);
        init();

        setVisible(true);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        ImageIcon logo = new ImageIcon("LandAnALogo1.png");
        setIconImage(logo.getImage());

        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.decode("#3DAC78"));

        JLabel lblLandAnA = new JLabel("LandAnA");
        lblLandAnA.setForeground(Color.decode("#D8F3DC"));
        lblLandAnA.setFont(new Font("Verdana", Font.BOLD, 20));
        //lblLandAnA.setIcon(logo);
        lblLandAnA.setBounds(0,0,200,200);

        panelNorth.add(lblLandAnA);

        this.add(panelNorth, BorderLayout.NORTH);
    }
}
