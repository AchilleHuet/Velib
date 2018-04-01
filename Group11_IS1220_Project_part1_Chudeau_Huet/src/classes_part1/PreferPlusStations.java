package classes_part1;

public class PreferPlusStations implements RideStrategy {

	public PreferPlusStations() {
	}
	
	public Station Destination(Location destination, Station start, VelibPark park) {
		double minDistance = start.location.Distance(destination);
		Station closestStation = start;
		for (Station station : park.stationsList) {
			if (station.location.Distance(destination) < minDistance) {
				minDistance = station.location.Distance(destination);
				closestStation = station;
			}
		}
		if (closestStation != start) {
			double plusDistance = 1.1 * minDistance;
			for (Station station : park.stationsList) {
				if (station.location.Distance(destination) < plusDistance && station.type == StationType.plus) {
					plusDistance = station.location.Distance(destination);
					closestStation = station;
				}
			}
			return closestStation;
		}
		System.out.println("The quickest path is by foot");
		return null;
	}
}
	
