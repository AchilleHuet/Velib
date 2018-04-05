package tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import classes_part1.AvoidPlusStations;
import classes_part1.Bicycle;
import classes_part1.BicycleType;
import classes_part1.Location;
import classes_part1.Ride;
import classes_part1.Station;
import classes_part1.Policy;

public class RideTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testDuration() {
		Bicycle bicycle = new Bicycle(BicycleType.Mechanical);
		Location loc1 = new Location(23.456,78.902);
		Station desiredDeparture = new Station(12, loc1);
		Location loc2 = new Location(46.872, 94.097);
		Station desiredArrival = new Station(4, loc2);
		Policy policy = new AvoidPlusStations();
		Ride ride = new Ride(bicycle, desiredDeparture, desiredArrival, policy);
		ride.setStartTime(new Date(2018, 2, 28, 6, 0, 0));
		ride.setEndTime(new Date(2018, 2, 28, 7, 30, 0));
		double dur = ride.duration();
		assertTrue(dur == 5400.);
		
	}
	
	@Test
	public void testDistance() {
		Bicycle bicycle = new Bicycle(BicycleType.Mechanical);
		Location loc1 = new Location(23.456,78.902);
		Station desiredDeparture = new Station(12, loc1);
		Location loc2 = new Location(28.872, 94.097);
		Station desiredArrival = new Station(4, loc2);
		Policy policy = new AvoidPlusStations();
		Ride ride = new Ride(bicycle, desiredDeparture, desiredArrival, policy);
		double dist = ride.distance();
		double desireddist = loc1.Distance(loc2);
		System.out.println("distance proposées : " + dist);
		System.out.println("distance désirée : " + desireddist);
	}
	
	@Test
	public void testPlanRide() {
		Bicycle bicycle = new Bicycle(BicycleType.Mechanical);
		Location loc1 = new Location(23.456,78.902);
		Station desiredDeparture = new Station(12, loc1);
		Location loc2 = new Location(28.872, 94.097);
		Station desiredArrival = new Station(4, loc2);
		Policy policy = new AvoidPlusStations();
		Ride ride = new Ride(bicycle, desiredDeparture, desiredArrival, policy);
		ride.planRide();
		
	}

}
