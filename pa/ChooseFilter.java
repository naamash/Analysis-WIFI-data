package pa;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ChooseFilter {
	public static void Decide() throws IOException{
		boolean flag1 = true;
		while(flag1){
			try {
				Scanner folderr = new Scanner((System.in));
				System.out.println("enter folder name");
				String foldername = folderr.nextLine();
				File folder = new File(foldername);
				ReadAndSave.readingFile(folder);
				flag1 = false;
			} catch (Exception e) {
				System.err.println("This folder does'nt exist! try again.");
			}
		}
		File file = new File("C:\\Users\\hadar\\Desktop\\Answer_Of_Matala_Zero.csv");
		boolean flag = true;
		while (flag){

			Scanner sc = new Scanner((System.in));
			System.out.println("enter: 1 to sortByTime , 2 to sortByLocation or 3 to sortById");
			int a = sc.nextInt();

			if (a == 1) {
				flag=time(file, flag);
			}
			else if (a == 2) {
				flag=location(file, flag);
			}
			else if (a == 3) {
				flag=id(file, flag);			
			} 
		}
	}

	public static boolean time(File file, boolean flag){
		Scanner timeSt = new Scanner((System.in));
		Scanner timeEn = new Scanner((System.in));
		System.out.println("enter begining");
		String timestart = timeSt.nextLine();
		System.out.println("enter end");
		String timeend = timeEn.nextLine();
		try {
			filters.FilterByTime(file, timestart, timeend);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean location(File file, boolean flag) throws IOException{
		Scanner location = new Scanner((System.in));
		System.out.println("enter lat");
		String locationstart = location.nextLine();
		System.out.println("enter lon");
		String locationend = location.nextLine();
		System.out.println("enter radious");
		double radious = location.nextDouble();
		filters.FilterByLocation(file, locationstart, locationend, radious);
		return false;				
	}

	public static boolean id(File file, boolean flag) throws IOException{
		Scanner id = new Scanner((System.in));
		System.out.println("enter id");
		String idName = id.nextLine();
		filters.FilterByID(file, "display=" + idName);
		return false;	
	}


}
