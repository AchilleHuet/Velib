package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes_part1.Bicycle;
import classes_part1.BicycleType;
import classes_part1.ParkingSlot;
import classes_part1.SlotStatus;

public class ParkingSlotTest {

	@Test
	public void testParkingSlot() {
		ParkingSlot slot = new ParkingSlot();
		System.out.println("ce slot doit être disponible");
		assertTrue(slot.getStatus() == SlotStatus.Free);
	}

	@Test
	public void testParkingSlotBicycle() {
		Bicycle bicycle = new Bicycle(BicycleType.Mechanical);
		ParkingSlot slot = new ParkingSlot(bicycle);
		System.out.println("ce slot doit être occupé");
		assertTrue(slot.getStatus() == SlotStatus.Occupied);
	}
	
	@Test
	public void testOutOfOrderSlot() {
		ParkingSlot slot = new ParkingSlot();
		slot.setStatus(SlotStatus.Out_of_order);
		System.out.println("ce slot doit être hors-service");
		assertTrue(slot.getStatus() == SlotStatus.Out_of_order);
	}

	@Test
	public void testRemoveBicycle() {
		Bicycle bicycle = new Bicycle(BicycleType.Mechanical);
		ParkingSlot slot = new ParkingSlot(bicycle);
		slot.RemoveBicycle();
		assertTrue(slot.getStatus() == SlotStatus.Free);
		slot.RemoveBicycle();
		System.out.println("doit renvoyer une erreur : this parking slot has no bike to remove");
	}

	@Test
	public void testAddBicycle() {
		Bicycle bicycle = new Bicycle(BicycleType.Mechanical);
		ParkingSlot slot = new ParkingSlot();
		slot.addBicycle(bicycle);
		assertTrue(slot.getStatus() == SlotStatus.Occupied);
		Bicycle bicycle2 = new Bicycle(BicycleType.Mechanical);
		slot.addBicycle(bicycle2);
		System.out.println("doit renvoyer une erreur : This parking slot is already occupied");
	}

	@Test
	public void testOutOfOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testFixSlot() {
		fail("Not yet implemented");
	}

	@Test
	public void testOccupationRate() {
		fail("Not yet implemented");
	}

}
