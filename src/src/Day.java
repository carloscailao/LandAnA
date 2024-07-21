public class Day {
    private int name;
    private double rate;

    public Day(int name, double rate) {
        this.rate = rate;
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
