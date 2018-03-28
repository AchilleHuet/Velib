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
	public void startRide(Bicycle bicycle, Station desiredDeparture, Station desiredArrival, Strategy strategy) {
		Ride ride = new Ride(bicycle,desiredDeparture,desiredArrival,strategy);
		Date date = new Date();
		ride.startTime = date.getTime(); //problème de typage, mais tout dépend de comment on implémente la date
	}
	
	
	/**
	 * ends a ride
	 * @param ride
	 */
	public void endRide(Ride ride) {
		Date date = new Date();
		ride.endTime = date.getTime();
	}

}
