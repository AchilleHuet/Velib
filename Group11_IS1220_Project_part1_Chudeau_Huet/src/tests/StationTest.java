package tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import classes_part1.AvoidPlusStations;
import classes_part1.Bicycle;
import classes_part1.BicycleType;
import classes_part1.Location;
import classes_part1.ParkingSlot;
import classes_part1.Policy;
import classes_part1.Ride;
import classes_part1.Station;
import classes_part1.User;
import classes_part1.VelibPark;

public class StationTest {

	@Test
	public void testStation() {
		Location loc = new Location(23.1, 46.2);
		Station station = new Station(7, loc);
		System.out.println(station.getParkingSlots());
	}

	@Test
	public void testBicycleNumber() {
		Location loc = new Location(23.1, 46.2);
		Station station = new Station(7, loc);
		for (ParkingSlot slot : station.getParkingSlots()) {
			Bicycle bicycle = null;
			slot.addBicycle(bicycle);
		}
		int num = 7;
		int bikeNum = station.BicycleCount();
		assertTrue(num == bikeNum);
	}

	@Test
	public void testBicycleNumberBicycleType() {
		Bicycle bike_meca = new Bicycle(BicycleType.Mechanical);
		Location loc = new Location(23.1,46.2);
		Station station = new Station(7,loc);
		for (ParkingSlot slot : station.getParkingSlots()) {
			slot.addBicycle(bike_meca);
		}
		int num = 7;
		int bikeNum = station.BicycleCount(BicycleType.Mechanical);
		assertTrue(num == bikeNum);
	}

	@Test
	public void testCalculateOccupationRate() {
		Location loc = new Location(23.1,46.2);
		Station station = new Station(7,loc);
		Date endTime = null;
		Date startTime = null;
		station.calculateOccupationRate(startTime, endTime);
		double rate = station.getOccupationRate();
		System.out.println(rate);
		assertTrue(rate == 0.);
	}
	
	@Test
	public void testStartRide() {
		Bicycle bicycle = new Bicycle(BicycleType.Mechanical);
		User Damien = new User("Damien");
		Location loc = new Location(23.1, 46.2);
		Station station = new Station(7, loc);
		station.startRide(bicycle, Damien);
		//tester maintenant le ride de Damien
	}
	
	@Test
	public void testEndRide() {
		Bicycle bicycle = new Bicycle(BicycleType.Mechanical);
		VelibPark park = new VelibPark("park");
		User Damien = new User("Damien");
		Location loc = new Location(23.1, 46.2);
		Station station = new Station(7, loc);
		Ride ride = new Ride(Damien, park, bicycle);
		station.startRide(bicycle, Damien);
		Location loc2 = new Location(400, -300);
		Station station2 = new Station(7, loc2);
		station2.endRide(ride);
	}
	
	@Test
	public void testFillStation() {
		Location loc = new Location(23.1, 46.2);
		Station station = new Station(8, loc);
		station.fillStation(0.5, 0.5);
		System.out.println(station.getParkingSlots());
	}

}
