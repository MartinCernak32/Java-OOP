import java.util.*;

public class PassengerPlane extends PlaneTransport {

    public PassengerPlane(String transportType, String departureDate, String departureTime,
                          String arrivalDate, String arrivalTime, double ticketPrice,
                          int allSeats, int occupiedSeats, int distance, String agencyName,
                          String planeType, String departureLocation, String arrivalLocation) {
        super(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                ticketPrice, allSeats, occupiedSeats, distance, agencyName,
                planeType, departureLocation, arrivalLocation);
    }

    public String showPassengerPlane() {
        return super.showPlaneTransport();
    }
}
