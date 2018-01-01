package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class choose_Between extends JPanel {

	/**
	 * Create the panel.
	 */
	public choose_Between() {
		setLayout(null);
		
		JButton btnNewButton = new JButton(" OR");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 42));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(26, 131, 172, 68);
		add(btnNewButton);
		
		JButton btnAnd = new JButton(" AND");
		btnAnd.setFont(new Font("Berlin Sans FB", Font.PLAIN, 42));
		btnAnd.setBounds(240, 131, 172, 68);
		add(btnAnd);
		
		JLabel lblEnter = new JLabel("Choose :");
		lblEnter.setFont(new Font("Berlin Sans FB", Font.PLAIN, 40));
		lblEnter.setBounds(145, 50, 164, 51);
		add(lblEnter);

	}

}
