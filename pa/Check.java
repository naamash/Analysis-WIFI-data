package pa;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * This class check and use the classes on this package.
 * the class contains main.
 * @author 
 *
 */
public class Check {

	public static void main(String[] args) throws IOException {

		//				2017/10/27 16:34:00
		//				2017/11/03 17:25:26
		//		
		//Copying.From_Channel_To_Frequency("55");
		//	ConvertToKml.ConvertTimeToKmlFormat("03/11/2017 16:34:00");
		ChooseFilter.Decide();
//		String foldername1 = "boaz";
//		File folder1 = new File(foldername1);
//		//String foldername2 = "matala two";
//		//		File folder2 = new File(foldername2);
//		ReadAndSave.readingFile(folder1);


		String foldername2 = "matala two";
		File folder2 = new File(foldername2);
		FindLocation.readingFileOfTwo(folder2);
		//Collections.sort(list,Location.loc);
	}
}


