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
	public void startRide(Bicycle bicycle, Station desiredDeparture, Station desiredArrival, RideStrategy strategy) {
		Ride ride = new Ride(bicycle,desiredDeparture,desiredArrival,strategy);
		ride.startTime = new Date();
	}
	
	
	/**
	 * ends a ride
	 * @param ride
	 */
	public void endRide(Ride ride) {
		ride.endTime = new Date();
	}

}
