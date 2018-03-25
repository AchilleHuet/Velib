package MyVelibProject.Package;

import java.util.Date;

public abstract class Operation {
	
	long date;
	Bicycle bicycle;
	OperationType type;
	
	Operation(OperationType type) {
		this.date = new Date().getTime();
		this.type = type;
	}
	
	Operation(OperationType type, Bicycle bicycle) {
		this.bicycle = bicycle;
		this.date = new Date().getTime();
		this.type = type;
	}

}
