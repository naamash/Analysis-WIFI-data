package objects;
/**
 * * This class creates object that contain Values of each sample.
 */
/**This function set all the Values in the MacBig
 */
public class MacBig {
	public String time;
	public String ID;
	public String lat;
	public String lon;
	public String alt;
	public String WIFI_Network;
	public String ssid;
	public String Mac;
	public String frequency;
	public String Signal;

		/**
		 * Default constructors
		 */
	public MacBig(){
		this.time=null;
		this.ID=null;
		this.lat=null;
		this.lon=null;
		this.alt = null;
		this.WIFI_Network=null;
		this.ssid=null;
		this.Mac=null;
		this.frequency=null;
		this.Signal=null;

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
	public MacBig(String time ,String ID ,String lat,String lon ,String alt ,String WIFI_Network,String ssid,String Mac ,String frequency,String Signal ){
		this.time = time;
		this.ID = ID;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.WIFI_Network=WIFI_Network;
		this.ssid = ssid;
		this.Mac = Mac;
		this.frequency = frequency;
		this.Signal = Signal;

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
		this.WIFI_Network=other.WIFI_Network;
	}
		/**
		 * The function print the object
		 */

		@Override
		public String toString() {
			return "MacBig [time=" + time + ", ID=" + ID + ", lat=" + lat + ", lon=" + lon + ", alt=" + alt
					+ ", WIFI_Network=" + WIFI_Network + ", ssid=" + ssid + ", Mac=" + Mac + ", frequency=" + frequency
					+ ", Signal=" + Signal + "]";
		}
		


}
