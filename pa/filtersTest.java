package pa;

import static org.junit.Assert.*;

import org.junit.Test;

public class filtersTest {

	@Test
	public void testDistance(){
		String lat = "35.21240758";
		String lon = "32.10651925";
		String lat1 = "31.21240345";
		String lon1 = "30.10652525";
		double distance = Math.sqrt(((Double.parseDouble(lat)-Double.parseDouble(lat1))*(Double.parseDouble(lat)-Double.parseDouble(lat1)) +
				((Double.parseDouble(lon)-Double.parseDouble(lon1))*(Double.parseDouble(lon)-Double.parseDouble(lon1)))));
		assertEquals(""+distance,""+filters.Distance(lat, lon, lat1, lon1));
	}

}
