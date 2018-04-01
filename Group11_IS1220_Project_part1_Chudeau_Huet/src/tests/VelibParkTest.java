package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes_part1.Station;
import classes_part1.VelibPark;

public class VelibParkTest {
	
	@Test
	public void testFillPark() {
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20);
		System.out.println(park.getStationsList());
	}
	
	@Test
	public void testFillPark2() {
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20,12);
		System.out.println(park.getStationsList());
	}


	@Test
	public void testMostUsedStation() {
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20);
		Station station = park.getStationsList().get(4);
		//station.calculateOccupationRate(startTime, endTime);
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
