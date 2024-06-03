public class CargoTrain extends TrainTransport 
{
    public double maxWeight;
    public String startCountry;
    public String endCountry;

    public CargoTrain(String transportType, String departureDate, String departureTime,
                      String arrivalDate, String arrivalTime, double ticketPrice,
                      int allSeats, int occupiedSeats, int distance,
                      String agencyName, String trainType, String startCountry,
                      String endCountry, double maxWeight, String departureLocation, String arrivalLocation) 
	{
        super(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
              ticketPrice, allSeats, occupiedSeats, distance, agencyName, trainType,
              departureLocation, arrivalLocation);
        this.startCountry = startCountry;
        this.endCountry = endCountry;
        this.maxWeight = maxWeight;
    }

    public String showCargoTrain() 
	{
        return super.showTrainTransport()
                + this.startCountry + ": " + this.departureTime + " ----------------> "
                + this.arrivalTime + " " + this.endCountry + "\n"
                + "Max cargo weight: " + this.maxWeight + "t \n";
    }

    @Override
    public String toString() {
        return super.toString() + "," + startCountry + "," + endCountry + "," + maxWeight;
    }
}