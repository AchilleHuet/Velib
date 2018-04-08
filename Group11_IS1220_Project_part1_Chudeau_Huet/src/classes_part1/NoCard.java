package classes_part1;

public class NoCard extends Card{
	
	public CardType type =  CardType.NoCard;
	
	public double computeCost(Ride ride) {
		double elapsedTime = ride.duration();
		int costPerHour = 1;
		if (ride.bicycleType == BicycleType.Electrical) {
			costPerHour = 2;
		}
		return (elapsedTime - 3600)/3600 * costPerHour;
	}

}
