import java.io.*;
import java.util.*;

public class Seminarska {
    public static void main(String[] args) 
	{
        List<BusTransport> buses = ReadBuses();
        List<TrainTransport> trains = ReadTrains();
		List<PlaneTransport> planes = ReadPlanes();
		List<BoatTransport> boats = ReadBoats();
		List<Rocket> rockets = ReadRockets();
		List<Ticket> tickets = ReadTickets("Tickets.txt");

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        
        do {
            System.out.println("Select the type of transport:");
            System.out.println("1. Buses");
            System.out.println("2. Trains");
            System.out.println("3. Planes");
            System.out.println("4. Boats");
            System.out.println("5. Rockets");
			System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
			scanner.nextLine();
            
			
            switch (choice) 
			{
                case 1:
                    System.out.println("Select operation: ");
					System.out.println("1. Display Buses");
					System.out.println("2. Add NewBus");
					System.out.println("3. Remove Bus");
					System.out.println("4. Search For Bus");
					System.out.println("5. Reserve A Ticket");
					System.out.print("Enter your choice: ");
					int busOperationChoice = scanner.nextInt();
					scanner.nextLine();
					
					switch(busOperationChoice)
					{
						case 1:
							DisplayBuses(buses);
							break;
						case 2:
							AddNewBus(buses);
							break;
						case 3:
							DeleteBus(buses);
							break;
						case 4:
							SearchBus(buses);
							break;
						case 5:
							ReserveBusTicket(buses);
							
						default:
							System.out.println("Invalid operation choice.");
							break;
					}	
					break;
                case 2:
                    System.out.println("Select operation: ");
					System.out.println("1. Display Trains");
					System.out.println("2. Add Train");
					System.out.println("3. Remove Train");
					System.out.println("4. Search For Train");
					System.out.println("5. Reserve A Ticket");
					System.out.print("Enter your choice: ");
					int trainOperationChoice = scanner.nextInt();
					scanner.nextLine();
					
					switch(trainOperationChoice)
					{
						case 1:
							DisplayTrains(trains);
							break;
						case 2:
							AddNewTrain(trains);
							break;
						case 3:
							DeleteTrain(trains);
							break;
						case 4:
							SearchTrains(trains);
							break;
						case 5:
							ReserveTrainTicket(trains);
							
						default:
							System.out.println("Invalid operation choice.");
							break;
					}
                    break;
                case 3:
                    System.out.println("Select operation: ");
					System.out.println("1. Display Planes");
					System.out.println("2. Add Planes");
					System.out.println("3. Remove Planes");
					System.out.println("4. Search For Planes");
					System.out.println("5. Reserve A Ticket");
					System.out.print("Enter your choice: ");
					int planeOperationChoice = scanner.nextInt();
					scanner.nextLine();
					
					switch(planeOperationChoice)
					{
						case 1:
							DisplayPlanes(planes);
							break;
						case 2:
							AddNewPlane(planes);
							break;
						case 3:
							DeletePlane(planes);
							break;
						case 4:
							SearchPlane(planes);
							break;
						case 5:
							ReservePlaneTicket(planes);
							break;
							
						default:
							System.out.println("Invalid operation choice.");
							break;
					}
                    break;
                case 4:
                    System.out.println("Select operation: ");
					System.out.println("1. Display Boats");
					System.out.println("2. Add Boats");
					System.out.println("3. Remove Boats");
					System.out.println("4. Search For Boats");
					System.out.println("5. Reserve A Ticket");
					System.out.print("Enter your choice: ");
					int boatOperationChoice = scanner.nextInt();
					scanner.nextLine();
					
					switch(boatOperationChoice)
					{
						case 1:
							DisplayBoats(boats);
							break;
						case 2:
							AddNewBoat(boats);
							break;
						case 3:
							DeleteBoat(boats);
							break;
						case 4:
							SearchBoat(boats);
							break;
						case 5:
							ReserveBoatTicket(boats);
							
						default:
							System.out.println("Invalid operation choice.");
							break;
					}
                    break;
				case 5:
                    System.out.println("Select operation: ");
					System.out.println("1. Display Rockets");
					System.out.println("2. Add New Rocket");
					System.out.println("3. Remove Rocket");
					System.out.println("4. Search For Rocket");
					System.out.println("5. Reserve A Ticket");
					System.out.print("Enter your choice: ");
					int rocketOperationChoice = scanner.nextInt();
					scanner.nextLine();
					
					switch(rocketOperationChoice)
					{
						case 1:
							DisplayRockets(rockets);
							break;
						case 2:
							AddNewRocket(rockets);
							break;
						case 3:
							DeleteRocket(rockets);
							break;
						case 4:
							SearchRocket(rockets);
							break;
						case 5:
							ReserveRocketTicket(rockets);
							
						default:
							System.out.println("Invalid operation choice.");
							break;
					}	
					break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
					break;
            }
        } while (choice != 0);
        
        scanner.close();
    }
    

