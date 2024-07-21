public class LandAnADriver {
    public static void main(String[] args) {
        LandAnAGUI gui = new LandAnAGUI();
        LandAnAManager manager = new LandAnAManager();
        LandAnAController controller = new LandAnAController(gui, manager);
    }
}