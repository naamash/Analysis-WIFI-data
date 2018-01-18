package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import objects.LineOfInfo;

public class LineOfInfoTest {
	
	LineOfInfo line1 =new LineOfInfo();

	@Test
	public void testcompareto() {
		line1.RSSI="-77";
		assertEquals(0, line1.RSSI.compareTo("-77"));
		
	}

}
