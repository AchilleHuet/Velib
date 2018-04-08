package classes_part1;

public class User {
	
	Card card;
	String name;
	Integer ID = 1;
	Double timeCredit; //user's time credit in seconds
	public static Integer counter = 1;
	Integer rides; //number of rides the user has done
	Double time; //amount of time user has been on a bike
	Double creditEarned; //total amount of time credit a user has earned in seconds
	Location location;
	Ride currentRide;
	VelibPark park;
	
	/**
	 * Creates a new user with specific card type
	 * @param name
	 * @param card
	 * @param location
	 */
	public User(String name, Card card, VelibPark park) {
		//Creates a new user with specific card type
		super();
		this.card = card;
		this.name = name;
		this.timeCredit = 0.;
		this.rides = 0;
		this.creditEarned = 0.;
		this.ID = counter;
		counter++;
		this.park = park;
		park.usersList.add(this);
	}
	
	/**
	 * Creates a new user without a card
	 * @param name
	 * @param location
	 */

	public User(String name, VelibPark park) {
		//Creates a new user without a card
		this(name, new NoCard(), park);
	}
	
	/**
	 * Creates a new user without a card
	 * @param name
	 */
	
	public User(String name) {
		//Creates a new user without a card
		super();
		this.name = name;
		this.timeCredit = 0.;
		this.card = new NoCard();
		this.rides = 0;
		this.creditEarned = 0.;
		this.ID = counter;
		counter++;
		this.location = new Location(0., 0.);
	}

	public Card getCard() {
		return card;
	}
	
	void setCard(Card card) {
		this.card = card;
	}

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public Integer getID() {
		return ID;
	}

	public Double getTimeCredit() {
		return timeCredit;
	}

	public Integer getRides() {
		return rides;
	}

	public void setRides(Integer rides) {
		this.rides = rides;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public Double getCreditEarned() {
		return creditEarned;
	}

	public void setCreditEarned(Double creditEarned) {
		this.creditEarned = creditEarned;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public void setTimeCredit(Double timeCredit) {
		this.timeCredit = timeCredit;
	}
	
	public void suscribe(Station station) {
		station.addObserver(this);
	}
	
	public void unsuscribe(Station station) {
		station.removeObserver(this);
	}
	public VelibPark getPark() {
		return park;
	}

	
	public void planRide(VelibPark park, Policy policy, BicycleType type, Location destination) {
		Ride ride = new Ride(this, park, policy, type, destination);
		ride.planRide();
		this.suscribe(ride.suggestedArrival);
	}

}
