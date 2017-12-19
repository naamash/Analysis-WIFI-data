package objects;

import java.util.Arrays;
/**
 * this class contains array of MacBig type and realSize of the array.
 *
 */
public class MacBig_Container {
	public MacBig []arr_macbig;
	public int realsize;
	
	/**
	 * Default constructors
	 */
	public MacBig_Container() {
		this.arr_macbig = null;
		this.realsize = 0;
	}
	
	/**
	 * Defined constructors
	 * @param arr_macbig
	 * @param realsize
	 */
	public MacBig_Container(MacBig []arr_macbig, int realsize){
		this.realsize = realsize;
		MacBig[] temp = new MacBig[arr_macbig.length];
		for (int i = 0; i < realsize; i++) {
			temp[i] = arr_macbig[i];
		}
		this.arr_macbig = temp;
	}
	
	/**
	 * Copy constructors
	 * @param other
	 */
	public MacBig_Container(MacBig_Container other){
		this.realsize = other.realsize;
		MacBig[] temp = new MacBig[other.arr_macbig.length];
		for (int i = 0; i < other.realsize; i++) {
			temp[i] = other.arr_macbig[i];
		}
		this.arr_macbig = temp;
	}

	/**
	 * The function print the object
	 */
	public String toString() {
		return "MacBig_Container [arr_macbig=" + Arrays.toString(arr_macbig) + ", realsize=" + realsize + "]";
	}
	
}
