package classes_part1;

public interface RideStrategy {
	
	Station Destination(Location desiredArrival, Station start, VelibPark park);

}
