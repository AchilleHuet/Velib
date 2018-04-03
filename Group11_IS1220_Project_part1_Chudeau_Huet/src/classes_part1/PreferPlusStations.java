package classes_part1;

public class PreferPlusStations implements Policy {

	public PreferPlusStations() {
	}
	
	public void PlanRide(User user, Location destination, VelibPark park, BicycleType type, Ride ride) {
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
		if (end != start) {
			double plusDistance = 1.1 * endDistance;
			for (Station station : park.stationsList) {
				if (station.location.Distance(destination) < plusDistance && station.type == StationType.plus && station.FreeSlots() > 0) {
					plusDistance = station.location.Distance(destination);
					end = station;
				}
			}
			ride.suggestedDeparture = start;
			ride.suggestedArrival = end;
		}
		System.out.println("The quickest path is by foot");
		ride.suggestedDeparture = null;
		ride.suggestedArrival = null;
	}
		
		
		
}