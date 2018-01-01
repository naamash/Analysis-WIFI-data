package GUI;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class addFilter extends JPanel {

	/**
	 * Create the panel.
	 */
	public addFilter(Connect c) {
		setLayout(null);
		
		JButton btnByOneOption = new JButton("   By one filter");
		btnByOneOption.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		btnByOneOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnByOneOption.setBounds(35, 142, 187, 40);
		add(btnByOneOption);
		
		JButton btnByTwoOptions = new JButton("   By two filters");
		btnByTwoOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnByTwoOptions.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		btnByTwoOptions.setBounds(236, 142, 187, 40);
		add(btnByTwoOptions);
		
		JLabel lblNewLabel = new JLabel("  choose filter");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 42));
		lblNewLabel.setBounds(96, 13, 250, 97);
		add(lblNewLabel);

	}
}
