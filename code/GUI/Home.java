package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Home extends JPanel {

	/**
	 * Create the panel.
	 */
	public Home(Connect c) {
		setLayout(null);
		
		JLabel lblChoose = new JLabel("Enter your choice in the menu");
		lblChoose.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		lblChoose.setBounds(12, 86, 426, 90);
		add(lblChoose);

	}

}
