package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes_part1.Bicycle;
import classes_part1.BicycleType;
import classes_part1.Operation;
import classes_part1.OperationType;

public class OperationTest {

	@Test
	public void testOperationOperationType() {
		Operation op = new Operation(OperationType.startRide);
		System.out.println(op.getType());
		assertTrue(op.getType() == OperationType.startRide);
		
		Operation op2 = new Operation(OperationType.endRide);
		System.out.println(op2.getType());
		assertTrue(op2.getType() == OperationType.endRide);
		
		Operation op3 = new Operation(OperationType.fixSlot);
		System.out.println(op3.getType());
		assertTrue(op3.getType() == OperationType.fixSlot);
		
		Operation op4 = new Operation(OperationType.breakSlot);
		System.out.println(op4.getType());
		assertTrue(op4.getType() == OperationType.breakSlot);
	}

	@Test
	public void testOperationOperationTypeBicycle() {
		Bicycle bike_meca = new Bicycle(BicycleType.Mechanical);
		
		Operation op = new Operation(OperationType.startRide,bike_meca);
		System.out.println(op.getType());
		assertTrue(op.getType() == OperationType.startRide);
		
		Operation op2 = new Operation(OperationType.endRide,bike_meca);
		System.out.println(op2.getType());
		assertTrue(op2.getType() == OperationType.endRide);
		
		Operation op3 = new Operation(OperationType.fixSlot,bike_meca);
		System.out.println(op3.getType());
		assertTrue(op3.getType() == OperationType.fixSlot);
		
		Operation op4 = new Operation(OperationType.breakSlot,bike_meca);
		System.out.println(op4.getType());
		assertTrue(op4.getType() == OperationType.breakSlot);
	}

}
