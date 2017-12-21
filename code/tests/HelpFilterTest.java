package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import filtersPack.HelpFilter;
import filtersPack.filters;
import objects.MacBig;
import objects.MacBig_Container;

public class HelpFilterTest {

	@Test
	public void testfromStringToDate(){
		String date1="Fri Nov 03 16:10:50 IST 2017";
		System.out.println(date1);
		assertEquals(date1, ""+HelpFilter.fromStringToDate("2017/11/03 16:10:50"));

	}
	@Test
	public void testswap(){
		MacBig temp=new MacBig("1c:b9:c4:12:7c:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U","46");
		MacBig original=new MacBig("1c:b9:c4:12:7c:c8","-68","2017/10/03 16:15:50","2262","35.21140758"
				,"32.10651925","Naama1","NRD900U","46");

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
				,"32.10551925","Naama","NRD90U","46");
		MacBig	s1 =	new MacBig("1c:b9:c4:12:7d:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U","46");
		a[0]=s;
		a[1]=s1;
		MacBig_Container m = new MacBig_Container(a,1);
		macs.add(m);
		String[] an = {"Time","ID","Lat","Lon","Alt","#WiFi networks","SSID1","MAC1","Frequncy1","Signal1","SSID2","MAC2","Frequncy2","Signal2"
			,"SSID3","MAC3","Frequncy3","Signal3","SSID4","MAC4","Frequncy4","Signal4","SSID5","MAC5","Frequncy5","Signal5","SSID6","MAC6"
			,"Frequncy6","Signal6","SSID7","MAC7","Frequncy7","Signal7","SSID8","MAC8","Frequncy8","Signal8","SSID9","MAC9","Frequncy9"
			,"Signal9","SSID10","MAC10","Frequncy10","Signal10"};
		String[] ab = {"2017/10/03 16:15:55","NRD90U","35.21240758","32.10651925","111.5999985","1",
				"Ariel_University","1c:b9:c4:12:7d:c8","2462","-46",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
				null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
		ArrayList<String[]> answer = new ArrayList<String[]>();
		answer.add(an);
		answer.add(ab);
		int row = 1;
		HelpFilter.SaveTheLargestSIGNAL(macs,answer,row);
		if (!((macs.get(0).arr_macbig[0].Signal).equals(answer.get(row)[9]))){
			fail("ERR - the polynoms should be the same (equals)");
		}
	}
	
	@Test
	public void testsortMACS (){
		MacBig	s =	new MacBig("1c:b9:c4:12:7d:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U","46");
		MacBig	s1 =	new MacBig("1c:b9:c4:12:7d:c8","-45","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U","46");
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
