package classes_part1;

public class NoCard implements Card{
	
	public double computeCost(Ride ride) {
		User user = ride.user;
		double elapsedTime = ride.endTime.compareTo(ride.startTime)/1000;
		int costPerHour = 1;
		if (ride.bicycle.type == BicycleType.Electrical) {
			costPerHour = 2;
		}
		return (elapsedTime - 3600)/3600 * costPerHour;
	}

}
