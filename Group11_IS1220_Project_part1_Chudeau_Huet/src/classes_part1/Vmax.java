package classes_part1;

public class Vmax implements Card{
	
	public double computeCost(Ride ride) {
		User user = ride.user;
		double elapsedTime = ride.endTime.compareTo(ride.startTime)/1000;
		int costPerHour = 1;
		if (elapsedTime < 3600) {
			return 0.;
		}
		else {
			if (elapsedTime - 3600 < user.timeCredit) {
				user.timeCredit -= elapsedTime - 3600;
				return 0.;
			}
			else {
				double credit = user.timeCredit;
				user.timeCredit = 0.;
				return (elapsedTime - 3600 - credit)/3600 * costPerHour;
			}
		}
	}


}
