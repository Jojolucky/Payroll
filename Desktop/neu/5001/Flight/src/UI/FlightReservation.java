/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Flight.Customer;
import Flight.Flight;
import Flight.Seat;
import Flight.SeatReservation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jojo
 */
public class FlightReservation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Seat> initial=new ArrayList();
        for(int i=0; i<10; i++){
            initial.add(new Seat(i+1));
       
        }
        
       Flight flight=new Flight("Chongqing","Boston"," E343","10:30","12:30",initial);
       
       Customer Jojo=new Customer("Jojo", 1234);
        Customer Lucy=new Customer("Lucy", 1123);
        Customer Nancy=new Customer("Nancy", 1244);
        Customer Ben=new Customer("Ben", 1314);
        Customer Jack=new Customer("Jack", 1333);
        Customer Hanna=new Customer("Hanna", 1432);
        
        
        SeatReservation beginReservation=new SeatReservation();
        beginReservation.seatReservation(flight, Jojo);
        beginReservation.seatReservation(flight, Lucy);
        beginReservation.seatReservation(flight, Nancy);
        beginReservation.seatReservation(flight, Ben);
             
            
        beginReservation.WindowSeatReservation(flight,Jack);
        beginReservation.WindowSeatReservation(flight,Hanna);
       }
    }
   
