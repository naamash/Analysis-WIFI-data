package tests;

import static org.junit.Assert.*;
import writeTo.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import objects.LineOfInfo;
import objects.MacBig;
import objects.MacBig_Container;

public class HelpersBeforeWriteTest {

	//	@Test
	//	public void testReadingFile() {
	//		fail("Not yet implemented");
	//	}

	@Test
	public void testMadeLine() {
		String[] line = {"Time","ID","Lat","Lon","Alt","#WiFi networks","SSID1","MAC1","Frequncy1","Signal1","SSID2","MAC2","Frequncy2","Signal2"
				,"SSID3","MAC3","Frequncy3","Signal3","SSID4","MAC4","Frequncy4","Signal4","SSID5","MAC5","Frequncy5","Signal5","SSID6","MAC6"
				,"Frequncy6","Signal6","SSID7","MAC7","Frequncy7","Signal7","SSID8","MAC8","Frequncy8","Signal8","SSID9","MAC9","Frequncy9"
				,"Signal9","SSID10","MAC10","Frequncy10","Signal10"};
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
		assertEquals(an.toString(), HelpersBeforeWrite.MadeLine().toString());
	}

	@Test
	public void testFrom_Channel_To_Frequency() {
		String channel="55";
		assertEquals("5275", HelpersBeforeWrite.From_Channel_To_Frequency(channel));
	}

	@Test
	public void testCopyingToAnswerFirst() {
		String[] s = {"hello","my","name","is","naama","and","i","love","choclate"};
		ArrayList<String[]> information=new ArrayList<String[]>();
		information.add(s);
		MacBig line = new MacBig("is","and","i","love","choclate","1",null,null,null,null);
		assertEquals(line.toString(), HelpersBeforeWrite.CopyingToAnswerFirst(information, 0, 1)[0].toString());
	}

	@Test
	public void testCopyingToAnswer() {
		String[] a = {"d8:fb:5e:17:62:f5", "HOTBOX-62EF", "[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS][BLE]"
				, "2017-12-01 10:45:37", "1", "-80", "32.170257763614224", "34.81246926564551", "26.042709343281796", 
				"3", "WIFI"};

		ArrayList<String[]> information = new ArrayList<String[]>();
		information.add(a);
		ArrayList<LineOfInfo> arrLineOfInfo = new ArrayList<LineOfInfo>();
		LineOfInfo k = new LineOfInfo("WIFI", "3",
				 "26.279075491882708", "34.8123593768823", "32.1700244717399","-92","11", "2017-12-01 10:45:33"
				, "[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS][BLE]", "landau", "d4:7b:b0:79:65:fc");
		arrLineOfInfo.add(k);
		int indexOfRow=0;
		int realsize=1;
		int sarr=1;
		ArrayList<MacBig_Container> answer = new ArrayList<MacBig_Container>();
		HelpersBeforeWrite.CopyingToAnswer(information, arrLineOfInfo, answer, indexOfRow, realsize, sarr);

		if (!((answer.get(0).arr_macbig[0].time.equals(information.get(0)[3]))
		&&(answer.get(0).arr_macbig[0].ID.equals(information.get(0)[5]))
		&&(answer.get(0).arr_macbig[0].lat.equals(information.get(0)[6]))
		&&(answer.get(0).arr_macbig[0].lon.equals(information.get(0)[7]))
		&&(answer.get(0).arr_macbig[0].alt.equals(information.get(0)[8])))){
			fail("ERR - the polynoms should be the same (equals)");
		}
	}

}
