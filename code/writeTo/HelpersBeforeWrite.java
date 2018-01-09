package writeTo;

import java.util.ArrayList;
import java.util.Arrays;

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
	public static void CopyingToAnswer(ArrayList<String[]> information,ArrayList<LineOfInfo> arrLineOfInfo,
			ArrayList<MacBig_Container> answer,int indexOfRow,int realsize,int sarr){
		
		//		int ssid=6;
		//		int mac=7;
		//		int frequncy=8;
		//		int signal=9;		
		//int networks=0;
//		for (int i = 0; i < information.size(); i++) {
//			System.out.println(Arrays.toString(information.get(i)));
//		}
		
//		System.out.println("*****************");
//		for (int i = 0; i < arrLineOfInfo.size(); i++) {
//				System.out.println(arrLineOfInfo.get(i).toString());
//
//		}
		MacBig[] infoofLine = new MacBig[10];
		int indexInfoOfLine=0;

		arrLineOfInfo.sort(null);
		
		for (int i = 0; i < realsize; i++) {
			MacBig With4values = new MacBig();
			With4values.time = information.get(indexOfRow)[3];
			With4values.ID = information.get(0)[5];
			With4values.lat = information.get(indexOfRow)[6];
			With4values.lon = information.get(indexOfRow)[7];
			With4values.alt = information.get(indexOfRow)[8];
			With4values.WIFI_Network = "" + realsize;
			With4values.ssid=arrLineOfInfo.get(i).SSID;
			With4values.Mac=arrLineOfInfo.get(i).MAC;
			With4values.frequency=From_Channel_To_Frequency(arrLineOfInfo.get(i).Channel);
			With4values.Signal=arrLineOfInfo.get(i).RSSI;
			infoofLine[indexInfoOfLine]=With4values;
			indexInfoOfLine++;	
		}
		MacBig_Container added = new MacBig_Container(infoofLine,realsize);
		answer.add(added);
//		for (int i = 0; i < answer.size(); i++) {
//			System.out.println(Arrays.toString(answer.get(i).arr_macbig));
//
//		}
	}

	/**
	 * This function copying values from information (in type ArrayList<String[]>) to array of String type.
	 * @param information
	 * @param answer
	 * @param indexOfRow
	 * @param realsize
	 * @return the array String.
	 */
	public static MacBig[] CopyingToAnswerFirst(ArrayList<String[]> information,int indexOfRow,  int realsize){
		MacBig With4values = new MacBig();
		MacBig[] line = new MacBig[realsize];
		With4values.time = information.get(indexOfRow)[3];
		With4values.ID = information.get(0)[5];
		With4values.lat = information.get(indexOfRow)[6];
		With4values.lon = information.get(indexOfRow)[7];
		With4values.alt = information.get(indexOfRow)[8];
		With4values.WIFI_Network = "" + realsize;
		line[0] = With4values;
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
	public static MacBig_Container MadeLine(){
		MacBig[] lineArticle = new MacBig[10];
		String helper1 = "SSID";
		String helper2 = "MAC";
		String helper3 = "Frequncy";
		String helper4 = "Signal";
		int j=0;
			for (int i = 1; i < 11; i++) {
				MacBig With4values = new MacBig();
				With4values.time = "Time";
				With4values.ID = "ID";
				With4values.lat = "Lat";
				With4values.lon = "Lon";
				With4values.alt = "Alt";
				With4values.WIFI_Network = "#WiFi networks";
				With4values.ssid = helper1 + i;
				With4values.Mac = helper2 + i;
				With4values.frequency = helper3 + i;
				With4values.Signal = helper4 + i;	
				lineArticle[j] = With4values;

				j++;
			}
		MacBig_Container line = new MacBig_Container(lineArticle,10);
		return line;
	}

	/**
	 * This function copying all of the relevant values from information to answer.
	 * this function use arraylist of String[] type. so it call another functions for doing it.
	 * @param information
	 * @param answer
	 * @param r
	 */
	public static void Save_info(ArrayList<String[]> information,ArrayList<MacBig_Container> answer){
		int TimePlace = FindIndex.PlaceArticleInfo(information,"FirstSeen",1);
		int LatPlace = FindIndex.PlaceArticleInfo(information,"CurrentLatitude",1);
		int LonPlace = FindIndex.PlaceArticleInfo(information,"CurrentLongitude",1);
		int WifiPlace = FindIndex.PlaceArticleInfo(information,"Type",1);
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
						//MacBig[] infoofLine=HelpersBeforeWrite.CopyingToAnswerFirst(information,r,arrLineOfInfo.size());
						HelpersBeforeWrite.CopyingToAnswer(information,arrLineOfInfo ,answer,r,10,arrLineOfInfo.size());

						arrLineOfInfo.clear();
					}
					else{
					//	MacBig[] infoofLine=HelpersBeforeWrite.CopyingToAnswerFirst(information,r,arrLineOfInfo.size());
						HelpersBeforeWrite.CopyingToAnswer(information, arrLineOfInfo,answer,r,arrLineOfInfo.size(),arrLineOfInfo.size());
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
				weight=Formulas.weight(Double.parseDouble(macs.get(i).arr_macbig[j].Signal));
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
			hel.Signal = ""+Formulas.sumOfWeight(helper,macs.get(i).realsize);
			hel.lat = ""+Formulas.sumOfLat(helper,macs.get(i).realsize)/Double.parseDouble(hel.Signal);
			hel.lon = ""+Formulas.sumOfLon(helper,macs.get(i).realsize)/Double.parseDouble(hel.Signal);
			hel.alt = ""+Formulas.sumOfAlt(helper,macs.get(i).realsize)/Double.parseDouble(hel.Signal);
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