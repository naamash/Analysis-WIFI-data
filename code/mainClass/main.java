package mainClass;

import java.io.File;
import java.io.IOException;

import algo1and2.FindLocation;
import filtersPack.ChooseFilter;

/**
 * This class check and use the classes of all of packages.
 * the class contains main.
 * @author 
 *
 */
public class main {

	public static void main(String[] args) throws IOException {


		// Matala zero+one: {
		
		//ChooseFilter.Decide();  
		
		//PB2-690Y_S200032_161214
		//lon=35.21019984, lat=32.10379261
		//2017-12-03 08:55:30
		//2017-12-03 08:56:05
		
		// } end of Matala zero+one
		
		// Matala two: {
		
		String foldername1 = "boazFiles";
		File folder1 = new File(foldername1);
		
		String foldername2 = "matala two";
		File folder2=new File(foldername2);

		
		String locationAlgo1 = "C:\\Users\\hadar\\Desktop\\Answer exampels\\BM3matala2algo1__.csv";
		FindLocation.Matala2_Algo1 (folder1, locationAlgo1);


		String locationAlgo2 = "C:\\Users\\hadar\\Desktop\\Answer exampels\\BM3matala2algo2__.csv";
		FindLocation.Matala2_Algo2 (folder1,folder2,locationAlgo2);

	    // } end of Matala two

		
		
		//2017-10-29 11:00:08
		//2017-10-30 10:32:34
	}
}


