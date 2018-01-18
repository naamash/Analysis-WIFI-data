package GUI;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import objects.Location;
import objects.MacBig;
import objects.MacBig_Container;

import java.sql.Statement;

/** 
 * This is a very simple example representing how to work with MySQL 
 * using java JDBC interface;
 * The example mainly present how to read a table representing a set of WiFi_Scans
 * Note: for simplicity only two properties are stored (in the DB) for each AP:
 * the MAC address (mac) and the signal strength (rssi), the other properties (ssid and channel)
 * are omitted as the algorithms do not use the additional data.
 * 
 */

public class MySql {
	private  String _ip = "5.29.193.52";
	private  String _url = "jdbc:mysql://"+_ip+":3306/oop_course_ariel";
	private  String _user = "oop1";
	private  String _password = "Lambda1();";
	private static  Connection _con = null;

	public static ArrayList<MacBig_Container> test_ex4_db(String _ip,String _url,String _password,String _user) {
		Statement st = null;
		ResultSet rs = null;
		int max_id = -1;
		ArrayList<MacBig_Container> macs = new ArrayList<MacBig_Container>();

		try {     
			_con = DriverManager.getConnection(_url, _user, _password);
			st = _con.createStatement();
			rs = st.executeQuery("SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'oop_course_ariel' AND TABLE_NAME = 'ex4_db'");
			if (rs.next()) {
				System.out.println("**** Update: "+rs.getString(1));
			}

			PreparedStatement pst = _con.prepareStatement("SELECT * FROM ex4_db");
			rs = pst.executeQuery();
			int ind=0;
			macs = new ArrayList<MacBig_Container>();
			while (rs.next()) {
				int size = rs.getInt(7);
				int len = 7+2*size;

				MacBig_Container line = new MacBig_Container();
				MacBig[] macArr = new MacBig[size+1];
				int j=1;
				MacBig mac = new MacBig();
				mac.time = rs.getString(j+1);
				mac.ID = rs.getString(j+2);
				mac.lat = rs.getString(j+3);
				mac.lon = rs.getString(j+4);
				mac.alt = rs.getString(j+5);
				mac.WIFI_Network = ""+size;
				for(int i=6;i<=len;i=i+2){
					mac.Mac = rs.getString(i);
					mac.Signal = rs.getString(i+1);
					macArr[j-1] = mac;
					j++;
				}
				line.arr_macbig=macArr;
				line.realsize=size;
				macs.add(line);
			}
			//			for (int i = 0; i < macs.size(); i++) {
			//				System.out.println(Arrays.toString(macs.get(i).arr_macbig));
			//			}
			ind++;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(MySql.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (st != null) { st.close(); }
				if (_con != null) { _con.close();  }
			} catch (SQLException ex) {

				Logger lgr = Logger.getLogger(MySql.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		System.out.println(macs.size());
		return macs;
	}

	public String get_ip() {
		return _ip;
	}

	public void set_ip(String _ip) {
		this._ip = _ip;
	}

	public String get_url() {
		return _url;
	}

	public void set_url(String _url) {
		this._url = _url;
	}

	public String get_user() {
		return _user;
	}

	public void set_user(String _user) {
		this._user = _user;
	}

	public String get_password() {
		return _password;
	}

	public void set_password(String _password) {
		this._password = _password;
	}

	public Connection get_con() {
		return _con;
	}

	public void set_con(Connection _con) {
		this._con = _con;
	}

}
