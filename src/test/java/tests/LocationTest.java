package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import objects.Location;

public class LocationTest {

	@Test
	public void testcompareTo() {
		Location loc = new Location("0.045827","699.287760530489","32.1025333033369","35.2072639902064");
		Location loc1 = new Location("0.103768","699.287760530489","32.1025333033369","35.2072639902064");
		assertEquals(1, loc.compareTo(loc1));
	}
}
