import java.util.*;

public class Transport 
{
    public String transportType;
    public String departureDate;
    public String departureTime;
    public String arrivalDate;
    public String arrivalTime;
    public double ticketPrice;
    public int allSeats;
    public int occupiedSeats;
    public int distance;
    public String agencyName;
    public String departureLocation;
    public String arrivalLocation;

    public Transport(String transportType, String departureDate, String departureTime, 
                     String arrivalDate, String arrivalTime, double ticketPrice, 
                     int allSeats, int occupiedSeats, int distance, String agencyName, 
                     String departureLocation, String arrivalLocation) 
	{
        this.transportType = transportType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.ticketPrice = ticketPrice;
        this.allSeats = allSeats;
        this.occupiedSeats = occupiedSeats;
        this.distance = distance;
        this.agencyName = agencyName;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
    }

    public int availableSeats() 
	{
        return allSeats - occupiedSeats;
    }
	
	public boolean reserveSeats(int numSeats) 
	{
        if (numSeats <= availableSeats()) 
		{
            occupiedSeats += numSeats;
            return true;
        }
        return false;
    }

    public String showTransport() 
	{
        return "Transport type: " + transportType + "\n" +
               "Departure date: " + departureDate + "\n" +
               "Departure time: " + departureTime + "\n" +
               "Arrival date: " + arrivalDate + "\n" +
               "Arrival time: " + arrivalTime + "\n" +
               "Ticket price: " + ticketPrice + "\n" +
               "Available seats: " + availableSeats() + "\n" +
               "Distance: " + distance + " km\n" +
               "Agency name: " + agencyName + "\n" +
               "Departure location: " + departureLocation + "\n" +
               "Arrival location: " + arrivalLocation + "\n";
    }
}
