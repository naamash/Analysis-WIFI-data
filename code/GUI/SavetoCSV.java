package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SavetoCSV extends JPanel {
	private JTextField path;

	/**
	 * Create the panel.
	 */
	public SavetoCSV(Connect c) {
		setLayout(null);
		
		JLabel lblSaveToCsv = new JLabel("Save to CSV");
		lblSaveToCsv.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblSaveToCsv.setBounds(141, 36, 173, 62);
		add(lblSaveToCsv);
		
		path = new JTextField();
		path.setColumns(10);
		path.setBounds(80, 130, 341, 32);
		add(path);
		
		JLabel label_1 = new JLabel("Path :");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		label_1.setBounds(22, 128, 56, 32);
		add(label_1);
		
		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path1 = path.getText();
				c.saveTOcsv(path1);
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		button.setBounds(175, 213, 85, 32);
		add(button);

	}

}
