import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Sample data
        Room room1 = new Room(101, "Single", 100.0);
        Room room2 = new Room(102, "Double", 150.0);

        List<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);

        List<Reservation> reservations = new ArrayList<>();
        Hotel hotel = new Hotel("Ocean View", roomList, reservations);

        Guest guest = new Guest("John Doe", "john@example.com");

        Reservation reservation = new Reservation(new Date(), new Date(System.currentTimeMillis() + 86400000), room1, guest);
        hotel.addReservation(reservation);

        System.out.println("Reservation made for " + guest.getName() + " in room " + room1.getRoomNumber());
    }
}
