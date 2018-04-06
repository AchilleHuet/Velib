package classes_part1;

public class AvoidPlusStations implements Policy {
	
	public AvoidPlusStations() {
	}
	
	
	public void PlanRide(User user, Location destination, VelibPark park, BicycleType type) {
		if (user.currentRide == null) {
			user.currentRide = new Ride(user, park, this, type, destination);
		}
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
			if ((station.location.Distance(destination) < endDistance) && (station.FreeSlots() > 0) && (station.type != StationType.plus)) {
				end = station;
				endDistance = end.location.Distance(destination);
			}
		}
		if (end != start) {
			ride.suggestedDeparture = start;
			ride.suggestedArrival = end;
		}
		System.out.println("The quickest path is by foot");
		ride.suggestedDeparture = null;
		ride.suggestedArrival = null;
		}

}
