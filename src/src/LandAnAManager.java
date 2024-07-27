import java.util.ArrayList;

public class LandAnAManager {
    private ArrayList<Hotel> hotels;
    private int hotelIndex;
    final ArrayList<Day> specialDays;

    public LandAnAManager () {
        this.hotels = new ArrayList<>();
        this.hotelIndex = -1;
        specialDays = new ArrayList<>();
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
    public void setSpecial(int day, double rate) {
        specialDays.add(new Day(day, rate/100));
        System.out.println("Day " + day + " set to " + rate/100);
    }
    public boolean isValidDiscount(String code, int in, int out) {
        if (code.equals("I_WORK_HERE")) {
            return true;
        }
        if (code.equals("STAY4_GET1")) {
            if ((out - in) >= 5 ) {
                return true;
            }
            else {
                return false;
            }
        }
        if(code.equals("PAYDAY")) {
            boolean includesDay15 = in <= 15 && out > 15;
            boolean includesDay30 = in <= 30 && out > 30;
            return includesDay15 || includesDay30;
        }
        return false;
    }
    public double getDayRate(int day) {
        for (Day specialDay : specialDays) {
            if (day == specialDay.getName()) {
                return specialDay.getRate();
            }
        }
        return 1;
    }
    public void newReservation(String name, int in, int out, String room) {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = in; i <= out; i++) {
            System.out.println("Adding new day " + i);
            days.add(new Day(i, getDayRate(i)));
        }
        hotels.get(getHotelIndex()).newReservation(name, days, room);
    }
    public void newReservation(String name, int in, int out, String room, String code) {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = in; i <= out; i++) {
            System.out.println("Adding new day " + i);
            days.add(new Day(i, getDayRate(i)));
        }
        if (code.equals("I_WORK_HERE")) {
            hotels.get(getHotelIndex()).newReservation(name, room, 0.1, false, days);
        }
        if (code.equals("STAY4_GET1")) {
            hotels.get(getHotelIndex()).newReservation(name, room, 0.0, true, days);
        }
        if(code.equals("PAYDAY")) {
            hotels.get(getHotelIndex()).newReservation(name, room, 0.07, false, days);
        }
    }
    public ArrayList<String> getReservationsNames(int iHotel) {
        return hotels.get(iHotel).getReservationNames();
    }

    public int getNAvailable(int iHotel, int date) {
        return hotels.get(iHotel).getNAvailable(date);
    }
    public int getNBooked(int iHotel, int date) {
        return hotels.get(iHotel).getNBooked(date);
    }
}
