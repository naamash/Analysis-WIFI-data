package algo1and2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import filters.HelpFilter;
import objects.Location;
import objects.MacBig;
import objects.MacBig_Container;
import writeTo.HelpersBeforeWrite;
import writeTo.ReadAndWrite;

public class FindLocation {
    int test =5 ;
	static int IndexSignalInfo=9;
	static int IndexMacInfo=7;
	static int IndexWifiNetworkInfo=5;

	static int IndexLatInfo=2;
	static int IndexLonInfo=3;
	static int IndexAltInfo=4;

	static int IndexMacAnswer=7;
	static int IndexWifiNetworkAnswer=5;

	static int IndexAltAnswer=4;
	static int IndexLonAnswer=3;
	static int IndexLatAnswer=2;

	static double sig_diff = 0.4;
	static double power = 2;
	static int norm = 10000;
	static int min_diff = 3;
	static int no_signal = -120;
	static int Number_of_loc = 4;
	/**
	 * This function get folder and String location.
	 * The function read the files from the folder calculate the Weighted average for any MAC and convert it to csv file.
	 * it calls to another function for doing this.
	 * @param folder
	 * @param locationAlgo1
	 * @throws IOException
	 */
	public static void Matala2_Algo1 (File folder,String locationAlgo1) throws IOException{
		ArrayList<String[]> answer = new ArrayList<String[]>();
		ArrayList<MacBig_Container> macs = new ArrayList<MacBig_Container>();

		answer = ReadAndWrite.readingFile(folder);

		for (int j = 1; j < answer.size(); j++) {
			macs = HelpFilter.SaveTheLargestSIGNAL(macs, answer, j);
		}
		MacBig[] MacsAfterFormulas = new MacBig[macs.size()];
		MacsAfterFormulas = HelpersBeforeWrite.FixingBeforeCsv(macs);
		for (int i = 0; i < MacsAfterFormulas.length; i++) {
			System.out.println(MacsAfterFormulas[i].toString());
		}

		WriteToCsv_Matala2_parta(MacsAfterFormulas,locationAlgo1);
	}

	/**
	 * This function get two folders-one with dataBase and the second with the lesses values.
	 * The function take all MACs in line on files in the second folder, and calculate the Weighted 
	 * average after searching the values of them in the dataBase folder.
	 * it calls to another function for doing this.
	 * @param folder1
	 * @param folder2
	 * @param locationAlgo2
	 * @throws IOException
	 */
	public static void Matala2_Algo2 (File folder1 ,File folder2, String locationAlgo2) throws IOException{
		ArrayList<String[]> answer = new ArrayList<String[]>();
		ArrayList<String[]> information2 = new ArrayList<String[]>();

		answer = ReadAndWrite.readingFile(folder1);
		information2 = readingFileOfTwo_(folder2);

		checkMac(answer,information2);
		ReadAndWrite.WriteToCsv(information2,locationAlgo2);

	}

	/**
	 * The function check the MACs for each line and search the values in answer about it. 
	 * The function take the three biggest values and calculate the Weighted average. 
	 * after that, it enter to information2 the values after calculating.
	 * At the end, the function convert information2 to csv file. 
	 * @param answer -  all the database
	 * @param information2 -  the file with the lesses values
	 * @param locationAlgo2 - the location that the file will be saved there
	 * @throws IOException
	 */
	public static void checkMac (ArrayList<String[]> answer ,ArrayList<String[]> information2) throws IOException{
		ArrayList<String[]> ArrAnswerLine = new ArrayList<String[]>();
		ArrayList<Location> ArrLocation = new ArrayList<Location>();
		boolean []isTuched = new boolean[answer.size()];

		int colm=0;
		int row=0;
		String MacInfo="";
		String SignalInfo="";

		for (int j = 0; j < information2.size(); j++) {
			ArrAnswerLine = new ArrayList<String[]>();
			ArrLocation = new ArrayList<Location>();
			isTuched = new boolean[answer.size()];
			String [][]MacAndSigInfo2 = new String [2][Integer.parseInt(information2.get(j)[IndexWifiNetworkInfo])];
			colm=0;
			row=0;
			for (int i = IndexMacInfo; i < ((Integer.parseInt(information2.get(j)[IndexWifiNetworkInfo])*4)+IndexWifiNetworkInfo) ; i=i+4) {
				MacInfo=information2.get(j)[i];
				SignalInfo=information2.get(j)[i+2];
				MacAndSigInfo2[row][colm]=MacInfo;
				MacAndSigInfo2[row+1][colm]=SignalInfo;
				row=0;
				colm++;
			}
			ArrAnswerLine = SearchMacInAnswer(MacAndSigInfo2,ArrLocation,answer,ArrAnswerLine,isTuched);
			CreateArrLocation(ArrLocation, ArrAnswerLine, MacAndSigInfo2);
			ArrLocation.sort(null);
			Location W_sum = WSUM(ArrLocation);
			information2.get(j)[IndexLatInfo] = W_sum.Lat;
			information2.get(j)[IndexAltInfo] = W_sum.Alt;
			information2.get(j)[IndexLonInfo] = W_sum.Lon;
		}
	}

