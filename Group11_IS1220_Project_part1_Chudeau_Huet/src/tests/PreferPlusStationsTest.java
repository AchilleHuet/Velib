package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes_part1.BicycleType;
import classes_part1.Location;
import classes_part1.PreferPlusStations;
import classes_part1.User;
import classes_part1.VelibPark;

public class PreferPlusStationsTest {

	@Test
	public void testPreferPlusStations() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlanRide() {
		PreferPlusStations policy = new PreferPlusStations();
		
		//cas du vélo mécanique
		User Damien = new User("Damien");
		Location loc = new Location(23.1,46.2);
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20);
		policy.PlanRide(Damien,loc,park,BicycleType.Mechanical);
		
		//cas du vélo électrique
		User Achille = new User("Achille");
		Location loc2 = new Location(28.1,6.2);
		VelibPark park2 = new VelibPark(0,30,0,120);
		park2.fillPark(20);
		policy.PlanRide(Achille,loc2,park2,BicycleType.Electrical);
	}

}
