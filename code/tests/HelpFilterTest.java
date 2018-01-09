package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.crypto.Mac;

import org.junit.Test;

import filtersPack.HelpFilter;
import objects.MacBig;
import objects.MacBig_Container;

public class HelpFilterTest {

	@Test
	public void testfromStringToDate(){
		String date1="Fri Nov 03 16:10:50 IST 2017";
		assertEquals(date1, ""+HelpFilter.fromStringToDate("2017/11/03 16:10:50"));
	}
	
	@Test
	public void testswap(){
		MacBig temp=new MacBig("1c:b9:c4:12:7c:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U","46","7.777438959");
		MacBig original=new MacBig("1c:b9:c4:12:7c:c8","-68","2017/10/03 16:15:50","2262","35.21140758"
				,"32.10651925","Naama1","NRD900U","46","7.777438959");

		HelpFilter.swap(temp,original);
		if(!(original.Signal.equals(temp.Signal))&&(original.Mac.equals(temp.Mac))
				&&(original.frequency.equals(temp.frequency))&&(original.ssid.equals(temp.ssid))
				&&(original.ID.equals(temp.ID))&&(original.lat.equals(temp.lat))
				&&(original.lon.equals(temp.lon))&&(original.time.equals(temp.time))) {
			fail("ERR - the polynoms should be the same (equals)");
		}
	}

	@Test
	public void testSaveTheLargestSSID (){
		ArrayList<MacBig_Container> macs = new ArrayList<MacBig_Container>();
		MacBig[] a = new MacBig[2];
		MacBig	s =	new MacBig("1c:b9:c4:12:7d:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U","46","7.777438959");
		MacBig	s1 =	new MacBig("1c:b9:c4:12:7d:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U","46","7.777438959");
		a[0]=s;
		a[1]=s1;
		MacBig_Container m = new MacBig_Container(a,1);
		macs.add(m);
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

		MacBig av = new MacBig("2017/10/03 16:15:55","NRD90U","35.21240758","32.10651925","111.5999985","1",
				"Ariel_University","1c:b9:c4:12:7d:c8","2462","-46");
		MacBig[] arrN = {av};
		MacBig_Container ab = new MacBig_Container(arrN,1);
		ArrayList<MacBig_Container> answer = new ArrayList<MacBig_Container>();
		answer.add(an);
		answer.add(ab);
		int row = 1;
		HelpFilter.SaveTheLargestSIGNAL(macs,answer,row);
		if (!((macs.get(0).arr_macbig[0].Signal).equals(answer.get(row).arr_macbig[0].Signal))){
			fail("ERR - the polynoms should be the same (equals)");
		}
	}
	
	@Test
	public void testsortMACS (){
		MacBig	s =	new MacBig("2017/11/03 16:10:50","NRD90U","32.10551925","35.21240758","7.777438959"
				,"Naama","2462","1c:b9:c4:12:7d:c8","46","-46");
		MacBig	s1 = new MacBig("2017/11/03 16:10:50","NRD90U","32.10551925","35.21240758","7.777438959"
				,"Naama","2462","1c:b9:c4:12:7d:c8","46","-45");
		MacBig[] a = new MacBig[2];
		a[0]=s;
		a[1]=s1;
		
		MacBig_Container p = new MacBig_Container(a,2);
		HelpFilter.sortMACS(p);
		if (!(Integer.parseInt(p.arr_macbig[0].Signal)<Integer.parseInt(p.arr_macbig[1].Signal))){
			fail("ERR - the polynoms should be the same (equals)");
		}
	}
	
	@Test
	public void testDistance(){
		String lat = "35.21240758";
		String lon = "32.10651925";
		String lat1 = "31.21240345";
		String lon1 = "30.10652525";
		double distance = Math.sqrt(((Double.parseDouble(lat)-Double.parseDouble(lat1))*(Double.parseDouble(lat)-Double.parseDouble(lat1)) +
				((Double.parseDouble(lon)-Double.parseDouble(lon1))*(Double.parseDouble(lon)-Double.parseDouble(lon1)))));
		assertEquals(""+distance,""+HelpFilter.Distance(lat, lon, lat1, lon1));
	}
}
