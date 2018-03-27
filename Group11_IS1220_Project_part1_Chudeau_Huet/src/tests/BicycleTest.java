package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes_part1.Bicycle;
import classes_part1.BicycleType;

public class BicycleTest {

	@Test
	public void testBicycle() {
		Bicycle bike_meca = new Bicyle(BicyleType(Mechanical));
		System.out.println(bike_meca.type() + bike_meca.ID());
		assertTrue(bike_meca.type == BicyleType.Mechanical);
		
		Bicycle bike_elec = new Bicyle(BicyleType(Electrical));
		System.out.println(bike_elec.type() + bike_elec.ID());
		assertTrue(bike_meca.type() == BicyleType(Electrical));
	}

}
