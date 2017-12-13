package pa;

import java.util.Arrays;

public class MacBig_Container {
	MacBig []arr_macbig;
	int realsize;
	
	public MacBig_Container() {
		this.arr_macbig = null;
		this.realsize = 0;
	}
	
	public MacBig_Container(MacBig []arr_macbig, int realsize){
		this.realsize = realsize;
		MacBig[] temp = new MacBig[arr_macbig.length];
		for (int i = 0; i < realsize; i++) {
			temp[i] = arr_macbig[i];
		}
		this.arr_macbig = temp;
	}
	
	public MacBig_Container(MacBig_Container other){
		this.realsize = other.realsize;
		MacBig[] temp = new MacBig[other.arr_macbig.length];
		for (int i = 0; i < other.realsize; i++) {
			temp[i] = other.arr_macbig[i];
		}
		this.arr_macbig = temp;
	}

	public String toString() {
		return "MacBig_Container [arr_macbig=" + Arrays.toString(arr_macbig) + ", realsize=" + realsize + "]";
	}
	
}
