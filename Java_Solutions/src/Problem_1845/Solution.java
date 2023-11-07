package Problem_1845;

import java.util.*;

class Seat implements Comparable<Seat> {
    int number;
    boolean reserved;

    Seat(int number, boolean reserved){
        this.number = number;
        this.reserved = reserved;
    }

    @Override
    public int compareTo(Seat s) {
        if (this.reserved && !s.reserved) {
            return 1;  // Move this entry to the end
        } else if (!this.reserved && s.reserved) {
            return -1; // Move the other entry to the end
        }

        // If flags are the same, compare by number
        return this.number - s.number;
    }

    public String toString() {
        return "" + this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat that = (Seat) o;
        return number == that.number;
    }

    public void toggleReserved() {
        this.reserved = !this.reserved;
    }
}

class SeatManager {
    SortedSet<Seat> seats = new TreeSet<>();
    int numReserved = -1;
    int n;

    public SeatManager(int n) {
        this.n = n-1;
        for(int i = 1; i <= n; i++) {
            seats.add(new Seat(i, false));
        }
    }

    public int reserve() {
        Seat seat = seats.first();
        seats.remove(seat);
        seat.toggleReserved();
        seats.add(seat);

        numReserved++;
        return seat.number;
    }

    public void unreserve(int seatNumber) {
        // System.out.println("Attempting to remove: " + seatNumber + " : " + (n - numReserved) + " : " + (seats.stream().map(Seat::toString).collect(Collectors.joining(","))));
        Seat seat = new Seat(seatNumber, true);
        // System.out.println("Removing: " + seat.toString());
        seats.remove(seat);
        seat.toggleReserved();
        seats.add(seat);
        numReserved--;
    }

    public static void main(String[] args) {
        List<Integer> results = new ArrayList<>();
       SeatManager sm = new SeatManager(5);

       results.add(sm.reserve());
       results.add(sm.reserve());
       sm.unreserve(2);
       results.add(null);
        results.add(sm.reserve());
        results.add(sm.reserve());
        results.add(sm.reserve());
        results.add(sm.reserve());
        sm.unreserve(5);
        results.add(null);

        System.out.println(results);

    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
