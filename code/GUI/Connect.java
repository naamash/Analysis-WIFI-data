package GUI;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import filtersPack.OR_filter;
import algo1and2.FindLocation;
import filtersPack.DoFilter;
import filtersPack.Filter;
import filtersPack.HelpFilter;
import filtersPack.NOT_filter;
import filtersPack.AND_filter;
import filtersPack.ChooseFilter;
import filtersPack.filter_id;
import filtersPack.filter_location;
import filtersPack.filter_time;
import objects.MacBig_Container;
import objects.hash;
import writeTo.ConvertToKml;
import writeTo.ReadAndWrite;
import java.util.concurrent.TimeUnit;

public class Connect {
	ArrayList<MacBig_Container> macs;
	ArrayList<MacBig_Container> macsBefore;

	ArrayList<String> csv_paths;
	ArrayList<String> folder_paths;

	public void douplicate() {

		List<MacBig_Container> temp = new ArrayList<MacBig_Container>();
		for (int i = 0; i < this.macs.size(); i++) {
			if (!temp.contains(this.macs.get(i)))
				temp.add(this.macs.get(i));
		}
		this.macs.clear();
		this.macs.addAll(temp);
	}

	public void addArrayList(ArrayList<MacBig_Container> other) {
		//this.macs.addAll(other);
		douplicate();
		hash.HowMacAndRow(other);
		//			for
		//			for (int i = 0; i < other.size(); i++) {
		//				if (macs.contains(other.get(i).arr_macbig))
		//				insertHash(other.get(i));

	}
	// we need to update the hash map and check douplicat in the hash map

