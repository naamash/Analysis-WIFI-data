package filtersPack;

import java.io.Serializable;

import objects.MacBig;
import objects.MacBig_Container;

public interface Filter extends Serializable{
	
	
		public boolean check(MacBig_Container scan);
}
