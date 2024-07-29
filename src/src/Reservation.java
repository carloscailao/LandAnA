import java.util.ArrayList;

/**
 * A Reservation has a guest name, check in and out date, number of days stayed, name, discount rate, gross price,
 * net price, boolean if first day is free, room name, and array list of days encompassing the reservation
 */
public class Reservation {
    private String guestName;
    private int in;
    private int out;
    private int daysStayed;
    private String name;
    private double dcRate;
    private double grossPrice;
    private double netPrice;
    private boolean firstFree;
    private String roomName;
    private ArrayList<Day> dayList;

    /**
     * Constructor of reservation without discount rate
     * @param roomName room name
     * @param guestName guest name
     * @param grossPrice room rate * day rates
     * @param days all days encompassing the reservation
     */
    public Reservation (String roomName, String guestName, double grossPrice, ArrayList<Day> days) {
        this.guestName = guestName;
        this.grossPrice = grossPrice; // room and day rates apply. no discounts
        this.netPrice = grossPrice;
        this.roomName = roomName;
        this.dayList = days;

        this.in = days.getFirst().getName();
        this.out = days.getLast().getName();
        this.daysStayed = days.size()-1;
        this.name = roomName + " " + guestName + " " + in + "-" + out;
        this.dcRate = 0.0;
    }

    /**
     * Constructor of reservation with a discount rate
     * @param roomName room name
     * @param guestName guest name
     * @param grossPrice room rate * days rate
     * @param discount discount rate
     * @param firstFree boolean if first day is free
     * @param days array list of all days encompassing the reservation
     */
    public Reservation (String roomName, String guestName, double grossPrice, double discount, boolean firstFree, ArrayList<Day> days) {
        this.guestName = guestName;
        this.grossPrice = grossPrice;
        this.roomName = roomName;
        this.dayList = days;
        if (firstFree) {
            this.netPrice = grossPrice;
            this.firstFree = true;
        }
        else {
            this.netPrice = grossPrice - (grossPrice * discount);
            this.firstFree = false;
        }
        this.in = days.getFirst().getName();
        this.out = days.getLast().getName();
        this.daysStayed = days.size()-1;
        this.name = roomName + " " + guestName + " " + in + "-" + out;
        this.dcRate = discount;

    }

    /**
     * Gets name of reservation
     * @return room name + guest name + check in and out dates
     */
    public String getName() {
        return name;
    }

    /**
     * Gets check in date
     * @return check in date
     */
    public int getIn() {
        return in;
    }

    /**
     * Gets check out date
     * @return check out date
     */
    public int getOut() {
        return out;
    }

    /**
     * Gets net price
     * @return net price with room rate, days rates, discounts
     */
    public double getNetPrice() {
        return netPrice;
    }

    /**
     * Gets guest name
     * @return guest name
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * Gets number of days stayed
     * @return number of days stayed
     */
    public int getDaysStayed() {
        return daysStayed;
    }

    /**
     * Gets discount rate in string form
     * @return discount rate in percent form
     */
    public String getDiscount() {
        return Math.round(dcRate*100) + "%";
    }

    /**
     * Gets number of free days
     * @return 0 if first day is free, 1 if first day is free
     */
    public int getFree() {
        if (firstFree) {
            return 1;
        }
        return 0;
    }

    /**
     * Gets all special days in a reservation
     * @return array list of special days in a reservation
     */
    public ArrayList<Day> getSpecialDays () {
        ArrayList<Day> specialDays = new ArrayList<>();
        for (Day day : dayList) {
            if (day.isSpecial()) {
                specialDays.add(day);
            }
        }
        return specialDays;
    }
}
