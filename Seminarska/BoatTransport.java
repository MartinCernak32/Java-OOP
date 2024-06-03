public class BoatTransport extends Transport 
{
    public String boatType;

    public BoatTransport(String transportType, String departureDate, String departureTime,
                         String arrivalDate, String arrivalTime, double ticketPrice,
                         int allSeats, int occupiedSeats, int distance, String agencyName,
                         String departureLocation, String arrivalLocation, String boatType) 
	{
        super(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
              ticketPrice, allSeats, occupiedSeats, distance, agencyName, departureLocation, arrivalLocation);
        this.boatType = boatType;
    }

    @Override
    public String toString() 
	{
        return String.join(",", transportType, departureDate, departureTime,
                        arrivalDate, arrivalTime, String.valueOf(ticketPrice),
                        String.valueOf(allSeats), String.valueOf(occupiedSeats),
                        String.valueOf(distance), agencyName, boatType, departureLocation, arrivalLocation);
    }
	
    public String showBoatTransport() 
	{
        return super.showTransport() + "Boat type: " + boatType + "\n";
    }
	
	public String get_arrivalLocation()
	{
		return this.arrivalLocation;
	}
	
	public String get_arrivalTime()
	{
		return this.arrivalTime;
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
	
	public String get_boatType()
	{
		return this.boatType;
	}
}