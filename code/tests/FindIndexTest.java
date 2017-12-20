package tests;
import writeTo.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FindIndexTest {

	
	@Test 
	public void testPlaceArticle(){
		String []a = {"1","2","3"};
		String []b = {"4","5","6"};
		String []c = {"7","8","9"};
		ArrayList<String[]> answer = new ArrayList<String[]>();
		answer.add(a);
		answer.add(b);
		answer.add(c);
		assertEquals(1, FindIndex.PlaceArticle(answer, "2", 0));

	}
	
	@Test 
	public void testPlace(){
		String []a = {"1","2","3"};
		String []b = {"4","5","6"};
		String []c = {"7","8","9"};
		ArrayList<String[]> answer = new ArrayList<String[]>();
		answer.add(a);
		answer.add(b);
		answer.add(c);
		assertEquals(1, FindIndex.Place(answer, "2"));

	}
	

}
