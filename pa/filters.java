package pa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import javax.crypto.MacSpi;

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
	 * the function gets file ,Start point and End point.
	 * it save only values who is at the defined time.
	 * After sorting, the function use another class for converting to KML file.
	 * @param file
	 * @param start
	 * @param end
	 * @throws IOException
	 */

	public static void FilterByTime(File file, String start, String end) throws Exception{
		//System.out.println(HelpFilter.fromStringToDate(start));
		Date StartDate = HelpFilter.fromStringToDate(start);
		//System.out.println(StartDate);
		Date EndDate =  HelpFilter.fromStringToDate(end);
		ArrayList<MacBig_Container> macs=new ArrayList<MacBig_Container>();
		

		FileInputStream fi = new FileInputStream(file);
		Scanner sc = new Scanner(fi);
		int m = 0;
		int r=0;
		BufferedReader read= new BufferedReader(new FileReader(file.getPath()));
		while(read.readLine()!=null){
			r++;
		}
		read.close();

		String [][]answer = new String[r][12];
		r=1;

		while (sc.hasNext()) {
			String str = sc.nextLine();
			answer[m] = str.split(",");
			m++;
		}
		sc.close();
		fi.close();
		Date dateLine = null;
		int timeIndex=FindIndex.PlaceArticle(answer, "Time",0);
		int rowSort = 1;
		for (int i = 1; i < answer.length; i++) {
			dateLine = (Date) (HelpFilter.fromStringToDate(answer[i][timeIndex]));
			System.out.println(StartDate);

			if (dateLine.after(StartDate)&&dateLine.before(EndDate)){
				macs = HelpFilter.SaveTheLargestSIGNAL(macs, answer, rowSort);
				rowSort++;
			}
		}

		MacBig[] MacsAfterFormulas = new MacBig[macs.size()];
		MacsAfterFormulas = HelpFilter.FixingBeforeCsv(macs);
		//ReadAndSave.WriteToCsvTheBetterMac(MacsAfterFormulas);
		//System.out.println(macs.toString());
		
		ConvertToKml.ToKml(macs);
	}

	/**
	 * This function sort the file it gets by ID.
	 * the function gets file and String ID .
	 * it save only values who have the same ID.
	 * After sorting, the function use another class for converting to KML file.
	 * @param file
	 * @param ID
	 * @throws IOException
	 */
	public static void FilterByID(File file, String ID) throws IOException{
		ArrayList<MacBig_Container> macs=new ArrayList<MacBig_Container>();
		//ArrayList<MacBig[]> MacsAfterFormulas=new ArrayList<MacBig[]>();


		FileInputStream fi = new FileInputStream(file);
		Scanner sc = new Scanner(fi);
		int m = 0;
		int r=0;
		BufferedReader read= new BufferedReader(new FileReader(file.getPath()));
		while(read.readLine()!=null){
			r++;
		}
		read.close();

		String [][]answer = new String[r][12];
		r=1;

		while (sc.hasNext()) {
			String str = sc.nextLine();
			answer[m] = str.split(",");
			m++;
		}
		sc.close();
		fi.close();
		int IDIndex=FindIndex.PlaceArticle(answer, "ID",0);
		int rowSort = 1;
		for (int i = 1; i < answer.length; i++) {
			if(((answer[i][IDIndex]).equals(ID))){
				HelpFilter.SaveTheLargestSIGNAL(macs, answer, rowSort);
				rowSort++;
			}
		}
		//2017-10-29 11:00:08
		//2017-10-30 10:32:34
//		for (int i = 0; i < macs.size(); i++) {
//		System.out.println(Arrays.toString(macs.get(i).arr_macbig));
//	}
		
	MacBig[] MacsAfterFormulas = new MacBig[macs.size()];
	MacsAfterFormulas = HelpFilter.FixingBeforeCsv(macs);
	//ReadAndSave.WriteToCsvTheBetterMac(MacsAfterFormulas);
	
	ConvertToKml.ToKml(macs);
	}

	/**
	 * This function sort the file it gets by location.
	 * the function gets file, lat, lon, and radius .
	 * it save only values within the radius range.
	 * After sorting, the function use another class for converting to KML file.
	 * @param file
	 * @param lat
	 * @param lon
	 * @param radious
	 * @throws IOException
	 */
	public static void FilterByLocation(File file, String lat, String lon, double radius) throws IOException{
		ArrayList<MacBig_Container> macs=new ArrayList<MacBig_Container>();
		FileInputStream fi = new FileInputStream(file);
		Scanner sc = new Scanner(fi);
		int m = 0;
		int r=0;
		BufferedReader read= new BufferedReader(new FileReader(file.getPath()));
		while(read.readLine()!=null){
			r++;
		}
		read.close();

		String [][]answer = new String[r][12];
		r=1;

		while (sc.hasNext()) {
			String str = sc.nextLine();
			answer[m] = str.split(",");
			m++;
		}
		sc.close();
		fi.close();

		int latIndex = FindIndex.PlaceArticle(answer, "Lat",0);
		int lonIndex = FindIndex.PlaceArticle(answer, "Lon",0);
		int rowSort = 1;
		for (int i = 1; i < answer.length; i++) {
			if(HelpFilter.Distance(lat, lon, (answer[i][latIndex]), (answer[i][lonIndex]))<=radius){
				HelpFilter.SaveTheLargestSIGNAL(macs, answer, rowSort);
				rowSort++;
			}
		}
		MacBig[] MacsAfterFormulas = new MacBig[macs.size()];
		MacsAfterFormulas = HelpFilter.FixingBeforeCsv(macs);
		//ReadAndSave.WriteToCsvTheBetterMac(MacsAfterFormulas);
		ConvertToKml.ToKml(macs);
	}
}




