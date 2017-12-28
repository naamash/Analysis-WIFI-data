package filtersPack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
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

	public static void FilterByTime(String file1, String start, String end) throws Exception{
		//System.out.println(HelpFilter.fromStringToDate(start));
		Date StartDate = HelpFilter.fromStringToDate(start);
		//System.out.println(StartDate);
		Date EndDate =  HelpFilter.fromStringToDate(end);
		ArrayList<MacBig_Container> macs=new ArrayList<MacBig_Container>();
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
				HelpFilter.FromAnsToAnswer(ans, answer, 0, 46,10);
				flag=1;
			}
			else{
				HelpFilter.FromAnsToAnswer(ans, answer, 0, ((Integer.parseInt(ans.get(0)[5]))*4+6),Integer.parseInt(ans.get(0)[5]));
			}
		}
		sc.close();
		fi.close();
		Date dateLine = null;
		for (int i = 1; i < answer.size(); i++) {
			if (check(answer.get(i).arr_macbig[0].time)){
				//			dateLine = (Date) (HelpFilter.fromStringToDate(answer.get(i).arr_macbig[0].time));

				//			if (dateLine.after(StartDate)&&dateLine.before(EndDate)){
				//				macs = HelpFilter.SaveTheLargestSIGNAL(macs, answer, i);
				//			}
			}
			//		MacBig[] MacsAfterFormulas = new MacBig[macs.size()];
			//		MacsAfterFormulas = HelpersBeforeWrite.FixingBeforeCsv(macs);
			ConvertToKml.ToKml(macs);
		}

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
					HelpFilter.FromAnsToAnswer(ans, answer, 0, 46,10);
					flag=1;
				}
				else{
					HelpFilter.FromAnsToAnswer(ans, answer, 0, ((Integer.parseInt(ans.get(0)[5]))*4+6),Integer.parseInt(ans.get(0)[5]));
				}
			}
			sc.close();
			fi.close();

			Filter f = new filter_id(ID);
			DoFilter fil = new DoFilter(f);
			for (int j = 0; j < answer.size(); j++) {
				if (f.check(answer.get(j))){
					macs.add(answer.get(j));
				}
			}

			//		HelpFilter.SaveTheLargestSIGNAL(macs, answer, i);
			//		int IDIndex=FindIndex.PlaceArticleAnswerID(answer, "ID",0);
			//		for (int i = 1; i < answer.size(); i++) {
			//			if(((answer.get(i).arr_macbig[IDIndex].ID).equals(ID))){
			//			}
			//		}
			//		MacBig[] MacsAfterFormulas = new MacBig[macs.size()];
			//		MacsAfterFormulas = HelpersBeforeWrite.FixingBeforeCsv(macs);
			ConvertToKml.ToKml(macs);
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
		public static void FilterByLocation(String file1, String lat, String lon, double radius) throws IOException{
			ArrayList<MacBig_Container> macs=new ArrayList<MacBig_Container>();
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
					HelpFilter.FromAnsToAnswer(ans, answer, 0, 46,10);
					flag=1;
				}
				else{
					HelpFilter.FromAnsToAnswer(ans, answer, 0, ((Integer.parseInt(ans.get(0)[5]))*4+6),Integer.parseInt(ans.get(0)[5]));
				}
			}
			sc.close();
			fi.close();
			int latIndex = FindIndex.PlaceArticleAnswerLat(answer, "Lat", 0);
			int lonIndex = FindIndex.PlaceArticleAnswerlon(answer, "Lon",0);
			for (int i = 1; i < answer.size(); i++) {
				if(HelpFilter.Distance(lat, lon, (answer.get(i).arr_macbig[latIndex].lat),
						(answer.get(i).arr_macbig[lonIndex].lon))<=radius){
					macs = HelpFilter.SaveTheLargestSIGNAL(macs, answer, i);
				}
			}
			MacBig[] MacsAfterFormulas = new MacBig[macs.size()];
			MacsAfterFormulas = HelpersBeforeWrite.FixingBeforeCsv(macs);
			ConvertToKml.ToKml(macs);
		}
	}




