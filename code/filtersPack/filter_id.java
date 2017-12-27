package filtersPack;

import objects.MacBig;
import objects.MacBig_Container;

public class filter_id implements Filter{
	public String id;
	
	public filter_id(String id){
		this.id=id;
	}
	
	public boolean check (MacBig_Container scan){
		if (scan.arr_macbig[0].ID.equals(this.id)){
			return true;
		}
		return false;
	}
}
