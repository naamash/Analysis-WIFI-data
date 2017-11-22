package pa;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertToKmlTest {

	@Test
	public void testConvertTimeToKmlFormat(){
		assertEquals("2017-11-03T16:10:50", ConvertToKml.ConvertTimeToKmlFormat("2017/11/03 16:10:50"));
	}
	
}
