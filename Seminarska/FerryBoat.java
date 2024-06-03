public class FerryBoat extends BoatTransport 
{
    private int maxNumOfCars;

    public FerryBoat(String transportType, String departureDate, String departureTime,
                     String arrivalDate, String arrivalTime, double ticketPrice,
                     int allSeats, int occupiedSeats, int distance, String agencyName,
                     String boatType, int maxNumOfCars, String departureLocation, String arrivalLocation) 
	{
        super(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                ticketPrice, allSeats, occupiedSeats, distance, agencyName, departureLocation, arrivalLocation, boatType);
        this.maxNumOfCars = maxNumOfCars;
    }

    @Override
	public String toString() 
	{
		return super.toString() + "," + maxNumOfCars; 
	}

    public String showFerryBoat() 
	{
        return super.showBoatTransport() + "Max car spots: " + maxNumOfCars +
                "\nDeparture Location: " + departureLocation +
                "\nArrival Location: " + arrivalLocation;
    }
}



//Boat,2024-06-01,10:30,2024-06-01,13:00,30.0,20,0,50,Maritime Transport,ferry,30,Port A,Port B
//Boat,2024-06-01,10:30,2024-06-01,13:00,30.0,20,0,50,Maritime Transport,ferry,30,Port A,Port B