package classes_part1;

public class User {
	
	Card card;
	String name;
	Integer ID = 1;
	Double timeCredit; 
	public static Integer counter = 1;
	Integer rides; //number of rides the user has done
	Double time; //amount of time user has been on a bike
	Double creditEarned; //total amount of time credit a user has earned
	Location location;
	
	
	public User(String name, Card card, Location location) {
		//Creates a new user with specific card type
		super();
		this.card = card;
		this.name = name;
		this.timeCredit = 0.;
		this.rides = 0;
		this.creditEarned = 0.;
		this.ID = counter;
		counter++;
		this.location = location;
	}

	public User(String name, Location location) {
		//Creates a new user without a card
		super();
		this.name = name;
		this.timeCredit = 0.;
		this.card = Card.NoCard;
		this.rides = 0;
		this.creditEarned = 0.;
		this.ID = counter;
		counter++;
		this.location = location;
	}
	
	public User(String name) {
		//Creates a new user without a card
		super();
		this.name = name;
		this.timeCredit = 0.;
		this.card = Card.NoCard;
		this.rides = 0;
		this.creditEarned = 0.;
		this.ID = counter;
		counter++;
	}

	public Card getCard() {
		//gives the card type of the user
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
	
	
	
	
	

}
