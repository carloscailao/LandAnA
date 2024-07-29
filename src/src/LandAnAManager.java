import java.util.ArrayList;

/**
 * Has a list of hotels, an index of operations,
 * and a list of days with special rates
 */
public class LandAnAManager {
    private ArrayList<Hotel> hotels;
    private int hotelIndex;
    private ArrayList<Day> specialDays;

    /**
     * Upon creation, instantiate list of hotels and special days
     * and set hotel index to 1
     */
    public LandAnAManager () {
        this.hotels = new ArrayList<>();
        this.hotelIndex = -1;
        specialDays = new ArrayList<>();
    }

    /**
     * Adds a hotel to manager hotel list
     * @param hotel to be added
     */
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    /**
     * Tells if a hotel name is unique among all hotels in hotel list
     * @param name in contention
     * @return boolean if unique or not
     */
    public boolean isUniqueHotel(String name) {
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get a hotel at a specific index
     * @param index index of hotel
     * @return hotel in list
     */
    public Hotel getHotel(int index) {
        return hotels.get(index);
    }

    /**
     * Get number of hotels
     * @return number of hotels
     */
    public int getNHotels() {
        return hotels.size();
    }

    /**
     * Create rooms in hotel based on number of three types
     * @param index of hotel
     * @param std number of standard rooms to be made
     * @param deluxe number of deluxe rooms to be made
     * @param executive number of executive rooms to be made
     */
    public void createRooms(int index, int std, int deluxe, int executive) {
        hotels.get(index).createRooms(std, deluxe, executive);
    }

    /**
     * Get names of all hotels in list
     * @return array list of names of all hotels
     */
    public ArrayList<String> getHotelNames () {
        ArrayList<String> names = new ArrayList<>();
        for (Hotel hotel : hotels) {
            names.add(hotel.getHotelName());
        }
        return names;
    }

    /**
     * Changes name of hotel
     * @param index of hotel
     * @param name new name
     */
    public void setHotelName(int index, String name) {
        hotels.get(index).setHotelName(name);
    }

    /**
     * Gets all names of the rooms in a hotel
     * @param index of hotel
     * @return array list of all names of rooms in hotel
     */
    public ArrayList<String> getRoomsNames(int index) {
        return hotels.get(index).getRoomsNames();
    }

    /**
     * Tells if a room in a hotel has no reservations
     * @param iHotel index of hotel
     * @param iRoom index of room in hotel
     * @return bool if no reservation or not
     */
    public boolean roomHasNoReservations (int iHotel, int iRoom) {
        return hotels.get(iHotel).roomHasNoReservations(iRoom);
    }

    /**
     * Deletes a room in hotel
     * @param iHotel index of hotel
     * @param iRoom index of room in hotel
     */
    public void deleteRoom (int iHotel, int iRoom) {
        hotels.get(iHotel).deleteRoom(iRoom);
    }

    /**
     * Sets current hotel index of operation
     * @param i hotel index of operation
     */
    public void setHotelIndex(int i) {
        hotelIndex = i;
    }

    /**
     * Gets current hotel index of operation
     * @return hotel index of operation
     */
    public int getHotelIndex() {
        return hotelIndex;
    }

    /**
     * Sets base price of a hotel
     * @param iHotel index of hotel
     * @param price new base price of hotel
     */
    public void setBasePrice(int iHotel, double price) {
        hotels.get(iHotel).setHotelBasePrice(price);
    }

    /**
     * Tells if hotel has no reservations
     * @param iHotel index of hotel
     * @return boolean if no reservations or not
     */
    public boolean hotelHasNoReservations(int iHotel) {
        return hotels.get(iHotel).hasNoReservations();
    }

    /**
     * Removes a reservation in a room in a hotel
     * @param iHotel index of hotel
     * @param iRoom index of room in hotel
     * @param iRes index of reservation in room in hotel
     */
    public void removeReservation(int iHotel, int iRoom, int iRes) {
        hotels.get(iHotel).removeReservation(iRoom, iRes);
    }

    /**
     * Gets all reservation names of a room in a hotel
     * @param iHotel index of hotel
     * @param iRoom index of room
     * @return array list of names of all reservations in a room in a hotel
     */
    public ArrayList<String> getReservationNames (int iHotel, int iRoom) {
        return hotels.get(iHotel).getReservationNames(iRoom);
    }

    /**
     * Removes hotel in manager hotel list
     * @param iHotel index of hotel
     */
    public void removeHotel(int iHotel) {
        hotels.remove(iHotel);
    }

    /**
     * Gets names of all available rooms given check in and out
     * @param in check in date
     * @param out check out date
     * @return array list of names of all available rooms
     */
    public ArrayList<String> getAvailRooms(int in, int out) {
        return hotels.get(hotelIndex).getAvailRooms(in, out);
    }

    /**
     * Sets a special date rate modifier
     * @param day date to be modified
     * @param rate new rate of date
     */
    public void setSpecial(int day, double rate) {
        specialDays.add(new Day(day, rate/100));
        System.out.println("Day " + day + " set to " + rate/100);
    }

    /**
     * Tells if discount code is valid
     * @param code string code input
     * @param in guest check in date
     * @param out guest check out date
     * @return if valid or not
     */
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

    /**
     * Gets rate of specific date
     * @param day day in contention
     * @return rate of the date
     */
    public double getDayRate(int day) {
        for (Day specialDay : specialDays) {
            if (day == specialDay.getName()) {
                return specialDay.getRate();
            }
        }
        return 1;
    }

    /**
     * Adds a new reservation without a discount
     * @param name guest name
     * @param in check in date
     * @param out check out date
     * @param room room name
     */
    public void newReservation(String name, int in, int out, String room) {
        ArrayList<Day> days = new ArrayList<>();
        for (int i = in; i <= out; i++) {
            System.out.println("Adding new day " + i);
            days.add(new Day(i, getDayRate(i)));
        }
        hotels.get(getHotelIndex()).newReservation(name, days, room);
    }

    /**
     * Adds a new reservation with a discount
     * @param name guest name
     * @param in check in date
     * @param out check out date
     * @param room name of room
     * @param code discount code used
     */
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

    /**
     * Gets names of all reservations in a hotel
     * @param iHotel index of hotel
     * @return array list of names of all reservations
     */
    public ArrayList<String> getReservationsNames(int iHotel) {
        return hotels.get(iHotel).getReservationNames();
    }

    /**
     * Gets number of available rooms in a hotel on a date
     * @param iHotel index of hotel
     * @param date date to be checked
     * @return number of available rooms
     */
    public int getNAvailable(int iHotel, int date) {
        return hotels.get(iHotel).getNAvailable(date);
    }

    /**
     * Gets number of booked rooms in a hotel on a date
     * @param iHotel index of hotel
     * @param date date to be checked
     * @return number of booked  rooms
     */
    public int getNBooked(int iHotel, int date) {
        return hotels.get(iHotel).getNBooked(date);
    }

    /**
     * Gets rate of room in a hotel
     * @param iHotel index of hotel
     * @param iRoom index of room in a hotel
     * @return rate of room in a hotel
     */
    public double getRoomRate(int iHotel, int iRoom) {
        return hotels.get(iHotel).getRoomRate(iRoom);
    }

    /**
     * Gets all available days of a room in a hotel
     * @param iHotel index of hotel
     * @param iRoom index of room
     * @return array list of integers representing days
     */
    public ArrayList<Integer> getDays(int iHotel, int iRoom) {
        return hotels.get(iHotel).getDays(iRoom);
    }

    /**
     * Gets a room based on reservation name.
     * Note that this only is used on a specific hotel, and each room in a hotel
     * is unique, so there is a guarantee that all reservation names are unique
     * in the scope of this method
     * @param reservationName name of reservation
     * @return room found to have that reservation
     */
    public Room getRoom(String reservationName) {
        return hotels.get(hotelIndex).getHotelRoom(reservationName);
    }

    /**
     * Gets a reservation based on name
     * Note that this only is used on a specific hotel, and each room in a hotel
     * is unique, so there is a guarantee that all reservation names are unique
     * in the scope of this method
     * @param reservation name of reservation
     * @return reservation found to have that name
     */
    public Reservation getReservation(String reservation) {
        return hotels.get(hotelIndex).getReservation(reservation);
    }
}
