package tests;

import static org.junit.Assert.*;
import writeTo.*;
import java.util.Arrays;

import org.junit.Test;

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

//	@Test
//	public void testWriteToCsv() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSave_info() {
//		fail("Not yet implemented");
//	}

}
