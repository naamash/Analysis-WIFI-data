package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import objects.hash;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class read46 extends JPanel {
	String name="";
	boolean correct = false;
	/**
	 * Create the panel.
	 */
	public read46(Connect c) {
		setLayout(null);

		JLabel lblEnterPathOf = new JLabel("Enter DataBase file :");
		lblEnterPathOf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathOf.setBounds(117, 101, 181, 32);
		add(lblEnterPathOf);

		JLabel label_1 = new JLabel("Read for filters");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 29));
		label_1.setBounds(105, 24, 203, 38);
		add(label_1);

		JButton button_2 = new JButton("File");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "csv");
				String path="";
				chooser.setFileFilter(filter);
				chooser.setDialogTitle("Choose Csv File");
				if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					path=chooser.getSelectedFile().getAbsolutePath();
				}
				name = path;
				name = name.replace("\\", "/");
				
			}
		});
		button_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		button_2.setBounds(148, 159, 122, 32);
		add(button_2);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name == ""){
					JOptionPane.showMessageDialog(new JFrame(), "Choose file please. This field can not be empty!");
				}
				else{
					try {
						c.macs = c.read46(name);						
						JOptionPane.showMessageDialog(new JFrame(), "The file was read successfully");
						JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(new JFrame(), "The file was read failed");

					}
				

				}
			}
		});
		btnNewButton_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		btnNewButton_1.setBounds(148, 234, 122, 38);
		add(btnNewButton_1);

	}

}