package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes_part1.Bicycle;
import classes_part1.BicycleType;

public class BicycleTest {

	@Test
	public void testBicycle() {
<<<<<<< HEAD
		Bicycle bike_meca = new Bicyle(BicyleType(Mechanical));
		System.out.println(bike_meca.type() + bike_meca.ID());
		assertTrue(bike_meca.type == BicyleType.Mechanical);
=======
		Bicycle bike_meca = new Bicycle(BicycleType.Mechanical);
		System.out.println(bike_meca.getType() + bike_meca.getID());
		assertTrue(bike_meca.getType() == BicycleType.Mechanical);
>>>>>>> 50029abf01153c593023a3d6f39856c4c7c2271c
		
		Bicycle bike_elec = new Bicycle(BicycleType.Electrical);
		System.out.println(bike_elec.getType() + bike_elec.getID());
		assertTrue(bike_meca.getType() == BicycleType.Electrical);
	}

}
