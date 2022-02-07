/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flight;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jojo
 */
public class Flight {

    String source;
    String destination;
    String flight_number;
    String departure_time;
    String arrival_time;
    List<Seat> seats;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Flight(String source, String destination, String flight_number, String departure_time, String arrival_time, List<Seat> seat) {
        this.source = source;
        this.destination = destination;
        this.flight_number = flight_number;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.seats = seat;
    }

    private List<Seat> findAvailableSeats() {
        List<Seat> available = new ArrayList<>();
        for (Seat seat : seats) {
            if (!seat.isIsBooked()) {
                available.add(seat);
            }
        }
        return available;

    }

    public Seat makeReservation() {
        List<Seat> seat = findAvailableSeats();
        if (seat.size() > 0) {
            seat.get(0).setIsBooked(true);
            return seat.get(0);
        } else {
            return null;
        }

    }

}
