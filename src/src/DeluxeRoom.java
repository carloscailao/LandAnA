/**
 * Child class of a room. Type deluxe
 */
public class DeluxeRoom extends Room{

    /**
     * Deluxe room constructor that uses parent constructor
     * @param name name of room
     * @param basePrice base price of hotel
     */
    public DeluxeRoom(String name, double basePrice) {
        super(name, basePrice + (basePrice * 0.20));
    }

    /**
     * Override's parent's update rate method
     * @param basePrice base price of hotel
     * @return new room rate based on type of room
     */
    @Override
    public double updateRate(double basePrice) {
        return basePrice + (basePrice * 0.20);
    }
}
