import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final String name;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String name, int numRows, int seatsPerRow) {
        this.name = name;

        int lastRow = 'A' + (numRows-1);
        for(char row = 'A'; row<= lastRow; row++) {
            for(int seatNum = 1; seatNum<=seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = null;
        for(Seat seat : seats) {
           if(seat.getSeatNumber().equals(seatNumber)) {
               requestedSeat = seat;
               break;
           }
        }
        if(requestedSeat == null) {
            System.out.println("There is no seat called " + seatNumber);
            return false;
        }

        return requestedSeat.reserve();
    }

    public void getSeats() {
        seats.forEach(seat -> System.out.println(seat.getSeatNumber()));
    }

    private class Seat {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve() {
            if(!this.reserved)
            {
                this.reserved = true;
                System.out.println("Reservation is done for seat: " +  this.seatNumber);
                return true;
            }
            return false;
        }

        public boolean cancel() {
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation is canceled for seat: " +  this.seatNumber);
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }
}
