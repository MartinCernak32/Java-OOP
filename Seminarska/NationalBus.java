public class NationalBus extends BusTransport 
{
	
    public NationalBus(String transportType, String departureDate, String departureTime, 
                       String arrivalDate, String arrivalTime, double ticketPrice, 
                       int allSeats, int occupiedSeats, int distance, String agencyName, 
                       String routeType, String departureLocation, String arrivalLocation) 
	{
        super(transportType, departureDate, departureTime, arrivalDate, arrivalTime, 
              ticketPrice, allSeats, occupiedSeats, distance, agencyName, 
              routeType, departureLocation, arrivalLocation);
    }

    public String showNationalBus() 
	{
        return super.showBus();
    }
	
	@Override
	public String toString()
	{
		return super.toString();
	}
}
