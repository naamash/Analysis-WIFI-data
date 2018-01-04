package GUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import filtersPack.AND_filter;
import filtersPack.Filter;
import filtersPack.OR_filter;
import objects.MacBig_Container;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;



public class filters_writeAndRead {


	public static void write_filter(String fileName,Filter[]filters){
		//		BufferedWriter bw = null;
		//		FileWriter fw = null;
		//
		//		try {
		//			fw=new FileWriter("savedFilters\\"+fileName+".txt");
		//			bw=new BufferedWriter(fw);
		//			bw.write(s);
		//		}
		//		catch(IOException e){
		//			System.out.println("error while write filter");
		//		}
		//		finally {
		//			try {
		//				if (bw != null)
		//					bw.close();
		//
		//				if (fw != null)
		//					fw.close();
		//
		//			} catch (IOException ex) {
		//				System.out.println("failed in close reader tools");
		//			}
		//
		//		}    
		//	}
		//
		//
		//	public static void read_filter(String path,ArrayList<MacBig_Container> macs){
		//		FileReader in=null;
		//		BufferedReader br=null;
		//		String line;
		//		try {
		//			in=new FileReader(path);
		//			br=new BufferedReader(in);
		//
		//			if((line=br.readLine())!=null){
		//				String []filtertype = line.split(",");
		//				Filter []filters = new Filter[3];
		//				if(filters[0].equals("Time")||filters[2].equals("Time")){
		//					
		//				}
		//				if(filtertype[1].equals("OR")){
		//					filters[1] = new OR_filter();
		//					
		//					//					CheckFilter.WhichOP(line,macs);
		//				}
		//			}
		//		}
		//		catch(IOException ex){
		//			System.out.println("not succed to read the file");
		//		}
		//		finally {
		//			try {
		//				in.close();
		//				br.close();
		//			}
		//			catch(IOException ex)
		//			{
		//				System.out.println("failed in close reader tools");
		//			}
		//		}
		//	}


		FileOutputStream f = null;
		ObjectOutputStream o;

		try {

			f = new FileOutputStream(fileName);
			o = new ObjectOutputStream(f);
			o.writeObject(filters);
			o.close();
			f.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**

	 * A function that get path and kind of operator as string and read

	 * the file with Serialization and cast the object to the correct operator

	 * @param path

	 * @param end

	 * @return

	 */

	public static Filter[] ReadObject(String path)
	{
		FileInputStream fi;
		ObjectInputStream oi;
		Filter[] filters= new Filter[3];

		try {
			fi = new FileInputStream(path);
			oi = new ObjectInputStream(fi);
			filters = (Filter[])(oi.readObject());
//			if(end.equals("A"))
//				filters[1] = (AND_filter)oi.readObject();
//
//			else if(end.equals("Non"))
//				filters[0] = (NonOperator)oi.readObject();
//
//			else if(end.equals("Not"))
//				filters = (NotOperator)oi.readObject();
//
//			else 
//				filters = (FilterNotFilterOperator)oi.readObject();

			oi.close();
			fi.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

		return filters;

	}

}