    // BUSES BUSES BUSES //
    public static List<BusTransport> ReadBuses() 
	{
        List<BusTransport> buses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Buses.txt"))) {
            String line;
            while ((line = br.readLine()) != null) 
			{
                String[] details = line.split(",");
                String transportType = details[0];
                String departureDate = details[1];
                String departureTime = details[2];
                String arrivalDate = details[3];
                String arrivalTime = details[4];
                double ticketPrice = Double.parseDouble(details[5]);
                int allSeats = Integer.parseInt(details[6]);
                int occupiedSeats = Integer.parseInt(details[7]);
                int distance = Integer.parseInt(details[8]);
                String agencyName = details[9];
                String routeType = details[10];
                String departureLocation = details[11];
                String arrivalLocation = details[12];

                if (routeType.equals("national")) 
				{
                    NationalBus nationalBus = new NationalBus(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                                                              ticketPrice, allSeats, occupiedSeats, distance, agencyName, routeType, departureLocation, arrivalLocation);
                    buses.add(nationalBus);
                } 
				else 
				{
                    CityBus cityBus = new CityBus(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                                                  ticketPrice, allSeats, occupiedSeats, distance, agencyName, routeType, departureLocation, arrivalLocation);
                    buses.add(cityBus);
                }
				
				
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buses;
    }

    public static void DisplayBuses(List<BusTransport> buses) 
	{
        for (BusTransport bus : buses) 
		{
            if (bus instanceof NationalBus) 
			{
                System.out.println(((NationalBus) bus).showNationalBus());
                System.out.println();
            } 
			else if (bus instanceof CityBus) 
			{
                System.out.println(((CityBus) bus).showCityBus());
                System.out.println();
            } 
			else 
			{
                System.out.println(bus.showBus());
                System.out.println();
            }
        }
    }
	
	public static void AddNewBus(List<BusTransport> buses) 
	{
		Scanner scanner = new Scanner(System.in);

		
		String transportType = "Bus";

		System.out.print("Enter departure date (yyyy-mm-dd): ");
		String departureDate = scanner.nextLine();

		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();

		System.out.print("Enter arrival date (yyyy-mm-dd): ");
		String arrivalDate = scanner.nextLine();

		System.out.print("Enter arrival time (hh:mm): ");
		String arrivalTime = scanner.nextLine();

		System.out.print("Enter ticket price: ");
		double ticketPrice = scanner.nextDouble();

		System.out.print("Enter total seats: ");
		int allSeats = scanner.nextInt();

		System.out.print("Enter occupied seats: ");
		int occupiedSeats = scanner.nextInt();

		System.out.print("Enter distance: ");
		int distance = scanner.nextInt();

		scanner.nextLine();  // Consume newline

		System.out.print("Enter agency name: ");
		String agencyName = scanner.nextLine();

		System.out.print("Enter route type (e.g., national, city): ");
		String routeType = scanner.nextLine();

		System.out.print("Enter departure location: ");
		String departureLocation = scanner.nextLine();

		System.out.print("Enter arrival location: ");
		String arrivalLocation = scanner.nextLine();

		BusTransport newBus;
		if (routeType.equals("national")) 
		{
			newBus = new NationalBus(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                ticketPrice, allSeats, occupiedSeats, distance, agencyName, routeType,
                departureLocation, arrivalLocation);
		} 
		else if (routeType.equals("city"))
		{
			newBus = new CityBus(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                ticketPrice, allSeats, occupiedSeats, distance, agencyName, routeType,
                departureLocation, arrivalLocation);
		}
		else
		{
			System.out.println("Invalid bus route type try again.");
			return;
		}

		buses.add(newBus);
		WriteBusesToFile(buses);  // Write to file
	}
	
	public static void DeleteBus(List<BusTransport> buses) 
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter bus type to delete (e.g., national, city): ");
		String routeType = scanner.nextLine();

		System.out.print("Enter departure date (yyyy-mm-dd): ");
		String departureDate = scanner.nextLine();

		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();
		
		System.out.print("Enter arrival location (yyyy-mm-dd): ");
		String arrivalLocation = scanner.nextLine();
		
		System.out.print("Enter arrival time (hh:mm): ");
		String arrivalTime = scanner.nextLine();

		Iterator<BusTransport> iterator = buses.iterator();
		while (iterator.hasNext()) 
		{
			BusTransport bus = iterator.next();
			if (bus.get_routeType().equals(routeType) &&
				bus.get_departureDate().equals(departureDate) &&
				bus.get_departureTime().equals(departureTime) &&
				bus.get_arrivalLocation().equals(arrivalLocation) &&
				bus.get_arrivalTime().equals(arrivalTime)) 
				{
				iterator.remove();
				System.out.println("Bus removed successfully.");
				WriteBusesToFile(buses);
				
				return;
			}
		}
		System.out.println("No matching bus found.");
		
	}
	
	public static void SearchBus(List<BusTransport> buses) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter transport arrival location to search: ");
		String arrivalLocation = scanner.nextLine();
		System.out.print("Enter arrival date (yyyy-mm-dd): ");
		String arrivalDate = scanner.nextLine();

