public class DeluxeRoom extends Room{
    public DeluxeRoom(String name, double basePrice) {
        super(name, basePrice + (basePrice * 0.20));
    }

    @Override
    public double calculateRate(double basePrice) {
        return basePrice + (basePrice * 0.20);
    }
}
