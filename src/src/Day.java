/**
 * A day has a name and a rate
 */
public class Day {
    private int name;
    private double rate;

    /**
     * Day constructor
     * @param name name from 1-31
     * @param rate rate of room
     */
    public Day(int name, double rate) {
        this.rate = rate;
        this.name = name;
    }

    /**
     * Gets day name 1-31
     * @return day name 1-31
     */
    public int getName() {
        return name;
    }

    /**
     * Gets rate of day
     * @return rate of day
     */
    public double getRate() {
        return rate;
    }

    /**
     * Tells if day has a rate modifier
     * @return true if day's rate is not 100%
     */
    public boolean isSpecial () {
        return rate != 1.0;
    }
}
