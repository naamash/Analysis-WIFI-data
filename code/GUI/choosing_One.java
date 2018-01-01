package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class choosing_One extends JPanel {

	/**
	 * Create the panel.
	 */
	public choosing_One(Connect c) {
		setLayout(null);
		
		JButton btnTime = new JButton(" Time");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTime.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnTime.setBounds(43, 81, 131, 51);
		add(btnTime);
		
		JButton btnPlace = new JButton(" Place");
		btnPlace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlace.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnPlace.setBounds(43, 145, 131, 51);
		add(btnPlace);
		
		JButton btnId = new JButton(" ID");
		btnId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnId.setBounds(43, 211, 131, 51);
		add(btnId);
		
		JButton btnWithoutTime = new JButton(" Without Time");
		btnWithoutTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWithoutTime.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnWithoutTime.setBounds(217, 81, 207, 51);
		add(btnWithoutTime);
		
		JButton btnWithoutPlace = new JButton(" Without Place");
		btnWithoutPlace.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnWithoutPlace.setBounds(217, 145, 207, 51);
		add(btnWithoutPlace);
		
		JButton btnWithoutId = new JButton(" Without ID");
		btnWithoutId.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnWithoutId.setBounds(217, 211, 207, 51);
		add(btnWithoutId);
		
		JLabel lblNewLabel = new JLabel("  Choose One Filter");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 41));
		lblNewLabel.setBounds(59, 13, 332, 51);
		add(lblNewLabel);

	}

}
