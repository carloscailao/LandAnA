import java.util.ArrayList;

public abstract class Room {
    private String name;
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

    public boolean isAvailable(int newIn, int newOut) {
        for (Reservation reservation : reservations) {
            int existingIn = reservation.getIn();
            int existingOut = reservation.getOut();

            if ((existingIn < newIn && newIn < existingOut) || // Condition 1
                    (existingIn < newOut && newOut < existingOut) || // Condition 2
                    (newIn <= existingIn && newOut >= existingOut) || // Condition 3
                    (existingIn <= newIn && existingOut >= newOut)) { // Condition 4
                return false;
            }
        }
        return true;
    }
    public void newReservation(String guest, ArrayList<Day> days) {
        double grossPrice = 0.0;
        for (int i = 0; i < days.size() - 1; i++) {
            grossPrice += days.get(i).getRate() * rate;
        }
        reservations.add(new Reservation(name, guest, grossPrice, days));
    }
    public void newReservation(String guest, double discount, boolean firstFree, ArrayList<Day> days) {
        double grossPrice = 0.0;
        if (firstFree) {
            for (int i = 1; i < days.size() - 1; i++) {
                grossPrice += days.get(i).getRate() * rate;
            }
        }
        else {
            for (int i = 0; i < days.size() - 1; i++) {
                grossPrice += days.get(i).getRate() * rate;
            }
        }
        reservations.add(new Reservation(name, guest, grossPrice, discount, firstFree, days));
    }
    public double getEstEarnings() {
        int i;
        double roomEstimateEarnings = 0.0;
        for (i = 0; i < reservations.size(); i++) {
            roomEstimateEarnings += reservations.get(i).getNetPrice();
        }
        return roomEstimateEarnings;
    }
    public boolean isAvailable(int day) {
        for (Reservation reservation : reservations) {
            if (day >= reservation.getIn() && day < reservation.getOut()) {
                return false;
            }
        }
        return true;
    }
    public double getRate() {
        return rate;
    }
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
}
