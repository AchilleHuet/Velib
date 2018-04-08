package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes_part1.Location;
import classes_part1.Station;
import classes_part1.VelibPark;

public class VelibParkTest {
	
	@Test
	public void testFillPark() {
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20);
		System.out.println(park.getStationsList());
		System.out.println(park);
	}
	
	@Test
	public void testFillPark2() {
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20,12);
		System.out.println(park.getStationsList());
	}
	
	@Test
	public void testAddStation() {
		Location loc = new Location(23.1, 46.2);
		Station station = new Station(7, loc);
		VelibPark park = new VelibPark(0,30,0,120);
		park.addStation(station);
	}


	@Test
	public void testMostUsedStation() {
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20,10);
		Station station = park.getStationsList().get(4);
		station.setRents(2);
		Station stationmax = park.mostUsedStation();
		assertTrue(station == stationmax);
		
	}

	@Test
	public void testLeastOccupiedStation() {
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20);
		Station station = park.getStationsList().get(0);
		//pour faire le test il faudrait pouvoir accéder directement à la stat (et lui donner une valeur)
		// sans devoir appeler une méthode
		Station stationmin = park.leastOccupiedStation();
		assertTrue(station == stationmin);
	}

}
