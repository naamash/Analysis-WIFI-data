package pa;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindIndexTest {

	
	@Test 
	public void testPlaceArticle(){
		String answer[][]={{"1","2","3"},{"4","5","6"},{"7","8","9"}};
		assertEquals(1, FindIndex.PlaceArticle(answer, "2", 0));

	}
	
	@Test 
	public void testPlace(){
		String answer[][]={{"1","2","3"},{"4","5","6"},{"7","8","9"}};
		assertEquals(1, FindIndex.Place(answer, "2"));

	}
	

}
