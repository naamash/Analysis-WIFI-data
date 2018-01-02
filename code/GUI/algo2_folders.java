package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class algo2_folders extends JPanel {
	private JTextField whigle;
	private JTextField les;
	private JTextField save;

	/**
	 * Create the panel.
	 */
	public algo2_folders(Connect c) {
		setLayout(null);
		
		JLabel label = new JLabel("Algo 2");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 35));
		label.setBounds(164, 0, 115, 40);
		add(label);
		
		whigle = new JTextField();
		whigle.setColumns(10);
		whigle.setBounds(30, 72, 393, 32);
		add(whigle);
		
		JLabel lblEnterPathOf_1 = new JLabel("Enter path of the lesses information folder or file :");
		lblEnterPathOf_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathOf_1.setBounds(30, 101, 408, 32);
		add(lblEnterPathOf_1);
		
		les = new JTextField();
		les.setColumns(10);
		les.setBounds(30, 134, 393, 32);
		add(les);
		
		JLabel lblEnterPathFor = new JLabel("Enter path for saving :");
		lblEnterPathFor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathFor.setBounds(127, 169, 194, 32);
		add(lblEnterPathFor);
		
		save = new JTextField();
		save.setColumns(10);
		save.setBounds(30, 201, 393, 32);
		add(save);
		
		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String folder = whigle.getText();
				String folderles = les.getText();
				File folder1 = new File(folder);
				File folder2 = new File(folderles);
				String path = save.getText();
				c.Algo2Folder(folder1, folder2, path);
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		button.setBounds(148, 242, 128, 45);
		add(button);
		
		JLabel label_1 = new JLabel("Enter path of wigle wifi folder or file :");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		label_1.setBounds(68, 38, 305, 32);
		add(label_1);

	}

}
