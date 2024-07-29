import java.util.ArrayList;

/**
 * Hotel has a name, base price, list of rooms, and integer indicators of room count
 */
public class Hotel {
    private String name;
    private double basePrice;
    private ArrayList<Room> rooms;
    private int nStdRooms;
    private int nDelRooms;
    private int nExeRooms;

    /**
     * Upon creation, initialize list of rooms and set base price to 0
     * @param name hotel name
     */
    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.nStdRooms = 0;
        this.nDelRooms = 0;
        this.nExeRooms = 0;
        setHotelBasePrice(1299.0);
    }

    /**
     * Sets base price of hotel
     * @param price new base price
     */
    public void setHotelBasePrice(double price) {
        this.basePrice = price;
        for (Room room : rooms) {
            room.updateBasePrice(basePrice);
        }
    }

    /**
     * Gets hotel name
     * @return hotel name
     */
    public String getHotelName() {
        return name;
    }

    /**
     * Creates multiple rooms based on number of each type
     * @param std number of standard rooms to be created
     * @param deluxe number of deluxe rooms to be created
     * @param executive number of executive rooms to be created
     */
    public void createRooms (int std, int deluxe, int executive) {
            for (int i = 0; i < std; i++) {
                String name = "S" + (nStdRooms + 1);
                rooms.add(new StandardRoom(name, basePrice));
                System.out.println("Standard room created");
                nStdRooms++;
            }
            for (int i = 0; i < deluxe; i++) {
                String name = "D" + (nDelRooms + 1);
                rooms.add(new DeluxeRoom(name, basePrice));
                System.out.println("Deluxe room created");
                nDelRooms++;
            }
            for (int i = 0; i < executive; i++) {
                String name = "E" + (nExeRooms + 1);
                rooms.add(new ExecutiveRoom(name, basePrice));
                System.out.println("Executive room created");
                nExeRooms++;
            }

    }

    /**
     * Gets number of standard rooms
     * @return number of standard rooms
     */
    public int getNStdRooms () {
        return nStdRooms;
    }

    /**
     * Gets number of deluxe rooms
     * @return number of deluxe rooms
     */
    public int getNDelRooms () {
        return nDelRooms;
    }

    /**
     * Gets number of executive rooms
     * @return number of executive rooms
     */
    public int getNExeRooms () {
        return nExeRooms;
    }

    /**
     * Gets number of total rooms
     * @return number of total rooms
     */
    public int getTotalRooms() {
        System.out.println("Number of rooms: " +rooms.size() + "in hotel" +name);
        return rooms.size();
    }

    /**
     * Sets hotel name
     * @param name new hotel name
     */
    public void setHotelName(String name) {
        this.name = name;
    }

    /**
     * Gets name of all rooms
     * @return array list of room names
     */
    public ArrayList<String> getRoomsNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Room room : rooms) {
            names.add(room.getName());
        }
        return names;
    }

    /**
     * Tells if a room has no reservation
     * @param roomIndex index of room
     * @return boolean if room has no reservation or not
     */
    public boolean roomHasNoReservations (int roomIndex) {
        return rooms.get(roomIndex).hasNoReservations();
    }

    /**
     * Deletes a room in a hotel
     * @param iRoom index of room
     */
    public void deleteRoom (int iRoom) {
        rooms.remove(iRoom);
    }

    /**
     * Tells if whole hotel has no reservations
     * @return boolean if hotel has no reservations or not
     */
    public boolean hasNoReservations () {
        for (Room room : rooms) {
            if (!room.hasNoReservations()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removes a reservation in a room
     * @param iRoom index of room
     * @param iRes index of reservation
     */
    public void removeReservation(int iRoom, int iRes) {
        rooms.get(iRoom).removeReservation(iRes);
    }

    /**
     * Gets all reservation names in a room
     * @param iRoom index of room
     * @return array list of reservation names in a room
     */
    public ArrayList<String> getReservationNames (int iRoom) {
        return rooms.get(iRoom).getReservationNames();
    }

    /**
     * Gets all reservation names in a hotel
     * @return array list of reservation names in a hotel
     */
    public ArrayList<String> getReservationNames () {
        ArrayList<String> names = new ArrayList<>();
        for (Room room : rooms) {
            names.addAll(room.getReservationNames());
        }
        return names;
    }

    /**
     * Gets all names of rooms available given a check in and out date
     * @param in check in date
     * @param out check out date
     * @return array list of names of rooms available given check in and out date
     */
    public ArrayList<String> getAvailRooms(int in, int out) {
        ArrayList<String> names = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable(in, out)) {
                names.add(room.getName());
            }
        }
        return names;
    }

    /**
     * Makes a new reservation in a room without discount
     * @param name guest name
     * @param days arraylist of days that the reservation spans
     * @param room room name
     */
    public void newReservation(String name, ArrayList<Day> days, String room) {
        getRoom(room).newReservation(name, days);
    }

    /**
     * Makes a new reservation in a room with discount
     * @param name guest name
     * @param room room name
     * @param discount discount rate
     * @param firstFree is first day free or not
     * @param days arraylist of days that the reservation spans
     */
    public void newReservation(String name, String room, double discount, boolean firstFree, ArrayList<Day> days) {
        getRoom(room).newReservation(name, discount, firstFree, days);
    }

    /**
     * Gets a room based on room name
     * @param roomName name of room
     * @return room based on name
     */
    public Room getRoom(String roomName) {
        for (Room room : rooms) {
            if (roomName.equals(room.getName())) {
                return room;
            }
        }
        return null;
    }

    /**
     * Gets total of all reservation net prices in whole hotel
     * @return total of all reservation net prices in whole hotel
     */
    public double getEstEarnings() {
        int i;
        double hotelEstimateEarnings = 0.0;
        for (i = 0; i < rooms.size(); i++) {
            hotelEstimateEarnings += rooms.get(i).getEstEarnings();
        }
        return hotelEstimateEarnings;
    }

    /**
     * Gets number of available rooms given a date
     * @param date date to check availability of room
     * @return number of available rooms given a date
     */
    public int getNAvailable(int date) {
        int n = 0;
        for (Room room: rooms) {
            if (room.isAvailable(date)) {
                n++;
            }
        }
        return n;
    }

    /**
     * Gets number of booked rooms in a date
     * @param date date to check bookings
     * @return number of booked rooms in a date
     */
    public int getNBooked(int date) {
        int n = 0;
        for (Room room : rooms) {
            if (!room.isAvailable(date)) {
                n++;
            }
        }
        return n;
    }

    /**
     * Gets rate of room
     * @param iRoom index of room
     * @return rate of room
     */
    public double getRoomRate(int iRoom) {
        return rooms.get(iRoom).getRate();
    }

    /**
     * Gets all days available in a room
     * @param iRoom room to check availability
     * @return array list of all dates available in a room
     */
    public ArrayList<Integer> getDays(int iRoom) {
        ArrayList<Integer> days = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            if (rooms.get(iRoom).isAvailable(i)) {
                days.add(i);
            }
        }
        return days;
    }

    /**
     * Gets room in a hotel given a reservation name
     * @param reservationName reservation name to extract room from
     * @return room found in a reservation name
     */
    public Room getHotelRoom(String reservationName) {
        for (Room room : rooms) {
            for (Reservation reservation : room.getReservations()) { // Assuming getReservations() returns a list of reservations
                if (reservation.getName().equals(reservationName)) { // Assuming getName() returns the reservation name
                    return room;
                }
            }
        }
        return null; // Return null if no room with the corresponding reservation name is found
    }

    /**
     * Gets reservation given its name
     * @param reservationName name of reservation
     * @return reservation given its name
     */
    public Reservation getReservation(String reservationName) {
        for (Room room : rooms) {
            for (Reservation reservation : room.getReservations()) {
                if (reservation.getName().equals(reservationName)) {
                    return reservation;
                }
            }
        }
        return null;
    }
}
