public class StandardRoom extends Room{
    public StandardRoom(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public double calculateRate(double basePrice) {
        return basePrice;
    }
}
