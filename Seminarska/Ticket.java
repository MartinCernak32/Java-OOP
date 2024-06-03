public class Ticket 
{
    public String transportType;
    public String departureDate;
    public String departureTime;
    public String arrivalDate;
    public String arrivalTime;
    public double ticketPrice;
    public String agencyName;
    public String departureLocation;
    public String arrivalLocation;
    public String buyerName;

    public Ticket(String transportType, String departureDate, String departureTime,
                  String arrivalDate, String arrivalTime, double ticketPrice,
                  String agencyName, String departureLocation, String arrivalLocation,
                  String buyerName) 
		{ 
        this.transportType = transportType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.ticketPrice = ticketPrice;
        this.agencyName = agencyName;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.buyerName = buyerName;
    }

    public String showTicket() 
	{
        return "Ticket for: " + transportType + "\n" +
               "Departure: " + departureDate + " " + departureTime + "\n" +
               "Arrival: " + arrivalDate + " " + arrivalTime + "\n" +
               "Price: " + ticketPrice + "\n" +
               "Agency: " + agencyName + "\n" +
               "From: " + departureLocation + "\n" +
               "To: " + arrivalLocation + "\n" +
               "Buyer: " + buyerName + "\n";
    }
	
	public String toString() 
	{
		return String.join(",", transportType, departureDate, departureTime,
                        arrivalDate, arrivalTime, String.valueOf(ticketPrice),
                        agencyName, departureLocation, arrivalLocation, buyerName);
	}
	
}