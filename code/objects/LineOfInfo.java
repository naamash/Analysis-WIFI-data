package objects;

import java.util.ArrayList;

/**
 * This class creates object that contain line.
 * each line contain eleven Strings who describes their own line. 
 * 
 *  this class contain three constructors.
 * @author 
 *
 */

public class LineOfInfo implements Comparable<LineOfInfo>  {
	public ArrayList<LineOfInfo> lines = new ArrayList<LineOfInfo>();
	
	public String Type;
	public String AccuracyMeters;
	public String AltitudeMeters;
	public String CurrentLongitude;
	public String CurrentLatitude;
	public String RSSI;
	public String Channel;
	public String FirstSeen;
	public String AuthMode;
	public String SSID;
	public String MAC;


		/**
		 * defulte constractor
		 */
	public LineOfInfo(){
		this.Type = null;
		this.AccuracyMeters = null;
		this.AltitudeMeters = null;
		this.CurrentLongitude = null;
		this.CurrentLatitude = null;
		this.RSSI = null;
		this.Channel = null;
		this.FirstSeen = null;
		this.AuthMode = null;
		this.SSID = null;
		this.MAC = null;
	}

		/**
		 * copying constractor
		 * @param other
		 */
	public LineOfInfo(LineOfInfo other) {
		this.AccuracyMeters = other.AccuracyMeters;
		this.AltitudeMeters = other.AltitudeMeters;
		this.AuthMode = other.AuthMode;
		this.Channel = other.Channel;
		this.CurrentLatitude = other.CurrentLatitude;
		this.CurrentLongitude = other.CurrentLongitude;
		this.FirstSeen = other.FirstSeen;
		this.MAC = other.MAC;
		this.RSSI = other.RSSI;
		this.SSID = other.SSID;
		this.Type = other.Type;
	}
	/**
	 * Defined constructors
	 * @param Type
	 * @param AccuracyMeters
	 * @param AltitudeMeters
	 * @param CurrentLongitude
	 * @param CurrentLatitude
	 * @param RSSI
	 * @param Channel
	 * @param FirstSeen
	 * @param AuthMode
	 * @param SSID
	 * @param MAC
	 */
	public LineOfInfo(String Type,String AccuracyMeters,String AltitudeMeters,String CurrentLongitude,String CurrentLatitude,
			String RSSI,String Channel,String FirstSeen,String AuthMode,String SSID,String MAC){
		this.AccuracyMeters = AccuracyMeters;
		this.AltitudeMeters = AltitudeMeters;
		this.AuthMode = AuthMode;
		this.Channel = Channel;
		this.CurrentLatitude = CurrentLatitude;
		this.CurrentLongitude = CurrentLongitude;
		this.FirstSeen = FirstSeen;
		this.MAC = MAC;
		this.RSSI = RSSI;
		this.SSID = SSID;
		this.Type = Type;
	}
	
	/**
	 * The function accept matrix of String type and int indexOfLine
	 * The function enter all Values from the matrix to Values LineOfInfo
	 * @param matrix
	 * @param indexOfLine
	 */
	
	public LineOfInfo(ArrayList<String[]> matrix, int indexOfLine){
		this.MAC = matrix.get(indexOfLine)[0];
		this.SSID = matrix.get(indexOfLine)[1];
		this.AuthMode = matrix.get(indexOfLine)[2];
		this.FirstSeen = matrix.get(indexOfLine)[3];
		this.Channel = matrix.get(indexOfLine)[4];
		this.RSSI = matrix.get(indexOfLine)[5];
		this.CurrentLatitude = matrix.get(indexOfLine)[6];
		this.CurrentLongitude = matrix.get(indexOfLine)[7];
		this.AltitudeMeters = matrix.get(indexOfLine)[8];
		this.AccuracyMeters = matrix.get(indexOfLine)[9];
		this.Type = matrix.get(indexOfLine)[10];
	}

	/**
	 * This function print all the information about the line.
	 */
	public String toString() {
		return "LineOfInfo [Type=" + Type + ", AccuracyMeters=" + AccuracyMeters + ", AltitudeMeters=" + AltitudeMeters
				+ ", CurrentLongitude=" + CurrentLongitude + ", CurrentLatitude=" + CurrentLatitude + ", RSSI=" + RSSI
				+ ", Channel=" + Channel + ", FirstSeen=" + FirstSeen + ", AuthMode=" + AuthMode + ", SSID=" + SSID
				+ ", MAC=" + MAC + "]";
	}

	/**
	 * The function compare between two RSSI of LineOfInfo type. 
	 */
	public int compareTo(LineOfInfo line) {
		return this.RSSI.compareTo(line.RSSI);
	}
}

	
	

