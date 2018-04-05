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
	}
	
	/**
	 * create a occupied new parking slot
	 * @param bicycle
	 */
	public ParkingSlot(Bicycle bicycle) {
		this.status = SlotStatus.Occupied;
		this.bicycle = bicycle;
	}
	
	
	
	public SlotStatus getStatus() {
		return status;
	}
	public void setStatus(SlotStatus status) {
		this.status = status;
	}
	public Bicycle getBicycle() {
		return bicycle;
	}
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
	public ArrayList<Operation> getHistory() {
		return history;
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
			this.addOperation(new Operation(OperationType.endRide, bicycle));
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
	double occupationRate(Date startTime, Date endTime) {
		int i = this.history.size();
		while (this.history.get(i).date.compareTo(endTime)>0) {
			i--;
		}
		long timeOccupied = 0;
		if (this.history.get(i).type == OperationType.endRide) {
			timeOccupied += endTime.compareTo(this.history.get(i).date);
			i--;
		}
		while (this.history.get(i-1).date.compareTo(startTime) > 0 && i>0) {
			if (this.history.get(i).type == OperationType.startRide) {
				timeOccupied += this.history.get(i).date.compareTo(history.get(i-1).date);
			}
			i--;
		}
		if (this.history.get(i).type == OperationType.startRide) {
			timeOccupied += this.history.get(i).date.compareTo(startTime);	
		}
		return timeOccupied / (endTime.compareTo(startTime));
	}
	
}
