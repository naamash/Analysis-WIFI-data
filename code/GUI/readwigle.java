package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import objects.hash;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class readwigle extends JPanel {
	String link = "";
	boolean correctlink;
	/**
	 * Create the panel.
	 */
	public readwigle(Connect c) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Read for filters");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 29));
		lblNewLabel.setBounds(121, 21, 202, 38);
		add(lblNewLabel);

		//		JButton button = new JButton("Enter");
		//		button.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//				String path1 = path.getText();
		//				File file = new File (path1);
		//				c.readWigle(file);
		//			}
		//		});
		//		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		//		button.setBounds(175, 255, 85, 32);
		//		add(button);

		JLabel lblEnterPathOf = new JLabel("Choose wigle wifi folder :");
		lblEnterPathOf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
		lblEnterPathOf.setBounds(114, 60, 209, 32);
		add(lblEnterPathOf);

		JButton aaa = new JButton("Folder");
		aaa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Folder");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				chooser.showOpenDialog(null);
			}
		});
		aaa.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		aaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Choose Folder");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				String path = "";
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					path = f.getAbsolutePath();
				}
				path = path.replace("\\", "/");
				File folder = new File(path);
				link = path;
				//c.macs = c.readWigle(folder);
			}
		});
		aaa.setBounds(144, 103, 131, 38);
		add(aaa);

//		JButton btnNewButton = new JButton("File");
//		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser chooser = new JFileChooser();
//				FileNameExtensionFilter filter = new FileNameExtensionFilter("csv", "csv");
//				chooser.setFileFilter(filter);
//				String path1 = "";
//				chooser.setDialogTitle("Choose Csv File");
//				if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//					path1=chooser.getSelectedFile().getAbsolutePath();
//				}
//				//File folder = new File(path1);
//				link = path1;
//				//c.macs = c.readWigle(folder);
//			}
//		});
//		btnNewButton.setBounds(153, 189, 122, 32);
//		add(btnNewButton);

//		JLabel lblChooseWigleWifi = new JLabel("Choose wigle wifi file :");
//		lblChooseWigleWifi.setFont(new Font("Berlin Sans FB", Font.PLAIN, 19));
//		lblChooseWigleWifi.setBounds(134, 144, 189, 32);
//		add(lblChooseWigleWifi);

		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (link == ""){
					JOptionPane.showMessageDialog(new JFrame(), "Choose folder or file please. This field can not be empty!");
					correctlink = false;
				}
				else{
					correctlink = true;
				}
				if (correctlink){
					try {
						File folder = new File(link);
						System.out.println(link);
						c.macs = c.readWigle(folder);
						JOptionPane.showMessageDialog(new JFrame(), "The file was read successfully");
						JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
					} 
					catch (Exception e2) {
						JOptionPane.showMessageDialog(new JFrame(), "The file was read failed");

					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		btnNewButton_1.setBounds(153, 236, 122, 38);
		add(btnNewButton_1);
		//System.out.println(c.macs.size());
		//		for (int i = 0; i < c.macs.size(); i++) {
		//			System.out.println(Arrays.toString(c.macs.get(i).arr_macbig));
		//		}
	}

}