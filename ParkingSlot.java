package MyVelibProject.Package;

import java.util.ArrayList;
import java.util.Date;

public class ParkingSlot {
	
	SlotStatus status;
	Bicycle bicycle;
	ArrayList<Operation> history;
	
	public ParkingSlot() {
		//Create an empty parking slot
		this.status = SlotStatus.Free;
	}
	public ParkingSlot(Bicycle bicycle) {
		//Create an occupied parking slot
		this.status = SlotStatus.Occupied;
		this.bicycle = bicycle;
	}
	
	public void RemoveBicycle() {
		//Removes a bicycle from an occupied parking slot
		if (this.status == SlotStatus.Occupied) {
			this.status = SlotStatus.Free;
			this.bicycle = null;
		}
		else if (this.status == SlotStatus.Free){
			System.out.println("This parking slot has no bike to remove");
		}
		else {
			//parking slot is out of order
			System.out.println("This parking slot is out of order");
		}
	}

	public void addBicycle(Bicycle bicycle) {
		//Adds a bicycle to a free parking slot
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
	
	public void OutOfOrder() {
		//Parking slot becomes out of order
		this.status = SlotStatus.Out_of_order;
		history.add(new Operation(OperationType.breakSlot));
	}
	
	public void FixSlot() {
		this.status = SlotStatus.Free;
		history.add(new Operation(OperationType.fixSlot));
	}
	
	double occupationRate(long startTime, long endTime) {
		int i = this.history.size();
		while (this.history.get(i).date>endTime) {
			i--;
		}
		long timeOccupied = 0;
		if (this.history.get(i).type == OperationType.endRide) {
			timeOccupied += endTime-this.history.get(i).date;
			i--;
		}
		while (this.history.get(i-1).date - startTime > 0) {
			if (this.history.get(i).type == OperationType.startRide) {
				timeOccupied += this.history.get(i).date-history.get(i-1).date;
			}
			i--;
		}
		if (this.history.get(i).type == OperationType.startRide) {
			timeOccupied += this.history.get(i).date-startTime;	
		}
		return timeOccupied / (endTime - startTime);
	}
	
}
