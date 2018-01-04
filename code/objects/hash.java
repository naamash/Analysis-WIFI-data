package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map;

/**
 * This class made to help the GUI.
 * @author 
 *
 */

public class hash {
	ArrayList<MacBig_Container> answer;
	Map<String, ArrayList<MacBig_Container>> hash_map;

	/**
	 * defulte constractor
	 */
	public hash() {
		this.answer = new ArrayList<MacBig_Container>();
		this.answer.clear();
		this.hash_map = new HashMap<String, ArrayList<MacBig_Container>>();
	}

	/**
	 * This function implement hashmap.
	 * @return
	 */
	public Map<String, ArrayList<MacBig_Container>> hashmap() {
		Map<String, ArrayList<MacBig_Container>> find = new HashMap<String, ArrayList<MacBig_Container>>();
		for (int i = 1; i < this.answer.size(); i++) {
			for (int j = 0; j < (Integer.parseInt(this.answer.get(i).arr_macbig[0].WIFI_Network)) ; j++) {
				if (find.containsKey(this.answer.get(i).arr_macbig[j].Mac)){
					find.get(this.answer.get(i).arr_macbig[j].Mac).add(this.answer.get(i));
				}
				else {
					ArrayList<MacBig_Container> temp = new ArrayList<MacBig_Container>();
					temp.add(this.answer.get(i));
					find.put(this.answer.get(i).arr_macbig[j].Mac, temp);
				}
			}
		}
		return find;
	}

	/**
	 * Defined constructor
	 * @param scan
	 */
	public hash(ArrayList<MacBig_Container> scan) {
		this.answer = new ArrayList<MacBig_Container>();
		this.answer.clear();
		this.answer.addAll(scan);
		this.hash_map = new HashMap<String, ArrayList<MacBig_Container>>();
		this.hash_map = hashmap();
	}

	/**
	 * copying constractor
	 * @param other
	 */
	public hash(hash other) {
		this.answer = new ArrayList<MacBig_Container>();
		this.answer.addAll(other.answer);
		this.hash_map = hashmap();
	}

	/**
	 * 
	 * @return num of lines in hash
	 */
	public int numOfScan() {
		return this.answer.size();
	}

	/**
	 * 
	 * @return num of macs in the hash
	 */
	public int numOfmacs() {
		Map<String, ArrayList<MacBig_Container>> find = hashmap();
		return find.size();
	}

	/**
	 * duplicating 
	 */
	public void douplicate() {
		List<MacBig_Container> temp = new ArrayList<MacBig_Container>();
		for (int i = 0; i < this.answer.size(); i++) {
			if (!temp.contains(this.answer.get(i)))
				temp.add(this.answer.get(i));
		}
		this.answer.clear();
		this.answer.addAll(temp);
	}

	/**
	 * adding scan
	 * @param other
	 */
	public void addScan(MacBig_Container other) {
		if (!this.answer.contains(other))
			this.answer.add(other);
	}

	/**
	 * toString
	 */
	public String toString() {
		return this.answer.toString();
	}




	public static String HowMacAndRow (ArrayList<MacBig_Container> answer){
		ArrayList<MacBig_Container> macs = new ArrayList<MacBig_Container>();
		MacBig temp;
		boolean isIn = true;
		for (int r = 1; r < answer.size(); r++) {
			for (int i =0; i < answer.get(r).realsize ; i++) {
				isIn = true;
				int j = 0;
				temp = new MacBig();
				temp.time=answer.get(r).arr_macbig[i].time;
				temp.ID=answer.get(r).arr_macbig[i].ID;
				temp.lat=answer.get(r).arr_macbig[i].lat;
				temp.lon=answer.get(r).arr_macbig[i].lon;
				temp.alt=answer.get(r).arr_macbig[i].alt;
				temp.ssid=answer.get(r).arr_macbig[i].ssid;
				temp.Mac=answer.get(r).arr_macbig[i].Mac;
				temp.frequency=answer.get(r).arr_macbig[i].frequency;
				temp.Signal=answer.get(r).arr_macbig[i].Signal;

				while (j < macs.size() && isIn){
					if (macs.get(j).arr_macbig[0].Mac.equals(temp.Mac)){	
						isIn=false;
						MacBig macc = new MacBig(temp);
						macs.get(j).arr_macbig[macs.get(j).realsize] = macc;
						macs.get(j).realsize ++;
					}
					j++;
				}
				if (macs.size()==0){
					MacBig []s = new MacBig[10000];
					MacBig macc = new MacBig(temp);
					s[0] =macc;
					MacBig_Container tempNew=new MacBig_Container(s,1);
					macs.add(tempNew);
				}	
				else if ((isIn && j <= macs.size())){
					MacBig []s = new MacBig[10000];
					MacBig macc = new MacBig(temp);
					s[0] =macc;
					MacBig_Container tempNew=new MacBig_Container(s,1);
					macs.add(tempNew);

				}
			}
		}
		return "Number of Row:  " + answer.size() +"     Number of macs:  "+macs.size();
	}
}
