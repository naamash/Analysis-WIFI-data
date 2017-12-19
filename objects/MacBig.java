package objects;
/**
 * * This class creates object that contain Values of each sample.
 */
/**This function set all the Values in the MacBig
 */
public class MacBig {

	public String Mac;
	public String Signal;
	public String time;
	public String frequency;
	public String lon;
	public String lat;
	public String ssid;
	public String ID;
	public String alt;

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
		this.alt = null;
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
	public MacBig(String Mac,String Signal,String time,String frequency,String lon,String lat,String ssid,String ID,String alt){
		this.frequency = frequency;
		this.ID = ID;
		this.lat = lat;
		this.lon = lon;
		this.Mac = Mac;
		this.Signal = Signal;
		this.ssid = ssid;
		this.time = time;
		this.alt = alt;
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
		this.alt = other.alt;
	}
		/**
		 * The function print the object
		 */
		public String toString() {
			return "MacBig [Mac=" + Mac + ", Signal=" + Signal + ", time=" + time + ", frequency=" + frequency
					+ ", lon=" + lon + ", lat=" + lat + ", ssid=" + ssid + ", ID=" + ID + ", alt=" + alt + "]";
		}


}
