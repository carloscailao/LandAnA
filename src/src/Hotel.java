import java.util.ArrayList;

public class Hotel {
    private String name;
    private double basePrice;
    private ArrayList<Room> rooms;
    private int nStdRooms;
    private int nDelRooms;
    private int nExeRooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.nStdRooms = 0;
        this.nDelRooms = 0;
        this.nExeRooms = 0;
        setHotelBasePrice(1299.0);
    }

    public void setHotelBasePrice(double price) {
        this.basePrice = price;
        for (Room room : rooms) {
            room.updateBasePrice(basePrice);
        }
    }

    public String getHotelName() {
        return name;
    }

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
    public int getNStdRooms () {
        return nStdRooms;
    }
    public int getNDelRooms () {
        return nDelRooms;
    }
    public int getNExeRooms () {
        return nExeRooms;
    }

    public int getTotalRooms() {
        System.out.println("Number of rooms: " +rooms.size() + "in hotel" +name);
        return rooms.size();
    }
    public void setHotelName(String name) {
        this.name = name;
    }
    public ArrayList<String> getRoomsNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Room room : rooms) {
            names.add(room.getName());
        }
        return names;
    }
    public boolean roomHasNoReservations (int roomIndex) {
        return rooms.get(roomIndex).hasNoReservations();
    }
    public void deleteRoom (int iRoom) {
        rooms.remove(iRoom);
    }
    public boolean hasNoReservations () {
        for (Room room : rooms) {
            if (!room.hasNoReservations()) {
                return false;
            }
        }
        return true;
    }
    public void removeReservation(int iRoom, int iRes) {
        rooms.get(iRoom).removeReservation(iRes);
    }
    public ArrayList<String> getReservationNames (int iRoom) {
        return rooms.get(iRoom).getReservationNames();
    }
    public ArrayList<String> getReservationNames () {
        ArrayList<String> names = new ArrayList<>();
        for (Room room : rooms) {
            names.addAll(room.getReservationNames());
        }
        return names;
    }
    public ArrayList<String> getAvailRooms(int in, int out) {
        ArrayList<String> names = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable(in, out)) {
                names.add(room.getName());
            }
        }
        return names;
    }
    public void newReservation(String name, ArrayList<Day> days, String room) {
        getRoom(room).newReservation(name, days);
    }
    public void newReservation(String name, String room, double discount, boolean firstFree, ArrayList<Day> days) {
        getRoom(room).newReservation(name, discount, firstFree, days);
    }
    public Room getRoom(String roomName) {
        for (Room room : rooms) {
            if (roomName.equals(room.getName())) {
                return room;
            }
        }
        return null;
    }
    public double getEstEarnings() {
        int i;
        double hotelEstimateEarnings = 0.0;
        for (i = 0; i < rooms.size(); i++) {
            hotelEstimateEarnings += rooms.get(i).getEstEarnings();
        }
        return hotelEstimateEarnings;
    }
    public int getNAvailable(int date) {
        int n = 0;
        for (Room room: rooms) {
            if (room.isAvailable(date)) {
                n++;
            }
        }
        return n;
    }
    public int getNBooked(int date) {
        int n = 0;
        for (Room room : rooms) {
            if (!room.isAvailable(date)) {
                n++;
            }
        }
        return n;
    }
    public double getRoomRate(int iRoom) {
        return rooms.get(iRoom).getRate();
    }
    public ArrayList<Integer> getDays(int iRoom) {
        ArrayList<Integer> days = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            if (rooms.get(iRoom).isAvailable(i)) {
                days.add(i);
            }
        }
        return days;
    }

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
