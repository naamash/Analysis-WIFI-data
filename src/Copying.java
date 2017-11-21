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

	public static void CopyingToAnswer(String [][]information ,ArrayList<LineOfInfo> arrLineOfInfo,ArrayList<String[]> answer,
		int indexOfRow,int realsize,int sarr){
		int ssid=6;
		int mac=7;
		int frequncy=8;
		int signal=9;		
		int networks=0;

		arrLineOfInfo.sort(null);
		
		String[] line = ReadAndSave.CopyingToAnswer(information,answer,indexOfRow,arrLineOfInfo.size());

		for (int i = 0; i < realsize; i++) {
			line[ssid]=arrLineOfInfo.get(i).SSID;
			ssid=ssid+4;
			networks++;
		}
		line[5]="" + networks;

		for (int i = 0; i < realsize; i++) {
			line[mac]=arrLineOfInfo.get(i).MAC;
			mac=mac+4;
		}
		for (int i = 0; i < realsize; i++) {
			line[frequncy]=From_Channel_To_Frequency(arrLineOfInfo.get(i).Channel);
			frequncy=frequncy+4;
		}
		for (int i = 0; i < realsize; i++) {
			line[signal]=arrLineOfInfo.get(i).RSSI;
			signal=signal+4;
		}
		answer.add(line);
	}

	/**
	 * This function converting from channel type to frequency type by ormula.
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
//
//	/**
//	 * The function copying all the relevant values to ArrayList<String[]> matrix2.
//	 * @param lines
//	 * @param matrix2
//	 * @param indexOfRow
//	 * @param indexanswer
//	 */
//	
//	public static void CopyingToSorted(ArrayList<LineOfInfo> lines, ArrayList<String[]> matrix2,int indexOfRow,int indexanswer){
//		int ssid=6;
//		int mac=7;
//		int frequncy=8;
//		int signal=9;		
//		int networks=0;
//
//		for (int i = 0; i < lines.size(); i++) {
//			matrix2.get(indexanswer)[ssid]=lines.get(i).SSID;
//			ssid=ssid+4;
//			networks++;
//		}
//		matrix2.get(indexanswer)[5]="" + networks;
//
//		for (int i = 0; i < lines.size(); i++) {
//			matrix2.get(indexanswer)[mac]=lines.get(i).MAC;
//			mac=mac+4;
//		}
//		for (int i = 0; i < lines.size(); i++) {
//			matrix2.get(indexanswer)[frequncy]=lines.get(i).Channel;
//			frequncy=frequncy+4;
//		}
//		for (int i = 0; i < lines.size(); i++) {
//			matrix2.get(indexanswer)[signal]=lines.get(i).RSSI;
//			signal=signal+4;
//		}
//	}
//	

}