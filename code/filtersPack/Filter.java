package filtersPack;

import java.io.Serializable;

import objects.MacBig;
import objects.MacBig_Container;

public interface Filter extends Serializable{
	
	/**
	 * The classes the extend Filter must imlement this function. 
	 * @param scan
	 * @return
	 */
		public boolean check(MacBig_Container scan);
}
