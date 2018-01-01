package GUI;

import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Time extends JPanel {
	private JTextField txtStart;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Time() {
		setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(12, 95, 177, 41);
		add(dateChooser);
		
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
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(261, 95, 177, 41);
		add(dateChooser_1);
		
		txtStart = new JTextField();
		txtStart.setBounds(33, 213, 165, 31);
		add(txtStart);
		txtStart.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(250, 213, 165, 31);
		add(textField);
		
		JLabel lblStartTime = new JLabel(" Start time");
		lblStartTime.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblStartTime.setBounds(44, 176, 154, 41);
		add(lblStartTime);
		
		JLabel lblEndTime = new JLabel(" End time");
		lblEndTime.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblEndTime.setBounds(271, 176, 154, 41);
		add(lblEndTime);
		
		JButton btnNewButton = new JButton(" Enter");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		btnNewButton.setBounds(146, 246, 124, 41);
		add(btnNewButton);

	}
}
