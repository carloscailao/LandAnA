import java.util.ArrayList;

public class LandAnAManager {
    private ArrayList<Hotel> hotels;
    private int hotelIndex;

    public LandAnAManager () {
        this.hotels = new ArrayList<>();
        this.hotelIndex = -1;
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

    public ArrayList<Hotel> getHotels () {
        return hotels;
    }

    public void setHotelName(int index, String name) {
        hotels.get(index).setHotelName(name);
    }

    public ArrayList<String> getRoomsNames(int index) {
        return hotels.get(index).getRoomsNames();
    }
    public boolean hasNoReservations (int iHotel, int iRoom) {
        return hotels.get(iHotel).hasNoReservations(iRoom);
    }
    public void deleteRoom (int iHotel, int iRoom) {
        //char type = hotels.get(iHotel).getRoom(iRoom).getRoomIdentifier();
        hotels.get(iHotel).deleteRoom(iRoom);
        /*
        if (type == 'S') {
            hotels.get(iHotel).setNStdRooms((hotels.get(iHotel).getNStdRooms())-1);
        }
        else if (type == 'D') {
            hotels.get(iHotel).setNDelRooms((hotels.get(iHotel).getNDelRooms())-1);
        }
        else if (type == 'E') {
            hotels.get(iHotel).setNExeRooms((hotels.get(iHotel).getNExeRooms())-1);
        }
        */
    }
    public void setHotelIndex(int i) {
        hotelIndex = i;
    }
    public int getHotelIndex() {
        return hotelIndex;
    }
    public void setBasePrice(int iHotel, double price) {
        hotels.get(iHotel).setHotelBasePrice(price);
    }
}
