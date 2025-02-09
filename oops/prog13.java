// Write a Java program to create a class called "Airplane" which stores all the flights' details and a class "Flight " containing flight number, destination, and departure time attributes, and methods to check flight status and delay.
package oops;

import java.time.LocalTime;
import java.util.*;

class Flight {
    private String flightno;
    private String destination;
    private LocalTime depTime;
    private int delay;

    public Flight(String flightno, String destination, LocalTime depTime) {
        this.flightno = flightno;
        this.destination = destination;
        this.depTime = depTime;
    }

    public String getFlight() {
        return flightno;
    }

    public String getDestination() {
        return destination;
    }

    public LocalTime getTime() {
        return depTime;
    }

    public void delay(int delay) {
        this.delay = delay;

    }

    public LocalTime delayedTime(int delay) {
        return this.depTime = this.depTime.plusMinutes(delay);
    }

    public void status(String flight) {
        if (delay == 0) {
            System.out.println("Flight " + getFlight() + " is on Time");
        } else {
            System.out.println("Flight " + getFlight() + " is delayed by " + delay + " minutes");
        }
    }

    public String check() {
        if (delay == 0) {
            return ("on time");
        } else {
            return ("delayed by " + delay + " minutes , so the new Departure Timing is : " + delayedTime(delay));
        }
    }
}

class Airplane {
    private ArrayList<Flight> flights;

    public Airplane() {
        this.flights = new ArrayList<Flight>();
    }

    public void addFlights(Flight flight) {
        this.flights.add(flight);
        System.out
                .println("Flight " + flight.getFlight() + " to " + flight.getDestination() + " is scheduled book now");
    }

    public void removeFlights(Flight flight) {
        this.flights.remove(flight);
        System.out.println("Flight " + flight.getFlight() + " to " + flight.getDestination() + " is cancelled");
    }

    public void details() {
        System.out.println("All flight details are as follows: ");
        for (Flight f : flights) {
            System.out.println("Flight " + f.getFlight() + " travelling to " + f.getDestination()
                    + " scheduled to depart at " + f.getTime() + " is " + f.check());
        }
    }

}

public class prog13 {
    public static void main(String[] args) {

        Airplane air = new Airplane();
        Flight f1 = new Flight("JDN58461", "London", LocalTime.of(10, 0));
        Flight f2 = new Flight("JDN58845", "America", LocalTime.of(12, 30));
        air.addFlights(f1);
        air.addFlights(f2);

        air.details();
        f2.delay(40);
        air.details();
        air.removeFlights(f2);
        air.details();
    }

}
