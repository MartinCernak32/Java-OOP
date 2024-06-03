import java.util.*;

public class Rocket extends Transport
{
	public String rocketType;
	
	public Rocket(String transportType, String departureDate, String departureTime, 
                     String arrivalDate, String arrivalTime, double ticketPrice, 
                     int allSeats, int occupiedSeats, int distance, String agencyName, 
                     String departureLocation, String arrivalLocation, String rocketType)
	{
		super(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
              ticketPrice, allSeats, occupiedSeats, distance, agencyName, departureLocation, arrivalLocation);
		
		this.rocketType = rocketType;
	}
	
	@Override
    public String toString() 
	{
        return String.join(",", transportType, departureDate, departureTime,
                        arrivalDate, arrivalTime, String.valueOf(ticketPrice),
                        String.valueOf(allSeats), String.valueOf(occupiedSeats),
                        String.valueOf(distance), agencyName,departureLocation, 
						arrivalLocation,rocketType);
    }
	
	public String showRocket() 
	{
        return super.showTransport() + "Rocket type: " + rocketType + "\n";
    }
	
	public String get_arrivalLocation()
	{
		return this.arrivalLocation;
	}
	
	public String get_arrivalTime()
	{
		return this.arrivalTime;
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
	
	public String get_rocketType()
	{
		return this.rocketType;
	}
}
	
