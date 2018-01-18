package tests;
import writeTo.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.crypto.Mac;

import org.junit.Test;

import objects.MacBig;
import objects.MacBig_Container;

public class FindIndexTest {
	
	@Test 
	public void testPlaceArticleInfo(){
		String []a = {"1","2","3"};
		String []b = {"4","5","6"};
		String []c = {"7","8","9"};
		ArrayList<String[]> answer = new ArrayList<String[]>();
		answer.add(a);
		answer.add(b);
		answer.add(c);
		assertEquals(1, FindIndex.PlaceArticleInfo(answer, "2",0));
	}

}
