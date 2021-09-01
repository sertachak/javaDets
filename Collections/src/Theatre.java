import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Theatre {
    private final String name;
    public List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if(seat1.getPrice() > seat2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    public Theatre(String name, int numRows, int seatsPerRow) {
        this.name = name;

        int lastRow = 'A' + (numRows-1);
        for(char row = 'A'; row<= lastRow; row++) {
            for(int seatNum = 1; seatNum<=seatsPerRow; seatNum++) {
                double price = 12.00;
                if((row < 'D') && (seatNum >= 4 || seatNum <= 9)){
                    price = 14.00;
                } else if( (row > 'F') || (seatNum < 4 || seatNum > 9 )) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
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

    class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;
        private final double price;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public double getPrice() {
            return price;
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

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}
