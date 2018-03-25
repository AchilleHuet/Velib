package classes_part1;

import java.util.Date;

public class Operation {
	
	Date date;
	Bicycle bicycle;
	OperationType type;
	
	Operation(OperationType type) {
		this.date = new Date();
		this.type = type;
	}
	
	Operation(OperationType type, Bicycle bicycle) {
		this.bicycle = bicycle;
		this.date = new Date();
		this.type = type;
	}

}
