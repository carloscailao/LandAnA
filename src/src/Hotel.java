import java.util.ArrayList;

public class Hotel {
    private String name;
    private double basePrice;
    private ArrayList<Room> rooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<Room>();
        setHotelBasePrice(1299.0);
        createRoom();
    }

    public void setHotelBasePrice(double price) {
        this.basePrice = price;
    }

    public void createRoom() {

    }

    public String getHotelName() {
        return name;
    }
}
