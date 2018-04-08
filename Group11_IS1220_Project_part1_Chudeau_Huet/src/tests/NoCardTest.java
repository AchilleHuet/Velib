package tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import classes_part1.AvoidPlusStations;
import classes_part1.BicycleType;
import classes_part1.CardType;
import classes_part1.Location;
import classes_part1.NoCard;
import classes_part1.Policy;
import classes_part1.Ride;
import classes_part1.User;
import classes_part1.VelibPark;


public class NoCardTest {
	
	@Test
	public void NoCardConstructionTest() {
		NoCard card = new NoCard();
		assertTrue(card.type == CardType.NoCard);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void NoCardComputeCostTest() {
		NoCard card = new NoCard();
		User damien = new User("Damien");
		VelibPark park = new VelibPark(0,30,0,120);
		park.fillPark(20,10);
		Location loc = new Location(23.456,78.902);
		Policy policy = new AvoidPlusStations();
		Ride ride = new Ride(damien, park, policy, BicycleType.Mechanical, loc);
		ride.setStartTime(new Date(2018, 2, 28, 6, 0, 0));
		ride.setEndTime(new Date(2018, 2, 28, 7, 30, 0));
		double cost = card.computeCost(ride);
		System.out.println(cost);
	}

}
