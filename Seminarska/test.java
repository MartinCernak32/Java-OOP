public static List<BusTransport> ReadBuses() 
	// RETURNS A LIST OF BUSES THAT ARE IN Buses.txt
	{
        List<BusTransport> buses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("buses.txt"))) 
		{
            String line;
            while ((line = br.readLine()) != null) 
			{
                String[] details = line.split(",");
                String transportType = details[0];
                String departureTime = details[1];
                String arrivalTime = details[2];
                int ticketPrice = Integer.parseInt(details[3]);
                int allSeats = Integer.parseInt(details[4]);
                int occupiedSeats = Integer.parseInt(details[5]);
                int distance = Integer.parseInt(details[6]);
                String agencyName = details[7];
                String routeType = details[8];

                if (routeType.equals("national")) 
				{ // National Bus
                    String startCountry = details[9];
                    String endCountry = details[10];
                    NationalBus nationalBus = new NationalBus(transportType, departureTime, arrivalTime, ticketPrice, allSeats, occupiedSeats, distance, agencyName, routeType, startCountry, endCountry);
                    buses.add(nationalBus);
                } 
				else 
				{ // City Bus
                    String startCity = details[9];
                    String endCity = details[10];
                    CityBus cityBus = new CityBus(transportType, departureTime, arrivalTime, ticketPrice, allSeats, occupiedSeats, distance, agencyName, routeType, startCity, endCity);
                    buses.add(cityBus);
                }
            }
        } 
		catch (IOException e) 
		{
            e.printStackTrace();
        }
        return buses;
    }