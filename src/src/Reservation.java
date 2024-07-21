public class Reservation {
    private String guestName;
    private int in;
    private int out;
    private int daysStayed;
    private String name;
    private double rmRate;
    private double dcRate;
    private double grossPrice;
    private double netPrice;

    public Reservation (String guestName, int in, int out, double rmRate, double dcRate, boolean firstDayFree) {
        this.guestName = guestName;
        this.in = in;
        this.out = out;
        this.daysStayed = (out-in);
        this.name = guestName + in + "-" + out;

        this.grossPrice = (rmRate * daysStayed);
        this.netPrice = (grossPrice - (grossPrice * dcRate));
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