		for (BusTransport bus : buses) 
		{
			if (bus.get_arrivalLocation().equals(arrivalLocation) &&
				bus.get_arrivalDate().equals(arrivalDate))
			{
				System.out.println("Bus found:");
				System.out.println(bus.showBus());
				return;
			}
		}
		System.out.println("No matching bus found.");
	}
		
	public static void WriteBusesToFile(List<BusTransport> buses) 
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Buses.txt"))) 
		{
			for (BusTransport bus : buses) 
			{
				bw.write(bus.toString());
				bw.newLine();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

    

    // TRAINS TRAINS TRAINS //
	
    public static List<TrainTransport> ReadTrains() 
	{
        List<TrainTransport> trains = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Trains.txt"))) 
		{
            String line;
            while ((line = br.readLine()) != null) 
			{				
                String[] details = line.split(",");
                String transportType = details[0];
                String departureDate = details[1];
                String departureTime = details[2];
                String arrivalDate = details[3];
                String arrivalTime = details[4];
                double ticketPrice = Double.parseDouble(details[5]);
                int allSeats = Integer.parseInt(details[6]);
                int occupiedSeats = Integer.parseInt(details[7]);
                int distance = Integer.parseInt(details[8]);
                String agencyName = details[9];
                String trainType = details[10];
                String departureLocation = details[11];
                String arrivalLocation = details[12];
                String startCountry = details[13];
                String endCountry = details[14];

                if (trainType.equals("public")) 
				{
                    PublicTrain publicTrain = new PublicTrain(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                                                              ticketPrice, allSeats, occupiedSeats, distance, agencyName, trainType,
                                                              startCountry, endCountry, departureLocation, arrivalLocation);
                    trains.add(publicTrain);
                } 
				else 
				{
                    double maxWeight = Double.parseDouble(details[15]);
                    CargoTrain cargoTrain = new CargoTrain(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                                                           ticketPrice, allSeats, occupiedSeats, distance, agencyName, trainType,
                                                           startCountry, endCountry, maxWeight, departureLocation, arrivalLocation);
                    trains.add(cargoTrain);
                }
            }
        } 
		catch (IOException e) 
		{
            e.printStackTrace();
        }
        return trains;
    }

    public static void DisplayTrains(List<TrainTransport> trains) {
        for (TrainTransport train : trains) {
            if (train instanceof PublicTrain) {
                System.out.println(((PublicTrain) train).showPublicTrain());
                System.out.println();
            } else if (train instanceof CargoTrain) {
                System.out.println(((CargoTrain) train).showCargoTrain());
                System.out.println();
            } else {
                System.out.println(train.showTrainTransport());
                System.out.println();
            }
        }
    }

	public static void AddNewTrain(List<TrainTransport> trains) 
	{
		Scanner scanner = new Scanner(System.in);

		
		String transportType = "Train";

		System.out.print("Enter departure date (yyyy-mm-dd): ");
		String departureDate = scanner.nextLine();

		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();

		System.out.print("Enter arrival date (yyyy-mm-dd): ");
		String arrivalDate = scanner.nextLine();

		System.out.print("Enter arrival time (hh:mm): ");
		String arrivalTime = scanner.nextLine();

		System.out.print("Enter ticket price: ");
		double ticketPrice = scanner.nextDouble();

		System.out.print("Enter total seats: ");
		int allSeats = scanner.nextInt();

		System.out.print("Enter occupied seats: ");
		int occupiedSeats = scanner.nextInt();

		System.out.print("Enter distance: ");
		int distance = scanner.nextInt();

		scanner.nextLine();  // Consume newline

		System.out.print("Enter agency name: ");
		String agencyName = scanner.nextLine();

		System.out.print("Enter train type (e.g., public, cargo): ");
		String trainType = scanner.nextLine();

		System.out.print("Enter start country: ");
		String startCountry = scanner.nextLine();

		System.out.print("Enter end country: ");
		String endCountry = scanner.nextLine();

		System.out.print("Enter departure city: ");
		String departureLocation = scanner.nextLine();

		System.out.print("Enter arrival city: ");
		String arrivalLocation = scanner.nextLine();

		TrainTransport newTrain;
		if (trainType.equals("public")) 
		{
			newTrain = new PublicTrain(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                ticketPrice, allSeats, occupiedSeats, distance, agencyName, trainType,
                startCountry, endCountry, departureLocation, arrivalLocation);
		} 
		else 
		{
			System.out.print("Enter max weight: ");
			double maxWeight = scanner.nextDouble();
			newTrain = new CargoTrain(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                ticketPrice, allSeats, occupiedSeats, distance, agencyName, trainType,
                startCountry, endCountry, maxWeight, departureLocation, arrivalLocation);
		}

		trains.add(newTrain);
		WriteTrainsToFile(trains);  // Write to file
	}

	public static void DeleteTrain(List<TrainTransport> trains) 
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter train type to delete (e.g., public, cargo): ");
		String trainType = scanner.nextLine();

		System.out.print("Enter departure date (yyyy-mm-dd): ");
		String departureDate = scanner.nextLine();

		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();
		
		System.out.print("Enter arrival location (yyyy-mm-dd): ");
		String arrivalLocation = scanner.nextLine();
		
		System.out.print("Enter arrival time (hh:mm): ");
		String arrivalTime = scanner.nextLine();

		Iterator<TrainTransport> iterator = trains.iterator();
		while (iterator.hasNext()) 
		{
			TrainTransport train = iterator.next();
			if (train.get_trainType().equals(trainType) &&
				train.get_departureDate().equals(departureDate) &&
				train.get_departureTime().equals(departureTime) &&
				train.get_arrivalLocation().equals(arrivalLocation) &&
				train.get_arrivalTime().equals(arrivalTime)) 
				{
				iterator.remove();
				System.out.println("Train removed successfully.");
				WriteTrainsToFile(trains);
				
				return;
			}
		}
		System.out.println("No matching train found.");
		
	}

    public static void SearchTrains(List<TrainTransport> trains) 
	{
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter train type (cargo or public): ");
        String trainType = scanner.nextLine();

        System.out.print("Enter arrival location: ");
        String arrivalLocation = scanner.nextLine();

        System.out.print("Enter arrival date (yyyy-mm-dd): ");
        String arrivalDate = scanner.nextLine();

        for (TrainTransport train : trains) 
		{
			if (train instanceof CargoTrain && 
				train.get_trainType().equals(trainType) &&
				train.get_arrivalLocation().equals(arrivalLocation) && 
				train.get_arrivalDate().equals(arrivalDate)) 
			{
				System.out.println("Cargo Train found:");
				System.out.println(((CargoTrain) train).showCargoTrain());
				return;
			} 
			else if (train instanceof PublicTrain && 
					 train.get_trainType().equals(trainType) &&
					 train.get_arrivalLocation().equals(arrivalLocation) && 
					 train.get_arrivalDate().equals(arrivalDate)) 
			{
				System.out.println("Public Train found:");
				System.out.println(((PublicTrain) train).showPublicTrain());
				return;
			}
		}

		System.out.println("No matching train found.");
	}
	
	public static void WriteTrainsToFile(List<TrainTransport> trains) 
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Trains.txt"))) 
		{
			for (TrainTransport train : trains) 
			{
				bw.write(train.toString());
				bw.newLine();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}



	
	// PLANES PLANES PLANES //
	
	public static List<PlaneTransport> ReadPlanes() 
	{
		List<PlaneTransport> planes = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("Planes.txt"))) 
		{
			String line;
			while ((line = br.readLine()) != null) {
				String[] details = line.split(",");
				String transportType = details[0];
				String departureDate = details[1];
				String departureTime = details[2];
				String arrivalDate = details[3];
				String arrivalTime = details[4];
				double ticketPrice = Double.parseDouble(details[5]);
				int allSeats = Integer.parseInt(details[6]);
				int occupiedSeats = Integer.parseInt(details[7]);
				int distance = Integer.parseInt(details[8]);
				String agencyName = details[9];
				String planeType = details[10];
				String departureLocation = details[11];
				String arrivalLocation = details[12];

				if (planeType.equals("private")) {
					PrivatePlane privatePlane = new PrivatePlane(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
																ticketPrice, allSeats, occupiedSeats, distance, agencyName, planeType,
																departureLocation, arrivalLocation);
					planes.add(privatePlane);
				} 
				else 
				{
					PassengerPlane passengerPlane = new PassengerPlane(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                                                                   ticketPrice, allSeats, occupiedSeats, distance, agencyName, planeType,
                                                                   departureLocation, arrivalLocation);
					planes.add(passengerPlane);
				}
			}
		} 		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return planes;
	}
		
	public static void DisplayPlanes(List<PlaneTransport> planes) 
	{
		for (PlaneTransport plane : planes) 
		{
			if (plane instanceof PrivatePlane) 
			{
				System.out.println(((PrivatePlane) plane).showPrivatePlane());
				System.out.println();
			} 
			else if (plane instanceof PassengerPlane) 
			{
				System.out.println(((PassengerPlane) plane).showPassengerPlane());
				System.out.println();
			} 
			else 
			{
				System.out.println(plane.showPlaneTransport());
				System.out.println();
			}
		}
	}
		
	public static void AddNewPlane(List<PlaneTransport> planes) 
	{
        Scanner scanner = new Scanner(System.in);

        
        String transportType = "Plane";

        System.out.print("Enter departure date (yyyy-mm-dd): ");
        String departureDate = scanner.nextLine();

        System.out.print("Enter departure time (hh:mm): ");
        String departureTime = scanner.nextLine();

        System.out.print("Enter arrival date (yyyy-mm-dd): ");
        String arrivalDate = scanner.nextLine();

        System.out.print("Enter arrival time (hh:mm): ");
        String arrivalTime = scanner.nextLine();

        System.out.print("Enter ticket price: ");
        double ticketPrice = scanner.nextDouble();

        System.out.print("Enter total seats: ");
        int allSeats = scanner.nextInt();

        System.out.print("Enter occupied seats: ");
        int occupiedSeats = scanner.nextInt();

        System.out.print("Enter distance: ");
        int distance = scanner.nextInt();

        scanner.nextLine(); 

        System.out.print("Enter agency name: ");
        String agencyName = scanner.nextLine();

        System.out.print("Enter plane type (e.g., private, passenger): ");
        String planeType = scanner.nextLine();

        System.out.print("Enter departure location: ");
        String departureLocation = scanner.nextLine();

        System.out.print("Enter arrival location: ");
        String arrivalLocation = scanner.nextLine();

        PlaneTransport newPlane;
        if (planeType.equals("private")) 
		{
            newPlane = new PrivatePlane(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                    ticketPrice, allSeats, occupiedSeats, distance, agencyName, planeType,
                    departureLocation, arrivalLocation);
        } 
		else 
		{
            newPlane = new PassengerPlane(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                    ticketPrice, allSeats, occupiedSeats, distance, agencyName, planeType,
                    departureLocation, arrivalLocation);
        }

        planes.add(newPlane);
        WritePlanesToFile(planes);  // Write to file
    }
	
	public static void DeletePlane(List<PlaneTransport> planes) 
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter plane type to delete (e.g., passenger, private): ");
		String planeType = scanner.nextLine();

		System.out.print("Enter departure date (yyyy-mm-dd): ");
		String departureDate = scanner.nextLine();

		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();
		
		System.out.print("Enter arrival location (yyyy-mm-dd): ");
		String arrivalLocation = scanner.nextLine();
		
		System.out.print("Enter arrival time (hh:mm): ");
		String arrivalTime = scanner.nextLine();

		Iterator<PlaneTransport> iterator = planes.iterator();
		while (iterator.hasNext()) 
		{
			PlaneTransport plane = iterator.next();
			if (plane.get_planeType().equals(planeType) &&
				plane.get_departureDate().equals(departureDate) &&
				plane.get_departureTime().equals(departureTime) &&
				plane.get_arrivalLocation().equals(arrivalLocation) &&
				plane.get_arrivalTime().equals(arrivalTime)) 
				{
				iterator.remove();
				System.out.println("Plane removed successfully.");
				WritePlanesToFile(planes);
				
				return;
			}
		}
		System.out.println("No matching plane found.");
	}
	
	public static void SearchPlane(List<PlaneTransport> planes) 
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter plane type (passenger or private): ");
		String planeType = scanner.nextLine();

		System.out.print("Enter arrival location: ");
		String arrivalLocation = scanner.nextLine();

		System.out.print("Enter arrival date (yyyy-mm-dd): ");
		String arrivalDate = scanner.nextLine();

		for (PlaneTransport plane : planes) 
		{
			if (plane instanceof PassengerPlane && 
				plane.get_planeType().equals(planeType) &&
				plane.get_arrivalLocation().equals(arrivalLocation) && 
				plane.get_arrivalDate().equals(arrivalDate)) 
			{
				System.out.println("Passenger Plane found:");
				System.out.println(((PassengerPlane) plane).showPassengerPlane());
				return;
			} 
			else if (plane instanceof PrivatePlane && 
					 plane.get_planeType().equals(planeType) &&
					 plane.get_arrivalLocation().equals(arrivalLocation) && 
					 plane.get_arrivalDate().equals(arrivalDate)) 
			{
				System.out.println("Private Plane found:");
				System.out.println(((PrivatePlane) plane).showPrivatePlane());
				return;
			}
		}

		System.out.println("No matching plane found.");
	}
	
	public static void WritePlanesToFile(List<PlaneTransport> planes) 
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Planes.txt"))) 
		{
			for (PlaneTransport plane : planes) 
			{
				bw.write(plane.toString());
				bw.newLine();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}



	// BOATS BOATS BOATS //
	
	public static List<BoatTransport> ReadBoats() 
	{
		List<BoatTransport> boats = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("Boats.txt"))) 
		{
			String line;
			while ((line = br.readLine()) != null) 
			{
				String[] details = line.split(",");
				String transportType = details[0];
				String departureDate = details[1];
				String departureTime = details[2];
				String arrivalDate = details[3];
				String arrivalTime = details[4];
				double ticketPrice = Double.parseDouble(details[5]);
				int allSeats = Integer.parseInt(details[6]);
				int occupiedSeats = Integer.parseInt(details[7]);
				int distance = Integer.parseInt(details[8]);
				String agencyName = details[9];
				String boatType = details[10];
				BoatTransport newBoat;
				if (boatType.equals("ferry")) 
				{
					
					String departureLocation = details[11];
					String arrivalLocation = details[12];
					int maxNumOfCars = Integer.parseInt(details[13]);
					newBoat = new FerryBoat(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                        ticketPrice, allSeats, occupiedSeats, distance, agencyName, boatType,
                        maxNumOfCars, departureLocation, arrivalLocation);
						
					boats.add(newBoat);
				} 
				
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return boats;
	}

    public static void DisplayBoats(List<BoatTransport> boats) {
        for (BoatTransport boat : boats) {
            if (boat instanceof FerryBoat) {
                System.out.println(((FerryBoat) boat).showFerryBoat());
            } else {
                System.out.println(boat.showBoatTransport());
            }
            System.out.println();
        }
    }

    public static void AddNewBoat(List<BoatTransport> boats) 
	{
		Scanner scanner = new Scanner(System.in);
		String transportType = "Boat";
		System.out.print("Enter departure date (yyyy-mm-dd): ");
		String departureDate = scanner.nextLine();
		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();
		System.out.print("Enter arrival date (yyyy-mm-dd): ");
		String arrivalDate = scanner.nextLine();
		System.out.print("Enter arrival time (hh:mm): ");
		String arrivalTime = scanner.nextLine();
		System.out.print("Enter ticket price: ");
		double ticketPrice = scanner.nextDouble();
		scanner.nextLine();  
		System.out.print("Enter total seats: ");
		int allSeats = scanner.nextInt();
		scanner.nextLine();  
		System.out.print("Enter occupied seats: ");
		int occupiedSeats = scanner.nextInt();
		scanner.nextLine();  
		System.out.print("Enter distance: ");
		int distance = scanner.nextInt();
		scanner.nextLine();  // Consume newline
		System.out.print("Enter agency name: ");
		String agencyName = scanner.nextLine();		
		String boatType = "ferry";
		BoatTransport newBoat;
		if (boatType.equals("ferry")) 
		{
			System.out.print("Enter max number of cars: ");
			int maxNumOfCars = scanner.nextInt();
			scanner.nextLine();  // Consume newline
			System.out.print("Enter departure location: ");
			String departureLocation = scanner.nextLine();
			System.out.print("Enter arrival location: ");
			String arrivalLocation = scanner.nextLine();
			newBoat = new FerryBoat(transportType, departureDate, departureTime, arrivalDate, arrivalTime,
                    ticketPrice, allSeats, occupiedSeats, distance, agencyName, boatType, maxNumOfCars,
                    departureLocation, arrivalLocation);
			boats.add(newBoat);
			writeBoatsToFile(boats);
		}
		else
		{
			System.out.println("Invalid Boat type");
		}
	}
	
	public static void SearchBoat(List<BoatTransport> boats) 
	{
        Scanner scanner = new Scanner(System.in);

        // Ask for the arrival location
        System.out.print("Enter arrival location: ");
        String arrivalLocation = scanner.nextLine();

        // Ask for the departure date
        System.out.print("Enter departure date (yyyy-mm-dd): ");
        String departureDate = scanner.nextLine();

        // Ask for the arrival date
        System.out.print("Enter arrival date (yyyy-mm-dd): ");
        String arrivalDate = scanner.nextLine();

        boolean boatFound = false;
        
        for (BoatTransport boat : boats) 
		{
            if (boat.arrivalLocation.equals(arrivalLocation) &&
                boat.departureDate.equals(departureDate) &&
                boat.arrivalDate.equals(arrivalDate)) 
			{

                System.out.println("Matching boat found:");
                System.out.println(boat);
                boatFound = true;
            }
        }

        if (!boatFound) 
		{
            System.out.println("No matching boat found.");
        }

        
    }
		
    public static void DeleteBoat(List<BoatTransport> boats) 
	{
        Scanner scanner = new Scanner(System.in);
        String boatType = "ferry";
		
        System.out.print("Enter departure date (yyyy-mm-dd): ");
		String departureDate = scanner.nextLine();

		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();
		
		System.out.print("Enter arrival location (yyyy-mm-dd): ");
		String arrivalLocation = scanner.nextLine();
		
		System.out.print("Enter arrival time (hh:mm): ");
		String arrivalTime = scanner.nextLine();

		Iterator<BoatTransport> iterator = boats.iterator();
		while (iterator.hasNext()) 
		{
			BoatTransport boat = iterator.next();
			if (boat.get_boatType().equals(boatType) &&
				boat.get_departureDate().equals(departureDate) &&
				boat.get_departureTime().equals(departureTime) &&
				boat.get_arrivalLocation().equals(arrivalLocation) &&
				boat.get_arrivalTime().equals(arrivalTime)) 
				{
				iterator.remove();
				System.out.println("Boat removed successfully.");
				writeBoatsToFile(boats);
				
				return;
			}
		}
        System.out.println("No matching boat found.");
    }

    public static void writeBoatsToFile(List<BoatTransport> boats) 
	{
		try (PrintWriter writer = new PrintWriter(new FileWriter("Boats.txt"))) 
		{
			for (BoatTransport boat : boats) 
			{
				writer.println(boat.toString());
			}
			
		} 
		catch (IOException e) 
		{
			System.err.println("Error writing boats data to file: " + e.getMessage());
		}
	}
	
	// ROCKET ROCKET ROCKET //
	
	public static List<Rocket> ReadRockets()
	{
		List<Rocket> rockets = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader("Rockets.txt"))) 
		{
			String line;
			while ((line = br.readLine()) != null) 
			{
				String[] details = line.split(",");
				String transportType = details[0];
				String departureDate = details[1];
				String departureTime = details[2];
                String arrivalDate = details[3];
				String arrivalTime = details[4];
				double ticketPrice = Double.parseDouble(details[5]);
                int allSeats = Integer.parseInt(details[6]);
				int occupiedSeats = Integer.parseInt(details[7]);
				int distance = Integer.parseInt(details[8]);
				String agencyName = details[9];
                String departureLocation = details[10]; 
				String arrivalLocation = details[11];
				String rocketType = details[12];
				Rocket newRocket;
				
				newRocket = new Rocket(transportType,departureDate,departureTime, 
									   arrivalDate,arrivalTime,ticketPrice, 
									   allSeats,occupiedSeats,distance,agencyName, 
									   departureLocation,arrivalLocation,rocketType);
				
				rockets.add(newRocket);
				
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return rockets;
	}
	
	public static void DisplayRockets(List<Rocket> rockets)
	{
		for (Rocket rocket : rockets)
		{
			System.out.println(rocket.showRocket());
		}
	}
	
	public static void AddNewRocket(List<Rocket> rockets)
	{
		Scanner scanner = new Scanner(System.in);
		String transportType = "Rocket";
		
		System.out.print("Enter departure location: ");
		String departureLocation = scanner.nextLine();
		
		System.out.print("Enter arrival location: ");
		String arrivalLocation = scanner.nextLine();
		
		System.out.print("Enter departure date (yyyy-mm-dd): ");
		String departureDate = scanner.nextLine();
		
		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();
		System.out.print("Enter arrival date (yyyy-mm-dd): ");
		String arrivalDate = scanner.nextLine();
		System.out.print("Enter arrival time (hh:mm): ");
		String arrivalTime = scanner.nextLine();
		System.out.print("Enter ticket price: ");
		double ticketPrice = scanner.nextDouble();
		scanner.nextLine();  
		System.out.print("Enter total seats: ");
		int allSeats = scanner.nextInt();
		scanner.nextLine();  
		System.out.print("Enter occupied seats: ");
		int occupiedSeats = scanner.nextInt();
		scanner.nextLine();  
		System.out.print("Enter distance: ");
		int distance = scanner.nextInt();
		scanner.nextLine();  
		System.out.print("Enter agency name: ");
		String agencyName = scanner.nextLine();
		
		System.out.print("Enter rocket type Land or Sea: ");		
		String rocketType = scanner.nextLine();;
		Rocket rocket;
		System.out.println(rocketType);
		if(rocketType.equals("Land") || rocketType.equals("Sea"))
		{
			rocket = new Rocket(transportType,departureDate,departureTime, 
							arrivalDate,arrivalTime,ticketPrice, 
							allSeats,occupiedSeats,distance,agencyName, 
							departureLocation,arrivalLocation,rocketType);
				
			rockets.add(rocket);
			WriteRocketToFile(rockets);
		}
		else
		{
			System.out.println("Invalid Rocket Type");
		}
	}
	
	public static void WriteRocketToFile(List<Rocket> rockets)
	{
		try (PrintWriter writer = new PrintWriter(new FileWriter("Rockets.txt"))) 
		{
			for (Rocket rocket : rockets) 
			{
				writer.println(rocket.toString());
			}
			
		} 
		catch (IOException e) 
		{
			System.err.println("Error writing rockets data to file: " + e.getMessage());
		}
	}
	
	public static void SearchRocket(List<Rocket> rockets)
	{
		Scanner scanner = new Scanner(System.in);

        // Ask for the arrival location
        System.out.print("Enter arrival location: ");
        String arrivalLocation = scanner.nextLine();

        // Ask for the departure date
        System.out.print("Enter departure date (yyyy-mm-dd): ");
        String departureDate = scanner.nextLine();

        // Ask for the arrival date
        System.out.print("Enter arrival date (yyyy-mm-dd): ");
        String arrivalDate = scanner.nextLine();

        boolean rocketFound = false;
		
		for (Rocket rocket : rockets) 
		{
            if (rocket.get_arrivalLocation().equals(arrivalLocation) &&
                rocket.get_departureDate().equals(departureDate) &&
                rocket.get_arrivalDate().equals(arrivalDate)) 
			{

                System.out.println("Matching rocket found:");
                System.out.println(rocket.showRocket());
                rocketFound = true;
            }
        }

        if (!rocketFound) 
		{
            System.out.println("No matching rocket found.");
        }

		
	}
	
	public static void DeleteRocket(List<Rocket> rockets)
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter rocket type:");
        String rocketType = scanner.nextLine();
		
        System.out.print("Enter departure date (yyyy-mm-dd): ");
		String departureDate = scanner.nextLine();

		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();
		
		System.out.print("Enter arrival location (yyyy-mm-dd): ");
		String arrivalLocation = scanner.nextLine();
		
		System.out.print("Enter arrival time (hh:mm): ");
		String arrivalTime = scanner.nextLine();

		Iterator<Rocket> iterator = rockets.iterator();
		while (iterator.hasNext()) 
		{
			Rocket rocket = iterator.next();
			if (rocket.get_rocketType().equals(rocketType) &&
				rocket.get_departureDate().equals(departureDate) &&
				rocket.get_departureTime().equals(departureTime) &&
				rocket.get_arrivalLocation().equals(arrivalLocation) &&
				rocket.get_arrivalTime().equals(arrivalTime)) 
				{
				iterator.remove();
				System.out.println("Rocket removed successfully.");
				WriteRocketToFile(rockets);
				
				return;
			}
		}
        System.out.println("No matching rocket found.");
	}
	// TICKETS TICKETS TICKETS //
	
	public static List<Ticket> ReadTickets(String filename) 
	{
		List<Ticket> tickets = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] details = line.split(",");
				// Assuming the ticket details are stored in a CSV format
				String transportType = details[0];
				String departureDate = details[1];
				String departureTime = details[2];
				String arrivalDate = details[3];
				String arrivalTime = details[4];
				double ticketPrice = Double.parseDouble(details[5]);
				String agencyName = details[6];
				String departureLocation = details[7];
				String arrivalLocation = details[8];
				String buyerName = details[9]; // Added buyerName field

				// Create a Ticket object and add it to the list
				Ticket ticket = new Ticket(transportType, departureDate, departureTime,
						arrivalDate, arrivalTime, ticketPrice, agencyName, departureLocation, arrivalLocation, buyerName);
				tickets.add(ticket);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return tickets;
	}
		
	public static void DisplayTickets(List<Ticket> tickets) 
	{
		for (Ticket ticket : tickets) 
		{
			System.out.println(ticket.showTicket());
		}
	}
	
	public static void WriteTicketToFile(Ticket ticket) 
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Tickets.txt", true))) {
			// Write the string representation of the ticket
			bw.write(ticket.toString());
			bw.newLine();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void ReserveBusTicket(List<BusTransport> buses) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String buyerName = scanner.nextLine();
		
		System.out.print("Enter arrival location: ");
        String arrivalLocation = scanner.nextLine();
		
		System.out.print("Enter departure date (yyyy-mm-dd): ");
        String departureDate = scanner.nextLine();
		
		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();
		
		for(BusTransport bus : buses)
		{
			if(bus.get_arrivalLocation().equals(arrivalLocation) &&
			   bus.get_departureDate().equals(departureDate) &&
			   bus.get_departureTime().equals(departureTime)
				)
			{
				if (bus.occupiedSeats < bus.allSeats)
				{
					bus.occupiedSeats++;
					Ticket ticket = new Ticket(bus.transportType, bus.departureDate,bus.departureTime,bus.arrivalDate,
												bus.arrivalTime,bus.ticketPrice,bus.agencyName,bus.departureLocation,
												bus.arrivalLocation,buyerName);
					WriteTicketToFile(ticket);

					System.out.println("Ticket reserved successfully:");
					System.out.println("Price: " + bus.get_ticketPrice() + "$");
					System.out.println(ticket);
				}
				else 
				{
					System.out.println("No available seats for this bus.");
				}
				return;
			}
		}
		System.out.println("No matching bus found.");
		
		
	}
		
	public static void ReserveTrainTicket(List<TrainTransport> trains) 
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String buyerName = scanner.nextLine();
		
		System.out.print("Enter arrival city: ");
        String arrivalLocation = scanner.nextLine();
		
		System.out.print("Enter departure city: ");
        String departureLocation = scanner.nextLine();
		
		System.out.print("Enter departure date (yyyy-mm-dd): ");
        String departureDate = scanner.nextLine();
		
		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();
		
		for(TrainTransport train : trains)
		{
			if(train.get_arrivalLocation().equals(arrivalLocation) &&
			   train.get_departureDate().equals(departureDate) &&
			   train.get_departureTime().equals(departureTime) &&
			   train.get_departureLocation().equals(departureLocation)
				)
			{
				if (train.occupiedSeats < train.allSeats)
				{
					train.occupiedSeats++;
					Ticket ticket = new Ticket(train.transportType, train.departureDate,train.departureTime,train.arrivalDate,
												train.arrivalTime,train.ticketPrice,train.agencyName,train.departureLocation,
												train.arrivalLocation,buyerName);
					WriteTicketToFile(ticket);

					System.out.println("Ticket reserved successfully:");
					System.out.println("Price: " + train.get_ticketPrice() + "$");
					System.out.println(ticket);
				}
				else 
				{
					System.out.println("No available seats for this train.");
				}
				return;
			}
		}
		System.out.println("No matching train found.");
		
		
	}
		
	public static void ReservePlaneTicket(List<PlaneTransport> planes) 
	{
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String buyerName = scanner.nextLine();
		
		System.out.print("Enter arrival location: ");
        String arrivalLocation = scanner.nextLine();
		
		System.out.print("Enter departure date (yyyy-mm-dd): ");
        String departureDate = scanner.nextLine();
		
		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();
		
		for(PlaneTransport plane : planes)
		{
			if(plane.get_arrivalLocation().equals(arrivalLocation) &&
			   plane.get_departureDate().equals(departureDate) &&
			   plane.get_departureTime().equals(departureTime) )
			{
				if (plane.occupiedSeats < plane.allSeats)
				{
					plane.occupiedSeats++;
					Ticket ticket = new Ticket(plane.transportType, plane.departureDate,plane.departureTime,plane.arrivalDate,
												plane.arrivalTime,plane.ticketPrice,plane.agencyName,plane.departureLocation,
												plane.arrivalLocation,buyerName);
					WriteTicketToFile(ticket);

					System.out.println("Ticket reserved successfully:");
					System.out.println("Price: " + plane.get_ticketPrice() + "$");
					System.out.println(ticket);
				}
				else 
				{
					System.out.println("No available seats for this plane.");
				}
				return;
			}
		}
		System.out.println("No matching plane found.");
		
		
	}
	
	public static void ReserveBoatTicket(List<BoatTransport> boats) 
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String buyerName = scanner.nextLine();

		System.out.print("Enter arrival location: ");
		String arrivalLocation = scanner.nextLine();

		System.out.print("Enter departure date (yyyy-mm-dd): ");
		String departureDate = scanner.nextLine();

		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();

		for (BoatTransport boat : boats) 
		{
			if(boat.get_arrivalLocation().equals(arrivalLocation) &&				
			   boat.get_departureDate().equals(departureDate) &&
			   boat.get_departureTime().equals(departureTime)) 
			{
				if (boat.occupiedSeats < boat.allSeats) 
				{
					boat.occupiedSeats++;
					Ticket ticket = new Ticket(boat.transportType, boat.departureDate, boat.departureTime,
												boat.arrivalDate, boat.arrivalTime,boat.ticketPrice, boat.agencyName,
												boat.departureLocation, boat.arrivalLocation, buyerName);
					WriteTicketToFile(ticket);

					System.out.println("Ticket reserved successfully:");
					System.out.println("Price: " + boat.get_ticketPrice() + "$");
					System.out.println(ticket);
				} 
				else 
				{
					System.out.println("No available seats for this boat.");
				}
				return;
			}
		}
		System.out.println("No matching boat found.");
	}

	
	public static void ReserveRocketTicket(List<Rocket> rockets)
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String buyerName = scanner.nextLine();

		System.out.print("Enter arrival location: ");
		String arrivalLocation = scanner.nextLine();

		System.out.print("Enter departure date (yyyy-mm-dd): ");
		String departureDate = scanner.nextLine();

		System.out.print("Enter departure time (hh:mm): ");
		String departureTime = scanner.nextLine();

		for (Rocket rocket : rockets) 
		{
			if(rocket.get_arrivalLocation().equals(arrivalLocation) &&				
			   rocket.get_departureDate().equals(departureDate) &&
			   rocket.get_departureTime().equals(departureTime)) 
			{
				if (rocket.occupiedSeats < rocket.allSeats) 
				{
					rocket.occupiedSeats++;
					Ticket ticket = new Ticket(rocket.transportType, rocket.departureDate, rocket.departureTime,
												rocket.arrivalDate, rocket.arrivalTime,rocket.ticketPrice, rocket.agencyName,
												rocket.departureLocation, rocket.arrivalLocation, buyerName);
					WriteTicketToFile(ticket);

					System.out.println("Ticket reserved successfully:");
					System.out.println("Price: " + rocket.get_ticketPrice() + "$");
					System.out.println(ticket);
				} 
				else 
				{
					System.out.println("No available seats for this rocket.");
				}
				return;
			}
		}
		System.out.println("No matching boat found.");
	}

}

	


