package classes_part1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class VelibPark {
	
	ArrayList<Station> stationsList;
	double xmin;
	double xmax;
	double ymin;
	double ymax;
	
	/**
	 * Creates a new empty Velib park 
	 * @param xmin
	 * @param xmax
	 * @param ymin
	 * @param ymax
	 */
	VelibPark(double xmin, double xmax, double ymin, double ymax) {
		this.stationsList = new ArrayList<Station>();
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
	}
	
	/**
	 * fills the Velib park with a number of randomly generated stations
	 * @param size : Number of stations
	 */
	public void fillPark(int size) {
		int stationSize = 100;
		for (int i = 0; i<size; i++) {
			double randomX = Math.random()*(this.xmax-this.xmin) + this.xmin;
			double randomY = Math.random()*(this.ymax-this.ymin) + this.ymin;
			Location location = new Location(randomX, randomY);
			this.stationsList.add(new Station(stationSize, location));
		}
	}
	
	/**
	 * fills the Velib Park with a number of randomly generated stations of a given size
	 * @param size : Number of stations
	 * @param stationSize : Number of parking slots in each station
	 */
	public void fillPark(int size, int stationSize) {
		for (int i = 0; i<size; i++) {
			double randomX = Math.random()*(this.xmax-this.xmin) + this.xmin;
			double randomY = Math.random()*(this.ymax-this.ymin) + this.ymin;
			Location location = new Location(randomX, randomY);
			this.stationsList.add(new Station(stationSize, location));
		}
	}

	
	public ArrayList<Station> getStationsList() {
		return stationsList;
	}


	public void setStationsList(ArrayList<Station> stationsList) {
		this.stationsList = stationsList;
	}
	
	/**
	 * returns the most used station of the park
	 * @return
	 */
	public Station mostUsedStation() {
		long maxUses = 0;
		Station stationMax = stationsList.get(0);
		for (Station station : this.stationsList) {
			if (station.uses > maxUses) {
				maxUses = station.uses;
				stationMax = station;
			}
		}
		return stationMax;
	}

	/**
	 * Returns the station which has been the least occupied in the past month
	 * @return
	 */	
	public Station leastOccupiedStation() {
		Calendar calendar = Calendar.getInstance();
		Date nowDate = calendar.getTime();
		int month = calendar.get(2);
		if (month == 0) {
			calendar.set(2,11);
		}
		else {
		calendar.set(2,month-1);
		}
		Date thenDate = calendar.getTime();
		double minRate = stationsList.get(0).occupationRate(thenDate, nowDate);
		Station minStation = stationsList.get(0);
		for (Station station : stationsList) {
			if (station.occupationRate(thenDate, nowDate) < minRate) {
				minRate = station.occupationRate(thenDate, nowDate);
				minStation = station;
			}
		}
		return minStation;
	}
	
}
