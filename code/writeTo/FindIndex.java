package writeTo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class contains two functions of find the index.
 * each function find the index of the name that the function accept.
 * @author 
 *
 */
public class FindIndex {

	/**
	 * This function getting matrix of String type, String name and int of row.
	 * The function search the String name on the matrix in the row and return the index of this.
	 * @param answer
	 * @param name
	 * @return the index of the name 
	 */
	public static int PlaceArticle (ArrayList<String[]> answer, String name,int row){
//		System.out.println(row);
//		System.out.println(name);
		for (int i = 0; i <answer.get(1).length; i++) {
			if(answer.get(row)[i].equals(name)){
				return i;
			}
		}
		return -1;
	}
	/**
	 * This function getting matrix of String type, and String name.
	 * The function search the String name on the matrix and return the index of this.
	 * @param answer
	 * @param name
	 * @return the index of the name 
	 */
	public static int Place (ArrayList<String[]>answer, String name){
		for (int i = 0; i <46; i++) {
			if(answer.get(0)[i].equals(name)){
				return i;
			}
		}
		return -1;
	}
}
