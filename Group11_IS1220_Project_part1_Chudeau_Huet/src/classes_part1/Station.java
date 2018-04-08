package classes_part1;

import java.util.ArrayList;
import java.util.Date;

public class Station {
	
	ArrayList<ParkingSlot> parkingSlots;
	Integer parkingSize;
	Location location;
	public StationStatus status;
	StationType type;
	Terminal terminal;
	public long rents;
	public long returns;
	double occupationRate;
	ArrayList<User> observers;
	VelibPark park;
	int ID;
	public static int slotCounter = 1;
	
	/**
	 * creates a new station with empty parking slots with a specific size and location
	 * @param parkingSize
	 * @param location instance of class Location
	 */
	public Station(Integer parkingSize, Location location) {
		super();
		this.parkingSlots = new ArrayList<ParkingSlot>();
		for (int i = 0; i < parkingSize; i++) {
			addParkingSlot(new ParkingSlot());
		}
		this.parkingSize = parkingSize;
		this.status = StationStatus.InService;
		this.type = StationType.standard;
		this.location = location;
		this.rents = 0;
		this.returns = 0;
		this.occupationRate = 0.;
		this.observers = new ArrayList<User>();
	}
	
	/**
	 * adds a new parking slot and gives it a unique ID (for this station)
	 * @param slot
	 */
	public void addParkingSlot(ParkingSlot slot) {
		slot.ID = slotCounter;
		slot.station = this;
		parkingSlots.add(slot);
		slotCounter++;
	}
	
	/**
	 * Fills the station with bikes according to parameters
	 * @param fullSlots proportion of filled slots
	 * @param mechSlots proportion of bikes which are mechanical
	 */
	public void fillStation(double fullSlots, double mechSlots) {
		assert(fullSlots <1 && mechSlots<1);
		int n = (int) (fullSlots * this.parkingSize);
		int m = (int) (mechSlots*n);
		for (int i= 0; i<m; i++) {
			Bicycle bicycle = new Bicycle(BicycleType.Mechanical);
			parkingSlots.get(i).addBicycle(bicycle);
		}
		for (int i= m; i<n; i++) {
			Bicycle bicycle = new Bicycle(BicycleType.Electrical);
			parkingSlots.get(i).addBicycle(bicycle);
		}
	}
	
