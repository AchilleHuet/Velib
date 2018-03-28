package classes_part1;

import java.util.Date;

public class Operation {
	
	Date date;
	Bicycle bicycle;
	OperationType type;
	
	public Operation(OperationType type) {
		this.date = new Date();
		this.type = type;
	}
	
	public Operation(OperationType type, Bicycle bicycle) {
		this.bicycle = bicycle;
		this.date = new Date();
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}
	
	

}
