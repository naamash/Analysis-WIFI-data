package pa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
		Date StartDate = HelpTime.fromStringToDate(start);
		Date EndDate = HelpTime.fromStringToDate(end);
		ArrayList<MacBig> macs=new ArrayList<MacBig>();

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
			dateLine = (Date) (HelpTime.fromStringToDate(answer[i][timeIndex]));
			if (dateLine.after(StartDate)&&dateLine.before(EndDate)){
				HelpTime.SaveTheLargestSSID(macs, answer, rowSort);
				rowSort++;
			}
		}
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
		ArrayList<MacBig> macs=new ArrayList<MacBig>();

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
				HelpTime.SaveTheLargestSSID(macs, answer, rowSort);
				rowSort++;
			}
		}
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
		ArrayList<MacBig> macs=new ArrayList<MacBig>();
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
			if(Distance(lat, lon, (answer[i][latIndex]), (answer[i][lonIndex]))<=radius){
				HelpTime.SaveTheLargestSSID(macs, answer, rowSort);
				rowSort++;
			}
		}
		ConvertToKml.ToKml(macs);
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

}




