package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class read46 extends JPanel {

	/**
	 * Create the panel.
	 */
	public read46(Connect c) {
		setLayout(null);
		
//		JButton button = new JButton("Enter");
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				String path1 = path.getText();
//				c.read46(path1);
//			}
//		});
//		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
//		button.setBounds(168, 255, 85, 32);
//		add(button);
		
		JLabel lblEnterPathOf = new JLabel("Enter path of DataBase file :");
		lblEnterPathOf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathOf.setBounds(89, 101, 248, 32);
		add(lblEnterPathOf);
		
		JLabel label_1 = new JLabel("Read for filters");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 29));
		label_1.setBounds(117, 13, 179, 38);
		add(label_1);
		
		JButton button_2 = new JButton("File");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "csv");
				chooser.setFileFilter(filter);
				chooser.setDialogTitle("Choose Csv File");
				chooser.showOpenDialog(null);
				chooser.getSelectedFile().getAbsolutePath();
			}
		});
		button_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		button_2.setBounds(148, 159, 122, 32);
		add(button_2);

	}

}
