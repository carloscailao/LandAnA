public class DeluxeRoom extends Room{
    public DeluxeRoom(String name, double basePrice) {
        super(name, basePrice + (basePrice * 0.20));
    }

    @Override
    public double updateRate(double basePrice) {
        return basePrice + (basePrice * 0.20);
    }
}
