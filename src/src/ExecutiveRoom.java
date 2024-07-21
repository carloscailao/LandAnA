public class ExecutiveRoom extends Room{
    public ExecutiveRoom(String name, double basePrice) {
        super(name, basePrice + (basePrice * 0.35));
    }

    @Override
    public double updateRate(double basePrice) {
        return basePrice + (basePrice * 0.35);
    }
}
