package filtersPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import objects.MacBig;
import objects.MacBig_Container;

public class DoFilter {
	
	public Filter filter;
	
	public DoFilter(Filter filter){
		this.filter=filter;
	}
	
	public ArrayList<MacBig_Container> filtering (ArrayList<MacBig_Container>answer){
		return (ArrayList<MacBig_Container>) answer.stream().filter(MacBig_Container ->this.filter.check(MacBig_Container))
				.collect(Collectors.<MacBig_Container>toList());
	}
	
}
