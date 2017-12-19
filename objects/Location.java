package objects;

import java.util.Comparator;

public class Location implements Comparable<Location> {
	
	public String Mac;
	public String PI;
	public String Alt;
	public String Lat;
	public String Lon;
	
	public Location(){
		this.Mac = null;
		this.PI = null;
		this.Alt = null;
		this.Lat = null;
		this.Lon = null;
	}
	
	public Location(String Mac, String PI, String Alt, String Lat, String Lon){
		this.Alt = Alt;
		this.PI = PI;
		this.Mac = Mac;
		this.Lat = Lat;
		this.Lon = Lon;
	}
	
	public Location(Location other){
		this.Alt = other.Alt;
		this.PI = other.PI;
		this.Mac = other.Mac;
		this.Lat = other.Lat;
		this.Lon = other.Lon;
	}
	
	public static Comparator<Location> loc(){
		Comparator t = new Comparator<Location>() {
			
			public int compare(Location o1, Location o2) {
				// TODO Auto-generated method stub
				if(Double.parseDouble(o1.Alt) > Double.parseDouble(o2.Alt))
					return 1;
				else
				return 0;
			}
		};
		return t;
	}
	
	
	
	

	public String toString() {
		return "Location [Mac=" + Mac + ", PI=" + PI + ", Alt=" + Alt + ", Lat=" + Lat + ", Lon=" + Lon + "]";
	}

	public int compareTo(Location loc) {
		if(Double.parseDouble(this.PI)<Double.parseDouble(loc.PI)){
			return 1;
		}
		else if(Double.parseDouble(this.PI)>Double.parseDouble(loc.PI)){
			return -1;
		}
		else return 0;
	}

}
