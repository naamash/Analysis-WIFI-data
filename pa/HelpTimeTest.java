package pa;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class HelpTimeTest {

	@Test
	public void testfromStringToDate(){
		Date date=new Date (); 
	//	date=(Fri Nov 03 16:10:50 IST 2017);
		date.setYear(2017);
		date.setMonth(11);
		date.setDate(03);
		date.setHours(16);
		date.setMinutes(10);
		date.setSeconds(50);
		System.out.println(date.toString());
		assertEquals(date, HelpTime.fromStringToDate("2017/11/03 16:10:50"));

	}

}
