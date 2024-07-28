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
    public double getRate() {
        return rate;
    }
    public boolean isSpecial () {
        return rate != 1.0;
    }
}
