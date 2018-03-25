package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes_part1.Bicycle;
import classes_part1.Operation;
import classes_part1.OperationType;

public class OperationTest {

	@Test
	public void testOperationOperationType() {
		Operation op = new Operation(OperationType(startRide));
		System.out.println(op.GetType());
		assertTrue(op.GetType() == OperationType(startRide));
		
		Operation op2 = new Operation(OperationType(endRide));
		System.out.println(op2.GetType());
		assertTrue(op2.GetType() == OperationType(endRide));
		
		Operation op3 = new Operation(OperationType(fixSlot));
		System.out.println(op3.GetType());
		assertTrue(op3.GetType() == OperationType(fixSlot));
		
		Operation op4 = new Operation(OperationType(breakSlot));
		System.out.println(op4.GetType());
		assertTrue(op4.GetType() == OperationType(breakSlot));
	}

	@Test
	public void testOperationOperationTypeBicycle() {
		Bicycle bike_meca = new Bicyle(BicyleType(Mechanical));
		
		Operation op = new Operation(OperationType(startRide),bike_meca);
		System.out.println(op.GetType());
		assertTrue(op.GetType() == OperationType(startRide));
		
		Operation op2 = new Operation(OperationType(endRide),bike_meca);
		System.out.println(op2.GetType());
		assertTrue(op2.GetType() == OperationType(endRide));
		
		Operation op3 = new Operation(OperationType(fixSlot),bike_meca);
		System.out.println(op3.GetType());
		assertTrue(op3.GetType() == OperationType(fixSlot));
		
		Operation op4 = new Operation(OperationType(breakSlot),bike_meca);
		System.out.println(op4.GetType());
		assertTrue(op4.GetType() == OperationType(breakSlot));
	}

}