	public Connect() {
		this.macs = new ArrayList<MacBig_Container>();
		this.macsBefore = new ArrayList<MacBig_Container>();

		this.csv_paths = new ArrayList<String>();
		this.folder_paths = new ArrayList<String>();

	}
	/**
	 * function that follow change on files 
	 * @param path
	 */
	public void folow_csv(String path) {
		this.csv_paths.add(path);
		new Thread(new Runnable() {
			@Override
			public void run() {
				changeFiles(macs);
				//readCSv(path);
			}

		}).start();

	}
	/**
	 * the  shell function check change in the folder
	 * @param path
	 */
	public void folow_folder(String path) {
		System.out.println("enter folow folder");
		this.folder_paths.add(path);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("enter run folow folder");
					//enterdatabase(path);
					changeFolder(macs);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}).start();

	}
	/**
	 * the function contians pool tread that follow the folder
	 * @param data
	 * @throws IOException
	 */
	// https://github.com/ruckc/filewatcher/blob/master/src/main/java/io/ruck/filewatcher/Watcher.java
	public void changeFolder(ArrayList<MacBig_Container> data) throws IOException {
		// System.out.println("enter change folder");
		ExecutorService servise = Executors.newCachedThreadPool();
		final FileSystem fs = FileSystems.getDefault();
		final WatchService watcher = fs.newWatchService();
		;
		int size = folder_paths.size();
		System.out.println("size of the csv_path " + size);
		Map<WatchKey, String> keys = new HashMap<>();
		for (int i = 0; i < this.folder_paths.size(); i++) {
			if (!keys.containsValue(folder_paths.get(i))) {
				try {
					Path path = Paths.get(folder_paths.get(i));
					// the event we want to check
					WatchKey key = path.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
					keys.put(key, folder_paths.get(i));

				} catch (Exception e) {
					System.out.println("error with the folder " + folder_paths.get(i));
				}
			}
		}
		servise.submit(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("enter ruunable");
				while (Thread.interrupted() == false) {
					WatchKey t = null;
					try {
						t = watcher.poll(20, TimeUnit.MILLISECONDS);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
					// if there is a change then the watchkey is change
					if (t != null) {
						System.out.println("change");
						database(data); // restart to the database
						System.out.println("data size  in the function" + data.size());
						servise.shutdownNow();
						Thread.currentThread().interrupt();
						try {
							changeFolder(data);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}

					else if (size != folder_paths.size()) {
						try {
							watcher.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						servise.shutdown();
						Thread.currentThread().interrupt();
						try {
							changeFolder(data);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}

		});
		System.out.println(hash.HowMacAndRow(data));
	}
	/**
	 * the function follow on the change on the csv file
	 */
	// https://stackoverflow.com/questions/2064694/how-do-i-find-the-last-modified-file-in-a-directory-in-java
	public void changeFiles(ArrayList<MacBig_Container> data) {
		int size = csv_paths.size();
		ExecutorService servise = Executors.newCachedThreadPool();
		ArrayList<Long> lastmodify = new ArrayList<Long>();
		for (int i = 0; i < this.csv_paths.size(); i++) {
			lastmodify.add(new File(csv_paths.get(i)).lastModified());
		}
		servise.submit(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub

				while (Thread.currentThread().isInterrupted() == false) {
					for (int i = 0; i < lastmodify.size(); i++) {
						if (lastmodify.get(i) != new File(csv_paths.get(i)).lastModified()) {
							database(data);
							servise.shutdownNow();
							Thread.currentThread().interrupt();
							changeFiles(data);
						}
					}
					if (size != csv_paths.size()) {
						database(data);
						servise.shutdownNow();
						Thread.currentThread().interrupt();
						changeFiles(data);
					}
				}
			}

		});

	}
	/**
	 * the function enter the wigle-wifi files from folder to the database
	 * @param path
	 */
	public void enterdatabase(String path) {

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (macs) {
					ReadAndWrite c = new ReadAndWrite();
					File file = new File(path);
					if (file.isDirectory()){
						macs.addAll(c.readingFolderWigle(file));
					}
					else{
						macs.addAll(c.readingFileWigle(file));
					}
				}
			}
		});
		t.start();
		// return this.data;
	}
	/**
	 * The function enter the Table.csv files  to the database
	 * @param path
	 */


	public void database(ArrayList<MacBig_Container> data) {
		//		System.out.println("restart database");
		this.macs.clear();

		for (int i = 0; i < this.folder_paths.size(); i++) {
			enterdatabase(this.folder_paths.get(i));
		}
		for (int i = 0; i < this.csv_paths.size(); i++) {

			read46(this.csv_paths.get(i));
		}
		//		System.out.println(hash.HowMacAndRow(data));
		//			System.out.println("data     size " + data.numOfScan());
		//			System.out.println("data size " + data.size());
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
		if(!path.substring(path.length()-4, path.length()).equals(".kml")) {
			path=path+".kml";
		}
		final String str=path;
		ConvertToKml k = new ConvertToKml();
		Thread y = new Thread(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				synchronized (macs) {
					k.ToKml(macs,str);
					macsBefore = new ArrayList<MacBig_Container>();
					macsBefore.addAll(macs);
					douplicate();
				}
			}
		});y.start();
	}

	public void saveTOcsv(String path) {
		if(!path.substring(path.length()-4, path.length()).equals(".csv")){
			path=path+".csv";
		}
		final String str=path;
		ReadAndWrite t = new ReadAndWrite();
		Thread y = new Thread(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				synchronized (macs) {
					try {
						t.WriteToCsv(macs, str);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					macsBefore = new ArrayList<MacBig_Container>();
					macsBefore.addAll(macs);
					douplicate();
				}
			}
		});y.start();
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
			return ("There is a problem in Algo2"); 
		}
	}

	public ArrayList<MacBig_Container> readWigle(File folder){
		if (folder.isDirectory()){
			//final String str=path;
			ReadAndWrite k = new ReadAndWrite();
			folow_folder(""+folder);
			Thread y = new Thread(new Runnable(){

				public void run() {
					// TODO Auto-generated method stub
					synchronized (macs) {
						macs.addAll(k.readingFolderWigle(folder));
						macsBefore = new ArrayList<MacBig_Container>();
						macsBefore.addAll(macs);
						douplicate();
					}
				}
			});y.start();
		}
		return macs;
	}

	//		
	//		else if (!folder.isDirectory()){
	//			//folow_folder(""+folder);
	//			folow_csv(""+folder);
	//			this.macs = ReadAndWrite.readingFileWigle(folder);
	//			//this.macsBefore.addAll(this.macs);
	//		}
	//		this.macsBefore = new ArrayList<MacBig_Container>();
	//		this.macsBefore.addAll(macs);
	//		return this.macs;
	//	}

	//	public void readCSV46(String path){
	//		if (!path.substring(path.length() - 4, path.length()).equals(".csv")){
	//			path = path + ".csv";
	//		}
	//		final String str=path;
	//		ReadAndWrite k = new ReadAndWrite();
	//		Thread t = new Thread(new Runnable() {
	//			@Override
	//			public void run() {
	//				// TODO Auto-generated method stub
	//				synchronized (macs) {
	//					try {
	//						macs.addAll(k.readingFile46Col(str));
	//					} catch (IOException e) {
	//						// TODO Auto-generated catch block
	//						e.printStackTrace();
	//					}
	//					macsBefore = new ArrayList<MacBig_Container>();
	//					macsBefore.addAll(macs);
	//					douplicate();
	//				}
	//			}
	//		});t.start();
	//
	//	}

	public  ArrayList<MacBig_Container> read46(String path){
		if (!path.substring(path.length() - 4, path.length()).equals(".csv")){
			path = path + ".csv";
		}
		final String str=path;
		ReadAndWrite k = new ReadAndWrite();
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (macs) {
					try {
						folow_csv(str);
						macs.addAll(k.readingFile46Col(str));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("There is problem with the file or with the path");
					}
					macsBefore = new ArrayList<MacBig_Container>();
					macsBefore.addAll(macs);
					douplicate();
				}
			}
		});t.start();
		return macs;
	}

	public String MacAndRows (ArrayList<MacBig_Container> macs){
		return hash.HowMacAndRow(macs);
	}

	public ArrayList<MacBig_Container> UNDO(){
		return ChooseFilter.UNDO_(this.macs,this.macsBefore);
	}

	public ArrayList<MacBig_Container> CLEAR(){
		this.macsBefore.clear();
		this.macs.clear();
		return macs;
	}

}

//display=NRD90M.G950FXXU1AQJ5
//lat=32.10246120400514
//lon=35.209976991172944
