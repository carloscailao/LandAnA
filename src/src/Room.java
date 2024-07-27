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
    public void newReservation(String name, ArrayList<Day> days) {
        double grossPrice = 0.0;
        // calculate gross price here
        /*
        for (Day day : days) {
            grossPrice += day.getRate() * rate; // day rate * room rate
        }
        */
        for (int i = 0; i < days.size() - 1; i++) {
            grossPrice += days.get(i).getRate() * rate;
        }
        reservations.add(new Reservation(name, grossPrice, days));
    }
    public void newReservation(String name, double discount, boolean firstFree, ArrayList<Day> days) {
        double grossPrice = 0.0;
        /*
        if (firstFree) {
            for (int i = in + 1; i < out - 1; i++) {
                grossPrice += days.get(i).getRate() * rate;
            }
        }
         */
        if (firstFree) {
            for (int i = 1; i < days.size() - 1; i++) {
                grossPrice += days.get(i).getRate() * rate;
            }
        }
        else {
            /*
            for (Day day : days) {
                grossPrice += day.getRate() * rate; // day rate * room rate
            }
            */
            for (int i = 0; i < days.size() - 1; i++) {
                grossPrice += days.get(i).getRate() * rate;
            }
        }
        reservations.add(new Reservation(name, grossPrice, discount, firstFree, days));
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

}
