package MyVelibProject.Package;

import java.util.ArrayList;

public class VelibPark {
	
	ArrayList<Station> stationsList;
	
	Station mostUsedStation() {
		long maxUses = 0;
		Station stationMax = null;
		for (Station station : this.stationsList) {
			if (station.uses > maxUses) {
				maxUses = station.uses;
				stationMax = station;
			}
		}
		return stationMax;
	}

	Station leastOccupiedSation() {
		
	}
	
}
