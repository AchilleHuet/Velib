package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes_part1.BicycleType;
import classes_part1.Card;
import classes_part1.Location;
import classes_part1.NoCard;
import classes_part1.PreferPlusStations;
import classes_part1.Station;
import classes_part1.User;
import classes_part1.VelibPark;

public class UserTest {

	@Test
	public void testUserStringCardLocation() {
		Location loc = new Location(23.1,46.2);
		Card card = new NoCard();
		User damien = new User("Damien",card,loc);
		
	}

	@Test
	public void testUserStringLocation() {
		Location loc = new Location(23.1,46.2);
		User damien = new User("Damien",loc);
	}

	@Test
	public void testUserString() {
		User damien = new User("Damien");
	}

	@Test
	public void testSuscribe() {
		Location loc = new Location(23.1,46.2);
		Station station = new Station(7,loc);
		User damien = new User("Damien");
		damien.suscribe(station);
		System.out.println(station.getObservers());
	}

	@Test
	public void testUnsuscribe() {
		Location loc = new Location(23.1,46.2);
		Station station = new Station(7,loc);
		User damien = new User("Damien");
		damien.suscribe(station);
		System.out.println(station.getObservers());
		damien.unsuscribe(station);
		System.out.println(station.getObservers());
	}

	@Test
	public void testPlanRide() {
		User damien = new User("Damien");
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20);
		PreferPlusStations policy = new PreferPlusStations();
		Location loc = new Location(31,2);
		damien.planRide(park, policy, BicycleType.Mechanical, loc);
		//il faudrait vérifier quelle est la station d'arrivée proposée
	}

}
