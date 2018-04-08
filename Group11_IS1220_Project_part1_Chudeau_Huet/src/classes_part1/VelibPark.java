package classes_part1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class VelibPark {
	
	ArrayList<Station> stationsList;
	ArrayList<User> usersList;
	public static int stationCounter = 1;
	public String name;
	double xmin;
	double xmax;
	double ymin;
	double ymax;
	
	public VelibPark(String name) {
		this(-2000., 2000., -2000., 2000.);
		this.stationsList = new ArrayList<Station>();
		this.name = name;
	}
	
	/**
	 * Creates a new empty Velib park 
	 * @param xmin the minimal x value in meters
	 * @param xmax the maximal x value in meters
	 * @param ymin the minimal y value in meters
	 * @param ymax the maximal y value in meters
	 */
	public VelibPark(double xmin, double xmax, double ymin, double ymax) {
		super();
		this.stationsList = new ArrayList<Station>();
		this.usersList = new ArrayList<User>();
		this.xmin = xmin;
		this.xmax = xmax;
		this.ymin = ymin;
		this.ymax = ymax;
	}
	
	public VelibPark(String name, double xmin, double xmax, double ymin, double ymax) {
		this(xmin, xmax, ymin, ymax);
		this.name = name;
	}
	
	/**
	 * fills the Velib park with a number of randomly generated stations
	 * @param size : Number of stations
	 */
	public void fillPark(int size) {
		this.fillPark(size, 100);
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
			Station station = new Station(stationSize, location);
			addStation(station);
		}
	}
	
	/**
	 * Creates a new station in the network and gives it a unique ID
	 * @param station
	 */
	public void addStation(Station station) {
		station.ID = stationCounter;
		station.park = this;
		stationsList.add(station);
		stationCounter++;
	}

	
	public ArrayList<Station> getStationsList() {
		return stationsList;
	}


	public void addStations(ArrayList<Station> stationsList) {
		this.stationsList.addAll(stationsList);
	}
	
	/**
	 * returns the most used station of the park
	 * @return
	 */
	public Station mostUsedStation() {
		long maxUses = 0;
		Station stationMax = stationsList.get(0);
		for (Station station : this.stationsList) {
			if (station.Uses() > maxUses) {
				maxUses = station.Uses();
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
		stationsList.get(0).calculateOccupationRate(thenDate, nowDate);
		double minRate = stationsList.get(0).getOccupationRate();
		Station minStation = stationsList.get(0);
		for (Station station : stationsList) {
			station.calculateOccupationRate(thenDate, nowDate);
			if (station.getOccupationRate() < minRate) {
				minRate = station.getOccupationRate();
				minStation = station;
			}
		}
		return minStation;
	}
	
	public String toString() {
		return "Park: " + name + ", " + stationsList;
	}
	
}
