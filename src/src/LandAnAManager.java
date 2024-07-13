import java.util.ArrayList;

public class LandAnAManager {
    private ArrayList<Hotel> hotels;

    public LandAnAManager () {
        this.hotels = new ArrayList<>();
    }

    public void createHotel(String name) {
        if (isUniqueHotel(name)) {
            hotels.add(new Hotel(name));
        }
    }

    public boolean isUniqueHotel(String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> returnHotelNames() {
        ArrayList<String> hotelNames = new ArrayList<>();
        for (Hotel hotel : hotels) {
            hotelNames.add(hotel.getHotelName());
        }
        return hotelNames;
    }
}
