package pa;

import objects.MacBig;

public class Formulas {

	public static double weight (int signal){
		return (double)1/(signal*signal);
	}
	
	public static double walt (double weight,double value){
		return weight*value;
	}
	public static double sumOfAlt (MacBig[] helper,int realsize){
		double counter=0;
		for (int i = 0; i < realsize; i++) {
			counter+=Double.parseDouble(helper[i].alt);
		}
		return counter;
	}
	
	public static double sumOfLat (MacBig[] helper,int realsize){
		double counter=0;
		for (int i = 0; i < realsize; i++) {
			counter+=Double.parseDouble(helper[i].lat);
		}
		return counter;
	}
	
	public static double sumOfLon (MacBig[] helper,int realsize){
		double counter=0;
		for (int i = 0; i < realsize; i++) {
			counter+=Double.parseDouble(helper[i].lon);
		}
		return counter;
	}
	
	public static double sumOfWeight (MacBig[] helper,int realsize){
		double counter=0;
		for (int i = 0; i < realsize; i++) {
			counter+=Double.parseDouble(helper[i].Signal);
		}
		return counter;
	}
	
}
