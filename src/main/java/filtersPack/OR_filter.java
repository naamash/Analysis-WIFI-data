package filtersPack;

import objects.MacBig_Container;

public class OR_filter implements Filter {

	Filter filter1;
	Filter filter2;
	
	/**
	 * defulte constractor
	 */
	public OR_filter() {
		this.filter1 = null;
		this.filter2 = null;
	}
	
	/**
	 * Defined constructors
	 * @param filter1
	 * @param filter2
	 */
	public OR_filter(Filter filter1, Filter filter2){
		this.filter1 = filter1;
		this.filter2 = filter2;
	}
	
	/**
	 * implementation the Check function from Filter
	 */
	public boolean check(MacBig_Container scan){
		return this.filter1.check(scan)||this.filter2.check(scan);
	}
	
}
