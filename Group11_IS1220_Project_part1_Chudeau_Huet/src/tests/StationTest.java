package tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import classes_part1.Bicycle;
import classes_part1.BicycleType;
import classes_part1.Location;
import classes_part1.ParkingSlot;
import classes_part1.Station;

public class StationTest {

	@Test
	public void testStation() {
		Location loc = new Location(23.1,46.2);
		Station station = new Station(7,loc);
		System.out.println(station.getParkingSlots());
	}

	@Test
	public void testBicycleNumber() {
		Location loc = new Location(23.1,46.2);
		Station station = new Station(7,loc);
		for (ParkingSlot slot : station.getParkingSlots()) {
			Bicycle bicycle = null;
			slot.addBicycle(bicycle);
		}
		int num = 7;
		int bikeNum = station.BicycleNumber();
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
		int bikeNum = station.BicycleNumber(BicycleType.Mechanical);
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

}
