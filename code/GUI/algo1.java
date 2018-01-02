package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class algo1 extends JPanel {
	private JTextField path;
	private JTextField mac;

	/**
	 * Create the panel.
	 */
	public algo1(Connect c) {
		setLayout(null);
		
		JLabel lblAlgo = new JLabel("Algo 1");
		lblAlgo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		lblAlgo.setBounds(170, 13, 115, 40);
		add(lblAlgo);
		
		path = new JTextField();
		path.setBounds(31, 112, 393, 32);
		add(path);
		path.setColumns(10);
		
		JLabel lblEnterPathOf_1 = new JLabel("Enter MAC :");
		lblEnterPathOf_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathOf_1.setBounds(170, 157, 115, 32);
		add(lblEnterPathOf_1);
		
		mac = new JTextField();
		mac.setColumns(10);
		mac.setBounds(90, 190, 261, 32);
		add(mac);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path1 = path.getText();
				File file = new File(path1);
				String mac1 = mac.getText();
				c.Algo1(file, mac1);
			}
		});
		btnEnter.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnEnter.setBounds(148, 234, 126, 40);
		add(btnEnter);
		
		JLabel label = new JLabel("Enter path of wigle wifi folder or file :");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		label.setBounds(76, 79, 305, 32);
		add(label);

	}

}
