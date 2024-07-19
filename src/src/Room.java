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

    public String getName() {
        return name;
    }

    public char getRoomIdentifier() {
        return name.charAt(0);
    }

    public boolean hasNoReservations() {
        if (reservations.size() == 0) {
            return true;
        }
        return false;
    }


}
