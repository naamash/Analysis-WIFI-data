package pa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;
/**
 * The function accept ArrayList<MacBig> macs and convert to kml file with all the Values
 * @author 
 *
 */
public class ConvertToKml {

	public static void ToKml(ArrayList<MacBig_Container> macs){	
		final Kml kml = new Kml();
		Document document = kml.createAndSetDocument();

		for (int i = 0; i < macs.size(); i++) {
			TimeStamp t = new TimeStamp();
			t.setWhen(ConvertTimeToKmlFormat(macs.get(i).arr_macbig[0].time));

			document.createAndAddPlacemark().withName(macs.get(i).arr_macbig[0].ID).withOpen(Boolean.TRUE)
			.withDescription(" Mac: "+macs.get(i).arr_macbig[0].Mac+" Signal: "+macs.get(i).arr_macbig[0].Signal+
			" SSID: "+macs.get(i).arr_macbig[0].ssid+ " Frequency: "+macs.get(i).arr_macbig[0].frequency).withTimePrimitive(t).
			createAndSetPoint().addToCoordinates(Double.parseDouble(macs.get(i).arr_macbig[0].lon),
			Double.parseDouble(macs.get(i).arr_macbig[0].lat));
		}

		try {
			kml.marshal(new File("C:\\Users\\hadar\\Desktop\\Answer_Of_Matala_Zero.kml"));
			System.out.println("completed");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The function accept String date and convert this to format of kml
	 * @param date
	 * @return - the function return String of the new format of time acording to the kml
	 */
	public static String ConvertTimeToKmlFormat(String date){
		date= date.replace('-', '/');
		String[] finalTime=date.split(" ");
		String timeSt= "";
		String[] finalDate=finalTime[0].split("/");
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