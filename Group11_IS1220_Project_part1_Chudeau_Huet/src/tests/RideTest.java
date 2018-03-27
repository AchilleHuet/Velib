package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes_part1.Bicycle;
import classes_part1.BicycleType;
import classes_part1.Location;
import classes_part1.Ride;
import classes_part1.Station;
import classes_part1.Strategy;

public class RideTest {

	@Test
	public void testDuration() {
		Bicycle bicycle = new Bicycle(BicycleType.Mechanical);
		Location loc1 = new Location(23.456,78.902);
		Station desiredDeparture = new Station(12, loc1);
		Location loc2 = new Location(46.872,94.097);
		Station desiredArrival = new Station(4, loc2);
		Strategy strategy = new Strategy();
		Ride ride = new Ride(bicycle, desiredDeparture, desiredArrival, strategy);
		ride.setStartTime("comment on fait une date ???");
		ride.setEndTime("hein ???");
		double dur = ride.duration();
		assertTrue(dur == ??);
		
		
	}

}
