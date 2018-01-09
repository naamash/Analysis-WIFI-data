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
	public Filter[] filters = new Filter[3];
	
	/**
	 * Copying constructor.
	 * @param filter
	 */
	public DoFilter(Filter filter){
		this.filter=filter;
	}
	
	public DoFilter(Filter[]filters){
		System.out.println(Arrays.toString(filters));
		if(!(""+filters[1]).equals("null") && !(""+filters[0]).equals("null") && !(""+filters[2]).equals("null")){
		this.filters[0] = filters[0];
		this.filters[1] = filters[1];
		this.filters[2] = filters[2];
		}
		else if((""+filters[1]).equals("null")&&!(""+filters[0]).equals("null")){
			System.out.println("*****");
			this.filters[0] = filters[0];
			System.out.println(Arrays.toString(this.filters));
		}
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
