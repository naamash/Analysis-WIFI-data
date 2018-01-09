package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import algo1and2.FindLocation;
import objects.Location;
import objects.MacBig;
import objects.MacBig_Container;

public class FindLocationTest {


	@Test
	public void testCheckMac() throws IOException {
		int IndexLatInfo=2;
		int IndexLonInfo=3;
		int IndexAltInfo=4;
		ArrayList<Location> ArrLocation = new ArrayList<Location>();
		ArrayList<String[]> ArrAnswerLine = new ArrayList<String[]>();
		ArrayList<MacBig_Container> answer = new ArrayList<MacBig_Container>();
		MacBig_Container ab = new MacBig_Container();
		MacBig []a = new MacBig[2];
		MacBig b = new MacBig("Time", "ID", "Lat", "Lon", "Alt", "#WiFi networks", "SSID1", "MAC1", 
				"Frequncy1", "Signal1");
		MacBig c = new MacBig("01/12/2017 10:42", "display=NRD90M.G950FXXU1AQJ5", "32.17224246", "34.81444894",
				"34.81444894", "32.17224246", "HOTBOX-D88A", "c0:ac:54:f5:b4:c9", "7.777438959", "-92");
		//a[0] = b;
		a[0] = c;

		//		a[1].time = "01/12/2017 10:42";
		//		a[1].ID = "display=NRD90M.G950FXXU1AQJ5";
		//		a[1].lat = "32.17224246";
		//		a[1].lon = "34.81444894";
		//		a[1].alt = "7.777438959";
		//		a[1].WIFI_Network = "1";
		//		a[1].ssid = "HOTBOX-D88A";
		//		a[1].Mac = "c0:ac:54:f5:b4:c9";
		//		a[1].frequency = "2412";
		//		a[1].Signal = "-92";

		//		String []a = {"Time", "ID", "Lat", "Lon", "Alt", "#WiFi networks", "SSID1", "MAC1", 
		//				"Frequncy1", "Signal1", "SSID2", "MAC2", "Frequncy2", "Signal2", "SSID3",
		//				"MAC3", "Frequncy3", "Signal3", "SSID4", "MAC4", "Frequncy4", "Signal4",
		//				"SSID5", "MAC5", "Frequncy5", "Signal5", "SSID6", "MAC6","Frequncy6",
		//				"Signal6", "SSID7", "MAC7", "Frequncy7", "Signal7", "SSID8", "MAC8", "Frequncy8",
		//				"Signal8", "SSID9", "MAC9", "Frequncy9", "Signal9", "SSID10", "MAC10", "Frequncy10",
		//		"Signal10"};
		//		String b[]={"01/12/2017 10:42", "display=NRD90M.G950FXXU1AQJ5", "32.17224246", "34.81444894",
		//				"7.777438959", "1", "HOTBOX-D88A", "c0:ac:54:f5:b4:c9", "2412", "-92", "null", "null",
		//				"null", "null", "null", "null", "null", "null", "null", "null","null", "null", "null", "null",
		//				"null", "null", "null", "null", "null", "null","null", "null", "null", "null", "null", "null",
		//				"null", "null", "null", "null","null", "null", "null", "null","null", "null"};
		ab = new MacBig_Container(a,1);;
		answer.add(ab);
		//answer.add(a);

		//String [][]MacAndSigInfo2 = {{"c0:ac:54:f5:b4:c9"},{"-92"}};
		//boolean []isTuched = new boolean[answer.size()];
		//		ArrAnswerLine =algo1and2.FindLocation.SearchMacInAnswer(MacAndSigInfo2,ArrLocation,answer,ArrAnswerLine,isTuched);
		//		algo1and2.FindLocation.CreateArrLocation(ArrLocation, ArrAnswerLine, MacAndSigInfo2);
		//	Location W_sum = algo1and2.FindLocation.WSUM(ArrLocation);
		ArrayList<MacBig_Container> information2 = new ArrayList<MacBig_Container>();
		//String locationAlgo2 = "C://Users//נעמה שטאובר//Desktop//testfunction//Matala_two_algo2_test.csv";
		File folder2 = new File ("C://Users//נעמה שטאובר//Desktop//fileLess");

		information2 = algo1and2.FindLocation.readingFolderOfTwo_(folder2);

		if ((information2.get(0).arr_macbig[0].lat.equals("32.17224246")&&
				information2.get(0).arr_macbig[0].lon.equals("34.81444894")&&
				information2.get(0).arr_macbig[0].alt.equals("7.777438959"))){
			fail("Not yet implemented");
		}
	}


