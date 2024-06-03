import java.util.*;

public class PrivatePlane extends PlaneTransport {

    public PrivatePlane(String transportType, String departureDate, String departureTime,
                        String arrivalDate, String arrivalTime, double ticketPrice,
                        int allSeats, int occupiedSeats, int distance, String agencyName,
                        String planeType, String departureLocation, String arrivalLocation) {
        super(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                ticketPrice, allSeats, occupiedSeats, distance, agencyName,
                planeType, departureLocation, arrivalLocation);
    }

    public String showPrivatePlane() {
        return super.showPlaneTransport();
    }
}
