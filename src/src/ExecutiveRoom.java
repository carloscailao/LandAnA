public class ExecutiveRoom extends Room{
    public ExecutiveRoom(String name, double basePrice) {
        super(name, basePrice + (basePrice * 0.35));
    }
}
