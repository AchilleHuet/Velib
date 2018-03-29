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

	
	/**
	 * counts the total number of bicycles in the station
	 * @return
	 */
	public Integer BicycleNumber() {
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
	public Integer BicycleNumber(BicycleType type) {
		Integer count = 0;
		for (ParkingSlot slot:parkingSlots) {
			if (slot.status == SlotStatus.Occupied && slot.bicycle.type == type) {
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
	double occupationRate(Date startTime, Date endTime) {
		double rate = 0.;
		for (ParkingSlot slot : this.parkingSlots) {
			rate += slot.occupationRate(startTime, endTime);
		}
		rate /= this.parkingSize;
		return rate;
	}
	
}
