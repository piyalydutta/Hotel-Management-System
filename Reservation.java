import java.util.Date;

public class Reservation {
    private final Date checkIn;
    private final Date checkOut;
    private final Room room;
    private final Guest guest;

    public Reservation(Date checkIn, Date checkOut, Room room, Guest guest) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
        this.guest = guest;
        this.room.setAvailable(false); // Room reserved
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }
}
