package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class read46 extends JPanel {
	private JTextField path;

	/**
	 * Create the panel.
	 */
	public read46(Connect c) {
		setLayout(null);
		
		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path1 = path.getText();
				c.read46(path1);
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		button.setBounds(168, 255, 85, 32);
		add(button);
		
		path = new JTextField();
		path.setColumns(10);
		path.setBounds(46, 137, 341, 32);
		add(path);
		
		JLabel lblEnterPathOf = new JLabel("Enter path of DataBase file :");
		lblEnterPathOf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathOf.setBounds(82, 92, 248, 32);
		add(lblEnterPathOf);
		
		JLabel label_1 = new JLabel("Read for filters");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 29));
		label_1.setBounds(117, 13, 179, 38);
		add(label_1);

	}

}
