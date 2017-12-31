package filtersPack;

import objects.MacBig_Container;

public class AND_filter {

	public Filter filter1;
	public Filter filter2;
	
	public AND_filter(){
		this.filter1 = null;
		this.filter2 = null;
	}
	
	public AND_filter(Filter filter1, Filter filter2){
		this.filter1 = filter1;
		this.filter2 = filter2;
	}
	
	public boolean check(MacBig_Container scan){
		return this.filter1.check(scan)&&this.filter2.check(scan);
	}
	
}
