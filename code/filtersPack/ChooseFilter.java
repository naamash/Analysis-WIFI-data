package filtersPack;

 /**
 * This class allow to user to enter folder that the files there and choose according to what to sort - by time, ID or location. 
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import objects.MacBig_Container;
import writeTo.ConvertToKml;
import writeTo.ReadAndWrite;

public class ChooseFilter {
	
	/**
	 * This function ask the user to enter folder name and choose type of sorting(time,ID or location).
	 */
	public static void Decide() throws IOException{
		ArrayList<MacBig_Container> answer = new ArrayList<MacBig_Container>();
		String file = "\\Answer_Of_Matala_Zero678910.csv";
//		String file = "C:\\Users\\hadar\\Desktop\\Answer exampels\\Answer_Of_Matala_Zero678910.csv";

		//String file = "C:\\Users\\נעמה שטאובר\\Desktop\\Answer exampels\\Answer_Of_Matala_Zero678.csv";

		boolean flag1 = true;
		while(flag1){
			try {
				Scanner folderr = new Scanner((System.in));
				System.out.println("enter folder name");
				String foldername = folderr.nextLine();
				File folder = new File(foldername);
				answer = ReadAndWrite.readingFileWigle(folder);
				Scanner csv = new Scanner(System.in);
				System.out.println("please enter path for saving the CSV");
				String csvTO = csv.nextLine();
				ReadAndWrite.WriteToCsv(answer, csvTO+file);
				flag1 = false;
			} catch (Exception e) {
				System.err.println("This folder does'nt exist! try again.");
			}
		}
		Scanner csv = new Scanner(System.in);
		System.out.println("please enter path for saving the CSV");
		String csvFROM = csv.nextLine();
		answer = ReadAndWrite.readingFile46Col(csvFROM);
		boolean flag = true;
		while (flag){

			Scanner sc = new Scanner((System.in));
			System.out.println("enter: 1 to sortByTime , 2 to sortByLocation or 3 to sortById");
			int a = sc.nextInt();

			if (a == 1) {
				flag=time(answer, flag);
			}
			else if (a == 2) {
				flag=location(answer, flag);
			}
			else if (a == 3) {
				flag=id(answer, flag);			
			} 
		}
	}
	
	/**
	 * The function accepts String file and boolean flag. 
	 * The function ask user to enter time start and time end so that the function will sort according to this .
	 * @param file
	 * @param flag - after user enter the times, the function return flag = false in order to the function not ask the user again.  
	 * @return
	 */
	public static boolean time(ArrayList<MacBig_Container> answer, boolean flag){
		ArrayList<MacBig_Container> macs=new ArrayList<MacBig_Container>();
		Scanner timeSt = new Scanner((System.in));
		Scanner timeEn = new Scanner((System.in));
		System.out.println("enter begining in Format dd-MM-yyyy HH:mm:ss");
		String timestart = timeSt.nextLine();
		while(timestart.length()!=19)
		{
			timeSt = new Scanner((System.in));
			
			System.out.println("enter begining in Format dd-MM-yyyy HH:mm:ss");
			timestart = timeSt.nextLine();
		}
		System.out.println("enter end");
		String timeend = timeEn.nextLine();
		while(timeend.length()!=19)
		{
			timeEn = new Scanner((System.in));
			
			System.out.println("enter ending in Format dd-MM-yyyy HH:mm:ss");
			timeend = timeEn.nextLine();
		}
		try {
			Filter f = new filter_time(timestart, timeend);
			DoFilter fil = new DoFilter(f);
			answer.remove(0);
			answer = fil.filtering(answer);
			ConvertToKml.ToKml(answer);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * The function accepts String file and boolean flag. 
	 * The function ask user to enter lat, lon and radious so that the function will sort according to this .
	 * @param file
	 * @param flag - after user enter the lat, lon and radious, the function return flag = false in order to the function not ask the user again.  
	 */
	public static boolean location(ArrayList<MacBig_Container> answer, boolean flag){
		ArrayList<MacBig_Container> macs=new ArrayList<MacBig_Container>();
		Scanner location = new Scanner((System.in));
		System.out.println("enter lat");
		String locationstart = location.nextLine();
		System.out.println("enter lon");
		String locationend = location.nextLine();
		System.out.println("enter radious");
		double radious = location.nextDouble();
		try {
			Filter f = new filter_location(locationstart, locationend, radious);
			DoFilter fil = new DoFilter(f);
			answer.remove(0);
			answer = fil.filtering(answer);
			ConvertToKml.ToKml(answer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;				
	}
	
	/**
	 * The function accepts String file and boolean flag. 
	 * The function ask user to enter id so that the function will sort according to this .
	 * @param file
	 * @param flag - after user enter the id, the function return flag = false in order to the function not ask the user again.  
	 */
	public static boolean id(ArrayList<MacBig_Container> answer, boolean flag){
		ArrayList<MacBig_Container> macs=new ArrayList<MacBig_Container>();
		Scanner id = new Scanner((System.in));
		System.out.println("enter id");
		String idName = id.nextLine();
		
		try {
			Filter f = new filter_id("display=" + idName);
			DoFilter fil = new DoFilter(f);
			answer.remove(0);
			answer = fil.filtering(answer);
			
//			for (int i = 0; i < answer.size(); i++) {
//				System.out.println(Arrays.toString(answer.get(i).arr_macbig));
//			}
			
			ConvertToKml.ToKml(answer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;	
	}
}
