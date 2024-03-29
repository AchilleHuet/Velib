package classes_part1;

import java.util.Date;

public class Ride {
	
	Date startTime;
	Date endTime;
	Bicycle bicycle;
	BicycleType bicycleType;
	Station suggestedDeparture;
	Station suggestedArrival;
	Station departure;
	Station arrival;
	Location destination;
	Double cost;
	Policy policy;
	User user;
	VelibPark park;
	
	/**
	 * Initializes a ride according to the costumer's destination and needs
	 * @param user
	 * @param destination
	 * @param type
	 * @param park
	 */
	public Ride(User user, VelibPark park, Policy policy, BicycleType type, Location destination) {
		super();
		this.user = user;
		this.destination = destination;
		this.bicycleType = type;
		this.policy = policy;
		user.setCurrentRide(this);
	}
	
	public Ride(User user, VelibPark park, Bicycle bicycle) {
		super();
		this.user = user;
		this.bicycle = bicycle;
		user.setCurrentRide(this);
	}

	public double duration() {
		return (this.endTime.getTime() - this.startTime.getTime())/1000;
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
		return suggestedDeparture;
	}

	public void setDesiredDeparture(Station desiredDeparture) {
		this.suggestedDeparture = desiredDeparture;
	}

	public Station getDesiredArrival() {
		return suggestedArrival;
	}

	public void setDesiredArrival(Station desiredArrival) {
		this.suggestedArrival = desiredArrival;
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

	public Policy getPolicy() {
		return policy;
	}

	public void setStrategy(Policy policy) {
		this.policy = policy;
	}
	
	/**
	 * Returns the distance between start and end of ride
	 * @return
	 */
	public double distance() {
		Location loc1 = departure.getLocation();
		Location loc2 = arrival.getLocation();
		return loc1.Distance(loc2);
	}
	
	public void planRide() {
		this.policy.PlanRide(this.user, this.destination, this.park, this.bicycleType);
	}
	
}
