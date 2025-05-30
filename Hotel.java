import java.util.List;

public class Hotel {
    private final String name;
    private final List<Room> rooms;
    private final List<Reservation> reservations;

    public Hotel(String name, List<Room> rooms, List<Reservation> reservations) {
        this.name = name;
        this.rooms = rooms;
        this.reservations = reservations;
    }

    public String getName() {
        return name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
}

