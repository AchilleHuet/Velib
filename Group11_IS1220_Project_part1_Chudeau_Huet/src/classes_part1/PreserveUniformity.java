package classes_part1;

public class PreserveUniformity implements Policy {
	
	@Override
	public void PlanRide(User user, Location destination, VelibPark park, BicycleType type) {
		Ride ride = user.currentRide;
		Station start = park.stationsList.get(0);
		double startDistance = start.location.Distance(user.location);
		Station end = park.stationsList.get(0);
		double endDistance = end.location.Distance(destination);
		for (Station station : park.stationsList) {
			if ((station.location.Distance(user.location) < startDistance) && (station.BicycleCount(type) > 0)) {
				start = station;
				startDistance = start.location.Distance(user.location);
			}
			if ((station.location.Distance(destination) < endDistance) && (station.FreeSlots() > 0)) {
				end = station;
				endDistance = end.location.Distance(destination);
			}
		}
		int bikeCount = start.BicycleCount(type);
		int freeSlotsCount = end.FreeSlots();
		for (Station station : park.stationsList) {
			//endDistance and startDistance are not modified so the program takes the station with the most bikes in a 105% distance radius
			if ((station.location.Distance(user.location) < startDistance * 1.05) && (station.BicycleCount(type) > bikeCount)) {
				start = station;
				bikeCount = station.BicycleCount(type);
			}
			if ((station.location.Distance(destination) < endDistance * 1.05) && (station.FreeSlots() > freeSlotsCount)) {
				end = station;
				freeSlotsCount = station.FreeSlots();
			}
		}
		if (start != end) {
			ride.suggestedDeparture = start;
			ride.suggestedArrival = end;
		}
		System.out.println("The quickest path is by foot");
		ride.suggestedDeparture = null;
		ride.suggestedArrival = null;
	}

}
