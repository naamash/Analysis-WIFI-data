package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JButton;

public class withoutTime extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public withoutTime() {
		setLayout(null);
		
		JLabel label = new JLabel(" Choose date and Time");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		label.setBounds(61, 13, 319, 41);
		add(label);
		
		JLabel label_1 = new JLabel("Start date");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		label_1.setBounds(33, 54, 137, 41);
		add(label_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(261, 95, 177, 41);
		add(dateChooser);
		
		JLabel label_2 = new JLabel("End date");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		label_2.setBounds(291, 54, 124, 41);
		add(label_2);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(12, 95, 177, 41);
		add(dateChooser_1);
		
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
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		button.setBounds(146, 246, 124, 41);
		add(button);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(250, 213, 165, 31);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(33, 213, 165, 31);
		add(textField_1);

	}
}
