package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SavetoKML extends JPanel {
	private JTextField path;

	/**
	 * Create the panel.
	 */
	public SavetoKML(Connect c) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Save to KML");
		lblNewLabel.setBounds(141, 36, 173, 62);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		add(lblNewLabel);
		
		JLabel lblPath = new JLabel("Path :");
		lblPath.setBounds(22, 128, 56, 32);
		lblPath.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		add(lblPath);
		
		path = new JTextField();
		path.setBounds(80, 130, 341, 32);
		add(path);
		path.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path1 = path.getText();
				c.saveTOkml(path1);
			}
		});
		btnEnter.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		btnEnter.setBounds(175, 213, 85, 32);
		add(btnEnter);

	}

}