	public void addBicycle(BicycleType type) {
		boolean added = false;
		int i = 0;
		while (!added && i < this.parkingSize) {
			if (parkingSlots.get(i).status == SlotStatus.Free) {
				parkingSlots.get(i).addBicycle(new Bicycle(type));
				added = true;
			}
		}
	}
	
	
	/**
	 * Fills the station with default parameter values 
	 */
	public void fillStation() {
		this.fillStation(.70, .70);
	}
	
	
	public ArrayList<ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}
	public void addParkingSlots(ArrayList<ParkingSlot> parkingSlots) {
		for (ParkingSlot slot: parkingSlots) {
			addParkingSlot(slot);
		}
	}
	public Integer getParkingSize() {
		return parkingSize;
	}
	public void setParkingSize(Integer parkingSize) {
		this.parkingSize = parkingSize;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public StationStatus getStatus() {
		return status;
	}
	public void setStatus(StationStatus status) {
		this.status = status;
		if (status == StationStatus.Offline) {
			this.notifyObservers();
		}
	}
	public StationType getType() {
		return type;
	}
	public void setType(StationType type) {
		this.type = type;
	}
	public Terminal getTerminal() {
		return terminal;
	}
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	public long getRents() {
		return rents;
	}
	public void setRents(long uses) {
		this.rents = uses;
	}
	public long getReturns() {
		return returns;
	}
	public void setReturns(long uses) {
		this.returns = uses;
	}
	public ArrayList<User> getObservers() {
		return observers;
	}
	public double getOccupationRate() {
		return occupationRate;
	}
	public int getID() {
		return ID;
	}
	public long Uses() {
		return rents + returns;
	}

	/**
	 * counts the total number of bicycles in the station
	 * @return
	 */
	public Integer BicycleCount() {
		Integer count = 0;
		for (ParkingSlot slot:parkingSlots) {
			if (slot.status == SlotStatus.Occupied) {
				count += 1;
			}
		}
		return count;
	}
	
	/**
	 * Counts number of bicycles in the station of the given bicycle type
	 * @param type instance of BicycleType class
	 * @return
	 */
	public Integer BicycleCount(BicycleType type) {
		Integer count = 0;
		for (ParkingSlot slot:parkingSlots) {
			if (slot.status == SlotStatus.Occupied && slot.bicycle.type == type) {
				count += 1;
			}
		}
		return count;
	}
	
	
	/**
	 * Counts the number of free slots in a station
	 * @return 
	 */
	public int FreeSlots() {
		int count = 0;
		for (ParkingSlot slot : this.parkingSlots) {
			if (slot.status == SlotStatus.Free) {
				count += 1;
			}
		}
		return count;
	}
	
	/**
	 * Calculates the occupation rate defined by (time occupied) / (total time elapsed) over a specified period of times
	 * @param startTime instance of Date class, time at which a bicycle is taken from its parking slot
	 * @param endTime instance of Date class, time at which a bicycle is returned to a parking slot
	 * @return
	 */
	public void calculateOccupationRate(Date startTime, Date endTime) {
		this.occupationRate = 0.;
		for (ParkingSlot slot : this.parkingSlots) {
			this.occupationRate += slot.occupationRate(startTime, endTime);
		}
		this.occupationRate /= this.parkingSize;
		
	}
	
	void addObserver(User user) {
		this.observers.add(user);
	}
	
	void removeObserver(User user) {
		for (int i = 0; i< this.observers.size(); i++) {
			if (this.observers.get(i) == user) {
				this.observers.remove(i);
				i--;
			}
		}
	}
	
	public void notifyObserver(User user) {
		if (this.status == StationStatus.InService) {
			System.out.println("Station is online");
		}
		else {
			System.out.println("Station is offline");
		}
	}
	
	public void notifyObservers() {
		for (User user : this.observers) {
			notifyObserver(user);
		}
	}
	
	/**
	 * Starts an actual ride - user takes a bike from the station
	 * @param bicycle
	 * @param user
	 */
	public void startRide(Bicycle bicycle, User user) {
		if (user.currentRide == null) {
			user.currentRide = new Ride(user, this.park, bicycle);
		}
		Ride ride = user.currentRide;
		ride.departure = this;
		ride.startTime = new Date();
		this.rents += 1;
	}
	
	public void startRide(BicycleType type, User user) {
		boolean started = false;
		int i = 0;
		if (BicycleCount(type) > 0 ) {
			while (!started && i<parkingSize) {
				if ((parkingSlots.get(i).status == SlotStatus.Occupied) && (parkingSlots.get(i).bicycle.type == type)) {
					Bicycle bicycle = parkingSlots.get(i).removeBicycle();
					started = true;
					startRide(bicycle, user);
				}
			}
		}
		else {
			System.out.println("There are no more bikes of this type at this station");
		}
		
	}
	
	public void startRide(User user) {
		boolean started = false;
		int i = 0;
		if (BicycleCount() > 0 ) {
			while (!started && i<parkingSize) {
				if (parkingSlots.get(i).status == SlotStatus.Occupied) {
					Bicycle bicycle = parkingSlots.get(i).removeBicycle();
					started = true;
					startRide(bicycle, user);
				}
			}
		}
		else {
			System.out.println("There are no more bikes at this station");
		}
		
	}
	
	
	/**
	 * ends a ride
	 * @param ride 
	 * @param arrival The station at which the user arrives
	 */
	public void endRide(Ride ride) {
		if (this.FreeSlots()>0) {
			int i = 0;
			while (this.parkingSlots.get(i).status != SlotStatus.Free) {
				i++;
			}
			this.parkingSlots.get(i).addBicycle(ride.bicycle);
			ride.endTime = new Date();
			ride.arrival = this;
			ride.cost = ride.user.card.computeCost(ride);
			if (this.type == StationType.plus && ride.user.card.type != CardType.NoCard) {
				ride.user.timeCredit += 300;
			}
			this.returns += 1;
		}
		else {
			System.out.println("This station cannot accomodate any more bikes");
		}
		
	}
	
	public String toString() {
		return "Station " + getID() + ": " + status + ", " + type + ", " + parkingSlots +"\n";
	}
	
	
}
