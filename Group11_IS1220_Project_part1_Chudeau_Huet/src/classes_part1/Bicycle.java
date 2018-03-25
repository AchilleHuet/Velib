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

}
