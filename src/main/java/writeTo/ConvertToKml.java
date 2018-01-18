package writeTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;
import objects.MacBig_Container;
/**
 * The function accept ArrayList<MacBig_Container> macs and convert to kml file with all the Values
 * @author 
 *
 */
public class ConvertToKml {

	public static Document ToKml(ArrayList<MacBig_Container> macs,String path){	
		final Kml kml = new Kml();
		Document document = kml.createAndSetDocument();

		for (int i = 1; i < macs.size(); i++) {
			TimeStamp t = new TimeStamp();
			t.setWhen(ConvertTimeToKmlFormat(macs.get(i).arr_macbig[0].time));

			document.createAndAddPlacemark().withName(macs.get(i).arr_macbig[0].ID).withOpen(Boolean.TRUE)
			.withDescription(" Mac: "+macs.get(i).arr_macbig[0].Mac+" Signal: "+macs.get(i).arr_macbig[0].Signal+
			" SSID: "+macs.get(i).arr_macbig[0].ssid+ " Frequency: "+macs.get(i).arr_macbig[0].frequency).withTimePrimitive(t).
			createAndSetPoint().addToCoordinates(Double.parseDouble(macs.get(i).arr_macbig[0].lon),
			Double.parseDouble(macs.get(i).arr_macbig[0].lat));
		}

		try {
//			Scanner kmlfile = new Scanner(System.in);
//			System.out.println("please enter path for saving the CSV");
//			String kmlTO = kmlfile.nextLine();
			kml.marshal(new File(path));
			//kml.marshal(new File("C:\\Users\\נעמה שטאובר\\Desktop\\Answer exampels\\Matala_Zero_test.kml"));

			System.out.println("completed Kml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return document;
	}

	/**
	 * The function accept String date and convert this to format of kml
	 * @param date
	 * @return  String of the new format of time according to the kml
	 */
	public static String ConvertTimeToKmlFormat(String date){
		date= date.replace('-', '/');
		System.out.println("date  "+date);
		String[] finalTime=date.split(" ");
		String timeSt= "";
		String[] finalDate=finalTime[0].split("/");
		for (int i = 0; i < finalDate.length; i++) {
			System.out.print(finalDate[i]+" ");
		}
		if(finalDate[0].length()==4){
			timeSt+= finalDate[0]+"-"+finalDate[1]+"-"+finalDate[2]+"T"+finalTime[1];
			return timeSt;
		}
		else{
			timeSt+= finalDate[2]+"-"+finalDate[1]+"-"+finalDate[0]+"T"+finalTime[1];
			return timeSt;
		}
	}
}