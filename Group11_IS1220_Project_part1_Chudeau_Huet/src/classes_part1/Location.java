package classes_part1;

public class Location {
	
	Double x;
	Double y;
	
	public Location(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	
	public double Distance(Location that) {
		//returns the distance between the 2 locations
		return Math.sqrt((this.x-that.x)*(this.x-that.x)+(this.y-that.y)*(this.y-that.y));
	}

}
