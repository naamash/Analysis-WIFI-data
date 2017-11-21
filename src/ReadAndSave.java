import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class get folder of files, read them, sort them, and convert them to one CSV sorted file.
 * @author 
 *
 */

public class ReadAndSave {

	/**
	 * This function get folder of files and sort it for getting only relevant files of CSV type.
	 * for doing that the function call another functions from it's class and from another classes on this package.
	 * at the end , the function convert all of the sorted information to new CSV file.
	 * 
	 * https://stackoverflow.com/questions/11496700/how-to-use-printwriter-and-file-classes-in-java
	 * https://stackoverflow.com/questions/11485311/how-can-a-fileinputstream-get-the-content-of-file
	 * 
	 * @param folder
	 * @return
	 * @throws IOException
	 */

	public static String[][] readingFile(File folder) throws IOException{	

		ArrayList<String[]> answer = new ArrayList<>();

		String[] line = new String[46];

		File[] listOfFiles = folder.listFiles();
		String [][]information ;
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

		answer.add(line);

		int r=2;

		boolean flag = false;

		for (int i = 0; i < listOfFiles.length; i++) {

			flag = false;

			try {

				if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains("csv")) {
					File f = new File(listOfFiles[i].getPath());
					FileInputStream fi = new FileInputStream(f);
					Scanner sc = new Scanner(fi);
					int m = 0;
					int row = 0;
					BufferedReader read = new BufferedReader(new FileReader(listOfFiles[i].getPath()));
					while (read.readLine() != null) {
						row++;
					}
					read.close();

					information = new String[row][12];
					r = 2;

					while (sc.hasNext()) {
						String str = sc.nextLine();
						information[m] = str.split(",");
						try {
							if ((information[0][0].contains("WigleWifi-1.4")) && (!(information[0][0].equals(null)))
									&& (!(information[0][1].equals(null)))) {
								m++;
							}
							else{
								throw new IOException();
							}

						}
						catch (Exception e) {
							flag = true;
							System.err.println("The file " + listOfFiles[i].getName() + " is illegal!!");
						}
					}

					if(flag)
						continue;


					Save_info(information, answer, r);

					sc.close();
					fi.close();

				}

				else {
					//if (!(listOfFiles[i].isFile()) || !(listOfFiles[i].getName().contains("csv"))){
					throw new IOException(); 
				}
			}
			catch (Exception e) {
				System.err.println("File " + listOfFiles[i].getName() + " is not csv file!");
			}
		}

		String [][]Answer_One = new String [answer.size()][46];
		int ansRows = 0;
		for (int i = 0; i < Answer_One.length; i++) {
			for (int j = 0; j < Answer_One[0].length; j++) {
				Answer_One[i][j] = answer.get(ansRows)[j];
			}
			ansRows++;
		}
		//Sorting.printanswer(Answer_One);

		FileWriter write = new FileWriter("C:\\Users\\hadar\\Desktop\\Answer_Of_Matala_Zero.csv");
		PrintWriter pw = new PrintWriter(write);
		for (int i = 0; i < Answer_One.length; i++) {
			for (int j = 0; j < Answer_One[0].length; j++) {
				write.append(answer.get(i)[j]);
				write.append(",");
			}
			pw.println();
		}
		write.close();

