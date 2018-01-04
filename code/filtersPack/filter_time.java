package filtersPack;

import java.util.Date;

import objects.MacBig_Container;

public class filter_time implements Filter {

	public String time_start;
	public String time_end;

	/**
	 * Defined constructors
	 * @param time_start
	 * @param time_end
	 */
	public filter_time(String time_start,String time_end){
		this.time_end=time_end;
		this.time_start=time_start;
	}

	/**
	 * implementation by time the Check function from Filter
	 */
	public boolean check (MacBig_Container scan){
		Date StartDate = HelpFilter.fromStringToDate(time_start);
		Date EndDate =  HelpFilter.fromStringToDate(time_end);
		Date dateLine = null;
		dateLine = (Date) (HelpFilter.fromStringToDate(scan.arr_macbig[0].time));
		if (dateLine.after(StartDate)&&dateLine.before(EndDate)){
			return true;
		}
		return false;
	}
}
//08:37:10