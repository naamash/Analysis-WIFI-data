package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import filtersPack.Filter;
import filtersPack.NOT_filter;
import filtersPack.filter_time;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class withoutTime extends JPanel {
	private JTextField time2;
	private JTextField time1;

	/**
	 * Create the panel.
	 */
	public withoutTime(Filter[]filters,Connect c) {
		setLayout(null);
		
		JLabel label = new JLabel(" Choose date and Time");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		label.setBounds(61, 25, 319, 41);
		add(label);
		
		JLabel label_1 = new JLabel("Start date");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		label_1.setBounds(33, 54, 137, 41);
		add(label_1);
		
		JDateChooser date2 = new JDateChooser();
		date2.setBounds(261, 95, 177, 41);
		add(date2);
		
		JLabel label_2 = new JLabel("End date");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		label_2.setBounds(291, 54, 124, 41);
		add(label_2);
		
		JDateChooser date1 = new JDateChooser();
		date1.setBounds(12, 95, 177, 41);
		add(date1);
		
		JLabel label_3 = new JLabel(" Write time in format:  hh:mm:ss");
		label_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		label_3.setBounds(0, 137, 438, 48);
		add(label_3);
		
		JLabel label_4 = new JLabel(" Start time");
		label_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		label_4.setBounds(44, 176, 154, 41);
		add(label_4);
		
		JLabel label_5 = new JLabel(" End time");
		label_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		label_5.setBounds(271, 176, 154, 41);
		add(label_5);
		
		JButton button = new JButton(" Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String datte1 = date1.getDateFormatString();
				String datte2 = date2.getDateFormatString();
				String timme1 = datte1 +" "+time1.getText();
				String timme2 = datte2 +" "+time2.getText();
				Filter ft = new filter_time(timme1,timme2);
				Filter filter = new NOT_filter(ft);
				if(filters[1]!=null)
					filters[2]= filter;

				else 
					filters[0]=filter;

				JOptionPane.showMessageDialog(new JFrame(), "Filter by NOT-time got finished");
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		button.setBounds(146, 246, 124, 41);
		add(button);
		
		time2 = new JTextField();
		time2.setColumns(10);
		time2.setBounds(250, 213, 165, 31);
		add(time2);
		
		time1 = new JTextField();
		time1.setColumns(10);
		time1.setBounds(33, 213, 165, 31);
		add(time1);
		
		JLabel label_6 = new JLabel(" NOT");
		label_6.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		label_6.setBounds(173, 0, 56, 28);
		add(label_6);

	}
}
