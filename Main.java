import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create room list
        Room room1 = new Room(101, "Single", 100.0);
        Room room2 = new Room(102, "Double", 150.0);

        List<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);

        List<Reservation> reservations = new ArrayList<>();
        Hotel hotel = new Hotel("Ocean View", roomList, reservations);

        // Get guest info
        try (Scanner scanner = new Scanner(System.in)) {
            // Get guest info
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();
            System.out.print("Enter guest email: ");
            String guestEmail = scanner.nextLine();
            
            Guest guest = new Guest(guestName, guestEmail);
            
            // Show available rooms
            System.out.println("\nAvailable Rooms:");
            for (Room room : hotel.getRooms()) {
                if (room.isAvailable()) {
                    System.out.println("Room " + room.getRoomNumber() + " - " + room.getType() + " - $" + room.getPrice());
                }
            }
            
            // Choose room
            System.out.print("\nEnter room number to book: ");
            int selectedRoomNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            Room selectedRoom = null;
            for (Room room : hotel.getRooms()) {
                if (room.getRoomNumber() == selectedRoomNumber && room.isAvailable()) {
                    selectedRoom = room;
                    break;
                }
            }
            
            if (selectedRoom == null) {
                System.out.println("Room not available or does not exist.");
            } else {
                // Simulate check-in and check-out (1 night)
                Date checkIn = new Date();
                Date checkOut = new Date(System.currentTimeMillis() + 86400000); // +1 day
                
                Reservation reservation = new Reservation(checkIn, checkOut, selectedRoom, guest);
                hotel.addReservation(reservation);
                
                System.out.println("\nReservation confirmed for " + guest.getName() + " in Room " + selectedRoom.getRoomNumber());
                System.out.println("Check-in: " + checkIn);
                System.out.println("Check-out: " + checkOut);
            }
        }
    }
}
