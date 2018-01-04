package filtersPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import objects.MacBig;
import objects.MacBig_Container;
/**
 * This class made for implement filters.
 * @author 
 *
 */
public class DoFilter {
	
	public Filter filter;
	
	/**
	 * Copying constructor.
	 * @param filter
	 */
	public DoFilter(Filter filter){
		this.filter=filter;
	}
	
	/**
	 * Implementation filters in ArrayList of MacBig_Container type. 
	 * @param answer
	 * @return
	 */
	public ArrayList<MacBig_Container> filtering (ArrayList<MacBig_Container>answer){
		return (ArrayList<MacBig_Container>) answer.stream().filter(MacBig_Container ->this.filter.check(MacBig_Container))
				.collect(Collectors.<MacBig_Container>toList());
	}
	
}
