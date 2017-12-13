package pa;

import java.util.ArrayList;

/**
 * This class using function for copying relevant values to answer. 
 * @author 
 *
 */

public class Copying {
	
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
	 * This function copying values from information matrix to array of String type.
	 * @param information
	 * @param answer
	 * @param indexOfRow
	 * @param realsize
	 * @return the array String.
	 */
	public static String[] CopyingToAnswerFirst(String information[][],ArrayList<String[]> answer,int indexOfRow,  int realsize){
		String[] line = new String[46];
		line[0] = information[indexOfRow][3];
		line[1] = information[0][5];
		line[2] = information[indexOfRow][6];
		line[3] = information[indexOfRow][7];
		line[4] = information[indexOfRow][8];
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

}