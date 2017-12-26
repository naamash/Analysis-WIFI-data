package filtersPack;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import objects.MacBig;
import objects.MacBig_Container;
import writeTo.FindIndex;
/**
 * This class contains function that "help" to the three functions filters (filters class).
 * The functions of the filters use those functions.
 * function that save the largest signal.
 * function swap.
 * function that convert from String To Date.
 * function that calculate the distance between two points.
 * @author 
 *
 */
public class HelpFilter {

	static int ARR_SIZE = 3;
	/**
	 * The function accept ArrayList of MacBig_Container type , ArrayList of String[] type and int row.
	 * The function save the largest SSID of each Mac.
	 * The function copying all the Values to ArrayList of MacBig type 
	 * @param macs
	 * @param answer
	 * @param row
	 */
	public static ArrayList<MacBig_Container> SaveTheLargestSIGNAL (ArrayList<MacBig_Container> macs,
			ArrayList<MacBig_Container>answer, int indexRowAnswer){

		boolean isIn = true;
//		int ssidindex=FindIndex.Place(answer, "SSID1");
//		int timeindex=FindIndex.Place(answer, "Time");
//		int IDindex=FindIndex.Place(answer, "ID");
//		int Latindex=FindIndex.Place(answer, "Lat");
//		int Lonindex=FindIndex.Place(answer, "Lon");
//		int network =FindIndex.Place(answer,"#WiFi networks");
//		int AltIndex =FindIndex.Place(answer,"Alt");
		System.out.println("----------------------------------------------");
		System.out.println(" answer.get(indexRowAnswer).realsize  "+ answer.get(indexRowAnswer).realsize);
		for (int i =0; i < answer.get(indexRowAnswer).realsize ; i++) {
			isIn = true;
			int j = 0;
			MacBig temp = new MacBig();
			temp.time=answer.get(indexRowAnswer).arr_macbig[i].time;
			temp.ID=answer.get(indexRowAnswer).arr_macbig[i].ID;
			temp.lat=answer.get(indexRowAnswer).arr_macbig[i].lat;
			temp.lon=answer.get(indexRowAnswer).arr_macbig[i].lon;
			temp.alt=answer.get(indexRowAnswer).arr_macbig[i].alt;
			temp.ssid=answer.get(indexRowAnswer).arr_macbig[i].ssid;
			temp.Mac=answer.get(indexRowAnswer).arr_macbig[i].Mac;
			temp.frequency=answer.get(indexRowAnswer).arr_macbig[i].frequency;
			temp.Signal=answer.get(indexRowAnswer).arr_macbig[i].Signal;
			System.out.println("temp:  "+temp.toString());
			while (j < macs.size() && isIn){
				if (macs.get(j).arr_macbig[0].Mac.equals(temp.Mac)){	
					isIn=false;
					if ((macs.get(j).realsize==ARR_SIZE)){
						if(Integer.parseInt(temp.Signal)>=Integer.parseInt(macs.get(j).arr_macbig[ARR_SIZE-1].Signal)){
							swap(temp, macs.get(j).arr_macbig[macs.get(j).realsize-1]);
							sortMACS(macs.get(j));
						}
					}
					else if (macs.get(j).realsize<ARR_SIZE){
						macs.get(j).arr_macbig[macs.get(j).realsize] =new  MacBig(temp);
						macs.get(j).realsize ++;
						sortMACS(macs.get(j));
					}
				}
				j++;
			}
			if (macs.size()==0){
				MacBig []s = new MacBig[ARR_SIZE];
				s[0] =new  MacBig(temp);
				MacBig_Container tempNew=new MacBig_Container(s,1);
				macs.add(tempNew);

				//MMB29K.A520FXXU1AQF3
			}	
			else if ((isIn && j <= macs.size())){
				MacBig []s = new MacBig[ARR_SIZE];
				s[0] =new  MacBig(temp);
				MacBig_Container tempNew=new MacBig_Container(s,1);
				macs.add(tempNew);
			}
		}
		return macs;
	}
	
