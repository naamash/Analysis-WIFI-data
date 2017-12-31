package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addcsv extends JPanel {
	private JTextField path;

	/**
	 * Create the panel.
	 */
	public addcsv(Conect c) {
		setLayout(null);
		
		JButton btnNewButton = new JButton("enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String t= path.getText();
				c.addCSV(t);
			}
		});
		btnNewButton.setBounds(178, 236, 97, 25);
		add(btnNewButton);
		
		path = new JTextField();
		path.setBounds(172, 143, 116, 22);
		add(path);
		path.setColumns(10);
		
		JLabel lblPath = new JLabel("path");
		lblPath.setBounds(81, 146, 56, 16);
		add(lblPath);
		
		JLabel lblEnterCsvPath = new JLabel("enter csv path");
		lblEnterCsvPath.setBounds(178, 72, 138, 16);
		add(lblEnterCsvPath);

	}
}