	@Test
	public void testWSUM() throws IOException {
		ArrayList<Location> ArrLocation = new ArrayList<Location>();
		ArrayList<MacBig_Container> ArrAnswerLine = new ArrayList<MacBig_Container>();
		ArrayList<MacBig_Container> answer = new ArrayList<MacBig_Container>();
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

		answer.add(ab);
		answer.add(an);

		String [][]MacAndSigInfo2 = {{"c0:ac:54:f5:b4:c9"},{"-92"}};
		boolean []isTuched = new boolean[answer.size()];
		ArrAnswerLine =algo1and2.FindLocation.SearchMacInAnswer
				(MacAndSigInfo2,ArrLocation,answer,ArrAnswerLine,isTuched);
		algo1and2.FindLocation.CreateArrLocation(ArrLocation, ArrAnswerLine, MacAndSigInfo2);
		Location W_sum = algo1and2.FindLocation.WSUM(ArrLocation);

		if ((W_sum.Alt.equals("7.777438959")&&W_sum.Lat.equals("32.17224246")
				&&W_sum.Lon.equals("34.81444894"))){
			fail("Not yet implemented");
		}
	}


	@Test
	public void testReadingFileOfTwo_() throws IOException {
		File folder = new File ("C://Users//נעמה שטאובר//Desktop//testfunction//testWriteToCsv_Matala2_parta.csv");
		ArrayList<MacBig_Container> information2 = new ArrayList<MacBig_Container>();
		try {
			information2 = algo1and2.FindLocation.readingFileOfTwo_(folder);
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}


	@Test
	public void testSearchMacInAnswer() throws IOException {
		ArrayList<Location> ArrLocation = new ArrayList<Location>();
		ArrayList<MacBig_Container> ArrAnswerLine = new ArrayList<MacBig_Container>();

		ArrayList<MacBig_Container> answer = new ArrayList<MacBig_Container>();
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

		answer.add(ab);
		answer.add(an);

		String [][]MacAndSigInfo2 = {{"c0:ac:54:f5:b4:c9"},{"-92"}};
		boolean []isTuched = new boolean[answer.size()];
		ArrAnswerLine =algo1and2.FindLocation.SearchMacInAnswer(MacAndSigInfo2,ArrLocation,answer,ArrAnswerLine,isTuched);

		algo1and2.FindLocation.CreateArrLocation(ArrLocation, ArrAnswerLine, MacAndSigInfo2);
		for (int i = 0; i < ArrAnswerLine.size(); i++) {
			if (!(ArrAnswerLine.get(0).arr_macbig[i] == (answer.get(1).arr_macbig[i]))){
				fail("Not yet implemented");
			}
		}
	}


	@Test
	public void testCreateArrLocation() throws IOException {
		ArrayList<Location> ArrLocation = new ArrayList<Location>();
		ArrayList<MacBig_Container> ArrAnswerLine = new ArrayList<MacBig_Container>();

		ArrayList<MacBig_Container> answer = new ArrayList<MacBig_Container>();
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
		answer.add(an);
		answer.add(ab);




		String [][]MacAndSigInfo2 = {{"c0:ac:54:f5:b4:c9"},{"-92"}};

		boolean []isTuched = new boolean[answer.size()];
		ArrAnswerLine =algo1and2.FindLocation.SearchMacInAnswer(MacAndSigInfo2,ArrLocation,answer,ArrAnswerLine,isTuched);
		algo1and2.FindLocation.CreateArrLocation(ArrLocation, ArrAnswerLine, MacAndSigInfo2);
		if (!(ArrLocation.get(0).Alt.equals("7.777438959")&&
				ArrLocation.get(0).Lat.equals("32.17224246")&&
				ArrLocation.get(0).Lon.equals("34.81444894"))){
			fail("Not yet implemented");
		}
	}

	@Test
	public void testWriteToCsv_Matala2_parta() throws IOException {
		int IndexIndex = 0;
		int MacIndex = 1;
		int SsidIndex = 2;
		int FreqIndex = 3;
		int SignalIndex = 4;
		int LonIndex = 5;
		int LatIndex = 6;
		int AltIndex = 7;
		int TimeIndex = 8;
		MacBig[] MacsAfterFormulas = new MacBig[1];
		MacBig av = new MacBig("01/12/2017 10:42", "display=NRD90M.G950FXXU1AQJ5", "32.17224246", "34.81444894",
				"7.777438959", "1", "HOTBOX-D88A", "c0:ac:54:f5:b4:c9", "2412", "-92");
		MacsAfterFormulas[0]=av;
		String locationAlgo1 = "C://Users//נעמה שטאובר//Desktop//testfunction//testWriteToCsv_Matala2_parta.csv";
		String [][]Answer_One = new String [1][9];

		Answer_One = algo1and2.FindLocation.WriteToCsv_Matala2_parta(MacsAfterFormulas, locationAlgo1);
		if (!(Answer_One[0][MacIndex].equals("c0:ac:54:f5:b4:c9")&&Answer_One[0][SignalIndex].equals("-92")&&
				Answer_One[0][TimeIndex].equals("01/12/2017 10:42")&&Answer_One[0][FreqIndex].equals("2412")&&
				Answer_One[0][LonIndex].equals("32.17224246")&&Answer_One[0][LatIndex].equals("34.81444894")&&
				Answer_One[0][SsidIndex].equals("HOTBOX-D88A")&&Answer_One[0][IndexIndex].equals("0")&&
				Answer_One[0][AltIndex].equals("7.777438959"))){

			fail("Not yet implemented");
		}
	}

}