package writeTo;

import java.util.ArrayList;
import java.util.Arrays;

import objects.MacBig_Container;

/**
 * This class contains two functions of find the index.
 * each function find the index of the name that the function accept.
 * @author 
 *
 */
public class FindIndex {

	/**
	 * The function search the String name on the ArrayList and return the index of this.
	 * @param answer
	 * @param name
	 * @param row
	 * @return
	 */
	public static int PlaceArticleInfo (ArrayList<String[]> answer, String name,int row){
		for (int i = 0; i <answer.get(1).length; i++) {
			if(answer.get(row)[i].equals(name)){
				return i;
			}
		}
		return -1;
	}
}
