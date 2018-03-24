package MyVelibProject.Package;

public class ParkingSlot {
	
	SlotStatus status;
	Bicycle bicycle;
	
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
	}
		
}
