public class PublicTrain extends TrainTransport 
{
    public String startCountry;
    public String endCountry;

    public PublicTrain(String transportType, String departureDate, String departureTime,
                       String arrivalDate, String arrivalTime, double ticketPrice,
                       int allSeats, int occupiedSeats, int distance,
                       String agencyName, String trainType, String startCountry, String endCountry,
                       String departureLocation, String arrivalLocation) 
	{
        super(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
              ticketPrice, allSeats, occupiedSeats, distance, agencyName, trainType,
              departureLocation, arrivalLocation);
        this.startCountry = startCountry;
        this.endCountry = endCountry;
    }

    public String showPublicTrain() 
	{
        return super.showTrainTransport()
                + this.startCountry + ": " + this.departureTime + " ----------------> "
                + this.arrivalTime + " " + this.endCountry + "\n";
    }

    @Override
    public String toString() {
        return super.toString() + "," + startCountry + "," + endCountry;
    }
}


