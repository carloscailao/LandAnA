/**
 * Child class of a room. Type deluxe
 */
public class DeluxeRoom extends Room{
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
