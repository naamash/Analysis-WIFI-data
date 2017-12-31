package GUI;

import java.io.IOException;
import java.util.ArrayList;

import objects.MacBig_Container;
import writeTo.ReadAndWrite;

public class Conect {
	ArrayList<MacBig_Container> macs;
	
	
	
	
	public void addCSV(String path){
		try {
			this.macs=ReadAndWrite.readingFile46Col(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
