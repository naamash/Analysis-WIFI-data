package pa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HelpTime {

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
	 * https://www.mkyong.com/java/java-date-and-calendar-examples/
	 * @param 
	 * @return
	 */
	public static Date fromStringToDate (String time)   {
		time = time.replace("-", "/");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=null;

		try {			
			date = sdf.parse(time);
			System.out.println(date);
			return date;
		} catch (ParseException e) {}
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			date = sdf2.parse(time);
			System.out.println(date);

			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		try{
			date = sdf3.parse(time);
			System.out.println(date);

			return date;
		}
		catch (ParseException e){
			e.printStackTrace();
		}
		SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	
		try {
			date = sdf4.parse(time);
			System.out.println(date);

			return date;		
		}
		catch (ParseException e){
			e.printStackTrace();		
		}
		System.out.println(date);

		return date;
	}

	/**
	 * check if the input is in the same format of the String-format
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static boolean checkingTheInput(String date, String format) {
		if (format.equals("dd/mm/yyyy")) {
			if ((date.length() == 10) && (date.charAt(2) == '/') && (date.charAt(5) == '/'))
				return true;
		}

		if (format.equals("hh:mm:ss")) {
			if ((date.length() == 8) && (date.charAt(2) == ':') && (date.charAt(5) == ':'))
				return true;
		}
		return false;

	}







}
