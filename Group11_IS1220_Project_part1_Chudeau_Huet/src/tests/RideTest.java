package tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import classes_part1.AvoidPlusStations;
import classes_part1.BicycleType;
import classes_part1.Location;
import classes_part1.Ride;
import classes_part1.User;
import classes_part1.VelibPark;
import classes_part1.Policy;

public class RideTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testDuration() {
		User damien = new User("Damien");
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20,10);
		Location loc = new Location(23.456,78.902);
		Policy policy = new AvoidPlusStations();
		Ride ride = new Ride(damien, park, policy, BicycleType.Mechanical, loc);
		ride.setStartTime(new Date(2018, 2, 28, 6, 0, 0));
		ride.setEndTime(new Date(2018, 2, 28, 7, 30, 0));
		double dur = ride.duration();
		System.out.println(dur);
		assertTrue(dur == 0);
		
	}
	
	@Test
	public void testDistance() {
		User damien = new User("Damien");
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20,10);
		Location loc = new Location(23.456,78.902);
		Policy policy = new AvoidPlusStations();
		Ride ride = new Ride(damien, park, policy, BicycleType.Mechanical, loc);
		double dist = ride.distance();
		System.out.println("distance proposée : " + dist);
	}
	
	@Test
	public void testPlanRide() {
		User damien = new User("Damien");
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20,10);
		Location loc = new Location(23.456,78.902);
		Policy policy = new AvoidPlusStations();
		Ride ride = new Ride(damien, park, policy, BicycleType.Mechanical, loc);
		ride.planRide();
		
	}

}
