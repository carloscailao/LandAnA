import java.util.ArrayList;

public abstract class Room {
    final String name;
    private double rate;
    private ArrayList<Reservation> reservations;

    public Room(String name, double price) {
        this.name = name;
        this.rate = price;
        this.reservations = new ArrayList<>();
    }

    public abstract double updateRate(double basePrice);

    public void updateBasePrice(double basePrice) {
        rate = updateRate(basePrice);
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
    public void removeReservation(int iRes) {
        reservations.remove(iRes);
    }
    public ArrayList<String> getReservationNames () {
        ArrayList<String> names = new ArrayList<>();
        for (Reservation reservation : reservations) {
            names.add(reservation.getName());
        }
        return names;
    }

    public boolean isAvailable(int in, int out) {
        int i;
        for (i = 0; i < reservations.size(); i++) {
            if (in > reservations.get(i).getIn() && reservations.get(i).getOut() < in) {
                return false;
            }
            if (out > reservations.get(i).getIn() && in < reservations.get(i).getOut()) {
                return false;
            }
        }
        return true;
    }


}
