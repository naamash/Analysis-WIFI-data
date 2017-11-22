package pa;

public class MacBig {

	String Mac;
	String Signal;
	String time;
	String frequency;
	String lon;
	String lat;
	String ssid;
	String ID;

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

	public String toString() {
		return "MacBig [Mac=" + Mac + ", Signal=" + Signal + ", time=" + time + ", frequency=" + frequency + ", lon="
				+ lon + ", lat=" + lat + ", ssid=" + ssid + ", ID=" + ID + "]";
	}

}
