package pa;

import java.io.File;
import java.io.FileNotFoundException;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;

public class ConvertToKml {

	
	/**
	 * https://stackoverflow.com/questions/12701364/how-to-mark-multiple-coordinates-in-kml-using-java
	 * @param 
	 */
	public static void ToKml(String [][]answer){	
		final Kml kml = new Kml();
		Document document = kml.createAndSetDocument();

		int network =Place(answer,"#WiFi networks");
		int name = Place(answer,"ID");
		int time = Place(answer,"Time");
		int lon = Place(answer,"Lon");
		int lat = Place(answer,"Lat");

		for(int row=1 ; row<answer.length;row++){
			TimeStamp t = new TimeStamp();
			t.setWhen(CheckTime(answer[row][time]));

			for (int i = 1; i <=Integer.parseInt(answer[row][network]); i++) {	
				int mac = Place(answer,"MAC"+i);
				int signal =  Place(answer,"Signal"+i);
				int ssid =  Place(answer,"SSID"+i);
				int frequency = Place(answer,"Frequncy"+i);

				document.createAndAddPlacemark().withName(answer[row][name]).withOpen(Boolean.TRUE)
				.withDescription(" Mac: "+answer[row][mac]+" Signal: "+answer[row][signal]+" SSID: "+answer[row][ssid]+" Frequency: "+answer[row][frequency])
				.withTimePrimitive(t).createAndSetPoint().
				addToCoordinates(Double.parseDouble(answer[row][lon]), Double.parseDouble(answer[row][lat]));
			}
		}
		try {
			kml.marshal(new File("C:\\Users\\hadar\\Desktop\\Answer_Of_Matala_Zero.kml"));
			System.out.println("completed");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int Place (String [][]answer, String name){
		for (int i = 0; i <46; i++) {
			if(answer[0][i].equals(name)){
				return i;
			}
		}
		return -1;
	}

	public static String CheckTime(String date){
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