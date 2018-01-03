package GUI;

import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;

import filtersPack.Filter;
import filtersPack.filter_location;
import filtersPack.filter_time;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Time extends JPanel {
	JPanel OrA;
	private JTextField time1;
	private JTextField time2;

	/**
	 * Create the panel.
	 */
	public Time(Filter[] filters,Connect c) {
		setLayout(null);
		
		JDateChooser date1 = new JDateChooser();
		date1.setBounds(12, 95, 177, 41);
		add(date1);
		
		JLabel lblNewLabel = new JLabel(" Choose date and Time");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		lblNewLabel.setBounds(61, 13, 319, 41);
		add(lblNewLabel);
		
		JLabel lblWriteTime = new JLabel(" Write time in format:  hh:mm:ss");
		lblWriteTime.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		lblWriteTime.setBounds(0, 137, 438, 48);
		add(lblWriteTime);
		
		JLabel lblStart = new JLabel("Start date");
		lblStart.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		lblStart.setBounds(33, 54, 137, 41);
		add(lblStart);
		
		JLabel lblEnd = new JLabel("End date");
		lblEnd.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		lblEnd.setBounds(291, 54, 124, 41);
		add(lblEnd);
		
		JDateChooser date2 = new JDateChooser();
		date2.setBounds(261, 95, 177, 41);
		add(date2);
		
		time1 = new JTextField();
		time1.setBounds(33, 213, 165, 31);
		add(time1);
		time1.setColumns(10);
		
		time2 = new JTextField();
		time2.setColumns(10);
		time2.setBounds(250, 213, 165, 31);
		add(time2);
		
		JLabel lblStartTime = new JLabel(" Start time");
		lblStartTime.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblStartTime.setBounds(44, 176, 154, 41);
		add(lblStartTime);
		
		JLabel lblEndTime = new JLabel(" End time");
		lblEndTime.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblEndTime.setBounds(271, 176, 154, 41);
		add(lblEndTime);
		
		JButton btnNewButton = new JButton(" Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date_min=date1.getDate().toLocaleString();
				String datte1 = date_min.substring(9, date_min.length());
				String date_max=date1.getDate().toLocaleString();
				String datte2 = date_max.substring(9, date_max.length());
				String timme1 = datte1 +" "+time1.getText();
				String timme2 = datte2 +" "+time2.getText();
				Filter ft = new filter_time(timme1,timme2);
				if(filters[1]!=null && filters[0]!=null){
					filters[2]= ft;
					if(filters[1].getClass().getName().contains("AND_filter")){
						c.and_filter(filters[0], filters[2]);
					}
					else if(filters[1].getClass().getName().contains("OR_filter")){
						c.OR_filter(filters[0], filters[2]);
					}
				}
				else if(filters[1]!=null && filters[0]==null){
					filters[0]= ft;
				}
				

				else if(filters[0]==null&&filters[1]==null){
					filters[0]=ft;
					c.addfilter_TIME(timme1,timme2);
				}
				JOptionPane.showMessageDialog(new JFrame(), "Filter by time got finished");
			}
		});
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		btnNewButton.setBounds(146, 246, 124, 41);
		add(btnNewButton);

	}
}