	/**
	 * This function gets array of MacBig and sort it so that the largest is in the lowest index.
	 * @param mac
	 */
	public static void sortMACS(MacBig_Container mac){
		for(int i=0; i < mac.realsize; i++){  
			for(int j=i+1; j < mac.realsize-1; j++){  
				if(Integer.parseInt(mac.arr_macbig[i].Signal) < Integer.parseInt(mac.arr_macbig[j].Signal)){  
					swap(mac.arr_macbig[i],mac.arr_macbig[j]);
				}  
			}  
		}  
	}
	/**
	 * The function accept two MacBig type and swap them.
	 * @param temp
	 * @param original
	 */
	public static void swap(MacBig temp,MacBig original){
		MacBig helper = new MacBig(original);

		original.time=temp.time;
		original.ID = temp.ID;
		original.lat = temp.lat;
		original.lon = temp.lon;
		original.ssid = temp.ssid;
		original.Mac = temp.Mac;
		original.frequency = temp.frequency;
		original.Signal = temp.Signal;
		original.alt = temp.alt;

		temp.time=helper.time;
		temp.ID = helper.ID;
		temp.lat = helper.lat;
		temp.lon = helper.lon;
		temp.ssid = helper.ssid;
		temp.Mac = helper.Mac;
		temp.frequency = helper.frequency;
		temp.Signal = helper.Signal;
		temp.alt = helper.alt;
	}
	/**
	 * The function accept String time, checking which format it is in and convert this to Date type 
	 * https://www.mkyong.com/java/java-date-and-calendar-examples/
	 * @param 
	 * @return the time in format of Date
	 */
	public static Date fromStringToDate (String time)   {
		time = time.replace("/", "-");
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date date=null;
		if(time.split(" ")[1].length() == 5)
			time = time + ":00";
		try {	
			if(time.split(" ")[0].split("-")[0].length() == 2)
				sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			else
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = sdf.parse(time);
			return date;
		}
		catch (Exception e) {
		}
		return date;
	}
	/**
	 * This function get two points - two values by String type of each point. convert them to double type and calculate the distance between them both.
	 * @param lat
	 * @param lon
	 * @param lat1
	 * @param lon1
	 * @return The distance between the two points.
	 */
	public static double Distance(String lat,String lon,String lat1,String lon1){
		double x1=(Double.parseDouble(lat));
		double x2=(Double.parseDouble(lat1));
		double y1=(Double.parseDouble(lon));
		double y2=(Double.parseDouble(lon1));
		double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		return distance;
	}
	public static void FromAnsToAnswer(ArrayList<String[]> ans,
			ArrayList<MacBig_Container> answer,int indexOfRowAns,int counterWifi,int realsize){

		MacBig[] infoofLine = new MacBig[10];
		int indexInfoOfLine=0;

		for (int i = 6; i < counterWifi; i=i+4) {
			MacBig With4values = new MacBig();
			With4values.time = ans.get(indexOfRowAns)[0];
			With4values.ID = ans.get(indexOfRowAns)[1];
			With4values.lat = ans.get(indexOfRowAns)[2];
			With4values.lon = ans.get(indexOfRowAns)[3];
			With4values.alt = ans.get(indexOfRowAns)[4];
			With4values.WIFI_Network = ans.get(indexOfRowAns)[5];
			With4values.ssid=ans.get(indexOfRowAns)[i];
			With4values.Mac=ans.get(indexOfRowAns)[i+1];
			With4values.frequency=ans.get(indexOfRowAns)[i+2];
			With4values.Signal=ans.get(indexOfRowAns)[i+3];
			infoofLine[indexInfoOfLine]=With4values;
			indexInfoOfLine++;	
		}
		MacBig_Container added = new MacBig_Container(infoofLine,realsize);
		answer.add(added);
		//		for (int i = 0; i < answer.size(); i++) {
		//			System.out.println(Arrays.toString(answer.get(i).arr_macbig));
		//
		//		}
	}
}


