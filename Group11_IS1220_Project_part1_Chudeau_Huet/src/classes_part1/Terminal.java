package classes_part1;

import java.util.Date;

public class Terminal {
	
	
	/**
	 * begins a ride
	 * @param bicycle
	 * @param desiredDeparture
	 * @param desiredArrival
	 * @param strategy
	 */
	public void startRide(Bicycle bicycle, Station departure, User user) {
		Ride ride = user.currentRide;
		ride.departure = departure;
		ride.startTime = new Date();
	}
	
	
	/**
	 * ends a ride
	 * @param ride 
	 * @param arrival The station at which the user arrives
	 */
	public void endRide(Ride ride, Station arrival) {
		ride.endTime = new Date();
		ride.arrival = arrival;
	}

}
