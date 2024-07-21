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

    public ArrayList<String> getHotelNames () {
        ArrayList<String> names = new ArrayList<>();
        for (Hotel hotel : hotels) {
            names.add(hotel.getHotelName());
        }
        return names;
    }

    public void setHotelName(int index, String name) {
        hotels.get(index).setHotelName(name);
    }

    public ArrayList<String> getRoomsNames(int index) {
        return hotels.get(index).getRoomsNames();
    }
    public boolean roomHasNoReservations (int iHotel, int iRoom) {
        return hotels.get(iHotel).roomHasNoReservations(iRoom);
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
    public boolean hotelHasNoReservations(int iHotel) {
        return hotels.get(iHotel).hasNoReservations();
    }
    public void removeReservation(int iHotel, int iRoom, int iRes) {
        hotels.get(iHotel).removeReservation(iRoom, iRes);
    }
    public ArrayList<String> getReservationNames (int iHotel, int iRoom) {
        return hotels.get(iHotel).getReservationNames(iRoom);
    }
    public void removeHotel(int iHotel) {
        hotels.remove(iHotel);
    }
    public ArrayList<String> getAvailRooms(int in, int out) {
        return hotels.get(hotelIndex).getAvailRooms(in, out);
    }
}
