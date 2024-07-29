/**
 * Child class of a room. Type standard
 */
public class StandardRoom extends Room{

    /**
     * Standard room constructor that uses parent constructor
     * @param name name of room
     * @param basePrice base price of hotel
     */
    public StandardRoom(String name, double basePrice) {
        super(name, basePrice);
    }

    /**
     * Override's parent's update rate method
     * @param basePrice base price of hotel
     * @return new room rate based on type of room
     */
    @Override
    public double updateRate(double basePrice) {
        return basePrice;
    }
}
