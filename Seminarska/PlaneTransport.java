import java.util.*;

public abstract class PlaneTransport extends Transport {
    public String planeType;

    public PlaneTransport(String transportType, String departureDate, String departureTime,
                          String arrivalDate, String arrivalTime, double ticketPrice,
                          int allSeats, int occupiedSeats, int distance, String agencyName,
                          String planeType, String departureLocation, String arrivalLocation) {
        super(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                ticketPrice, allSeats, occupiedSeats, distance, agencyName,
                departureLocation, arrivalLocation);
        this.planeType = planeType;
    }

    public String showPlaneTransport() {
        return super.showTransport() + "Plane type: " + planeType + "\n";
    }

    @Override
    public String toString() {
        return String.join(",", transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                String.valueOf(ticketPrice), String.valueOf(allSeats), String.valueOf(occupiedSeats),
                String.valueOf(distance), agencyName, planeType, departureLocation, arrivalLocation);
    }
	
	public String get_arrivalLocation()
	{
		return this.arrivalLocation;
	}
	
	public String get_arrivalDate()
	{
		return this.arrivalDate;
	}
	
	public String get_departureDate()
	{
		return this.departureDate;
	}
	
	public String get_departureTime()
	{
		return this.departureTime;
	}
	
	public double get_ticketPrice()
	{
		return this.ticketPrice;
	}
	
	public String get_planeType()
	{
		return this.planeType;
	}
	
	public String get_arrivalTime()
	{
		return this.arrivalTime;
	}
	
}
