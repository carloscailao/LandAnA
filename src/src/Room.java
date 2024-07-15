import java.util.ArrayList;

public class Room {
    final String name;
    final double price;
    private ArrayList<Reservation> reservations;

    public Room(String name, double price) {
        this.name = name;
        this.price = price;
        this.reservations = new ArrayList<>();
    }

    public char getRoomIdentifier() {
        return name.charAt(0);
    }


}
