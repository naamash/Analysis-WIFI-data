package pa;

/**
 * This class contains function that "help" to three functions filters (filters class).
 * The functions of the filters call to this functions.
 * function that save the largest SSID.
 * function swap.
 * function that convert from String To Date.
 * function that calculate the distance between two points.
 * @author 
 *
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HelpTime {
	
		/**
		 * The function accept ArrayList of MacBig type , matrix of String type and int row.
		 * The function save the largest SSID of each Mac.
		 * The function copying all the Values to ArrayList of MacBig type 
		 * @param macs
		 * @param answer
		 * @param row
		 */
	public static void SaveTheLargestSSID (ArrayList<MacBig> macs,String [][]answer,int row){

		boolean isIn = true;
		int ssidindex=FindIndex.Place(answer, "SSID1");
		int timeindex=FindIndex.Place(answer, "Time");
		int IDindex=FindIndex.Place(answer, "ID");
		int Latindex=FindIndex.Place(answer, "Lat");
		int Lonindex=FindIndex.Place(answer, "Lon");
		int network =FindIndex.Place(answer,"#WiFi networks");

		for (int i =ssidindex; i < (Integer.parseInt(answer[row][network])*4)+ssidindex ; i=i+4) {
			isIn = true;
			int j = 0;
			MacBig temp = new MacBig();
			temp.time=answer[row][timeindex];
			temp.ID=answer[row][IDindex];
			temp.lat=answer[row][Latindex];
			temp.lon=answer[row][Lonindex];
			temp.ssid=answer[row][i];
			temp.Mac=answer[row][i+1];
			temp.frequency=answer[row][i+2];
			temp.Signal=answer[row][i+3];

			while (j < macs.size() && isIn){
				if (macs.get(j).Mac.equals(temp.Mac)){	
					isIn=false;
					if (Integer.parseInt(temp.Signal)>=Integer.parseInt(macs.get(j).Signal)){
						swap(temp, macs.get(j));
					}
				}
				j++;
			}
			if (isIn){
				macs.add(temp);
			}
		}
	}
	/**
	 * The function accept two MacBig type and copying all the Values of one another
	 * @param temp
	 * @param original
	 */
	public static void swap(MacBig temp,MacBig original){
		original.time=temp.time;
		original.ID = temp.ID;
		original.lat = temp.lat;
		original.lon = temp.lon;
		original.ssid = temp.ssid;
		original.Mac = temp.Mac;
		original.frequency = temp.frequency;
		original.Signal = temp.Signal;
	}
	/**
	 * The function accept String time, checking which format it is in and convert this to Date type 
	 * https://www.mkyong.com/java/java-date-and-calendar-examples/
	 * @param 
	 * @return the time in format of Date
	 */
	public static Date fromStringToDate (String time)   {
		time = time.replace("-", "/");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=null;

		try {			
			date = sdf.parse(time);
			return date;
		} catch (ParseException e) {}
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			date = sdf2.parse(time);

			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try{
			date = sdf3.parse(time);

			return date;
		}
		catch (ParseException e){
			e.printStackTrace();
		}
		SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	
		try {
			date = sdf4.parse(time);

			return date;		
		}
		catch (ParseException e){
			e.printStackTrace();		
		}
		return date;
	}

}
