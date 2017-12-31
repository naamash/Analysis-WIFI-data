package filtersPack;

import objects.MacBig_Container;

public class NOT_filter implements Filter {

	public Filter filter;
	
	public NOT_filter() {
		this.filter = null;
	}
	
	public NOT_filter(Filter filter){
		this.filter = filter;
	}
	
	public boolean check(MacBig_Container scan){
		return !(this.filter.check(scan));
	}
}
