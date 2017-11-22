package pa;

public class FindIndex {

	/**
	 * This function getting matrix of String type, and String name.
	 * The function search the String name on the matrix and return the index of this.
	 * @param answer
	 * @param name
	 * @return
	 */
	public static int PlaceArticle (String [][]answer, String name,int row){
		for (int i = 0; i <11; i++) {
			if(answer[row][i].equals(name)){
				return i;
			}
		}
		return -1;
	}
	
	public static int Place (String [][]answer, String name){
		for (int i = 0; i <46; i++) {
			if(answer[0][i].equals(name)){
				return i;
			}
		}
		return -1;
	}
}
