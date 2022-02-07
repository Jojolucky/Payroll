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
public class SeatReservation {

    public void seatReservation(Flight flight, Customer customer) {

        Seat seat = flight.makeReservation();
        if (seat != null) {
            System.out.println("-----------------------");
            System.out.println("Reservation Successful!");
            System.out.println("Hello, " + customer.getName() + "! The seat number is : " + seat.seat_number);
            System.out.println("The flight number is: " + flight.flight_number + ". From " + flight.getSource() + " to " + flight.getDestination() + ".");
        } else {
            System.out.println("Reservation Failed");
        }
    }

    public void WindowSeatReservation(Flight flight, Customer customer) {
        List<Seat> windowSeat = new ArrayList<>();
        for (int i = 0; i < flight.seats.size(); i += 5) {
            if (!flight.seats.get(i).isIsBooked()) {
                windowSeat.add(flight.seats.get(i));
            }

        }
        if (windowSeat.size() == 0) {
            System.out.println("-----------------------");
            System.out.println("Sorry," + customer.getName() + "! There is not enough window seat!");
        } else {
            windowSeat.get(0).setIsBooked(true);
            System.out.println("-----------------------");
            System.out.println("Reservation Successful!");
            System.out.println("Hello, " + customer.getName() + "! The window seat number is " + windowSeat.get(0).getSeat_number());
            System.out.println("The flight number is: " + flight.flight_number + ". From " + flight.getSource() + " to " + flight.getDestination() + ".");

        }

    }

}
