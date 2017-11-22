package pa;

import java.io.IOException;

/**
 * This class check and use the classes on this package.
 * the class contains main.
 * @author 
 *
 */
public class Check {

	/**
	 * The main accord the user the options to choose if he want to sort and convert the file to KML by time, ID or location.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//				2017/10/27 16:34:00
		//				2017/11/03 17:25:26
		//		
		
		HelpTime.fromStringToDate("2017-11-03 16:10:50");
		//ConvertToKml.ConvertTimeToKmlFormat("2017/11/03 16:10:50");
		//ChooseFilter.Decide();
		
		
	}
}


