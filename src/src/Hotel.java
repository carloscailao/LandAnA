import java.util.ArrayList;

public class Hotel {
    private String name;
    private double basePrice;
    private ArrayList<Room> rooms;
    private int nStdRooms;
    private int nDelRooms;
    private int nExeRooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.nStdRooms = 0;
        this.nDelRooms = 0;
        this.nExeRooms = 0;
        setHotelBasePrice(1299.0);
    }

    public void setHotelBasePrice(double price) {
        this.basePrice = price;
    }

    public String getHotelName() {
        return name;
    }

    public void createRooms (int std, int deluxe, int executive) {
            for (int i = 0; i < std; i++) {
                String name = "S" + nStdRooms + 1;
                rooms.add(new StandardRoom(name, basePrice));
                nStdRooms++;
            }
            for (int i = 0; i < deluxe; i++) {
                String name = "D" + nDelRooms + 1;
                rooms.add(new DeluxeRoom(name, basePrice));
                nDelRooms++;
            }
            for (int i = 0; i < executive; i++) {
                String name = "E" + nExeRooms + 1;
                rooms.add(new ExecutiveRoom(name, basePrice));
                nExeRooms++;
            }

    }

    public int getNStdRooms () {
        return nStdRooms;
    }
    public int getNDelRooms () {
        return nDelRooms;
    }
    public int getNExeRooms () {
        return nExeRooms;
    }

    public void setHotelName(String name) {
        this.name = name;
    }
}
