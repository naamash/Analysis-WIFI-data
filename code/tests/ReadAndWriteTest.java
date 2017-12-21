package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import writeTo.ReadAndWrite;

public class ReadAndWriteTest {

	//	@Test
	//	public void testReadingFile() {
	//		fail("Not yet implemented");
	//	}

	@Test
	public void testWriteToCsv() throws IOException {
		ArrayList<String[]> answer = new ArrayList<String[]>();
		String []a = {"Time", "ID", "Lat", "Lon", "Alt", "#WiFi networks", "SSID1", "MAC1", 
				"Frequncy1", "Signal1", "SSID2", "MAC2", "Frequncy2", "Signal2", "SSID3",
				"MAC3", "Frequncy3", "Signal3", "SSID4", "MAC4", "Frequncy4", "Signal4",
				"SSID5", "MAC5", "Frequncy5", "Signal5", "SSID6", "MAC6","Frequncy6",
				"Signal6", "SSID7", "MAC7", "Frequncy7", "Signal7", "SSID8", "MAC8", "Frequncy8",
				"Signal8", "SSID9", "MAC9", "Frequncy9", "Signal9", "SSID10", "MAC10", "Frequncy10",
		"Signal10"};
		String b[]={"01/12/2017 10:42", "display=NRD90M.G950FXXU1AQJ5", "32.17224246", "34.81444894",
				"7.777438959", "1", "HOTBOX-D88A", "c0:ac:54:f5:b4:c9", "2412", "-92", "null", "null",
				"null", "null", "null", "null", "null", "null", "null", "null","null", "null", "null", "null",
				"null", "null", "null", "null", "null", "null","null", "null", "null", "null", "null", "null",
				"null", "null", "null", "null","null", "null", "null", "null","null", "null"};
		answer.add(a);
		answer.add(b);

		String location = "C://Users//נעמה שטאובר//Desktop//testfunction//testWriteToCsv_Matala_zero.csv";
		ArrayList<String[]> Answer_One = new ArrayList<String[]>();

		Answer_One = writeTo.ReadAndWrite.WriteToCsv(answer, location);
		if (!(Answer_One.get(1)[0].equals("01/12/2017 10:42"))&&(Answer_One.get(1)[1].equals("display=NRD90M.G950FXXU1AQJ5"))
				&&(Answer_One.get(1)[2].equals("32.17224246"))&&(Answer_One.get(1)[3].equals("34.81444894"))
				&&(Answer_One.get(1)[4].equals("7.777438959"))&&(Answer_One.get(1)[5].equals("1"))
				&&(Answer_One.get(1)[6].equals("HOTBOX-D88A"))&&(Answer_One.get(1)[7].equals("c0:ac:54:f5:b4:c9"))
				&&(Answer_One.get(1)[8].equals("2412"))&&(Answer_One.get(1)[9].equals("-92"))){	
			fail("Not yet implemented");
		}
	}

}
