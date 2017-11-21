import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * This class contains three sorting functions.
 * each function sort by a different thing.
 * 
 * @author 
 *
 */
public class Sorting {

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
	public static void SortByTime(File file, String start, String end) throws Exception{
		Date StartDate = fromStringToDate(start);
		Date EndDate = fromStringToDate(end);

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

		int timeIndex=PlaceArticle(answer, "Time");
		int row=0;
		Date dateLine = null;
		for (int i = 1; i < answer.length; i++) {
			dateLine = (Date) (fromStringToDate(answer[i][timeIndex]));
			if (dateLine.after(StartDate)&&dateLine.before(EndDate)){
				row++;
			}
		}
		String [][]sorted = new String[row+1][46];
		sorted[0][0] = "Time";
		sorted[0][1] = "ID";
		sorted[0][2] = "Lat";
		sorted[0][3] = "Lon";
		sorted[0][4] = "Alt";
		sorted[0][5] = "#WiFi networks";
		String helper1 = "SSID";
		String helper2 = "MAC";
		String helper3 = "Frequncy";
		String helper4 = "Signal";
		int hel = 1;

		for (int i = 6; i < sorted[0].length; i=i+4) {
			sorted[0][i] = helper1 + hel;
			hel++;
		}
		hel = 1;
		for (int i = 7; i < sorted[0].length; i=i+4) {
			sorted[0][i] = helper2 + hel;
			hel++;
		}
		hel = 1;
		for (int i = 8; i < sorted[0].length; i=i+4) {
			sorted[0][i] = helper3 + hel;
			hel++;
		}
		hel = 1;
		for (int i = 9; i < sorted[0].length; i=i+4) {
			sorted[0][i] = helper4 + hel;
			hel++;
		}

		int rowSort = 1;
		for (int i = 1; i < answer.length; i++) {
			if (dateLine.after(StartDate)&&dateLine.before(EndDate)){
				for (int j2 = 0; j2 < answer[0].length; j2++) {
					sorted[rowSort][j2]=answer[i][j2];

				}
				rowSort++;
			}
		}
		//printanswer(sorted);
		ConvertToKml.ToKml(sorted);
		//	return sorted;
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

	public static void SortByID(File file, String ID) throws IOException{
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
		int IDIndex=PlaceArticle(answer, "ID");
		int row=0;
		for (int i = 1; i < answer.length; i++) {
			if(((answer[i][IDIndex]).equals(ID))){
				row++;
			}
		}
		String [][]sorted = new String[row+1][46];
		sorted[0][0] = "Time";
		sorted[0][1] = "ID";
		sorted[0][2] = "Lat";
		sorted[0][3] = "Lon";
		sorted[0][4] = "Alt";
		sorted[0][5] = "#WiFi networks";
		String helper1 = "SSID";
		String helper2 = "MAC";
		String helper3 = "Frequncy";
		String helper4 = "Signal";
		int hel = 1;

		for (int i = 6; i < sorted[0].length; i=i+4) {
			sorted[0][i] = helper1 + hel;
			hel++;
		}
		hel = 1;
		for (int i = 7; i < sorted[0].length; i=i+4) {
			sorted[0][i] = helper2 + hel;
			hel++;
		}
		hel = 1;
		for (int i = 8; i < sorted[0].length; i=i+4) {
			sorted[0][i] = helper3 + hel;
			hel++;
		}
		hel = 1;
		for (int i = 9; i < sorted[0].length; i=i+4) {
			sorted[0][i] = helper4 + hel;
			hel++;
		}

		int rowSort = 1;
		for (int i = 1; i < answer.length; i++) {
			if(((answer[i][IDIndex]).equals(ID))){
				for (int j2 = 0; j2 < answer[0].length; j2++) {
					sorted[rowSort][j2]=answer[i][j2];

				}
				rowSort++;
			}
		}
		//printanswer(sorted);
		ConvertToKml.ToKml(sorted);
		//kmlFile.convertTokml(sorted);
		//return sorted;
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
	public static void SortByLocation(File file, String lat, String lon, double radius) throws IOException{
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


		int latIndex = PlaceArticle(answer, "Lat");
		int lonIndex = PlaceArticle(answer, "Lon");
		int row=0;
		for (int i = 1; i < answer.length; i++) {
			if(Distance(lat, lon, (answer[i][latIndex]), (answer[i][lonIndex]))<=radius){
				row++;
			}
		}
		String [][]sorted = new String[row+1][46];
		sorted[0][0] = "Time";
		sorted[0][1] = "ID";
		sorted[0][2] = "Lat";
		sorted[0][3] = "Lon";
		sorted[0][4] = "Alt";
		sorted[0][5] = "#WiFi networks";
		String helper1 = "SSID";
		String helper2 = "MAC";
		String helper3 = "Frequncy";
		String helper4 = "Signal";
		int hel = 1;

		for (int i = 6; i < sorted[0].length; i=i+4) {
			sorted[0][i] = helper1 + hel;
			hel++;
		}
		hel = 1;
		for (int i = 7; i < sorted[0].length; i=i+4) {
			sorted[0][i] = helper2 + hel;
			hel++;
		}
		hel = 1;
		for (int i = 8; i < sorted[0].length; i=i+4) {
			sorted[0][i] = helper3 + hel;
			hel++;
		}
		hel = 1;
		for (int i = 9; i < sorted[0].length; i=i+4) {
			sorted[0][i] = helper4 + hel;
			hel++;
		}

		int rowSort = 1;
		for (int i = 1; i < answer.length; i++) {
			if(Distance(lat, lon, (answer[i][latIndex]), (answer[i][lonIndex]))<=radius){
				for (int j2 = 0; j2 < answer[0].length; j2++) {
					sorted[rowSort][j2]=answer[i][j2];

				}
				rowSort++;
			}
		}
		//printanswer(sorted);
		//kmlFile.convertTokml(sorted);
		ConvertToKml.ToKml(sorted);
		//	return sorted;
	}


	/**
	 * This function gets String matrix and print it.
	 * @param answer
	 */
	public static void printanswer (String [][] answer){
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				System.out.print(answer[i][j]+" ");
			}System.out.println();

		}
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
	
	/**
	 * This function getting matrix of String type, and String name.
	 * The function search the String name on the matrix and return the index of this.
	 * @param answer
	 * @param name
	 * @return
	 */
	public static int PlaceArticle (String [][]answer, String name){
		for (int i = 0; i <11; i++) {
			if(answer[0][i].equals(name)){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * https://www.mkyong.com/java/java-date-and-calendar-examples/
	 * @param 
	 * @return
	 */
	public static Date fromStringToDate (String time)   {
		//System.out.println(time);
		time = time.replace("-", "/");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date=null;

		try {			
			date = sdf.parse(time);
			//System.out.println(date.toString());
			return date;
		} catch (ParseException e) {}
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			date = sdf2.parse(time);
			//System.out.println(date.toString());
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




