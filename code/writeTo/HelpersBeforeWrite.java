package writeTo;

import java.util.ArrayList;

import algo1and2.Formulas;
import objects.LineOfInfo;
import objects.MacBig;
import objects.MacBig_Container;

/**
 * This class contains functions that previous and helps the writing to csv.
 *
 */

public class HelpersBeforeWrite {
	
	/**
	 * This function sort arraylist of LineOfInfo type and copying up to ten better wifi network to answer(answer on ArrayList<String[]> type).
	 * @param information
	 * @param arrLineOfInfo
	 * @param answer
	 * @param indexOfRow
	 * @param realsize
	 * @param sarr
	 */
	public static void CopyingToAnswer(ArrayList<LineOfInfo> arrLineOfInfo,
		ArrayList<String[]> answer,int indexOfRow,int realsize,int sarr,String[] infoofLine){
		int ssid=6;
		int mac=7;
		int frequncy=8;
		int signal=9;		
		int networks=0;
		
		arrLineOfInfo.sort(null);
		
		for (int i = 0; i < realsize; i++) {
			infoofLine[ssid]=arrLineOfInfo.get(i).SSID;
			ssid=ssid+4;
			networks++;
		}
		infoofLine[5]="" + networks;

		for (int i = 0; i < realsize; i++) {
			infoofLine[mac]=arrLineOfInfo.get(i).MAC;
			mac=mac+4;
		}
		for (int i = 0; i < realsize; i++) {
			infoofLine[frequncy]=From_Channel_To_Frequency(arrLineOfInfo.get(i).Channel);
			frequncy=frequncy+4;
		}
		for (int i = 0; i < realsize; i++) {
			infoofLine[signal]=arrLineOfInfo.get(i).RSSI;
			signal=signal+4;
		}
		answer.add(infoofLine);
		
	}
	
	/**
	 * This function copying values from information (in type ArrayList<String[]>) to array of String type.
	 * @param information
	 * @param answer
	 * @param indexOfRow
	 * @param realsize
	 * @return the array String.
	 */
	public static String[] CopyingToAnswerFirst(ArrayList<String[]> information,ArrayList<String[]> answer,int indexOfRow,  int realsize){
		String[] line = new String[46];
		line[0] = information.get(indexOfRow)[3];
		line[1] = information.get(0)[5];
		line[2] = information.get(indexOfRow)[6];
		line[3] = information.get(indexOfRow)[7];
		line[4] = information.get(indexOfRow)[8];
		line[5] = "" + realsize;

		return line;
	}


	/**
	 * This function converting from channel type to frequency type by formula.
	 * @param getting channel from String type.
	 * @return frequency from String type.
	 */
	public static String From_Channel_To_Frequency(String channel){
		String ans;
		if ((Integer.parseInt(channel)>=1)&&(Integer.parseInt(channel)<=14)){
			ans = "" + ((Integer.parseInt(channel)-1) * 5 + 2412);
			return ans;
		}
		else if (((Integer.parseInt(channel)>=36)&&(Integer.parseInt(channel)<=165))){
			ans = "" + ((Integer.parseInt(channel)-34)*5 + 5170);

			return ans;
		}
		else {
			return "";
		}
	}
	
	/**
	 * The function create line of the Headers of values
	 * @return the line with the Headers of values
	 */
	public static String[] MadeLine(){
		String[] line = new String[46];
		line[0] = "Time";
		line[1] = "ID";
		line[2] = "Lat";
		line[3] = "Lon";
		line[4] = "Alt";
		line[5] = "#WiFi networks";
		String helper1 = "SSID";
		String helper2 = "MAC";
		String helper3 = "Frequncy";
		String helper4 = "Signal";
		int hel = 1;

		for (int i = 6; i < line.length; i=i+4) {
			line[i] = helper1 + hel;
			hel++;
		}
		hel = 1;
		for (int i = 7; i < line.length; i=i+4) {
			line[i] = helper2 + hel;
			hel++;
		}
		hel = 1;
		for (int i = 8; i < line.length; i=i+4) {
			line[i] = helper3 + hel;
			hel++;
		}
		hel = 1;
		for (int i = 9; i < line.length; i=i+4) {
			line[i] = helper4 + hel;
			hel++;
		}

		return line;

	}
	
