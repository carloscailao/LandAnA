/**
 * Instantiates Model, View, and Controller
 */
public class LandAnADriver {

    /**
     * Main
     * @param args args
     */
    public static void main(String[] args) {
        LandAnAGUI gui = new LandAnAGUI();
        LandAnAManager manager = new LandAnAManager();
        LandAnAController controller = new LandAnAController(gui, manager);
    }
}