	/**
	 * The function get ArrayList<Location> ArrLocation and calculate WSUM by using Formulas. 
	 * @param ArrLocation - arraylist of Location type
	 * @return object of Location type with the calculated values.
	 */
	public static Location WSUM (ArrayList<Location> ArrLocation){
		Location W_sum = new Location();
		double sumAlt=0;
		double sumLat=0.0;
		double sumLon=0.0;
		double weight=0.0;
		int size;
		
		if (ArrLocation.size()>=Number_of_loc){
			size = Number_of_loc;
		}
		else{
			size = ArrLocation.size();
		}
		for (int i = 0; i < size; i++) {
			sumAlt+=Formulas.walt(Double.parseDouble(ArrLocation.get(i).PI), Double.parseDouble(ArrLocation.get(i).Alt));
			sumLat+=Formulas.walt(Double.parseDouble(ArrLocation.get(i).PI), Double.parseDouble(ArrLocation.get(i).Lat));
			sumLon+=Formulas.walt(Double.parseDouble(ArrLocation.get(i).PI), Double.parseDouble(ArrLocation.get(i).Lon));
			weight+=Double.parseDouble(ArrLocation.get(i).PI);
		}

		W_sum.Alt=""+sumAlt/weight;
		W_sum.Lat=""+sumLat/weight;
		W_sum.Lon=""+sumLon/weight;
		return W_sum;	
	}

