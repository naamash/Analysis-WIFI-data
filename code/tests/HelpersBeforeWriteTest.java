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
		assertTrue(Arrays.equals(line,HelpersBeforeWrite.MadeLine()));
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
		ArrayList<String[]> answer=new ArrayList<String[]>();
		String[] line = {"is","and","i","love","choclate","7",null,null,null,null,null,null,null,null,null,null
				,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null
				,null,null,null,null,null,null,null,null,null,null,null};
		assertEquals(line, HelpersBeforeWrite.CopyingToAnswerFirst(information, answer, 0, 7));
	}

	@Test
	public void testCopyingToAnswer() {
		LineOfInfo a = new LineOfInfo("WIFI","6","699.287760530489",
				"35.2072639902064","32.1025333033369","-83","6","03/12/2017  08:37:10",
				"[WPA2-PSK-CCMP][ESS]","Moria","d8:fe:e3:03:5a:31");
		ArrayList<LineOfInfo> arrLineOfInfo = new ArrayList<LineOfInfo>();
		arrLineOfInfo.add(a);
		String[] infoofLine = {"is","and","i","love","choclate","1",null,null,null,null,null,null,null,null,null,null
				,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null
				,null,null,null,null,null,null,null,null,null,null,null};
		ArrayList<String[]> answer = new ArrayList<String[]>();
		answer.add(infoofLine);
		int indexOfRow=0;
		int realsize=1;
		int sarr=1;
		HelpersBeforeWrite.CopyingToAnswer(arrLineOfInfo, answer, indexOfRow, realsize, sarr, infoofLine);

		if (!answer.get(0)[5].equals("1")){
			fail("ERR - the polynoms should be the same (equals)");
		}
	}

	@Test
	public void testSave_info() {
		String fre = "2412";
		String [] s1 = {"12","23","34","45","56","67","78","78","89","90"};
		String[] s = {"MAC","SSID","AuthMode","FirstSeen","Channel","RSSI","CurrentLatitude","AltitudeMeters","AccuracyMeters","Type"};
		ArrayList<String[]> information=new ArrayList<String[]>();
		information.add(s1);
		information.add(s);
		String[] infoofLine = {"is","and","i","love","choclate","7",null,null,"1",null,null,null,null,null,null,null
				,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null
				,null,null,null,null,null,null,null,null,null,null,null};
		ArrayList<String[]> answer = new ArrayList<String[]>();
		answer.add(infoofLine);
		ArrayList<LineOfInfo> arrLineOfInfo = new ArrayList<LineOfInfo>();
		LineOfInfo a = new LineOfInfo("WIFI","2","699.287760530489",
				"35.2072639902064","32.1025333033369","-83","1","03/12/2017  08:37:10",
				"1","Moria","d8:fe:e3:03:5a:31");
		arrLineOfInfo.add(a);
		HelpersBeforeWrite.CopyingToAnswer(arrLineOfInfo,answer,0,1,1,infoofLine);
		if(!answer.get(0)[8].equals(fre)){
			fail("ERR - the polynoms should be the same (equals)");
		}
	}
	
	@Test
	public void testFixingBeforeCsv() {
		MacBig[] a = new MacBig[1];
		MacBig	s =	new MacBig("1c:b9:c4:12:7d:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U","46");
		a[0]=s;
		int realsize = 1;
		MacBig[] a1 = new MacBig[1];
		MacBig	s1 = new MacBig("1c:b9:c4:12:7d:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","ABC","NRD90U","46");
		MacBig_Container m = new MacBig_Container(a,1);
		MacBig_Container m1 = new MacBig_Container(a1,1);

		ArrayList<MacBig_Container> macs = new ArrayList<MacBig_Container>();
		macs.add(m);
		macs.add(m1);
		MacBig []fixed = new MacBig[macs.size()];
		MacBig[] same = HelpersBeforeWrite.FixingBeforeCsv(macs);
//		double lat = 0.015172740666351608;
//		double lon = 0.016641024376181472;
//		double alt = 0.021739130434782608;
//		double signal = 4.725897920604915E-4;
		
		MacBig[] ans = new MacBig[1];
		MacBig ma = new MacBig("1c:b9:c4:12:7d:c8", "4.725897920604915E-4","2017/11/03 16:10:50", "2462", "0.016641024376181472", "0.015172740666351608",
				"ABC", "NRD90U", "0.021739130434782608");
		ans[0] = ma;
		assertArrayEquals(ans, same);
		
	}
	

}
