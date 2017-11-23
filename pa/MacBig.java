package pa;
/**
 * * This class creates object that contain Values of each sample.
 */
/**This function set all the Values in the MacBig
 */
public class MacBig {

	String Mac;
	String Signal;
	String time;
	String frequency;
	String lon;
	String lat;
	String ssid;
	String ID;

		/**
		 * Default constructors
		 */
	public MacBig(){
		this.Mac=null;
		this.Signal=null;
		this.time=null;
		this.frequency=null;
		this.lon=null;
		this.lat=null;
		this.ssid=null;
		this.ID=null;
	}

	/**
	 * Defined constructors
	 * @param Mac
	 * @param Signal
	 * @param time
	 * @param frequency
	 * @param lon
	 * @param lat
	 * @param ssid
	 * @param ID
	 */
	public MacBig(String Mac,String Signal,String time,String frequency,String lon,String lat,String ssid,String ID){
		this.frequency = frequency;
		this.ID = ID;
		this.lat = lat;
		this.lon = lon;
		this.Mac = Mac;
		this.Signal = Signal;
		this.ssid = ssid;
		this.time = time;
	}
		/**
		 * Copy constructors
		 * @param other
		 */
	public MacBig(MacBig other){
		this.frequency = other.frequency;
		this.ID = other.ID;
		this.lat = other.lat;
		this.lon = other.lon;
		this.Mac = other.Mac;
		this.Signal = other.Signal;
		this.ssid = other.ssid;
		this.time = other.time;
	}
		/**
		 * The function print the object
		 */
	public String toString() {
		return "MacBig [Mac=" + Mac + ", Signal=" + Signal + ", time=" + time + ", frequency=" + frequency + ", lon="
				+ lon + ", lat=" + lat + ", ssid=" + ssid + ", ID=" + ID + "]";
	}

}
