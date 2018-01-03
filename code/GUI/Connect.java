package GUI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import filtersPack.OR_filter;
import algo1and2.FindLocation;
import filtersPack.DoFilter;
import filtersPack.Filter;
import filtersPack.NOT_filter;
import filtersPack.AND_filter;
import filtersPack.filter_id;
import filtersPack.filter_location;
import filtersPack.filter_time;
import objects.MacBig_Container;
import writeTo.ConvertToKml;
import writeTo.ReadAndWrite;

public class Connect {
	ArrayList<MacBig_Container> macs;
	ArrayList<MacBig_Container> macsBefore;


	public void readCSV46(String path){
		try {
			this.macs=ReadAndWrite.readingFile46Col(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addfilter_ID(String idName){
		Filter filter = new filter_id(idName);
		this.macs.remove(0);
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
	}

	public void addfilter_TIME(String start, String end){
		Filter filter = new filter_time(start, end);
		System.out.println(macs.size());
		this.macs.remove(0);
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
	}

	public void addfilter_LOC(String lat,String lon,double radious){
		Filter filter = new filter_location(lat, lon, radious);
		this.macs.remove(0);
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
	}

	public void NOT_filter_LOC(String lat,String lon,double radious){
		Filter filter = new NOT_filter(new filter_location(lat, lon, radious));
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs) ;
	}

	public void NOT_filter_ID(String id){
		Filter filter = new NOT_filter(new filter_id(id));
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
	}

	public void NOT_filter_TIME(String start, String end){
		Filter filter = new NOT_filter(new filter_time(start, end));
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
	}
	
	public void and_filter(Filter a,Filter b){
		Filter filter = new AND_filter(a,b);
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
	}
	
	public void OR_filter(Filter a,Filter b){
		Filter filter = new OR_filter(a,b);
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
	}

	public void saveTOkml(String path) {
		if(!path.substring(path.length()-3, path.length()).equals("kml")) {
			path=path+".kml";
		}
		ConvertToKml k = new ConvertToKml();
		k.ToKml(this.macs,path);
	}
	
	public void saveTOcsv(String path) {
		if(!path.substring(path.length()-3, path.length()).equals("csv")){
			path=path+".csv";
		}
		
		ReadAndWrite t = new ReadAndWrite();
		try {
			t.WriteToCsv(this.macs, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	public String Algo1(File folder,String Mac) {
		FindLocation al = new FindLocation();
		try {
			return al.Matala2_Algo1User(folder, Mac);
		} catch (IOException e) {
			e.printStackTrace();
			return "There is problem in Algo1";
		}
	}
	
	public void Algo2Folder(File folder1 ,File folder2,String path){
		FindLocation al = new FindLocation();
		try {
			al.Matala2_Algo2Folder(folder1, folder2, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String Algo2User(File folder1 ,String mac1,String mac2,String mac3,String sig1,String sig2,String sig3){
		FindLocation al = new FindLocation();
		try {
			return (al.Matala2_Algo2User(folder1, mac1, mac2, mac3, sig1, sig2, sig3));
		} catch (IOException e) {
			e.printStackTrace();
			return ("There is problem in Algo1"); 
		}
	}
	
	public ArrayList<MacBig_Container> readWigle(File folder){
		if (folder.isDirectory()){
			return macs = ReadAndWrite.readingFolderWigle(folder);
		}
		else if (!folder.isDirectory()){
			return macs = ReadAndWrite.readingFileWigle(folder);
		}
		return macs;
	}
	
	public  ArrayList<MacBig_Container> read46(String path){
		try {
			return macs = ReadAndWrite.readingFile46Col(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("There is problem with the file or with the path");
		}
		return macs;
	}
	
}

//display=NRD90M.G950FXXU1AQJ5
//lat=32.10246120400514
//lon=35.209976991172944
