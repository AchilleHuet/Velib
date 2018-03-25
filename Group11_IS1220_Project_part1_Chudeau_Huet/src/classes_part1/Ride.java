package classes_part1;

import java.util.Date;

public class Ride {
	
	Date startTime;
	Date endTime;
	Bicycle bicycle;
	Station desiredDeparture;
	Station desiredArrival;
	Station departure;
	Station arrival;
	Double cost;
	Strategy strategy;
	
	double duration() {
		return this.endTime.compareTo(this.startTime)/1000;
	}
	
}
