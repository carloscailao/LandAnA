import java.util.ArrayList;

public class Reservation {
    final String guestName;
    final int in;
    final int out;
    final int daysStayed;
    final String name;
    final double dcRate;
    final double grossPrice;
    final double netPrice;
    private boolean firstFree;

    public Reservation (String guestName, double grossPrice, ArrayList<Day> days) {
        this.guestName = guestName;
        this.grossPrice = grossPrice; // room and day rates apply. no discounts
        this.netPrice = grossPrice;

        this.in = days.getFirst().getName();
        this.out = days.getLast().getName();
        this.daysStayed = days.size();
        this.name = guestName + " " + in + "-" + out;
        this.dcRate = 0.0;
    }

    public Reservation (String guestName, double grossPrice, double discount, boolean firstFree, ArrayList<Day> days) {
        this.guestName = guestName;
        this.grossPrice = grossPrice;
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
        this.daysStayed = days.size();
        this.name = guestName + " " + in + "-" + out;
        this.dcRate = discount;

    }
    public String getName() {
        return name;
    }
    public int getIn() {
        return in;
    }
    public int getOut() {
        return out;
    }
}