		return Answer_One;
	}

	/**
	 * This function copying all of the relevant values from information matrix to answer.
	 * this function use arraylist of String[] type. so it call another functions for doing it.
	 * @param information
	 * @param answer
	 * @param r
	 */
	public static void Save_info(String [][]information,ArrayList<String[]> answer,int r){
		int TimePlace = Place(information,"FirstSeen");
		int LatPlace = Place(information,"CurrentLatitude");
		int LonPlace = Place(information,"CurrentLongitude");
		int WifiPlace = Place(information,"Type");
		ArrayList<LineOfInfo> arrLineOfInfo = new ArrayList<>();

		while (r<information.length-1){

			if (information[r][LatPlace].equals(information[r+1][LatPlace]) && information[r][LonPlace].equals(information[r+1][LonPlace]) 
					&& information[r][TimePlace].equals(information[r+1][TimePlace]) && (information[r][WifiPlace]).equals("WIFI")){

				LineOfInfo line= new LineOfInfo(information,r);
				arrLineOfInfo.add(line);
			}

			else if ((information[r][WifiPlace]).equals("WIFI")){
				LineOfInfo line= new LineOfInfo(information,r+1);
				arrLineOfInfo.add(line);

				if(arrLineOfInfo.size() >= 10){
					CopyingToAnswer(information,answer,r+1,arrLineOfInfo.size());
					Copying.CopyingToAnswer(information,arrLineOfInfo ,answer,r+1,10,arrLineOfInfo.size());

					arrLineOfInfo = new ArrayList<>();
				}
				else{
					CopyingToAnswer(information,answer,r+1,arrLineOfInfo.size());
					Copying.CopyingToAnswer(information,arrLineOfInfo,answer,r+1,arrLineOfInfo.size(),arrLineOfInfo.size());
					arrLineOfInfo = new ArrayList<>();
				}

			}
			r++;
		}
	}

	/**
	 * This function copying values from information matrix to array of String type.
	 * @param information
	 * @param answer
	 * @param indexOfRow
	 * @param realsize
	 * @return the array String.
	 */

	public static String[] CopyingToAnswer(String information[][],ArrayList<String[]> answer,int indexOfRow,  int realsize){
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
	 * This function getting matrix of String type, and String name.
	 * The function search the String name on the matrix and return the index of this.
	 * @param answer
	 * @param name
	 * @return
	 */
	public static int Place (String [][]information, String name){
		for (int i = 0; i <11; i++) {
			if(information[1][i].equals(name)){
				return i;
			}
		}
		return -1;
	}

	public static void Decide() throws IOException{
		boolean flag1 = true;
		while(flag1){
			try {
				Scanner folderr = new Scanner((System.in));
				System.out.println("enter folder name");
				String foldername = folderr.nextLine();
				File folder = new File(foldername);
				ReadAndSave.readingFile(folder);
				flag1 = false;
			} catch (Exception e) {
				System.err.println("This folder does'nt exist! try again.");
			}
		}
//		Scanner p = new Scanner(System.in);
//		System.out.println("Please write where you want to save the CSV file");
//		String place = p.next() + "\\Answer_Of_Matala_Zero.csv";
		File file = new File("C:\\Users\\hadar\\Desktop\\Answer_Of_Matala_Zero.csv");
		boolean flag = true;
		while (flag){

			Scanner sc = new Scanner((System.in));
			System.out.println("enter: 1 to sortByTime , 2 to sortByLocation or 3 to sortById");
			int a = sc.nextInt();

			if (a == 1) {
				Scanner timeSt = new Scanner((System.in));
				Scanner timeEn = new Scanner((System.in));
				System.out.println("enter begining");
				String timestart = timeSt.nextLine();
				System.out.println("enter end");
				String timeend = timeEn.nextLine();
				try {
					Sorting.SortByTime(file, timestart, timeend);
				} catch (Exception e) {
					e.printStackTrace();
				}
				flag = false;

			} else if (a == 2) {
				Scanner location = new Scanner((System.in));
				System.out.println("enter lat");
				String locationstart = location.nextLine();
				System.out.println("enter lon");
				String locationend = location.nextLine();
				System.out.println("enter radious");
				double radious = location.nextDouble();
				Sorting.SortByLocation(file, locationstart, locationend, radious);
				flag = false;					
			} else if (a == 3) {
				Scanner id = new Scanner((System.in));
				System.out.println("enter id");
				String idName = id.nextLine();
				Sorting.SortByID(file, "display=" + idName);
				flag = false;					
			} 
		}
	}
}