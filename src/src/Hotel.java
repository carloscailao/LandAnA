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
        for (Room room : rooms) {
            room.updateBasePrice(basePrice);
        }
    }

    public String getHotelName() {
        return name;
    }

    public void createRooms (int std, int deluxe, int executive) {
            for (int i = 0; i < std; i++) {
                String name = "S" + (nStdRooms + 1);
                rooms.add(new StandardRoom(name, basePrice));
                System.out.println("Standard room created");
                nStdRooms++;
            }
            for (int i = 0; i < deluxe; i++) {
                String name = "D" + (nDelRooms + 1);
                rooms.add(new DeluxeRoom(name, basePrice));
                System.out.println("Deluxe room created");
                nDelRooms++;
            }
            for (int i = 0; i < executive; i++) {
                String name = "E" + (nExeRooms + 1);
                rooms.add(new ExecutiveRoom(name, basePrice));
                System.out.println("Executive room created");
                nExeRooms++;
            }

    }
    /*
    public void setNStdRooms (int n) {
        nStdRooms = n;
    }
    public void setNDelRooms (int n) {
        nDelRooms = n;
    }
    public void setNExeRooms (int n) {
        nExeRooms = n;
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
    */
    public int getTotalRooms() {
        System.out.println("Number of rooms: " +rooms.size() + "in hotel" +name);
        return rooms.size();
    }
    public void setHotelName(String name) {
        this.name = name;
    }
    public ArrayList<String> getRoomsNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Room room : rooms) {
            names.add(room.getName());
        }
        return names;
    }
    public boolean roomHasNoReservations (int roomIndex) {
        return rooms.get(roomIndex).hasNoReservations();
    }
    public void deleteRoom (int iRoom) {
        rooms.remove(iRoom);
    }
    /*
    public Room getRoom(int i) {
        return rooms.get(i);
    }
     */
    public boolean hasNoReservations () {
        for (Room room : rooms) {
            if (!room.hasNoReservations()) {
                return false;
            }
        }
        return true;
    }
}
