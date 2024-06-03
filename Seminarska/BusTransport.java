public class BusTransport extends Transport 
{
	
    public String routeType;

    public BusTransport(String transportType, String departureDate, String departureTime, 
                        String arrivalDate, String arrivalTime, double ticketPrice, 
                        int allSeats, int occupiedSeats, int distance, String agencyName, 
                        String routeType, String departureLocation, String arrivalLocation) 
	{
        super(transportType, departureDate, departureTime, arrivalDate, arrivalTime, 
              ticketPrice, allSeats, occupiedSeats, distance, agencyName, 
              departureLocation, arrivalLocation);
        this.routeType = routeType;
    }

    public String showBus() 
	{
        return super.showTransport() + "Route type: " + routeType + "\n";
    }
	
	@Override
	public String toString()
    {
        return String.join(",", transportType, departureDate, departureTime, arrivalDate, arrivalTime, 
              String.valueOf(ticketPrice), String.valueOf(allSeats), String.valueOf(occupiedSeats), 
              String.valueOf(distance), agencyName,routeType, departureLocation, arrivalLocation);
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
	
	public String get_routeType()
	{
		return this.routeType;
	}
	

}
