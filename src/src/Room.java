import java.util.ArrayList;

/**
 * Abstract class room with 3 inheritors has a name, rate, and list of reservations
 */
public abstract class Room {
    private String name;
    private double rate;
    private ArrayList<Reservation> reservations;

    /**
     * Upon creation, initialize new list of reservations
     * @param name name of room
     * @param price price of a room per night
     */
    public Room(String name, double price) {
        this.name = name;
        this.rate = price;
        this.reservations = new ArrayList<>();
    }

    /**
     * Abstract method to update a room's rate based on hotel base price
     * @param basePrice base price of hotel
     * @return new room rate
     */
    public abstract double updateRate(double basePrice);

    /**
     * Updates room's rate per night based on hotel base price
     * @param basePrice hotel base price
     */
    public void updateBasePrice(double basePrice) {
        rate = updateRate(basePrice);
    }

    /**
     * Gets name of room
     * @return name of room
     */
    public String getName() {
        return name;
    }

    /**
     * Tells if room has no reservations
     * @return boolean if no reservations or not
     */
    public boolean hasNoReservations() {
        return reservations.isEmpty();
    }

    /**
     * Removes a room's reservation
     * @param iRes index of reservation
     */
    public void removeReservation(int iRes) {
        reservations.remove(iRes);
    }

    /**
     * Gets all reservation names in room
     * @return array list of reservation names
     */
    public ArrayList<String> getReservationNames () {
        ArrayList<String> names = new ArrayList<>();
        for (Reservation reservation : reservations) {
            names.add(reservation.getName());
        }
        return names;
    }

    /**
     * Tells if room is available given a check in time and check out time
     * @param newIn check in time
     * @param newOut check out time
     * @return boolean if room is available or not
     */
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

    /**
     * Creates a new reservation without discount
     * @param guest guest name
     * @param days array list of days encompassing the reservation
     */
    public void newReservation(String guest, ArrayList<Day> days) {
        double grossPrice = 0.0;
        for (int i = 0; i < days.size() - 1; i++) {
            grossPrice += days.get(i).getRate() * rate;
        }
        reservations.add(new Reservation(name, guest, grossPrice, days));
    }

    /**
     * Creates new reservation with discount
     * @param guest guest name
     * @param discount discount rate
     * @param firstFree is first day free or not
     * @param days array list of days encompassing the reservation
     */
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

    /**
     * Gets total net price of all reservations in a room
     * @return total net price of all reservations in a room
     */
    public double getEstEarnings() {
        int i;
        double roomEstimateEarnings = 0.0;
        for (i = 0; i < reservations.size(); i++) {
            roomEstimateEarnings += reservations.get(i).getNetPrice();
        }
        return roomEstimateEarnings;
    }

    /**
     * Tells if room is available for reservation given a day
     * @param day day to check availability
     * @return boolean if available or not
     */
    public boolean isAvailable(int day) {
        for (Reservation reservation : reservations) {
            if (day >= reservation.getIn() && day < reservation.getOut()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets rate of room
     * @return room rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * Gets all reservations in room
     * @return array list of reservations in a room
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
}