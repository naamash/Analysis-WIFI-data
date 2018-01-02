package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class readwigle extends JPanel {
	private JTextField path;

	/**
	 * Create the panel.
	 */
	public readwigle(Connect c) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Read for filters");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 29));
		lblNewLabel.setBounds(130, 13, 179, 38);
		add(lblNewLabel);
		
		path = new JTextField();
		path.setColumns(10);
		path.setBounds(59, 137, 341, 32);
		add(path);
		
		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path1 = path.getText();
				File file = new File (path1);
				c.readWigle(file);
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		button.setBounds(181, 255, 85, 32);
		add(button);
		
		JLabel lblEnterPathOf = new JLabel("Enter path of wigle wifi folder or file :");
		lblEnterPathOf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathOf.setBounds(80, 92, 305, 32);
		add(lblEnterPathOf);

	}

}
