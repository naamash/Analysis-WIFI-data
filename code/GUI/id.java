package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class id extends JPanel {
	private JTextField path;

	/**
	 * Create the panel.
	 */
	public id(Connect c) {
		setLayout(null);
		
		JLabel lblPleaseEnterId = new JLabel(" Please enter ID display");
		lblPleaseEnterId.setFont(new Font("Berlin Sans FB", Font.PLAIN, 43));
		lblPleaseEnterId.setBounds(12, 36, 426, 60);
		add(lblPleaseEnterId);
		
		path = new JTextField();
		path.setBounds(33, 128, 386, 46);
		add(path);
		path.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = path.getText();
				c.addfilter_ID(id);
			}
		});
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 41));
		btnNewButton.setBounds(123, 206, 191, 46);
		add(btnNewButton);

	}
}
