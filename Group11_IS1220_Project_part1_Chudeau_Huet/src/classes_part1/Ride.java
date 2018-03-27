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
	
	/**
	 * initializes a ride according to what the customer asked
	 * @param bicycle
	 * @param desiredDeparture
	 * @param desiredArrival
	 * @param strategy
	 */
	
	public Ride(Bicycle bicycle, Station desiredDeparture, Station desiredArrival, Strategy strategy) {
		super();
		this.bicycle = bicycle;
		this.desiredDeparture = desiredDeparture;
		this.desiredArrival = desiredArrival;
		this.strategy = strategy;
	}

	public double duration() {
		return this.endTime.compareTo(this.startTime)/1000;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	public Station getDesiredDeparture() {
		return desiredDeparture;
	}

	public void setDesiredDeparture(Station desiredDeparture) {
		this.desiredDeparture = desiredDeparture;
	}

	public Station getDesiredArrival() {
		return desiredArrival;
	}

	public void setDesiredArrival(Station desiredArrival) {
		this.desiredArrival = desiredArrival;
	}

	public Station getDeparture() {
		return departure;
	}

	public void setDeparture(Station departure) {
		this.departure = departure;
	}

	public Station getArrival() {
		return arrival;
	}

	public void setArrival(Station arrival) {
		this.arrival = arrival;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public double distance() {
		Location loc1 = departure.getLocation();
		Location loc2 = arrival.getLocation();
		return loc1.Distance(loc2);
	}
	
	
}
