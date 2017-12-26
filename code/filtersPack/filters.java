package filtersPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import javax.crypto.Mac;

import objects.LineOfInfo;
import objects.MacBig;
import objects.MacBig_Container;
import writeTo.ConvertToKml;
import writeTo.FindIndex;
import writeTo.HelpersBeforeWrite;
/**
 * This class contains three sorting functions.
 * each function sort by a different thing.
 * 
 * @author 
 *
 */
public class filters {

	/**
	 * This function sort the file it gets by time.
	 * the function gets String file ,Start point and End point.
	 * it save only values who is at the defined time.
	 * After sorting, the function use another class for converting to KML file.
	 * @param file
	 * @param start
	 * @param end
	 * @throws IOException
	 */

	//	public static void FilterByTime(String file1, String start, String end) throws Exception{
	//		//System.out.println(HelpFilter.fromStringToDate(start));
	//		Date StartDate = HelpFilter.fromStringToDate(start);
	//		//System.out.println(StartDate);
	//		Date EndDate =  HelpFilter.fromStringToDate(end);
	//		ArrayList<MacBig_Container> macs=new ArrayList<MacBig_Container>();
	//		File file = new File(file1);
	//
	//
	//		FileInputStream fi = new FileInputStream(file);
	//		Scanner sc = new Scanner(fi);
	//
	//		ArrayList<String[]> answer = new ArrayList<String[]>();
	//
	//		while (sc.hasNext()) {
	//			String str = sc.nextLine();
	//			answer.add(str.split(","));
	//		}
	//		sc.close();
	//		fi.close();
	//		Date dateLine = null;
	//		int timeIndex=FindIndex.PlaceArticle(answer, "Time",0);
	//		int rowSort = 1;
	//		for (int i = 1; i < answer.size(); i++) {
	//			dateLine = (Date) (HelpFilter.fromStringToDate(answer.get(i)[timeIndex]));
	//
	//			if (dateLine.after(StartDate)&&dateLine.before(EndDate)){
	//				macs = HelpFilter.SaveTheLargestSIGNAL(macs, answer, rowSort);
	//				rowSort++;
	//			}
	//		}
	//
	//		//		MacBig[] MacsAfterFormulas = new MacBig[macs.size()];
	//		//		MacsAfterFormulas = HelpFilter.FixingBeforeCsv(macs);
	//		//ReadAndSave.WriteToCsvTheBetterMac(MacsAfterFormulas);
	//		//System.out.println(macs.toString());
	//
	//		//	ConvertToKml.ToKml(macs);
	//	}

	/**
	 * This function sort the file it gets by ID.
	 * the function gets String file and String ID .
	 * it save only values who have the same ID.
	 * After sorting, the function use another class for converting to KML file.
	 * @param file
	 * @param ID
	 * @throws IOException
	 */
	public static void FilterByID(String file1, String ID) throws IOException{
		ArrayList<MacBig_Container> macs=new ArrayList<MacBig_Container>();
		//ArrayList<MacBig[]> MacsAfterFormulas=new ArrayList<MacBig[]>();
		File file = new File(file1);
		FileInputStream fi = new FileInputStream(file);
		Scanner sc = new Scanner(fi);
		ArrayList<String[]> ans = new ArrayList<String[]>();
		ArrayList<MacBig_Container> answer = new ArrayList<MacBig_Container>();
		int flag=0;
		while (sc.hasNext()) {
			ans = new ArrayList<String[]>();
			String str = sc.nextLine();
			ans.add(str.split(","));
			if (flag==0){
			FromAnsToAnswer(ans, answer, 0, 46,10);
			flag=1;
			}
			else{
				FromAnsToAnswer(ans, answer, 0, ((Integer.parseInt(ans.get(0)[5]))*4+6),Integer.parseInt(ans.get(0)[5]));
			}
		}
		sc.close();
		fi.close();

		int IDIndex=FindIndex.PlaceArticleAnswer(answer, "ID",0);
		//	int rowSort = 1;
		//System.out.println("iii    "+answer.size());
		for (int i = 1; i < answer.size(); i++) {
			System.out.println("answer.get(i).arr_macbig[IDIndex]  "+answer.get(i).arr_macbig[IDIndex].ID);
			if(((answer.get(i).arr_macbig[IDIndex].ID).equals(ID))){
				HelpFilter.SaveTheLargestSIGNAL(macs, answer, i);
				//rowSort++;
			}
		}
		//2017-10-29 11:00:08
		//2017-10-30 10:32:34
		//		for (int i = 0; i < macs.size(); i++) {
		//		System.out.println(Arrays.toString(macs.get(i).arr_macbig));
		//	}
		//System.out.println("pp  "+macs.size());
		MacBig[] MacsAfterFormulas = new MacBig[macs.size()];
		MacsAfterFormulas = HelpersBeforeWrite.FixingBeforeCsv(macs);
		//ReadAndSave.WriteToCsvTheBetterMac(MacsAfterFormulas);
//		for (int i = 0; i < macs.size(); i++) {
//			System.out.println(Arrays.toString(macs.get(i).arr_macbig));
//		}
		ConvertToKml.ToKml(macs);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * This function sort the file it gets by location.
	 * the function gets String file, lat, lon, and radius .
	 * it save only values within the radius range.
	 * After sorting, the function use another class for converting to KML file.
	 * @param file
	 * @param lat
	 * @param lon
	 * @param radious
	 * @throws IOException
	 */
	//	public static void FilterByLocation(String file1, String lat, String lon, double radius) throws IOException{
	//		ArrayList<MacBig_Container> macs=new ArrayList<MacBig_Container>();
	//		File file = new File(file1);
	//
	//		FileInputStream fi = new FileInputStream(file);
	//		Scanner sc = new Scanner(fi);
	//
	//		ArrayList<String[]> answer = new ArrayList<String[]>();
	//
	//		while (sc.hasNext()) {
	//			String str = sc.nextLine();
	//			answer.add(str.split(","));
	//		}
	//		sc.close();
	//		fi.close();
	//
	//		int latIndex = FindIndex.PlaceArticle(answer, "Lat",0);
	//		int lonIndex = FindIndex.PlaceArticle(answer, "Lon",0);
	//		int rowSort = 1;
	//		for (int i = 1; i < answer.size(); i++) {
	//			if(HelpFilter.Distance(lat, lon, (answer.get(i)[latIndex]), (answer.get(i)[lonIndex]))<=radius){
	//				rowSort++;
	//			}
	//		}
	//
	//		//ReadAndSave.WriteToCsvTheBetterMac(MacsAfterFormulas);
	//		//	ConvertToKml.ToKml(macs);
	//	}
}




