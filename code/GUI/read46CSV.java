package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class read46CSV extends JPanel {
	private JTextField path;

	/**
	 * Create the panel.
	 */
	public read46CSV(Connect c) {
		setLayout(null);
		
		JButton btnNewButton = new JButton("enter");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t= path.getText();
				c.readCSV46(t);
			}
		});
		btnNewButton.setBounds(144, 236, 131, 38);
		add(btnNewButton);
		
		path = new JTextField();
		path.setBounds(80, 144, 318, 28);
		add(path);
		path.setColumns(10);
		
		JLabel lblPath = new JLabel("  path");
		lblPath.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblPath.setBounds(12, 144, 80, 21);
		add(lblPath);
		
		JLabel lblEnterCsvPath = new JLabel(" enter csv path");
		lblEnterCsvPath.setFont(new Font("Berlin Sans FB", Font.PLAIN, 49));
		lblEnterCsvPath.setBounds(63, 64, 335, 47);
		add(lblEnterCsvPath);

	}
}
