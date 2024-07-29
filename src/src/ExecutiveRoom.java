/**
 * Child class of a room. Type executive
 */
public class ExecutiveRoom extends Room{

    /**
     * Executive room constructor that uses parent constructor
     * @param name name of room
     * @param basePrice base price of hotel
     */
    public ExecutiveRoom(String name, double basePrice) {
        super(name, basePrice + (basePrice * 0.35));
    }

    /**
     * Override's parent's update rate method
     * @param basePrice base price of hotel
     * @return new room rate based on type of room
     */
    @Override
    public double updateRate(double basePrice) {
        return basePrice + (basePrice * 0.35);
    }
}
