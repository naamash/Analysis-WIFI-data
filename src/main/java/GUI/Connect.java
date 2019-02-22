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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
	ArrayList<MySql> sql;

	ArrayList<String> csv_paths;
	ArrayList<String> folder_paths;


	/**
	 * Checks that there are no Macs duplicate 
	 */
	public void douplicate() {

		List<MacBig_Container> temp = new ArrayList<MacBig_Container>();
		for (int i = 0; i < this.macs.size(); i++) {
			if (!temp.contains(this.macs.get(i)))
				temp.add(this.macs.get(i));
		}
		this.macs.clear();
		this.macs.addAll(temp);
	}

	public void addArrayList(ArrayList<MacBig_Container> other) throws IOException {
		//this.macs.addAll(other);
		douplicate();
		hash.HowMacAndRow(other);
		//			for
		//			for (int i = 0; i < other.size(); i++) {
		//				if (macs.contains(other.get(i).arr_macbig))
		//				insertHash(other.get(i));

	}

	public Connect() {
		this.macs = new ArrayList<MacBig_Container>();
		this.macsBefore = new ArrayList<MacBig_Container>();
		this.sql= new ArrayList<MySql>();
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

	public void folow_sql(MySql e) {
		this.sql.add(e);
		new Thread(new Runnable() {
			@Override
			public void run() {
				checkForChange(e);
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
	 * the function enter the wigle-wifi files from folder to the Arraylist of database
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
						try {
							macs.addAll(c.readingFolderWigle(file));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
		for (int i = 0; i < this.sql.size(); i++) {
			MySql.test_ex4_db(this.sql.get(i).get_ip(),this.sql.get(i).get_url(), this.sql.get(i).get_password(), this.sql.get(i).get_user());
		}
		//		System.out.println(hash.HowMacAndRow(data));
		//			System.out.println("data     size " + data.numOfScan());
		//			System.out.println("data size " + data.size());
	}


	/**
	 * The function implement filter by id 
	 * @param idName
	 */
	public void addfilter_ID(String idName){
		Filter filter = new filter_id(idName);
		this.macs.remove(0);
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
	}
	/**
	 * The function implement filter by time 
	 * @param idName
	 */
	public void addfilter_TIME(String start, String end){
		Filter filter = new filter_time(start, end);
		System.out.println(macs.size());
		this.macs.remove(0);
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
	}
	/**
	 * The function implement filter by place 
	 * @param idName
	 */
	public void addfilter_LOC(String lat,String lon,double radious){
		Filter filter = new filter_location(lat, lon, radious);
		this.macs.remove(0);
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
	}
	/**
	 * The function implement filter NOT by place 
	 * @param idName
	 */
	public void NOT_filter_LOC(String lat,String lon,double radious){
		Filter filter = new NOT_filter(new filter_location(lat, lon, radious));
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs) ;
	}
	/**
	 * The function implement filter by NOT id 
	 * @param idName
	 */
	public void NOT_filter_ID(String id){
		Filter filter = new NOT_filter(new filter_id(id));
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
	}
	/**
	 * The function implement filter by NOT time 
	 * @param idName
	 */
	public void NOT_filter_TIME(String start, String end){
		Filter filter = new NOT_filter(new filter_time(start, end));
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
	}
	/**
	 * The function implement AND two filters 
	 * @param idName
	 */
	public boolean and_filter(Filter a,Filter b){
		if ((""+a).equals("null")||(""+b).equals("null")){
			return false;
		}

		Filter filter = new AND_filter(a,b);
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
		return true;
	}
	/**
	 * The function implement OR two filters 
	 * @param idName
	 */
	public boolean OR_filter(Filter a,Filter b){
		if ((""+a).equals("null")||(""+b).equals("null")){
			return false;
		}
		Filter filter = new OR_filter(a,b);
		DoFilter fil = new DoFilter(filter);
		this.macs = fil.filtering(macs);
		return false;
	}
	/**
	 * The function write and save to kml file 
	 * @param idName
	 */
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
	/**
	 * The function write and save to csv file 
	 * @param idName
	 */
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

	/**
	 * The function implements the Algo1
	 * @param folder
	 * @param Mac
	 * @return
	 */
	public String Algo1(File folder,String Mac) {
		FindLocation al = new FindLocation();
		try {
			return al.Matala2_Algo1User(folder, Mac);
		} catch (IOException e) {
			e.printStackTrace();
			return "There is problem in Algo1";
		}
	}
	/**
	 * The function implements the Algo2 by receiving a file
	 * @param folder
	 * @param Mac
	 * @return
	 */
	public void Algo2Folder(File folder1 ,File folder2,String path){
		FindLocation al = new FindLocation();
		try {
			al.Matala2_Algo2Folder(folder1, folder2, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * The function implements the Algo2 by receiving a Macs and Signals
	 * @param folder
	 * @param Mac
	 * @return
	 */
	public String Algo2User(File folder1 ,String mac1,String mac2,String mac3,String sig1,String sig2,String sig3){
		FindLocation al = new FindLocation();
		try {
			return (al.Matala2_Algo2User(folder1, mac1, mac2, mac3, sig1, sig2, sig3));
		} catch (IOException e) {
			e.printStackTrace();
			return ("There is a problem in Algo2"); 
		}
	}

	/**
	 * The function implements read wigle wifi files 
	 * @param folder
	 * @param Mac
	 * @return
	 */

	public ArrayList<MacBig_Container> readWigle(File folder){
		if (folder.isDirectory()){
			//final String str=path;
			ReadAndWrite k = new ReadAndWrite();
			folow_folder(""+folder);
			Thread y = new Thread(new Runnable(){

				public void run() {
					// TODO Auto-generated method stub
					synchronized (macs) {
						try {
							macs.addAll(k.readingFolderWigle(folder));
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
	/**
	 * The function implements read file with 46 cols
	 * @param folder
	 * @param Mac
	 * @return
	 */
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
	/**
	 * The function returns how many Macs and rows there are
	 * @param macs
	 * @return
	 * @throws IOException 
	 */
	public String MacAndRows (ArrayList<MacBig_Container> macs) throws IOException{
		return hash.HowMacAndRow(macs);
	}
	/**
	 * The function implements UNDO - return the Database before the filtering
	 * @return
	 */
	public ArrayList<MacBig_Container> UNDO(){
		return ChooseFilter.UNDO_(this.macs,this.macsBefore);
	}
	/**
	 * The function implements clear
	 * @return
	 */
	public ArrayList<MacBig_Container> CLEAR(){
		this.macsBefore.clear();
		this.macs.clear();
		return macs;
	}

	public void readfilters(Connect c){
		filters_writeAndRead.ReadObject("matala two\\filter that have been choose.txt",c);
	}

//	public void sql(String ip, String url, String user, String password){
//		Thread t = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				synchronized (macs) {
//					folow_sql(ip,url,user,password);
//					macs.addAll(MySql.test_ex4_db(ip,url,password,user));
//					macsBefore = new ArrayList<MacBig_Container>();
//					macsBefore.addAll(macs);
//					douplicate();
//				}
//			}
//		});t.start();
//
//	}

//	public void check_sql (MySql s){
//		Thread t = new Thread(new Runnable() {
//			 Statement st = null;
//			 ResultSet rs = null;
//			 ResultSet temp = null;
//
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//
//				try {     
//					s.set_con( DriverManager.getConnection(s.get_url(),s.get_user(), s.get_password()));
//					st =s.get_con().createStatement();
//					rs = st.executeQuery("SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'oop_course_ariel' AND TABLE_NAME = 'ex4_db'");
//					boolean flag = true;
//					while(flag){
//						s.set_con( DriverManager.getConnection(s.get_url(),s.get_user(), s.get_password()));
//						st =s.get_con().createStatement();
//						temp = st.executeQuery("SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'oop_course_ariel' AND TABLE_NAME = 'ex4_db'");
//						if(!temp.equals(rs)){
//							database(macs);
//							flag=false;
//							Thread.interrupted();
//							check_sql(s);
//
//						}
//						Thread.sleep(2000);
//					}
//				}
//				catch (Exception e) {
//					// TODO: handle exception
//				}
//			}
//		
//		}); t.start();
//
//	}
	
	
	/**
	 * the function follow on the change on SQL.
	 * @param a
	 */
	public void checkForChange (MySql a) {
		//ArrayList<Scan> data = new ArrayList<>();
		Thread t = new Thread(new Runnable() {
			Statement st ;
			int rs ;
			public void run() {
				// TODO Auto-generated method stub

				try { 
					while(true) {
						a.set_con( DriverManager.getConnection(a.get_url(), a.get_user(), a.get_password()));
						st = a.get_con().createStatement();
						rs = st.executeUpdate("\"SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'oop_course_ariel' AND TABLE_NAME = 'ex4_db'\"); ");
						if (rs!=0) {
							database(macs);
							Thread.interrupted();
							
						}
						Thread.sleep(2000);
					}
				}
				catch (Exception e) {
					// TODO: handle exception
				}

			}
		}); t.start();

	}
}






//display=NRD90M.G950FXXU1AQJ5
//lat=32.10246120400514
//lon=35.209976991172944
