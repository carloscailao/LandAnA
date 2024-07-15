import java.util.ArrayList;

public class LandAnAManager {
    private ArrayList<Hotel> hotels;

    public LandAnAManager () {
        this.hotels = new ArrayList<>();
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
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

    public Hotel getHotel(int index) {
        return hotels.get(index);
    }

    public int getNHotels() {
        return hotels.size();
    }

    public void createRooms(int index, int std, int deluxe, int executive) {
        hotels.get(index).createRooms(std, deluxe, executive);
    }
}
