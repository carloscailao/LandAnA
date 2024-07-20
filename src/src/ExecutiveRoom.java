public class ExecutiveRoom extends Room{
    public ExecutiveRoom(String name, double basePrice) {
        super(name, basePrice + (basePrice * 0.35));
    }

    @Override
    public double calculateRate(double basePrice) {
        return basePrice + (basePrice * 0.35);
    }
}
