package objects;

import java.util.Comparator;
/**
 * this class contains four strings that describes the lesses values in algo2.
 * 
 *
 */

public class Location implements Comparable<Location> {
	public String PI;
	public String Alt;
	public String Lat;
	public String Lon;
	
	/**
	 * defulte constractor
	 */
	public Location(){
		this.PI = null;
		this.Alt = null;
		this.Lat = null;
		this.Lon = null;
	}
	/**
	 * Defined constructors
	 * @param PI
	 * @param Alt
	 * @param Lat
	 * @param Lon
	 */
	public Location( String PI, String Alt, String Lat, String Lon){
		this.Alt = Alt;
		this.PI = PI;
		this.Lat = Lat;
		this.Lon = Lon;
	}
	

	/**
	 * copying constractor
	 * @param other
	 */
	public Location(Location other){
		this.Alt = other.Alt;
		this.PI = other.PI;
		this.Lat = other.Lat;
		this.Lon = other.Lon;
	}
	
//	public static Comparator<Location> loc(){
//		Comparator t = new Comparator<Location>() {
//			
//			public int compare(Location o1, Location o2) {
//				// TODO Auto-generated method stub
//				if(Double.parseDouble(o1.Alt) > Double.parseDouble(o2.Alt))
//					return 1;
//				else
//				return 0;
//			}
//		};
//		return t;
//	}
//	
	/**
	 * This function print all the information about the line.
	 */
	public String toString() {
		return "Location [PI=" + PI + ", Alt=" + Alt + ", Lat=" + Lat + ", Lon=" + Lon + "]";
	}

	/**
	 * The function compare between two PI of Location type. 
	 */
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
