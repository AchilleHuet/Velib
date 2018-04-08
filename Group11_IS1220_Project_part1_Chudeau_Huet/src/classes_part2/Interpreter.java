package classes_part2;

import java.util.concurrent.ThreadLocalRandom;

import classes_part1.BicycleType;
import classes_part1.NoCard;
import classes_part1.Station;
import classes_part1.StationStatus;
import classes_part1.User;
import classes_part1.VelibPark;
import classes_part1.Vlibre;
import classes_part1.Vmax;

public class Interpreter {
		
	public Interpreter() {
	}
	
	Reader reader;
		
	public void InterpretCommand(String string) {
		
		try {
		
			String[] words = string.split(" ");
			
			if (words[0].equalsIgnoreCase("help")) {
				Help();
			}
			else if (words[0].equalsIgnoreCase("exit")) {
				System.out.println("Exiting the program");
			}
			else if (words[0].equalsIgnoreCase("setup")) {
				if (words.length == 2) {
					VelibPark(words[1]);
				}
				else if (words.length == 6) {
					VelibPark(words[1], words[2], words[3], words[4], words[5]);
				}
				else {
					CommandDoesntExist();
				}
			}
			else if (words[0].equalsIgnoreCase("offline") && words.length == 3) {
				SetOffline(words[1], words[2]);
			}
			else if (words[0] == "online" && words.length == 3) {
				SetOnline(words[1], words[2]);
			}
			else if (words[0] == "addUser" && words.length == 4) {
				AddUser(words[1], words[2], words[3]);
			}
			else if (words[0] == "rentBike"  && words.length == 3) {
				RentBike(words[1], words[2]);
			}
/*			else if (words[0] == "returnBike"  && words.length == 4) {
				ReturnBike(words[1], words[2], words[3]);
			}
			else if (words[0] == "displayStation"  && words.length == 3) {
				DisplayStation(words[1], words[2]);
			}
			else if (words[0] == "displayUser"  && words.length == 3) {
				DisplayUser(words[1], words[2]);
			}
			else if (words[0] == "sortStation"  && words.length == 3) {
				SortStation(words[1], words[2]);
			}
			else if (words[0] == "display"  && words.length == 2) {
				DisplayNetwork(words[1], words[2]);
			}	
*/			else {
			CommandDoesntExist();
			}
		}
		catch (NullPointerException e) { }
		finally {
		}

	}
	
	public void CommandDoesntExist() {
		System.out.println("This command doesn't exist. To see all existing commmands, type help");
	}
	
	public void Help() {
		System.out.println("setup <velibnetworkName> \n"
				+ "setup <name> <nstations> <nslots> <sidearea> <nbikes> \n"
				+ "addUser <userName, cardType, velibnetworkName> \n"
				+ "offline <velibnetworkName, stationID>\n"
				+ "online <velibnetworkName, stationID>\n"
				+ "rentBike <userID, stationID>\n"
				+ "returnBike <userID, stationID, time> \n"
				+ "displayStation<velibnetworkName, stationID> \n"
				+ "displayStation<velibnetworkName, userID>\n"
				+ "sortStation<velibnetworkName, sortpolicy> \n" 
				+ "display <velibnetworkName>");
	}
	
	public void VelibPark(String name) {
		this.VelibPark(name, "10", "10", "4000", "75");
	}
	
	
	/**
	 * creates a Velib park with given name and consisting of nstations stations each of which has nslots parking slots and such that 
	 * stations are arranged on a square grid whose of side sidearea and initially populated with a nbikes bikes randomly distributed
	 * over the nstations stations
	 * @param name
	 * @param nstations
	 * @param nslots
	 * @param sidearea
	 * @param nbikes
	 */
	public void VelibPark(String name, String nstations, String nslots, String sidearea, String nbikes) {
		
		int stations = Integer.parseInt(nstations);
		int slots = Integer.parseInt(nslots);
		double xmax = Double.parseDouble(sidearea);
		int bikes = Integer.parseInt(nbikes);
		
		//Create park with stations
		VelibPark park = new VelibPark(name, -xmax, xmax, -xmax, xmax);
		park.fillPark(stations, slots);
		if (bikes > stations * slots) {
			System.out.println("There are not enough slots to put this amount of bikes");
		}
		
		//Randomly fill the stations with bikes 
		else {
			int[] divideBikes = new int[stations];
			int i = 0;
			while (i<bikes) {
				int randomInt = ThreadLocalRandom.current().nextInt(0, stations);
				if (divideBikes[randomInt] < slots) {
					divideBikes[randomInt]++;
					i++;
				}
			}
			BicycleType type = BicycleType.Mechanical;
			for (int j = 0; j < stations; j++) {
				Station station = park.getStationsList().get(j);
				station.addBicycle(type);
			}
			Reader.parks.add(park);
			System.out.println("The network " + name + " has been created");
		}
	}
	
	public VelibPark findVelibPark(String parkName) {
		for (VelibPark park : Reader.parks) {
			if (park.name.equalsIgnoreCase(parkName)) {
				return park;
			}
		}
		System.out.println("There is no Velib park with this name");
		throw new NullPointerException();
	}
	
	public void SetOnline(String parkName, String stationID) {
		
		VelibPark park = findVelibPark(parkName);
		int ID = Integer.parseInt(stationID);
		if (ID > park.getStationsList().size()-1 || ID <= 0) {
			System.out.println("The station you asked for does not exist");
		}
		else {
			Station station = park.getStationsList().get(ID-1);
			if (station.getStatus() == StationStatus.InService) {
				System.out.println("This station is already online");
			}
			else {
				station.status = StationStatus.InService;
				System.out.println("The station has been put online");
			}
		
		}
		
	}
	
	public void SetOffline(String parkName, String stationID) {
		
		VelibPark park = findVelibPark(parkName);
		int ID = Integer.parseInt(stationID);
		if (ID > park.getStationsList().size() || ID <= 0) {
			System.out.println("The station you asked for does not exist");
		}
		else {
			Station station = park.getStationsList().get(ID-1);
			if (station.getStatus() == StationStatus.Offline) {
				System.out.println("This station is already offline");
			}
			else {
				station.status = StationStatus.Offline;
				System.out.println("The station has been put offline");
			}
		
		}
		
	}
	
	public void AddUser(String name, String cardType, String parkName) {
		VelibPark park = findVelibPark(parkName);
		if (cardType.equalsIgnoreCase("none")) {
			User user = new User(name, new NoCard(), park);
			Reader.users.add(user);
			System.out.println("User " + name + " has been added.");
		}
		else if (cardType.equalsIgnoreCase("Vlibre")) {
			User user = new User(name, new Vlibre(), park);
			Reader.users.add(user);
			System.out.println("User " + name + " has been added.");
		}
		else if (cardType.equalsIgnoreCase("Vmax")) {
			User user = new User(name, new Vmax(), park);
			Reader.users.add(user);
			System.out.println("User " + name + " has been added.");
		}
		else {
			System.out.println("This card type does not exist. Please type Vmax, Vlibre or none");
		}
	}
	
	public void RentBike(String userID, String stationID) { 
		int uID = Integer.parseInt(userID);
		int sID = Integer.parseInt(stationID);
		
	}
		
		
}

