package classes_part1;

import java.util.ArrayList;
import java.util.Date;

public class Station {
	
	ArrayList<ParkingSlot> parkingSlots;
	Integer parkingSize = parkingSlots.size();
	Location location;
	StationStatus status;
	StationType type;
	Terminal terminal;
	public long uses;
	double occupationRate;
	ArrayList<User> observers;
	
	/**
	 * creates a new station with empty parking slots with a specific size and location
	 * @param parkingSize
	 * @param location instance of class Location
	 */
	public Station(Integer parkingSize, Location location) {
		super();
		this.parkingSlots = new ArrayList<ParkingSlot>();
		for (int i=0; i<parkingSize; i++) {
			this.parkingSlots.add(new ParkingSlot());
		}
		this.location = location;
		this.uses = 0;
	}
		
	
	public ArrayList<ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(ArrayList<ParkingSlot> parkingSlots) {
		this.parkingSlots = parkingSlots;
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

	public long getUses() {
		return uses;
	}


	public void setUses(long uses) {
		this.uses = uses;
	}
	
		
	public ArrayList<User> getObservers() {
		return observers;
	}


	public double getOccupationRate() {
		return occupationRate;
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
		Ride ride = user.currentRide;
		ride.departure = this;
		ride.startTime = new Date();
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
			this.parkingSlots.get(i).endRide(ride.bicycle);
			ride.endTime = new Date();
			ride.arrival = this;
			ride.cost = ride.user.card.computeCost(ride);
		}
		
	}
	
	
}
