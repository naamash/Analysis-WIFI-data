package filtersPack;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import objects.MacBig;
import objects.MacBig_Container;

public class DoFilter {
	
	public Filter filter;
	
	public DoFilter(Filter filter){
		this.filter=filter;
	}
	
	public Set<MacBig_Container> filtering (ArrayList<MacBig_Container>answer){
		return answer.stream().filter(s ->this.filter.check(s)).collect(Collectors.<MacBig_Container>toSet());
	}
}
