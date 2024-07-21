public class Reservation {
    private String guestName;
    private int in;
    private int out;
    private String name;
    public Reservation (String guestName, int in, int out, double rmRate) {
        this.guestName = guestName;
        this.in = in;
        this.out = out;
        this.name = guestName + in + "-" + out;
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
