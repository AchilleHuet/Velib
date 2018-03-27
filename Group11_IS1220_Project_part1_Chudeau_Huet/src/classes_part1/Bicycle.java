package classes_part1;

public class Bicycle {
		
	Integer ID;
	BicycleType type;
	public static int counter = 1;
	
	Bicycle(BicycleType type) {
		this.type= type;
		this.ID = counter;
		counter++;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public BicycleType getType() {
		return type;
	}

	public void setType(BicycleType type) {
		this.type = type;
	}
	
	

}
