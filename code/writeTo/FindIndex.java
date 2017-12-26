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
	 * This function getting matrix of String type, String name and int of row.
	 * The function search the String name on the matrix in the row and return the index of this.
	 * @param answer
	 * @param name
	 * @return the index of the name 
	 */
	public static int PlaceArticle (ArrayList<MacBig_Container> answer, String name,int row){
		for (int i = 0; i <answer.get(1).realsize; i++) {
			if(answer.get(row).arr_macbig[i].equals(name)){
				return i;
			}
		}
		return -1;
	}
	public static int PlaceArticleAnswerID (ArrayList<MacBig_Container> answer, String name,int row){
		for (int i = 0; i <answer.get(0).realsize; i++) {
			if(answer.get(0).arr_macbig[i].ID.equals(name)){
				return i;
			}
		}
		return -1;
	}
	public static int PlaceArticleAnswerTime (ArrayList<MacBig_Container> answer, String name,int row){
		for (int i = 0; i <answer.get(0).realsize; i++) {
			if(answer.get(0).arr_macbig[i].time.equals(name)){
				return i;
			}
		}
		return -1;
	}
	public static int PlaceArticleAnswerLat (ArrayList<MacBig_Container> answer, String name,int row){
		for (int i = 0; i <answer.get(0).realsize; i++) {
			if(answer.get(0).arr_macbig[i].lat.equals(name)){
				return i;
			}
		}
		return -1;
	}
	public static int PlaceArticleAnswerlon (ArrayList<MacBig_Container> answer, String name,int row){
		for (int i = 0; i <answer.get(0).realsize; i++) {
			if(answer.get(0).arr_macbig[i].lon.equals(name)){
				return i;
			}
		}
		return -1;
	}
	public static int PlaceArticleInfo (ArrayList<String[]> answer, String name,int row){
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
	public static int Place (ArrayList<MacBig_Container>answer, String name){
		for (int i = 0; i <46; i++) {
			if(answer.get(0).arr_macbig[i].equals(name)){
				return i;
			}
		}
		return -1;
	}
	public static int Place (String[]str, String name){
		for (int i = 0; i <46; i++) {
			if(str[i].contains(name)){
				return i;
			}
		}
		return -1;
	}
}
