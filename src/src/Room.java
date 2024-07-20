import java.util.ArrayList;

public abstract class Room {
    final String name;
    private double price;
    private ArrayList<Reservation> reservations;

    public Room(String name, double price) {
        this.name = name;
        this.price = price;
        this.reservations = new ArrayList<>();
    }

    public abstract double calculateRate(double basePrice);

    public void updateBasePrice(double basePrice) {
        price = calculateRate(basePrice);
    }

    public String getName() {
        return name;
    }
    /*
    public char getRoomIdentifier() {
        return name.charAt(0);
    }
     */

    public boolean hasNoReservations() {
        return reservations.isEmpty();
    }


}
