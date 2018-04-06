package classes_part1;

import java.util.ArrayList;
import java.util.Date;

public class ParkingSlot {
	
	SlotStatus status;
	Bicycle bicycle;
	ArrayList<Operation> history;
	
	/**
	 * create an empty parking slot
	 */
	public ParkingSlot() {
		this.status = SlotStatus.Free;
		this.history = new ArrayList<Operation>();
	}
	
	/**
	 * create a occupied new parking slot
	 * @param bicycle
	 */
	public ParkingSlot(Bicycle bicycle) {
		this.status = SlotStatus.Occupied;
		this.bicycle = bicycle;
		this.history = new ArrayList<Operation>();
		history.add(new Operation(OperationType.addBike, bicycle));
	}
	
	
	
	public SlotStatus getStatus() {
		return this.status;
	}
	public void setStatus(SlotStatus status) {
		this.status = status;
	}
	public Bicycle getBicycle() {
		return this.bicycle;
	}
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
	public ArrayList<Operation> getHistory() {
		return this.history;
	}
	public void addOperations(ArrayList<Operation> operations) {
		this.history.addAll(operations);
	}
	public void addOperation(Operation operation) {
		this.history.add(operation);
	}

	/**
	 * remove the bicycle from an occupied parking slot
	 */
	public void RemoveBicycle() {
		if (this.status == SlotStatus.Occupied) {
			this.status = SlotStatus.Free;
			this.bicycle = null;
		}
		else if (this.status == SlotStatus.Free){
			System.out.println("This parking slot has no bike to remove");
		}
		else {
			System.out.println("This parking slot is out of order");
		}
	}
	
	/**
	 * add a bicycle to a free parking slot
	 * @param bicycle
	 */
	public void addBicycle(Bicycle bicycle) {
		if (this.status == SlotStatus.Free) {
			this.status = SlotStatus.Occupied;
			this.bicycle = bicycle;
		}
		else if (this.status == SlotStatus.Occupied) {
			System.out.println("This parking slot is already occupied");
		}
		else { 
			//parkingSlot is out of order
			System.out.println("This parking slot is out of order");
		}
	}
	
	/**
	 * add a bicycle to a free parking slot
	 * @param bicycle
	 */
	public void endRide(Bicycle bicycle) {
		if (this.status == SlotStatus.Free) {
			this.status = SlotStatus.Occupied;
			this.bicycle = bicycle;
			this.addOperation(new Operation(OperationType.removeBike, bicycle));
		}
		else if (this.status == SlotStatus.Occupied) {
			System.out.println("This parking slot is already occupied");
		}
		else { 
			//parkingSlot is out of order
			System.out.println("This parking slot is out of order");
		}
	}
	
	/**
	 * parking slot becomes out of order
	 */
	public void OutOfOrder() {
		this.status = SlotStatus.Out_of_order;
		history.add(new Operation(OperationType.breakSlot));
	}
	
	/**
	 * parking slot is fixed, and becomes free
	 */
	public void FixSlot() {
		if (this.status == SlotStatus.Out_of_order) {
			if (this.bicycle == null) {
				this.status = SlotStatus.Free;
			}
			else {
				this.status = SlotStatus.Occupied;
				}
			history.add(new Operation(OperationType.fixSlot));
		}
		else {
			System.out.println("This slot doesn't need to be fixed");
		}
	}
	
	/**
	 * return the occupation rate of the parking slot
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public double occupationRate(Date startTime, Date endTime) {
		int i = this.history.size()-1;
		if (i == -1) {
			return 0;
		}
		while (this.history.get(i).date.after(endTime) && i>=0) {
			i--;
		}
		if (i == -1) {
			return 0;
		}
		long timeOccupied = 0;
		if (this.history.get(i).type == OperationType.addBike) {
			timeOccupied += endTime.compareTo(this.history.get(i).date);
			i--;
		}
		if (i == -1) {
			return timeOccupied;
		}
		while (this.history.get(i).date.after(startTime) && i>0) {
			if (this.history.get(i).type == OperationType.addBike) {
				int j = i+1;
				while (this.history.get(j).type != OperationType.removeBike) {
					j++;
				}
				timeOccupied += this.history.get(j).date.compareTo(history.get(i).date);
			}
			i--;
		}
		if (this.history.get(i+1).type == OperationType.removeBike) {
			timeOccupied += this.history.get(i).date.compareTo(startTime);	
		}
		return timeOccupied / (endTime.compareTo(startTime));
	}
	
	public String toString() {
		if (this.bicycle != null) {
			return "Slot: " + this.status + " " + this.bicycle.type + " bike";
		}
		return "Slot: " + this.status;
	}
	
}
