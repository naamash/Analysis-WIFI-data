package filtersPack;

import java.awt.geom.Line2D.Double;

import objects.MacBig_Container;

public class filter_location implements Filter{
	
	public String lat;
	public String lon;
	public double radious;
	
	
	public filter_location(String lat, String lon, double radious){
		this.lat=lat;
		this.lon=lon;
		this.radious=radious;
	}
	
	public boolean check (MacBig_Container scan){
		if(HelpFilter.Distance(lat, lon, (scan.arr_macbig[0].lat),
				(scan.arr_macbig[0].lon))<=this.radious){
			return true;
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
}






