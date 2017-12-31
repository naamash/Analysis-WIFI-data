package GUI;

import java.io.IOException;
import java.util.ArrayList;

import filtersPack.DoFilter;
import filtersPack.Filter;
import filtersPack.NOT_filter;
import filtersPack.filter_id;
import filtersPack.filter_location;
import filtersPack.filter_time;
import objects.MacBig_Container;
import writeTo.ReadAndWrite;

public class Conect {
	ArrayList<MacBig_Container> macs;

	
	public void addCSV(String path){
		try {
			this.macs=ReadAndWrite.readingFile46Col(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addfilter_ID(String idName){
			Filter f = new filter_id("display=" + idName);
			this.macs.remove(0);
			DoFilter fil = new DoFilter(f);
			this.macs = fil.filtering(macs);
	}
	
	public void addfilter_TIME(String start, String end){
		Filter f = new filter_time(start, end);
		this.macs.remove(0);
		DoFilter fil = new DoFilter(f);
		this.macs = fil.filtering(macs);
	}
	
	public void addfilter_LOC(String lat,String lon,double radious){
		Filter f = new filter_location(lat, lon, radious);
		DoFilter fil = new DoFilter(f);
		this.macs.remove(0);
		this.macs = fil.filtering(macs);
	}
	
	public void NOT_filter_LOC(String lat,String lon,double radious){
		Filter f = new NOT_filter(new filter_location(lat, lon, radious));
		DoFilter fil = new DoFilter(f);
		this.macs = fil.filtering(macs) ;
	}
	
	public void NOT_filter_ID(String id){
		Filter f = new NOT_filter(new filter_id(id));
		DoFilter fil = new DoFilter(f);
		this.macs = fil.filtering(macs);
	}
	
	public void NOT_filter_TIME(String start, String end){
		Filter f = new NOT_filter(new filter_time(start, end));
		DoFilter fil = new DoFilter(f);
		this.macs = fil.filtering(macs);
	}
	
	
}
