import java.util.ArrayList;

public class LandAnAManager {
    private ArrayList<Hotel> hotels;

    public LandAnAManager () {
        this.hotels = new ArrayList<Hotel>();
    }

    public void createHotel(String name) {
        if (isUniqueHotel(name)) {
            hotels.add(new Hotel(name));
        }
    }

    public boolean isUniqueHotel(String name) {
        for (int i = 0; i < hotels.size(); i++) {
            if (hotels.get(i).getHotelName().equals(name)) {
                return false;
            }
        }
        return true;
    }
}
