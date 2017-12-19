package algo1and2;

import objects.MacBig;
/**
 * This class contains calculate functions.
 *
 */
public class Formulas {

	/**
	 * This function calculate weight.
	 * @param signal
	 * @return
	 */
	public static double weight (int signal){
		return (double)1/(signal*signal);
	}
	
	/**
	 * This function calculate walt, wlat, wlon.
	 * @param weight
	 * @param value
	 * @return
	 */
	public static double walt (double weight,double value){
		return weight*value;
	}
	
	/**
	 * This function get array of MacBig type and calculate sum of alt of each value.
	 * @param helper
	 * @param realsize
	 * @return
	 */
	public static double sumOfAlt (MacBig[] helper,int realsize){
		double counter=0;
		for (int i = 0; i < realsize; i++) {
			counter+=Double.parseDouble(helper[i].alt);
		}
		return counter;
	}
	
	/**
	 * This function get array of MacBig type and calculate sum of lat of each value.
	 * @param helper
	 * @param realsize
	 * @return
	 */
	public static double sumOfLat (MacBig[] helper,int realsize){
		double counter=0;
		for (int i = 0; i < realsize; i++) {
			counter+=Double.parseDouble(helper[i].lat);
		}
		return counter;
	}
	
	/**
	 * This function get array of MacBig type and calculate sum of lon of each value.
	 * @param helper
	 * @param realsize
	 * @return
	 */
	public static double sumOfLon (MacBig[] helper,int realsize){
		double counter=0;
		for (int i = 0; i < realsize; i++) {
			counter+=Double.parseDouble(helper[i].lon);
		}
		return counter;
	}
	
	/**
	 * This function get array of MacBig type and calculate sum of Weight of each value.
	 * @param helper
	 * @param realsize
	 * @return
	 */
	public static double sumOfWeight (MacBig[] helper,int realsize){
		double counter=0;
		for (int i = 0; i < realsize; i++) {
			counter+=Double.parseDouble(helper[i].Signal);
		}
		return counter;
	}
	
	/**
	 * This function calculate the PI.
	 * @param inputSignal
	 * @param signalOfUs
	 * @param PI
	 * @return PI
	 */
	public static double CalculatePI(int inputSignal, int signalOfUs,double PI){
		int diff;
		double w;
		if (Math.abs(inputSignal-signalOfUs)==0){
			diff=FindLocation.min_diff;
		}
		else{
			diff = Math.abs(inputSignal-signalOfUs);
		}
		w=(FindLocation.norm/(Math.pow(diff, FindLocation.sig_diff)))*(1/(Math.pow(inputSignal, FindLocation.power)));
		PI = PI*w;
		return PI;
	}

	
}
