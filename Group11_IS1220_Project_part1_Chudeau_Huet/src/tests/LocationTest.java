package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes_part1.Location;

public class LocationTest {

	@Test
	public void testLocation() {
		Location loc = new Location(23.1,46.2);
		System.out.println("loc (23.1,46.2)" + loc.getX() + loc.getY());
		assertTrue(23.1 == loc.getX() && 46.2 == loc.getY());
		
	}

	@Test (expected = Exception.class)
	public void testGetX() {
		Location loc = new Location("ce n'est pas un double",46.2);
	}

	@Test (expected = Exception.class)
	public void testSetX() {
		Location loc = new Location(23.1,"ce n'est pas un double");
	}


	@Test
	public void testDistance() {
		Location loc1 = new Location(23,2);
		Location loc2 = new Location(31,2);
		assertTrue(loc1.Distance(loc2) == 8);
	}

}
