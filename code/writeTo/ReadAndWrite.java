package writeTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class get folder of files, read them and convert them to one CSV file after filtering them.
 * @author 
 *
 */

public class ReadAndWrite {

	/**
	 * This function get folder of files and filter it for getting only relevant files of CSV type.
	 * for doing that the function call another functions from it's class and from another classes from relevents package.
	 * 
	 * https://stackoverflow.com/questions/11496700/how-to-use-printwriter-and-file-classes-in-java
	 * https://stackoverflow.com/questions/11485311/how-can-a-fileinputstream-get-the-content-of-file
	 * 
	 * @param folder
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String[]> readingFile(File folder)  {	
		ArrayList<String[]> answer = new ArrayList<String[]>();

		File[] listOfFiles = folder.listFiles();
		ArrayList<String[]> information = new ArrayList<String[]>();
		
		answer.add(HelpersBeforeWrite.MadeLine());
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
					//					int row = 0;
					//					BufferedReader read = new BufferedReader(new FileReader(listOfFiles[i].getPath()));
					//					while (read.readLine() != null) {
					//						row++;
					//					}
					//					read.close();

					//information = new String[row][12];
					r = 2;
					while (sc.hasNext()) {
						String str = sc.nextLine();
						String []a = str.split(",");
						information.add(a) ;
						try {
							if ((information.get(0)[0].contains("WigleWifi-1.4")) && (!(information.get(0)[0].equals(null)))
									&& (!(information.get(0)[1].equals(null)))) {
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

					HelpersBeforeWrite.Save_info(information, answer);
					information = new ArrayList<String[]>(); 
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
		//		System.out.println("---------------------------------------size:  "+answer.size());
		//		FindLocation.checkMac(answer);
		//return WriteToCsv(answer);
		return answer;
	}
	

	/**
	 * The function accept array of String [] type and write it to csv file.
	 * The function return the ArrayList<String[]> after creating csv file 
	 * @param answer
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String[]> WriteToCsv(ArrayList<String[]> answer,String location) throws IOException{
		ArrayList<String[]> Answer_One = new ArrayList<String[]>();
		Answer_One.addAll(answer);
		FileWriter write = new FileWriter(location);
		PrintWriter pw = new PrintWriter(write);
		for (int i = 0; i < Answer_One.size(); i++) {
			for (int j = 0; j < Answer_One.get(i).length; j++) {
				write.append(Answer_One.get(i)[j]);
				write.append(",");
			}
			pw.println();
		}
		write.close();
		System.out.println("completed Csv");
		return Answer_One;
	}

	
}