package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import objects.MacBig;
import objects.MacBig_Container;
import writeTo.ReadAndWrite;

public class ReadAndWriteTest {

	@Test
	public void testWriteToCsv() throws IOException {
		MacBig as = new MacBig("Time","ID","Lat","Lon","Alt","#WiFi networks","SSID1","MAC1","Frequncy1","Signal1"); 
		MacBig bs = new MacBig("Time","ID","Lat","Lon","Alt","#WiFi networks","SSID2","MAC2","Frequncy2","Signal2");
		MacBig cs = new MacBig("Time","ID","Lat","Lon","Alt","#WiFi networks","SSID3","MAC3","Frequncy3","Signal3");
		MacBig ds = new MacBig("Time","ID","Lat","Lon","Alt","#WiFi networks","SSID4","MAC4","Frequncy4","Signal4");
		MacBig es = new MacBig("Time","ID","Lat","Lon","Alt","#WiFi networks","SSID5","MAC5","Frequncy5","Signal5");
		MacBig fs = new MacBig("Time","ID","Lat","Lon","Alt","#WiFi networks","SSID6","MAC6","Frequncy6","Signal6");
		MacBig gs = new MacBig("Time","ID","Lat","Lon","Alt","#WiFi networks","SSID7","MAC7","Frequncy7","Signal7");
		MacBig hs = new MacBig("Time","ID","Lat","Lon","Alt","#WiFi networks","SSID8","MAC8","Frequncy8","Signal8");
		MacBig is = new MacBig("Time","ID","Lat","Lon","Alt","#WiFi networks","SSID9","MAC9","Frequncy9","Signal9");
		MacBig js = new MacBig("Time","ID","Lat","Lon","Alt","#WiFi networks","SSID10","MAC10","Frequncy10","Signal10");
		MacBig[] arrM = {as,bs,cs,ds,es,fs,gs,hs,is,js};
		MacBig_Container an = new MacBig_Container(arrM,10);

		MacBig av = new MacBig("01/12/2017 10:42", "display=NRD90M.G950FXXU1AQJ5", "32.17224246", "34.81444894",
				"7.777438959", "1", "HOTBOX-D88A", "c0:ac:54:f5:b4:c9", "2412", "-92");
		MacBig[] arrN = {av};
		MacBig_Container ab = new MacBig_Container(arrN,1);
		ArrayList<MacBig_Container> answer = new ArrayList<MacBig_Container>();
		answer.add(an);
		answer.add(ab);

		String location = "C://Users//נעמה שטאובר//Desktop//testfunction//testWriteToCsv_Matala_zero.csv";
		ArrayList<MacBig_Container> Answer_One = new ArrayList<MacBig_Container>();

		Answer_One = writeTo.ReadAndWrite.WriteToCsv(answer, location);
		if ((Answer_One.get(1).arr_macbig[0].time.equals("01/12/2017 10:42"))
				&&(Answer_One.get(1).arr_macbig[1].ID.equals("display=NRD90M.G950FXXU1AQJ5"))
				&&(Answer_One.get(1).arr_macbig[2].lat.equals("32.17224246"))
				&&(Answer_One.get(1).arr_macbig[3].lon.equals("34.81444894"))
				&&(Answer_One.get(1).arr_macbig[4].alt.equals("7.777438959"))
				&&(Answer_One.get(1).arr_macbig[5].WIFI_Network.equals("1"))
				&&(Answer_One.get(1).arr_macbig[6].ssid.equals("HOTBOX-D88A"))
				&&(Answer_One.get(1).arr_macbig[7].Mac.equals("c0:ac:54:f5:b4:c9"))
				&&(Answer_One.get(1).arr_macbig[8].frequency.equals("2412"))
				&&(Answer_One.get(1).arr_macbig[9].Signal.equals("-92"))){	
			fail("Not yet implemented");
		}
	}
}