package filtersPack;

import objects.MacBig_Container;
/**
 * This class made to access two filters so that both of them must be in the value for save this value. 
 * @author hadar
 *
 */
public class AND_filter implements Filter {

	public Filter filter1;
	public Filter filter2;
	
	/**
	 * defulte constractor
	 */
	public AND_filter(){
		this.filter1 = null;
		this.filter2 = null;
	}
	
	/**
	 * Defined constructors
	 * @param filter1
	 * @param filter2
	 */
	public AND_filter(Filter filter1, Filter filter2){
		this.filter1 = filter1;
		this.filter2 = filter2;
	}
	
	/**
	 * implementation the Check function from Filter
	 */
	public boolean check(MacBig_Container scan){
		return this.filter1.check(scan)&&this.filter2.check(scan);
	}
	
}
