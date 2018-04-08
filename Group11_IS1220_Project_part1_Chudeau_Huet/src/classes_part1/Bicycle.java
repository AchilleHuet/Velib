package classes_part1;

public class Bicycle {
		
	Integer ID;
	public BicycleType type;
	public static int counter = 1;
	
	/**
	 * Creates a bike of the given type
	 * @param type
	 */
	public Bicycle(BicycleType type) {
		this.type= type;
		this.ID = counter;
		counter++;
	}

	public Integer getID() {
		return ID;
	}

	public BicycleType getType() {
		return type;
	}

	public void setType(BicycleType type) {
		this.type = type;
	}
	
	

}
