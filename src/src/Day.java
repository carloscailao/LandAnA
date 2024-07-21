public class Day {
    private int name;
    private double rate;

    public Day(int name) {
        this.rate = 1.0;
        this.name = name;
    }

    public int getName() {
        return name;
    }
    public void setRate(double rate) {
        this.rate = rate;
    }
    public double getRate() {
        return rate;
    }
}