	/**
	 *This function get folder of files and filter it for getting only relevant files of CSV type.
	 *for doing that the function call another functions from it's class and from another classes from relevents package.
	 * 
	 * @param folder
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String[]> readingFileOfTwo_(File folder) throws IOException  {	
		ArrayList<String[]> information2 = new ArrayList<String[]>();
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			try {
				if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains("csv")) {
					File f = new File(listOfFiles[i].getPath());
					FileInputStream fi = new FileInputStream(f);
					Scanner sc = new Scanner(fi);
					BufferedReader read = new BufferedReader(new FileReader(listOfFiles[i].getPath()));
					read.close();

					while (sc.hasNext()) {
						String str = sc.nextLine();
						String[] line = str.split(",");
						information2.add(line);
					}
					sc.close();
					fi.close();
				}
				else {
					throw new IOException(); 
				}
			}
			catch (Exception e) {
				System.err.println("File " + listOfFiles[i].getName() + " is not csv file!");
			}
		}
		return information2;
	}


	/**
	 * This function search the MACs of the line(information2) in the dataBase files(answer) 
	 * and add each line that contains at least one of the Macs to ArrAnswerLine  
	 * @param MacAndSigInfo2
	 * @param ArrLocation
	 * @param answer
	 * @param ArrAnswerLine
	 * @param isTuched
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String[]> SearchMacInAnswer (String [][]MacAndSigInfo2,ArrayList<Location> ArrLocation,
			ArrayList<String[]> answer, ArrayList<String[]> ArrAnswerLine,boolean []isTuched) throws IOException{
		for (int i = 1; i < answer.size(); i++) {
			boolean flag = false;
			for (int j = IndexMacAnswer; j <(Integer.parseInt(answer.get(i)[IndexWifiNetworkAnswer])*4)+IndexWifiNetworkAnswer; j+=4) {
				for (int k = 0; k < MacAndSigInfo2[0].length; k++) {
					flag = false;
					if (MacAndSigInfo2[0][k].equals(answer.get(i)[j])){
						flag = true;
						ArrAnswerLine.add(answer.get(i));
						isTuched[i] = true;
					}
				}
			}
		}

		return ArrAnswerLine;
	}
	
	/**
	 * The function create arraylist of Location type.
	 * the function scanning ArrAnswerLine ,calculate PI and copying the relevant values (alt, lat, lon and PI) to ArrayList<Location> ArrLocation.
	 * @param ArrLocation
	 * @param ArrAnswerLine
	 * @param MacAndSigInfo2
	 */
	public static void CreateArrLocation (ArrayList<Location> ArrLocation,  ArrayList<String[]> ArrAnswerLine,String [][]MacAndSigInfo2){
		Location line = new Location();

		for (int i = 0; i < ArrAnswerLine.size(); i++) {
			double PI=1;
			line = new Location();
			for (int j = IndexMacAnswer; j <(Integer.parseInt(ArrAnswerLine.get(i)[IndexWifiNetworkAnswer])*4)+IndexWifiNetworkAnswer; j+=4) {
				for (int h = 0; h < MacAndSigInfo2[0].length; h++) {
					if(ArrAnswerLine.get(i)[j].equals(MacAndSigInfo2[0][h])){
						PI=Formulas.CalculatePI(Integer.parseInt(MacAndSigInfo2[1][h]),Integer.parseInt(ArrAnswerLine.get(i)[j+2]),PI);
					}
					else{
						PI=Formulas.CalculatePI(Integer.parseInt(MacAndSigInfo2[1][h]),no_signal,PI);
					}
				}
			}
			line.PI=""+PI;
			line.Alt=ArrAnswerLine.get(i)[IndexAltAnswer];
			line.Lat=ArrAnswerLine.get(i)[IndexLatAnswer];
			line.Lon=ArrAnswerLine.get(i)[IndexLonAnswer];
			ArrLocation.add(line);
		}
	}

/**
 * The function write to csv file the algo1 after calculation.
 * @param MacsAfterFormulas
 * @param locationAlgo1
 * @throws IOException
 */
	public static void WriteToCsv_Matala2_parta(MacBig[] MacsAfterFormulas,String locationAlgo1) throws IOException{
		int IndexIndex = 0;
		int MacIndex = 1;
		int SsidIndex = 2;
		int FreqIndex = 3;
		int SignalIndex = 4;
		int LonIndex = 5;
		int LatIndex = 6;
		int AltIndex = 7;
		int TimeIndex = 8;

		String [][]Answer_One = new String [MacsAfterFormulas.length][9];
		int ansRows = 0;
		for (int i = 0; i < Answer_One.length; i++) {
			Answer_One[i][IndexIndex] = ""+ansRows;
			Answer_One[i][MacIndex] = MacsAfterFormulas[i].Mac;
			Answer_One[i][SsidIndex] = MacsAfterFormulas[i].ssid;
			Answer_One[i][FreqIndex] = MacsAfterFormulas[i].frequency;
			Answer_One[i][SignalIndex] = MacsAfterFormulas[i].Signal;
			Answer_One[i][LonIndex] = MacsAfterFormulas[i].lon;
			Answer_One[i][LatIndex] = MacsAfterFormulas[i].lat;
			Answer_One[i][AltIndex] = MacsAfterFormulas[i].alt;
			Answer_One[i][TimeIndex] = MacsAfterFormulas[i].time;
			ansRows++;
		}

		FileWriter write = new FileWriter(locationAlgo1);
		PrintWriter pw = new PrintWriter(write);
		for (int i = 0; i < Answer_One.length; i++) {
			for (int j = 0; j < Answer_One[0].length; j++) {
				write.append(Answer_One[i][j]);
				write.append(",");
			}
			pw.println();
		}
		write.close();
		System.out.println("completed writing to csv the best macs");
	}
}
