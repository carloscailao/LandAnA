public class Reservation {
    private String guestName;
    private int in;
    private int out;
    private String name;
    public Reservation (String guestName, int in, int out) {
        this.guestName = guestName;
        this.in = in;
        this.out = out;
        this.name = guestName + in + "-" + out;
    }
    public String getName() {
        return name;
    }
}
