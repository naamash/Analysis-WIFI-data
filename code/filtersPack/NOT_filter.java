package filtersPack;

import objects.MacBig_Container;

public class NOT_filter implements Filter {

	public Filter filter;
	
	/**
	 * defulte constractor
	 */
	public NOT_filter() {
		this.filter = null;
	}
	
	/**
	 * Copying constructors
	 * @param filter
	 */
	public NOT_filter(Filter filter){
		this.filter = filter;
	}
	
	/**
	 * implementation by NOT the Check function from Filter
	 */
	public boolean check(MacBig_Container scan){
		return !(this.filter.check(scan));
	}
}
