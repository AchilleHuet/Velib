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
	 * @param location
	 */
	public Station(Integer parkingSize, Location location) {
		//creates a new station with empty parking slots with a specific size and location
		super();
		this.parkingSlots = new ArrayList<ParkingSlot>();
		for (int i=0; i<parkingSize; i++) {
			this.parkingSlots.add(new ParkingSlot());
		}
		this.location = location;
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
		//counts the total number of bicycles in the station
		Integer count = 0;
		for (ParkingSlot slot:parkingSlots) {
			if (slot.status == SlotStatus.Occupied) {
				count += 1;
			}
		}
		return count;
	}
	
	/**
	 * counts the number of bicycles of a particular type
	 * @param type
	 * @return
	 */
	
	public Integer BicycleNumber(BicycleType type) {
		//counts the number of bicycles of a particular type
		Integer count = 0;
		for (ParkingSlot slot:parkingSlots) {
			if (slot.status == SlotStatus.Occupied && slot.bicycle.type == type) {
				count += 1;
			}
		}
		return count;
	}
	
	/**
	 * returns the occupation rate of the station over a specific period of time
	 * @param startTime
	 * @param endTime
	 * @return
	 */

	double occupationRate(Date startTime, Date endTime) {
		// returns the occupation rate of the station over a specific period of time
		double rate = 0.;
		for (ParkingSlot slot : this.parkingSlots) {
			rate += slot.occupationRate(startTime, endTime);
		}
		rate /= this.parkingSize;
		return rate;
	}
	
}