	/**
	 * This function copying all of the relevant values from information to answer.
	 * this function use arraylist of String[] type. so it call another functions for doing it.
	 * @param information
	 * @param answer
	 * @param r
	 */
	public static void Save_info(ArrayList<String[]> information,ArrayList<String[]> answer){
		int TimePlace = FindIndex.PlaceArticle(information,"FirstSeen",1);
		int LatPlace = FindIndex.PlaceArticle(information,"CurrentLatitude",1);
		int LonPlace = FindIndex.PlaceArticle(information,"CurrentLongitude",1);
		int WifiPlace = FindIndex.PlaceArticle(information,"Type",1);
		ArrayList<LineOfInfo> arrLineOfInfo = new ArrayList<LineOfInfo>();
		int r=1;
		while (r<information.size()){
			if ((information.get(r)[WifiPlace]).equals("WIFI")){
				if (r<information.size()-1&&(information.get(r+1)[WifiPlace]).equals("WIFI")&&information.get(r)[LatPlace].equals(information.get(r+1)[LatPlace])
						&& information.get(r)[LonPlace].equals(information.get(r+1)[LonPlace]) 
						&& information.get(r)[TimePlace].equals(information.get(r+1)[TimePlace])){

					LineOfInfo line= new LineOfInfo(information,r);
					arrLineOfInfo.add(line);

				}

//				else if (((r<=information.size()-1)&&(information.get(r)[WifiPlace]).equals("WIFI"))&&
//						(information.get(r)[LatPlace].equals(information.get(r+1)[LatPlace])
//								|| information.get(r)[LonPlace].equals(information.get(r+1)[LonPlace]) 
//								|| information.get(r)[TimePlace].equals(information.get(r+1)[TimePlace]))){
				else{
					LineOfInfo line= new LineOfInfo(information,r);
					arrLineOfInfo.add(line);

					if(arrLineOfInfo.size() >= 10){
						String infoofLine[]=HelpersBeforeWrite.CopyingToAnswerFirst(information,answer,r,arrLineOfInfo.size());
						HelpersBeforeWrite.CopyingToAnswer(arrLineOfInfo ,answer,r,10,arrLineOfInfo.size(),infoofLine);

						arrLineOfInfo.clear();
					}
					else{
						String infoofLine[]=HelpersBeforeWrite.CopyingToAnswerFirst(information,answer,r,arrLineOfInfo.size());
						HelpersBeforeWrite.CopyingToAnswer(arrLineOfInfo,answer,r,arrLineOfInfo.size(),arrLineOfInfo.size(),infoofLine);
						arrLineOfInfo.clear();

					}
				}
			}
			r++;
		}
	}
	
	/**
	 * This function help algo1 before converting to csv.
	 * it calculate Weighted average for any mac(value numbers of any X better mac was given) .
	 * @param macs
	 * @return
	 */
	public static MacBig[] FixingBeforeCsv (ArrayList<MacBig_Container> macs){
		double weight;
		double walt;
		double wlon;
		double wlat;
		MacBig []fixed = new MacBig[macs.size()];
		MacBig []helper ;
		int k=0;
		for (int i = 0; i < macs.size(); i++) {
			helper = new MacBig[macs.get(i).realsize];
			k=0;
			for (int j = 0; j < macs.get(i).realsize; j++) {
				weight=Formulas.weight(Integer.parseInt(macs.get(i).arr_macbig[j].Signal));
				wlat=Formulas.walt(weight, Double.parseDouble(macs.get(i).arr_macbig[j].lat));
				wlon=Formulas.walt(weight, Double.parseDouble(macs.get(i).arr_macbig[j].lon));
				walt=Formulas.walt(weight, Double.parseDouble(macs.get(i).arr_macbig[j].alt));
				MacBig t = new MacBig();
				t.alt = ""+walt;
				t.lat = ""+wlat;
				t.lon = ""+wlon;
				t.Signal = ""+weight;
				helper[k]=t;
				k++;
			}
			MacBig hel = new MacBig();
			hel.lat = ""+Formulas.sumOfLat(helper,macs.get(i).realsize);
			hel.lon = ""+Formulas.sumOfLon(helper,macs.get(i).realsize);
			hel.alt = ""+Formulas.sumOfAlt(helper,macs.get(i).realsize);
			hel.Signal = ""+Formulas.sumOfWeight(helper,macs.get(i).realsize);
			hel.Mac = ""+macs.get(i).arr_macbig[0].Mac;
			hel.ssid = ""+macs.get(i).arr_macbig[0].ssid;
			hel.ID = ""+macs.get(i).arr_macbig[0].ID;
			hel.time = ""+macs.get(i).arr_macbig[0].time;
			hel.frequency = ""+macs.get(i).arr_macbig[0].frequency;
			fixed[i] = hel;
			//System.out.println((fixed[i].toString()));
		}
		return fixed;
	}
	
}