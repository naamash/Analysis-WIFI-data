package pa;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class HelpTimeTest {

	@Test
	public void testfromStringToDate(){
		String date1="Fri Nov 03 16:10:50 IST 2017";
		System.out.println(date1);
		assertEquals(date1, ""+HelpTime.fromStringToDate("2017/11/03 16:10:50"));

	}
	@Test
	public void testswap(){
		MacBig temp=new MacBig("1c:b9:c4:12:7c:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U");
		MacBig original=new MacBig("1c:b9:c4:12:7c:c8","-68","2017/10/03 16:15:50","2262","35.21140758"
				,"32.10651925","Naama1","NRD900U");

		HelpTime.swap(temp,original);
		if(!(original.Signal.equals(temp.Signal))&&(original.Mac.equals(temp.Mac))
				&&(original.frequency.equals(temp.frequency))&&(original.ssid.equals(temp.ssid))
				&&(original.ID.equals(temp.ID))&&(original.lat.equals(temp.lat))
				&&(original.lon.equals(temp.lon))&&(original.time.equals(temp.time))) {
			fail("ERR - the polynoms should be the same (equals)");
		}
	}

	@Test
	public void testSaveTheLargestSSID (){
		ArrayList<MacBig> macs = new ArrayList<MacBig>();
		MacBig m = new MacBig("1c:b9:c4:12:7c:c8","-68","2017/10/03 16:15:50","2262","35.21140758"
				,"32.10651925","Naama1","STD90U");
		MacBig a = new  MacBig("1c:b9:c4:12:7d:c8","-46","2017/11/03 16:10:50","2462","35.21240758"
				,"32.10551925","Naama","NRD90U");
		macs.add(m);
		macs.add(a);

		String [][]answer = {{"Time","ID","Lat","Lon","Alt","#WiFi networks","SSID1","MAC1","Frequncy1","Signal1","SSID2","MAC2","Frequncy2","Signal2"
			,"SSID3","MAC3","Frequncy3","Signal3","SSID4","MAC4","Frequncy4","Signal4","SSID5","MAC5","Frequncy5","Signal5","SSID6","MAC6"
			,"Frequncy6","Signal6","SSID7","MAC7","Frequncy7","Signal7","SSID8","MAC8","Frequncy8","Signal8","SSID9","MAC9","Frequncy9"
			,"Signal9","SSID10","MAC10","Frequncy10","Signal10"},{"2017/10/03 16:15:55","NRD90U","35.21240758","32.10651925","111.5999985","1",
				"Ariel_University","1c:b9:c4:12:7d:c8","2462","-40",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
				null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null}};
		int row = 1;
		HelpTime.SaveTheLargestSSID(macs,answer,row);
		if (!((macs.get(1).Signal).equals(answer[row][9]))){
			fail("ERR - the polynoms should be the same (equals)");
		}
	}

}
