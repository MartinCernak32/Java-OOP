public class TrainTransport extends Transport 
{
    public String trainType;

    public TrainTransport(String transportType, String departureDate, String departureTime,
                          String arrivalDate, String arrivalTime, double ticketPrice,
                          int allSeats, int occupiedSeats, int distance,
                          String agencyName, String trainType, String departureLocation, String arrivalLocation) 
	{
        super(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
              ticketPrice, allSeats, occupiedSeats, distance, agencyName,
              departureLocation, arrivalLocation);
        this.trainType = trainType;
    }

    public String showTrainTransport() 
	{		
        return super.showTransport() + "Train type: " + this.trainType + "\n";
    }

    @Override
    public String toString() 
	{
        return String.join(",", transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                String.valueOf(ticketPrice), String.valueOf(allSeats), String.valueOf(occupiedSeats),
                String.valueOf(distance), agencyName, trainType, departureLocation, arrivalLocation);
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
	
	public String get_departureLocation()
	{
		return this.departureLocation;
	}
	
	public double get_ticketPrice()
	{
		return this.ticketPrice;
	}
	
	public String get_trainType()
	{
		return this.trainType;
	}
}
