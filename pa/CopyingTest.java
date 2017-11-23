package pa;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class CopyingTest {

	@Test
	public void testCopyingToAnswer2() {
		String information[][]={{"hello","my","name","is","naama","and","i","love","choclate"}};
		ArrayList<String[]> answer=new ArrayList<String[]>();
		String[] line = {"is","and","i","love","choclate","7",null,null,null,null,null,null,null,null,null,null
				,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null
				,null,null,null,null,null,null,null,null,null,null,null};
		assertEquals(line, Copying.CopyingToAnswerFirst(information, answer, 0, 7));
	}
	
	@Test
	public void testFrom_Channel_To_Frequency() {
		String channel="55";
		assertEquals("5275", Copying.From_Channel_To_Frequency(channel));
	}

}
